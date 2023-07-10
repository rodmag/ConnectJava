package preparaConexao;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;

import java.io.File;
import java.net.URI;

public class PreparaConexao {

    public static Client startConection () {
        String filePath = "resources/Caminho.txt";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "apiKeyId", "secretApiKey");
        return client;
    }
}
