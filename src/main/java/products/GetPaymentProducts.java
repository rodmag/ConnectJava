package products;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.product.PaymentProducts;
import com.ingenico.connect.gateway.sdk.java.merchant.products.FindProductsParams;

import java.io.File;
import java.net.URI;

public class GetPaymentProducts {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");

        FindProductsParams query = new FindProductsParams();
        query.setCountryCode("BR");
        query.setCurrencyCode("BRL");
        query.setLocale("en_US");
        query.setAmount(1000L);
        query.setIsRecurring(true);
        query.addHide("fields");

        PaymentProducts response = client.merchant("10179").products().find(query);

        URI.
        //Working on implement the response.
    }

}
