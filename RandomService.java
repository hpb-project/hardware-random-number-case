package io.hpb.ballot.contract;

import io.hpb.web3.abi.EventEncoder;
import io.hpb.web3.abi.TypeReference;
import io.hpb.web3.abi.datatypes.Address;
import io.hpb.web3.abi.datatypes.DynamicArray;
import io.hpb.web3.abi.datatypes.Event;
import io.hpb.web3.abi.datatypes.Function;
import io.hpb.web3.abi.datatypes.Type;
import io.hpb.web3.abi.datatypes.Utf8String;
import io.hpb.web3.abi.datatypes.generated.StaticArray5;
import io.hpb.web3.abi.datatypes.generated.Uint256;
import io.hpb.web3.abi.datatypes.generated.Uint8;
import io.hpb.web3.crypto.Credentials;
import io.hpb.web3.protocol.Web3;
import io.hpb.web3.protocol.core.DefaultBlockParameter;
import io.hpb.web3.protocol.core.RemoteCall;
import io.hpb.web3.protocol.core.RemoteFunctionCall;
import io.hpb.web3.protocol.core.methods.request.HpbFilter;
import io.hpb.web3.protocol.core.methods.response.BaseEventResponse;
import io.hpb.web3.protocol.core.methods.response.Log;
import io.hpb.web3.protocol.core.methods.response.TransactionReceipt;
import io.hpb.web3.tuples.generated.Tuple3;
import io.hpb.web3.tx.Contract;
import io.hpb.web3.tx.TransactionManager;
import io.hpb.web3.tx.gas.ContractGasProvider;
import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the web3 command line tools
 * or the io.hpb.web3.codegen.SolidityFunctionWrapperGenerator in the 
 * codegen module to update.
 *
 * <p>Generated with web3 version none.
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class RandomService extends Contract {
    private static final String BINARY = "60806040908152600080546001600160a01b031990811633178083556001600160a01b0316808352600160205292909120805490911690911790556115a6806100496000396000f3fe6080604052600436106101095760003560e01c80638b9c673211610095578063cfdf68ab11610064578063cfdf68ab146104f2578063d89601fd14610507578063dbbc830b1461051c578063dec91d871461054f578063f2fde38b1461056457610109565b80638b9c6732146104005780638da5cb5b146104335780638e9a800814610464578063afc76e3c146104dd57610109565b8063538ba4f9116100dc578063538ba4f9146101e0578063655b08eb1461026a578063704802751461039157806371d78b12146103c45780638051f37b146103d957610109565b806327e1f7df146101415780632e1a7d4d1461018857806341c0e1b5146101a557806351e05c22146101ad575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b34801561014d57600080fd5b506101746004803603602081101561016457600080fd5b50356001600160a01b0316610599565b604080519115158252519081900360200190f35b6101746004803603602081101561019e57600080fd5b5035610711565b6101746107e0565b3480156101b957600080fd5b50610174600480360360208110156101d057600080fd5b50356001600160a01b031661086d565b3480156101ec57600080fd5b506101f561091e565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561022f578181015183820152602001610217565b50505050905090810190601f16801561025c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561027657600080fd5b5061029a6004803603604081101561028d57600080fd5b5080359060200135610943565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156102e25781810151838201526020016102ca565b505050509050018481038352868181518152602001915080516000925b818410156103415760208085028401015160a080838360005b83811015610330578181015183820152602001610318565b5050505090500192600101926102ff565b878103855288518152885160209182019450818a01935002905080838360005b83811015610379578181015183820152602001610361565b50505050905001965050505050505060405180910390f35b34801561039d57600080fd5b50610174600480360360208110156103b457600080fd5b50356001600160a01b0316610b98565b3480156103d057600080fd5b506101f5610c6c565b3480156103e557600080fd5b506103ee610c91565b60408051918252519081900360200190f35b34801561040c57600080fd5b506101746004803603602081101561042357600080fd5b50356001600160a01b0316610d8e565b34801561043f57600080fd5b50610448610e3f565b604080516001600160a01b039092168252519081900360200190f35b34801561047057600080fd5b5061048e6004803603602081101561048757600080fd5b5035610e4e565b6040516001600160a01b0384168152602081018360a080838360005b838110156104c25781810151838201526020016104aa565b50505050905001828152602001935050505060405180910390f35b3480156104e957600080fd5b50610448610ff2565b3480156104fe57600080fd5b50610448611001565b34801561051357600080fd5b5061048e611010565b34801561052857600080fd5b506104486004803603602081101561053f57600080fd5b50356001600160a01b03166111b2565b34801561055b57600080fd5b506101746111cd565b34801561057057600080fd5b506105976004803603602081101561058757600080fd5b50356001600160a01b031661140a565b005b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461065457604051600160e51b62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b83811015610619578181015183820152602001610601565b50505050905090810190601f1680156106465780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b506001600160a01b0382811660009081526001602090815260409182902054825180840190935260068352600160d11b6518189c18181902918301919091529091166106e457604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b50506001600160a01b0316600090815260016020819052604090912080546001600160a01b031916905590565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461078f57604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b50303182111561079e57600080fd5b600080546040516001600160a01b039091169184156108fc02918591818181858888f193505050501580156107d7573d6000803e3d6000fd5b50600192915050565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461085e57604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506000546001600160a01b0316ff5b33600090815260016020908152604080832054815180830190925260068252600160d11b6518189c1818190292820192909252906001600160a01b03166108f857604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b5050600380546001600160a01b0383166001600160a01b03199091161790556001919050565b604051806040016040528060068152602001600160d11b6518189c1818190281525081565b6002546040805180820190915260068152600160d11b6518189c181819026020820152606091829182916001600160a01b03166109c457604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506003546040805180820190915260068152600160d11b6518189c181819026020820152906001600160a01b0316610a4057604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b50838510610a4d57600080fd5b604080516001878703018082526020808202830101909252606090828015610a7f578160200160208202803883390190505b509050606082604051908082528060200260200182016040528015610abe57816020015b610aab61155c565b815260200190600190039081610aa35790505b509050606083604051908082528060200260200182016040528015610aed578160200160208202803883390190505b509050885b88811015610b88576000610b0461155c565b6000610b0f84610e4e565b89519295509093509150839088908f8703908110610b2957fe5b60200260200101906001600160a01b031690816001600160a01b03168152505081868e860381518110610b5857fe5b602002602001018190525080858e860381518110610b7257fe5b6020908102919091010152505050600101610af2565b5091955093509150509250925092565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b03163314610c1657604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506001600160a01b038281166000908152600160205260409020541615610c3c57600080fd5b506001600160a01b0316600081815260016020819052604090912080546001600160a01b03191690921790915590565b604051806040016040528060068152602001600160d01b653031383030310281525081565b6002546040805180820190915260068152600160d11b6518189c1818190260208201526000916001600160a01b0316610d0e57604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b50600260009054906101000a90046001600160a01b03166001600160a01b0316638051f37b6040518163ffffffff1660e01b815260040160206040518083038186803b158015610d5d57600080fd5b505afa158015610d71573d6000803e3d6000fd5b505050506040513d6020811015610d8757600080fd5b5051905090565b33600090815260016020908152604080832054815180830190925260068252600160d11b6518189c1818190292820192909252906001600160a01b0316610e1957604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b5050600280546001600160a01b0383166001600160a01b03199091161790556001919050565b6000546001600160a01b031681565b6000610e5861155c565b6002546040805180820190915260068152600160d11b6518189c1818190260208201526000916001600160a01b0316610ed557604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506003546040805180820190915260068152600160d11b6518189c181819026020820152906001600160a01b0316610f5157604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b5060025460408051600160e31b6311d350010281526004810187905290516001600160a01b0390921691638e9a80089160248082019260e092909190829003018186803b158015610fa157600080fd5b505afa158015610fb5573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525060e0811015610fda57600080fd5b50805160c08201519096602090920195509350915050565b6003546001600160a01b031681565b6002546001600160a01b031681565b600061101a61155c565b6002546040805180820190915260068152600160d11b6518189c1818190260208201526000916001600160a01b031661109757604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506003546040805180820190915260068152600160d11b6518189c181819026020820152906001600160a01b031661111357604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b50600260009054906101000a90046001600160a01b03166001600160a01b031663d89601fd6040518163ffffffff1660e01b815260040160e06040518083038186803b15801561116257600080fd5b505afa158015611176573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525060e081101561119b57600080fd5b50805160c082015190956020909201945092509050565b6001602052600090815260409020546001600160a01b031681565b6002546040805180820190915260068152600160d11b6518189c1818190260208201526000916001600160a01b031661124a57604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506003546040805180820190915260068152600160d11b6518189c181819026020820152906001600160a01b03166112c657604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506112cf61155c565b600360009054906101000a90046001600160a01b03166001600160a01b03166302e4af016040518163ffffffff1660e01b815260040160a060405180830381600087803b15801561131f57600080fd5b505af1158015611333573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525060a081101561135857600080fd5b50600254604051600160e01b63073b823902815233600482018181529394506001600160a01b039092169263073b823992918591906024018260a080838360005b838110156113b1578181015183820152602001611399565b5050505090500192505050602060405180830381600087803b1580156113d657600080fd5b505af11580156113ea573d6000803e3d6000fd5b505050506040513d602081101561140057600080fd5b5060019250505090565b6000546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461148757604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b506040805180820190915260068152600160d11b6518189c1818190260208201526001600160a01b03821661150057604051600160e51b62461bcd028152602060048201818152835160248401528351909283926044909101919085019080838360008315610619578181015183820152602001610601565b50600080546040516001600160a01b03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a3600080546001600160a01b0319166001600160a01b0392909216919091179055565b6040518060a00160405280600590602082028038833950919291505056fea165627a7a72305820f84b3f891f02b20c0c0ec29e7a1753452662f6b5960ef104cb82e16eaa8c398d0029";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_SETRANDOMRANDOMADDR = "setRandomRandomAddr";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_GETRANDOM = "getRandom";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_GETCURRENTRANDOMINDEX = "getCurrentRandomIndex";

    public static final String FUNC_SETRANDOMCONTRACTADDR = "setRandomContractAddr";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_GETRANDOMBYINDEX = "getRandomByIndex";

    public static final String FUNC_RANDOMRANDOMADDR = "randomRandomAddr";

    public static final String FUNC_RANDOMCONTRACTADDR = "randomContractAddr";

    public static final String FUNC_GETCURRENTRANDOM = "getCurrentRandom";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_ADDRANDOM = "addRandom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected RandomService(String contractAddress, Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3, credentials, gasPrice, gasLimit);
    }

    protected RandomService(String contractAddress, Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3, credentials, contractGasProvider);
    }

    @Deprecated
    protected RandomService(String contractAddress, Web3 web3,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3, transactionManager, gasPrice, gasLimit);
    }

    protected RandomService(String contractAddress, Web3 web3,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> deleteAdmin(String addr) {
        final Function function = new Function(
                FUNC_DELETEADMIN, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger _value, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> kill(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> setRandomRandomAddr(String _randomRandomAddr) {
        final Function function = new Function(
                FUNC_SETRANDOMRANDOMADDR, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, _randomRandomAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> ZERO_ADDRESS() {
        final Function function = new Function(FUNC_ZERO_ADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>> getRandom(BigInteger beginIndex,
            BigInteger endIndex) {
        final Function function = new Function(FUNC_GETRANDOM, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.generated.Uint256(beginIndex), 
                new io.hpb.web3.abi.datatypes.generated.Uint256(endIndex)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<StaticArray5<Uint8>>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>>(function,
                new Callable<Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>>() {
                    @Override
                    public Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>> call()
                            throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>(
                                convertToNative((List<Address>) results.get(0).getValue()), 
                                convertToNative((List<StaticArray5<Uint8>>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> addAdmin(String addr) {
        final Function function = new Function(
                FUNC_ADDADMIN, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> NOT_OWNER() {
        final Function function = new Function(FUNC_NOT_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getCurrentRandomIndex() {
        final Function function = new Function(FUNC_GETCURRENTRANDOMINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setRandomContractAddr(String _randomContractAddr) {
        final Function function = new Function(
                FUNC_SETRANDOMCONTRACTADDR, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, _randomContractAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> getRandomByIndex(BigInteger index) {
        final Function function = new Function(FUNC_GETRANDOMBYINDEX, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint8>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> randomRandomAddr() {
        final Function function = new Function(FUNC_RANDOMRANDOMADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> randomContractAddr() {
        final Function function = new Function(FUNC_RANDOMCONTRACTADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> getCurrentRandom() {
        final Function function = new Function(FUNC_GETCURRENTRANDOM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint8>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> adminMap(String param0) {
        final Function function = new Function(FUNC_ADMINMAP, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addRandom() {
        final Function function = new Function(
                FUNC_ADDRANDOM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ReceivedHpbEventResponse> getReceivedHpbEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVEDHPB_EVENT, transactionReceipt);
        ArrayList<ReceivedHpbEventResponse> responses = new ArrayList<ReceivedHpbEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedHpbEventResponse typedResponse = new ReceivedHpbEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedHpbEventResponse> receivedHpbEventFlowable(HpbFilter filter) {
        return web3.hpbLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReceivedHpbEventResponse>() {
            @Override
            public ReceivedHpbEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVEDHPB_EVENT, log);
                ReceivedHpbEventResponse typedResponse = new ReceivedHpbEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedHpbEventResponse> receivedHpbEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        HpbFilter filter = new HpbFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVEDHPB_EVENT));
        return receivedHpbEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(HpbFilter filter) {
        return web3.hpbLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        HpbFilter filter = new HpbFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    @Deprecated
    public static RandomService load(String contractAddress, Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new RandomService(contractAddress, web3, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RandomService load(String contractAddress, Web3 web3,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RandomService(contractAddress, web3, transactionManager, gasPrice, gasLimit);
    }

    public static RandomService load(String contractAddress, Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new RandomService(contractAddress, web3, credentials, contractGasProvider);
    }

    public static RandomService load(String contractAddress, Web3 web3,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RandomService(contractAddress, web3, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RandomService> deploy(Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(RandomService.class, web3, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<RandomService> deploy(Web3 web3, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(RandomService.class, web3, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<RandomService> deploy(Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(RandomService.class, web3, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<RandomService> deploy(Web3 web3, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(RandomService.class, web3, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class ReceivedHpbEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
