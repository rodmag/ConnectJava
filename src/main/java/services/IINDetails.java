package services;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsRequest;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsResponse;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class IINDetails {
    public static void main(String[] args) throws URISyntaxException {

        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");

        GetIINDetailsRequest body = new GetIINDetailsRequest();
        body.setBin("4485592758359790");

        GetIINDetailsResponse response = client.merchant("10179").services().getIINdetails(body);

        System.out.println("The card country is: " + response.getCountryCode());
        System.out.println("The card paymentID is: " + response.getPaymentProductId());

    }

}
