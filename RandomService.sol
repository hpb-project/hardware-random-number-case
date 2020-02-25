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
contract RandomContract{
    function addRandom(
        address payable addr,
        uint8[5] memory data
    )public returns(bool);
    function getRandomByIndex(
        uint index
    )  public view returns (
        address payable _addr,
        uint8[5] memory _data,
        uint _blockTime
    );
    function getCurrentRandom(
    )  public view returns (
        address payable _addr,
        uint8[5] memory _data,
        uint _blockTime
    );
    function getCurrentRandomIndex(
    )  public view returns (
        uint _length
    );
}
contract RandomRandom{
    function generateRandom() public returns(uint8[5] memory _data);
}
contract RandomService is Ownable{
	
	address payable public randomContractAddr;
	address payable public randomRandomAddr;
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
    function setRandomContractAddr(
        address payable _randomContractAddr
    ) onlyAdmin public returns(bool){
        randomContractAddr=_randomContractAddr;
        return true;
    }
    function setRandomRandomAddr(
        address payable _randomRandomAddr
    ) onlyAdmin public returns(bool){
        randomRandomAddr=_randomRandomAddr;
        return true;
    }
   function addRandom(
   ) public returns(bool){
        require(randomContractAddr!= address(0), ZERO_ADDRESS);
        require(randomRandomAddr!= address(0), ZERO_ADDRESS);
        uint8[5] memory _data=RandomRandom(randomRandomAddr).generateRandom();
        RandomContract(randomContractAddr).addRandom(msg.sender,_data);
        return true;
    }
    function getRandomByIndex(
        uint index
    )  public view returns (
        address payable _addr,
        uint8[5] memory _data,
        uint _blockTime
    ){
        require(randomContractAddr!= address(0), ZERO_ADDRESS);
        require(randomRandomAddr!= address(0), ZERO_ADDRESS);
        return RandomContract(randomContractAddr).getRandomByIndex(index);
    }
    function getCurrentRandom(
    )  public view returns (
        address payable _addr,
        uint8[5] memory _data,
        uint _blockTime
    ){
        require(randomContractAddr!= address(0), ZERO_ADDRESS);
        require(randomRandomAddr!= address(0), ZERO_ADDRESS);
        return RandomContract(randomContractAddr).getCurrentRandom();
    }
    function getCurrentRandomIndex(
    )  public view returns (
        uint _length
    ){
        require(randomContractAddr!= address(0), ZERO_ADDRESS);
        return RandomContract(randomContractAddr).getCurrentRandomIndex();
    }
    
    function getRandom(
        uint beginIndex,
        uint endIndex
    )  public view returns (
        address payable[] memory _addrs,
        uint8[5][] memory _datas,
        uint[] memory _blockTimes
    ){
        require(randomContractAddr!= address(0), ZERO_ADDRESS);
        require(randomRandomAddr!= address(0), ZERO_ADDRESS);
        require(beginIndex<endIndex);
        uint cl=endIndex-beginIndex+1;
        address payable [] memory addrs=new address payable[](cl);
        uint8[5][] memory datas=new uint8[5][](cl);
        uint[] memory blockTimes=new uint[](cl);
        for(uint index=beginIndex;index<endIndex;index++){
            address payable _addr;
            uint8[5] memory _data;
            uint _blockTime;
            (_addr,_data, _blockTime)=getRandomByIndex(index);
            addrs[index-beginIndex]=_addr;
            datas[index-beginIndex]=_data;
            blockTimes[index-beginIndex]=_blockTime;
        }
        return (addrs,datas,blockTimes);
    }
}
//0x47fa92ac3e86eb6fdc06e283b419814cff94c399