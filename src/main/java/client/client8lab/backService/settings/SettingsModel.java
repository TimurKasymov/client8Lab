package client.client8lab.backService.settings;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SettingsModel {
    @JsonProperty("local_port")
    public int localPort;
    @JsonProperty("server_port")
    public int serverPort;
    @JsonProperty("package_bytes_size")
    public Integer packageSize;
}
