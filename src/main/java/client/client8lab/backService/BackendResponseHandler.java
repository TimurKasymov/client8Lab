package client.client8lab.backService;

import common.src.models.Product;
import common.src.models.User;
import common.src.network.Response;

import java.util.List;

@FunctionalInterface
public interface BackendResponseHandler {
    void handle(Response response);
}
