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
import io.hpb.web3.tuples.generated.Tuple2;
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
public class RandomContract extends Contract {
    private static final String BINARY = "60008054336001600160a01b0319918216178083556001600160a01b031680835260016020819052604080852080548516909317909255608084815261018090925260e084815261010085905261012085905261014085905261016085905260a081905260c08590526002805492830180825595527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace6003909202918201805490941684559192916100d5917f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf019060056100e8565b506040820151816002015550505061019c565b60018301918390821561016b5791602002820160005b8382111561013c57835183826101000a81548160ff021916908360ff16021790555092602001926001016020816000010492830192600103026100fe565b80156101695782816101000a81549060ff021916905560010160208160000104928301926001030261013c565b505b5061017792915061017b565b5090565b61019991905b8082111561017757805460ff19168155600101610181565b90565b610e75806101ab6000396000f3fe6080604052600436106100dd5760003560e01c80638051f37b1161007f578063c0d0ed7c11610059578063c0d0ed7c14610390578063d89601fd146103dd578063dbbc830b146103f2578063f2fde38b14610425576100dd565b80638051f37b146102bf5780638da5cb5b146102e65780638e9a800814610317576100dd565b806341c0e1b5116100bb57806341c0e1b5146101e5578063538ba4f9146101ed578063704802751461027757806371d78b12146102aa576100dd565b8063073b82391461011557806327e1f7df146101955780632e1a7d4d146101c8575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b34801561012157600080fd5b50610181600480360360c081101561013857600080fd5b6040805160a08181019092526001600160a01b0384351693928301929160c0830191906020840190600590839083908082843760009201919091525091945061045a9350505050565b604080519115158252519081900360200190f35b3480156101a157600080fd5b50610181600480360360208110156101b857600080fd5b50356001600160a01b0316610651565b610181600480360360208110156101de57600080fd5b503561078c565b61018161085b565b3480156101f957600080fd5b506102026108eb565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561023c578181015183820152602001610224565b50505050905090810190601f1680156102695780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561028357600080fd5b506101816004803603602081101561029a57600080fd5b50356001600160a01b0316610910565b3480156102b657600080fd5b506102026109e4565b3480156102cb57600080fd5b506102d4610a09565b60408051918252519081900360200190f35b3480156102f257600080fd5b506102fb610a13565b604080516001600160a01b039092168252519081900360200190f35b34801561032357600080fd5b506103416004803603602081101561033a57600080fd5b5035610a22565b6040516001600160a01b0384168152602081018360a080838360005b8381101561037557818101518382015260200161035d565b50505050905001828152602001935050505060405180910390f35b34801561039c57600080fd5b506103ba600480360360208110156103b357600080fd5b5035610af9565b604080516001600160a01b03909316835260208301919091528051918290030190f35b3480156103e957600080fd5b50610341610b2e565b3480156103fe57600080fd5b506102fb6004803603602081101561041557600080fd5b50356001600160a01b0316610c0d565b34801561043157600080fd5b506104586004803603602081101561044857600080fd5b50356001600160a01b0316610c28565b005b33600090815260016020908152604080832054815180830190925260068252600160d11b6518189c1818190292820192909252906001600160a01b031661052257604051600160e51b62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156104e75781810151838201526020016104cf565b50505050905090810190601f1680156105145780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b50604080516060810182526001600160a01b038581168252602082018581524293830193909352600280546001810180835560009290925283517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace600390920291820180546001600160a01b03191691909416178355935190936105cc917f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf909101906005610d7a565b5060408201518160020155505050826001600160a01b03167f78d7a5f4daf574cca1f41bbc727f43ffa045265cb4bd6dfc64cca0072d03767183426040518083600560200280838360005b8381101561062f578181015183820152602001610617565b505050509050018281526020019250505060405180910390a250600192915050565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b031633146106cf57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b506001600160a01b0382811660009081526001602090815260409182902054825180840190935260068352600160d11b6518189c181819029183019190915290911661075f57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b50506001600160a01b0316600090815260016020819052604090912080546001600160a01b031916905590565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461080a57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b50303182111561081957600080fd5b600080546040516001600160a01b039091169184156108fc02918591818181858888f19350505050158015610852573d6000803e3d6000fd5b50600192915050565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b031633146108d957604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b506000546001600160a01b0316ff5b90565b604051806040016040528060068152602001600160d11b6518189c1818190281525081565b600080546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b0316331461098e57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b506001600160a01b0382811660009081526001602052604090205416156109b457600080fd5b506001600160a01b0316600081815260016020819052604090912080546001600160a01b03191690921790915590565b604051806040016040528060068152602001600160d01b653031383030310281525081565b6002546000190190565b6000546001600160a01b031681565b6000610a2c610e0d565b600083610a3857600080fd5b60028481548110610a4557fe5b6000918252602090912060039091020154600280546001600160a01b039092169186908110610a7057fe5b906000526020600020906003020160010160028681548110610a8e57fe5b600091825260208220600390910201600201546040805160a0810191829052919284916005918390855b825461010083900a900460ff16815260206001928301818104948501949093039092029101808411610ab85750979c949b5094995092975050505050505050565b60028181548110610b0657fe5b6000918252602090912060039091020180546002909101546001600160a01b03909116915082565b6000610b38610e0d565b6002546000906000190180610b4c57600080fd5b60028181548110610b5957fe5b6000918252602090912060039091020154600280546001600160a01b039092169183908110610b8457fe5b906000526020600020906003020160010160028381548110610ba257fe5b600091825260208220600390910201600201546040805160a0810191829052919284916005918390855b825461010083900a900460ff16815260206001928301818104948501949093039092029101808411610bcc5790505050505050915093509350935050909192565b6001602052600090815260409020546001600160a01b031681565b6000546040805180820190915260068152600160d01b65303138303031026020820152906001600160a01b03163314610ca557604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b506040805180820190915260068152600160d11b6518189c1818190260208201526001600160a01b038216610d1e57604051600160e51b62461bcd0281526020600482018181528351602484015283519092839260449091019190850190808383600083156104e75781810151838201526020016104cf565b50600080546040516001600160a01b03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a3600080546001600160a01b0319166001600160a01b0392909216919091179055565b600183019183908215610dfd5791602002820160005b83821115610dce57835183826101000a81548160ff021916908360ff1602179055509260200192600101602081600001049283019260010302610d90565b8015610dfb5782816101000a81549060ff0219169055600101602081600001049283019260010302610dce565b505b50610e09929150610e2b565b5090565b6040518060a001604052806005906020820280388339509192915050565b6108e891905b80821115610e0957805460ff19168155600101610e3156fea165627a7a72305820a2d8c3e6d4dbb29a13b8c385f92f3a69118c691618bbd79b01aeed742d4eee240029";

