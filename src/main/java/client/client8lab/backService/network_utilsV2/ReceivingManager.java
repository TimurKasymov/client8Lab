package client.client8lab.backService.network_utilsV2;

import com.google.common.primitives.Bytes;

import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ReceivingManager {
    private byte[] receivedData;
    private final int DATA_CHUNK = 1024;
    private final TCPServer tcpServer;


    public ReceivingManager(TCPServer tcpServer) {
        this.tcpServer = tcpServer;
        this.receivedData = new byte[0];
    }
    public boolean isEnabled() {
        return ManagementFactory.getRuntimeMXBean()
                .getInputArguments()
                .toString().contains("jdwp");
    }
    public byte[] receive() {
        receivedData = new byte[0];
        while (true) {
            try {
                Thread.sleep(500);
                if (tcpServer.getSocketChannel() == null || !tcpServer.getSocketChannel().isConnected())
                    tcpServer.start();

                ByteBuffer byteBuffer = ByteBuffer.allocate(DATA_CHUNK);
                var readBytes = tcpServer.getSocketChannel().read(byteBuffer);
                if (readBytes == 0)
                    continue;
                if (readBytes == -1)
                    tcpServer.getSocketChannel().close();
                receivedData = Bytes.concat(receivedData, Arrays.copyOf(byteBuffer.array(), byteBuffer.array().length - 1));
                // reached the end of the object being sent
                if (byteBuffer.array()[readBytes - 1] == 1) {
                    return receivedData;
                }
                byteBuffer.clear();
            } catch (Exception e) {
                // server has crashed, and we got isConnectionPending - true and isOpen - true as well
                // and so we close the connection, because this channel is left by the server and create another one
                if (Objects.equals(e.getMessage(), "Connection reset")) {
                    try {
                        Thread.sleep(3000);
                        tcpServer.start();
                    } catch (Exception e1) {
                        System.err.println(e1.getMessage());
                    }
                }
            }
        }
    }
}
