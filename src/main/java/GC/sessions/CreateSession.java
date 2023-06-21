package GC.sessions;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.sessions.SessionRequest;
import com.ingenico.connect.gateway.sdk.java.domain.sessions.SessionResponse;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class CreateSession {
    public static void main(String[] args) throws URISyntaxException {

        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");

        SessionRequest body = new SessionRequest();

        SessionResponse response = client.merchant("10179").sessions().create(body);

        System.out.println("assetUrl : " + response.getAssetUrl());
        System.out.println("clientApiUrl: " + response.getClientApiUrl());
        System.out.println("clientSessionId: " + response.getClientSessionId());
        System.out.println("customerId: " + response.getCustomerId());
        System.out.println("region: " + response.getRegion());
        System.out.println("invalidTokens: " + response.getInvalidTokens());

    }

}