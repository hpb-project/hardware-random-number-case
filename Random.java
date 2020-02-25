package io.hpb.ballot.contract;

import io.hpb.web3.abi.EventEncoder;
import io.hpb.web3.abi.TypeReference;
import io.hpb.web3.abi.datatypes.Address;
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
@SuppressWarnings("rawtypes")
public class Random extends Contract {
    private static final String BINARY = "60806040908152600080546001600160a01b031990811633178083556001600160a01b031680835260016020529290912080549091169091179055610929806100496000396000f3fe6080604052600436106100915760003560e01c80637048027511610059578063704802751461020c57806371d78b121461023f5780638da5cb5b14610254578063dbbc830b14610285578063f2fde38b146102b857610091565b806302e4af01146100c957806327e1f7df146101165780632e1a7d4d1461015d57806341c0e1b51461017a578063538ba4f914610182575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b3480156100d557600080fd5b506100de6102ed565b604051808260a080838360005b838110156101035781810151838201526020016100eb565b5050505090500191505060405180910390f35b34801561012257600080fd5b506101496004803603602081101561013957600080fd5b50356001600160a01b0316610371565b604080519115158252519081900360200190f35b6101496004803603602081101561017357600080fd5b50356104e9565b6101496105b8565b34801561018e57600080fd5b50610197610645565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101d15781810151838201526020016101b9565b50505050905090810190601f1680156101fe5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561021857600080fd5b506101496004803603602081101561022f57600080fd5b50356001600160a01b031661066a565b34801561024b57600080fd5b5061019761073e565b34801561026057600080fd5b50610269610763565b604080516001600160a01b039092168252519081900360200190f35b34801561029157600080fd5b50610269600480360360208110156102a857600080fd5b50356001600160a01b0316610772565b3480156102c457600080fd5b506102eb600480360360208110156102db57600080fd5b50356001600160a01b031661078d565b005b6102f56108df565b6040805146602080830191909152825180830382018152918301909252805191012061031f6108df565b6040518060a001604052806009848161033457fe5b0660ff1681526020016008840660ff1681526020016007840660ff1681526020016006840660ff1681526020016005840660ff1690529392505050565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461042c57604051600160e51b62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156103f15781810151838201526020016103d9565b50505050905090810190601f16801561041e5780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b506001600160a01b0382811660009081526001602090815260409182902054825180840190935260068352600160d11b6518189c18181902918301919091529091166104bc57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156103f15781810151838201526020016103d9565b50506001600160a01b0316600090815260016020819052604090912080546001600160a01b031916905590565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461056757604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156103f15781810151838201526020016103d9565b50303182111561057657600080fd5b600080546040516001600160a01b039091169184156108fc02918591818181858888f193505050501580156105af573d6000803e3d6000fd5b50600192915050565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461063657604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156103f15781810151838201526020016103d9565b506000546001600160a01b0316ff5b604051806040016040528060068152602001600160d11b6518189c1818190281525081565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b031633146106e857604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156103f15781810151838201526020016103d9565b506001600160a01b03828116600090815260016020526040902054161561070e57600080fd5b506001600160a01b0316600081815260016020819052604090912080546001600160a01b03191690921790915590565b604051806040016040528060068152602001600160d01b653031383030310281525081565b6000546001600160a01b031681565b6001602052600090815260409020546001600160a01b031681565b6000546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461080a57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156103f15781810151838201526020016103d9565b506040805180820190915260068152600160d11b6518189c1818190260208201526001600160a01b03821661088357604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156103f15781810151838201526020016103d9565b50600080546040516001600160a01b03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a3600080546001600160a01b0319166001600160a01b0392909216919091179055565b6040518060a00160405280600590602082028038833950919291505056fea165627a7a72305820df3c20da3f6e340eb21484028f2bb812eaa116db3adfa931523667ef4c94e8950029";

    public static final String FUNC_GENERATERANDOM = "generateRandom";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected Random(String contractAddress, Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3, credentials, gasPrice, gasLimit);
    }

    protected Random(String contractAddress, Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3, credentials, contractGasProvider);
    }

    @Deprecated
    protected Random(String contractAddress, Web3 web3, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3, transactionManager, gasPrice, gasLimit);
    }

    protected Random(String contractAddress, Web3 web3, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<List> generateRandom() {
        final Function function = new Function(FUNC_GENERATERANDOM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray5<Uint8>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
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

    public RemoteFunctionCall<String> ZERO_ADDRESS() {
        final Function function = new Function(FUNC_ZERO_ADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> adminMap(String param0) {
        final Function function = new Function(FUNC_ADMINMAP, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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
    public static Random load(String contractAddress, Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Random(contractAddress, web3, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Random load(String contractAddress, Web3 web3,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Random(contractAddress, web3, transactionManager, gasPrice, gasLimit);
    }

    public static Random load(String contractAddress, Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Random(contractAddress, web3, credentials, contractGasProvider);
    }

    public static Random load(String contractAddress, Web3 web3,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Random(contractAddress, web3, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Random> deploy(Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(Random.class, web3, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<Random> deploy(Web3 web3, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(Random.class, web3, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Random> deploy(Web3 web3, Credentials credentials, BigInteger gasPrice,
            BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(Random.class, web3, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Random> deploy(Web3 web3, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(Random.class, web3, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
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
