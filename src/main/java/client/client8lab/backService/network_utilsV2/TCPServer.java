package client.client8lab.backService.network_utilsV2;

import client.client8lab.backService.container.SettingsContainer;

import common.src.loggerUtils.LoggerManager;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TCPServer {
    private final InetSocketAddress host;
    private SocketChannel socketChannel;
    private Logger logger;

    public TCPServer(InetSocketAddress host) {
        this.host = host;
        this.logger = LoggerManager.getLogger(TCPServer.class);
        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            try {
                System.out.println("closing socket...");
                socketChannel.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }));
    }


    synchronized public SocketChannel start() {
        for(;;){
            try {
                if(socketChannel != null &&  socketChannel.isOpen() && socketChannel.isConnected()) return socketChannel;
                this.socketChannel = SocketChannel.open();
                var port = SettingsContainer.settingsModel.localPort;
                socketChannel.bind(new InetSocketAddress("localhost", port));
                socketChannel.configureBlocking(false);
                socketChannel.connect(host);
                while (socketChannel.isConnectionPending()) {
                    var finished = socketChannel.finishConnect();
                }
                // if because of called finishConnect the connection got closed we are trying to make another connection
                if (!socketChannel.isOpen()) {
                    Thread.sleep(3000);
                    logger.info("not connected, waiting..");
                    continue;
                }
                return socketChannel;
            } catch (Exception e) {
                logger.info("TCP server: " + e.getMessage());
                try{
                    socketChannel.close();
                    Thread.sleep(3000);
                }
                catch (Exception e1){
                    logger.info("TCP server: " + e1.getMessage());
                }
            }
        }
    }

        public SocketChannel getSocketChannel () {
            return this.socketChannel;
        }
    }