    public static final String FUNC_ADDRANDOM = "addRandom";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_GETCURRENTRANDOMINDEX = "getCurrentRandomIndex";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_GETRANDOMBYINDEX = "getRandomByIndex";

    public static final String FUNC_RANDOMS = "randoms";

    public static final String FUNC_GETCURRENTRANDOM = "getCurrentRandom";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ADDRANDOM_EVENT = new Event("AddRandom", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected RandomContract(String contractAddress, Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3, credentials, gasPrice, gasLimit);
    }

    protected RandomContract(String contractAddress, Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3, credentials, contractGasProvider);
    }

    @Deprecated
    protected RandomContract(String contractAddress, Web3 web3,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3, transactionManager, gasPrice, gasLimit);
    }

    protected RandomContract(String contractAddress, Web3 web3,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addRandom(String addr, List<BigInteger> data) {
        final Function function = new Function(
                FUNC_ADDRANDOM, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.Address(160, addr), 
                new io.hpb.web3.abi.datatypes.generated.StaticArray5<io.hpb.web3.abi.datatypes.generated.Uint8>(
                        io.hpb.web3.abi.datatypes.generated.Uint8.class,
                        io.hpb.web3.abi.Utils.typeMap(data, io.hpb.web3.abi.datatypes.generated.Uint8.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteFunctionCall<BigInteger> getCurrentRandomIndex() {
        final Function function = new Function(FUNC_GETCURRENTRANDOMINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<Tuple2<String, BigInteger>> randoms(BigInteger param0) {
        final Function function = new Function(FUNC_RANDOMS, 
                Arrays.<Type>asList(new io.hpb.web3.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<String, BigInteger>>(function,
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
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

    public List<AddRandomEventResponse> getAddRandomEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDRANDOM_EVENT, transactionReceipt);
        ArrayList<AddRandomEventResponse> responses = new ArrayList<AddRandomEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddRandomEventResponse typedResponse = new AddRandomEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.blockTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddRandomEventResponse> addRandomEventFlowable(HpbFilter filter) {
        return web3.hpbLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddRandomEventResponse>() {
            @Override
            public AddRandomEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDRANDOM_EVENT, log);
                AddRandomEventResponse typedResponse = new AddRandomEventResponse();
                typedResponse.log = log;
                typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.blockTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddRandomEventResponse> addRandomEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        HpbFilter filter = new HpbFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDRANDOM_EVENT));
        return addRandomEventFlowable(filter);
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
    public static RandomContract load(String contractAddress, Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new RandomContract(contractAddress, web3, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RandomContract load(String contractAddress, Web3 web3,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RandomContract(contractAddress, web3, transactionManager, gasPrice, gasLimit);
    }

    public static RandomContract load(String contractAddress, Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new RandomContract(contractAddress, web3, credentials, contractGasProvider);
    }

    public static RandomContract load(String contractAddress, Web3 web3,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RandomContract(contractAddress, web3, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RandomContract> deploy(Web3 web3, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(RandomContract.class, web3, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<RandomContract> deploy(Web3 web3,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            BigInteger initialWeiValue) {
        return deployRemoteCall(RandomContract.class, web3, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<RandomContract> deploy(Web3 web3, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(RandomContract.class, web3, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<RandomContract> deploy(Web3 web3,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            BigInteger initialWeiValue) {
        return deployRemoteCall(RandomContract.class, web3, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class ReceivedHpbEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class AddRandomEventResponse extends BaseEventResponse {
        public String addr;

        public List<BigInteger> data;

        public BigInteger blockTime;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
