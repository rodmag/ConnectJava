package GC.services;

import com.ingenico.connect.gateway.sdk.java.Client;

import java.net.URISyntaxException;

public class TestConnection {
    public static void main(String[] args) throws URISyntaxException {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        com.ingenico.connect.gateway.sdk.java.domain.services.TestConnection response = client.merchant("merchantId").services().testconnection();

        System.out.println("Resposta do Test Connection: " + response.getResult());

    }

}
