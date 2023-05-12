package hostedCheckout;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.GetHostedCheckoutResponse;

import java.io.File;
import java.net.URI;

public class GetHostedCheckout {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");

        GetHostedCheckoutResponse response = client.merchant("10179").hostedcheckouts().get("0645e96b-08ba-71ff-90ae-3dad09bf3184");

        System.out.printf("The payment status is: " + response.getStatus());

    }
}
