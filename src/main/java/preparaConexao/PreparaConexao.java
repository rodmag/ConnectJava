package preparaConexao;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;

import java.io.File;
import java.net.URI;

public class PreparaConexao {

    public static Client startConection () {
        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");
        return client;
    }
}
