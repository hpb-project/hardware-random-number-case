pragma solidity ^0.5.6;
/**
 * @dev The contract has an owner address, and provides basic authorization control whitch
 * simplifies the implementation of user permissions. This contract is based on the source code at:
 * https://github.com/OpenZeppelin/openzeppelin-solidity/blob/master/contracts/ownership/Ownable.sol
 */
contract Ownable {

    /**
     * @dev Error constants.
     */
    string public constant NOT_OWNER = "018001";
    string public constant ZERO_ADDRESS = "018002";

    /**
     * @dev Current owner address.
     */
    address payable public owner;

    /**
     * @dev An event which is triggered when the owner is changed.
     * @param previousOwner The address of the previous owner.
     * @param newOwner The address of the new owner.
     */
    event OwnershipTransferred(address payable indexed previousOwner,
    address indexed newOwner);

    /**
     * @dev Throws if called by any account other than the owner.
     */
    modifier onlyOwner() {
        require(msg.sender == owner, NOT_OWNER);
        _;
    }

    /**
     * @dev Allows the current owner to transfer control of the contract to a newOwner.
     * @param _newOwner The address to transfer ownership to.
     */
    function transferOwnership(address payable _newOwner) public onlyOwner {
        require(_newOwner != address(0), ZERO_ADDRESS);
        emit OwnershipTransferred(owner, _newOwner);
        owner = _newOwner;
    }
    // 合约管理员，可以添加和删除候选人
    mapping (address  => address) public adminMap;

    modifier onlyAdmin {
        require(adminMap[msg.sender] != address(0), ZERO_ADDRESS);
        _;
    }

    function addAdmin(address  addr) onlyOwner public returns(bool) {
        require(adminMap[addr] == address(0));
        adminMap[addr] = addr;
        return true;
    }

    function deleteAdmin(address  addr) onlyOwner public returns(bool) {
        require(adminMap[addr] != address(0), ZERO_ADDRESS);
        adminMap[addr] = address(0);
        delete adminMap[addr];
        return true;
    }

}


contract Random is Ownable{
	
	event ReceivedHpb(
        address payable indexed sender, 
        uint amount
    );
	// 接受HPB转账
    function () payable external {
        emit ReceivedHpb(
            msg.sender, 
            msg.value
        );
    }
    // 销毁合约，并把合约余额返回给合约拥有者
    function kill() onlyOwner payable public returns(bool) {
        selfdestruct(owner);
        return true;
    }

    function withdraw(
        uint _value
    ) onlyOwner payable public returns(bool) {
        require(address(this).balance >= _value);
        owner.transfer(_value);
        return true;
    }
    
    constructor () payable public {
        owner = msg.sender;
        // 设置默认管理员
        adminMap[owner] = owner;
    }
    
   function generateRandom() public view returns(
       uint8[5] memory _data
   ) {
       uint256 r=uint(keccak256(abi.encodePacked(block.random)));
       uint8[5] memory data= [
           uint8(uint(r) %9),
           uint8(uint(r) %8),
           uint8(uint(r) %7),
           uint8(uint(r) %6),
           uint8(uint(r) %5)
       ];
       return data;
    }
    
}