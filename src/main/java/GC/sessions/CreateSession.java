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

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        SessionRequest body = new SessionRequest();

        SessionResponse response = client.merchant("merchantID").sessions().create(body);

        System.out.println("assetUrl : " + response.getAssetUrl());
        System.out.println("clientApiUrl: " + response.getClientApiUrl());
        System.out.println("clientSessionId: " + response.getClientSessionId());
        System.out.println("customerId: " + response.getCustomerId());
        System.out.println("region: " + response.getRegion());
        System.out.println("invalidTokens: " + response.getInvalidTokens());

    }

}
