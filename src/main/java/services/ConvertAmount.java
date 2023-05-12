package services;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsRequest;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsResponse;
import com.ingenico.connect.gateway.sdk.java.merchant.services.ConvertAmountParams;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class ConvertAmount {
    public static void main(String[] args) throws URISyntaxException {

        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");

        ConvertAmountParams query = new ConvertAmountParams();
        query.setSource("USD");
        query.setTarget("BRL");
        query.setAmount(100L);

        com.ingenico.connect.gateway.sdk.java.domain.services.ConvertAmount response = client.merchant("10179").services().convertAmount(query);

        System.out.println("Convert: " + query.getSource() + " To: " + query.getTarget());
        System.out.println("Converted value is: " + response.getConvertedAmount());

    }

}
