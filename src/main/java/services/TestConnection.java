package services;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) throws URISyntaxException {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        com.ingenico.connect.gateway.sdk.java.domain.services.TestConnection response = client.merchant("1908466593").services().testconnection();

        System.out.println(response.getResult());

    }

}
