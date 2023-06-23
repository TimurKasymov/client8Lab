package client.client8lab.backService.network_utilsV2;

import client.client8lab.backService.container.SettingsContainer;
import com.google.common.primitives.Bytes;
import common.src.loggerUtils.LoggerManager;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

public class SendingManager {
    private final int PACKET_SIZE = SettingsContainer.settingsModel.packageSize;
    private final int DATA_SIZE = PACKET_SIZE - 1;
    private final TCPServer tcpServer;

    public SendingManager(TCPServer tcpServer) {
        this.tcpServer = tcpServer;
    }

    public void contactServer(byte[] data) {
        var logger = LoggerManager.getLogger(SendingManager.class);
        for(;;) {
            try {

                byte[][] ret = new byte[(int) Math.ceil(data.length / (double) DATA_SIZE)][DATA_SIZE];

                int start = 0;
                for (int i = 0; i < ret.length; i++) {
                    ret[i] = Arrays.copyOfRange(data, start, start + DATA_SIZE);
                    start += DATA_SIZE;
                }

                logger.info("Отправляется " + ret.length + " чанков...");

                for (int i = 0; i < ret.length; i++) {
                    var chunk = ret[i];
                    if (i == ret.length - 1) {
                        var lastChunk = Bytes.concat(chunk, new byte[]{1});
                        tcpServer.getSocketChannel().write(ByteBuffer.wrap(lastChunk));
                        logger.info("Последний чанк размером " + chunk.length + " отправлен на сервер.");
                    } else {
                        chunk = Bytes.concat(chunk, new byte[]{0});
                        tcpServer.getSocketChannel().write(ByteBuffer.wrap(chunk));
                        logger.info("Чанк размером " + chunk.length + " отправлен на сервер.");
                    }
                }
                return;
            }
            catch (Exception e) {
                // server has crashed, and we got isConnectionPending - true and isOpen - true as well
                // and so we close the connection, because this channel is left by the server and create another one
                if (Objects.equals(e.getMessage(), "Connection reset")) {
                    try {
                        Thread.sleep(3000);
                        tcpServer.getSocketChannel().close();
                        tcpServer.start();
                    } catch (Exception e1) {
                        System.err.println(e1.getMessage());
                    }
                }
            }
            finally {
            }
        }
    }
}
