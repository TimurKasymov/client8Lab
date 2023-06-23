package client.client8lab.backService;

import client.client8lab.ClientApplication;
import client.client8lab.backService.container.SettingsContainer;
import client.client8lab.backService.converters.SerializationManager;
import client.client8lab.backService.network_utilsV2.ReceivingManager;
import client.client8lab.backService.network_utilsV2.SendingManager;
import client.client8lab.backService.network_utilsV2.TCPServer;
import common.src.models.Product;
import common.src.models.Role;
import common.src.models.User;
import common.src.network.MessageType;
import common.src.network.Request;
import common.src.network.Response;
import javafx.application.Platform;
import javafx.concurrent.Task;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.LinkedHashMap;
import java.util.List;

public class BackendManager {

    private TCPServer tcpServer;
    private SendingManager sendingManager;
    private ReceivingManager receivingManager;
    private SocketChannel socketChannel;
    private final SerializationManager serializationManager;

    public BackendManager(){
        this.serializationManager = new SerializationManager();
    }

    public void initiateListener(BackendResponseHandler backendResponseHandler){
        if(tcpServer != null) return;
        tcpServer = new TCPServer(new InetSocketAddress(SettingsContainer.settingsModel.serverPort));
        receivingManager = new ReceivingManager(tcpServer);
        sendingManager = new SendingManager(tcpServer);
        socketChannel = tcpServer.start();
        var serializer = new SerializationManager();

        var task = new Task() {
            @Override
            protected Object call() throws Exception {
                    for(;;){
                        var bytes = receivingManager.receive();
                        var response = (Response) serializer.deserialize(bytes);
                        backendResponseHandler.handle(response);
                    }
            }
        };
        new Thread(task).start();
    }

    public void addProduct(Product product, String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.ADD);
        request.userName = name;
        request.userPassword = password;
        request.requiredArguments.add(product);
        complete(request);
    }

    public void executeScript(LinkedHashMap<String, List<String>> packedFile, String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.EXECUTE_SCRIPT);
        request.userName = name;
        request.userPassword = password;
        request.requiredArguments.add(packedFile);
        request.requiredArguments.add(10);
        complete(request);
    }

    public void clearAll(String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.CLEAR);
        request.userName = name;
        request.userPassword = password;
        complete(request);
    }

    public void update(Product product, String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.UPDATE_BY_ID);
        request.userName = name;
        request.userPassword = password;
        request.requiredArguments.add(product);
        complete(request);
    }

    public void delete(Product product, String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.REMOVE_BY_ID);
        request.userName = name;
        request.userPassword = password;
        request.requiredArguments.add(product.getId());
        complete(request);
    }

    public void login(String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.LOGIN);
        request.userName = name;
        request.userPassword = password;
        complete(request);
    }

    public void changeUserRole(String name, String password, int userId, Role role){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.ASSIGN_ROLE);
        request.userName = name;
        request.userPassword = password;
        request.requiredArguments.add(userId);
        request.requiredArguments.add(role);
        complete(request);
    }

    public void signup(String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.SIGNUP);
        request.userName = name;
        request.userPassword = password;
        complete(request);
    }

    public void requestData(String name, String password){
        if(tcpServer == null)
            return;
        var request = new Request(MessageType.DATA_REQUEST);
        request.userName = name;
        request.userPassword = password;
        complete(request);
    }


    private void complete(Request request){
        request.createNewUser = false;
        var serialized = serializationManager.serialize(request);
        sendingManager.contactServer(serialized);
    }
}
