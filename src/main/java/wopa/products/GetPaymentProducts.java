package wopa.products;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.product.PaymentProducts;
import com.ingenico.connect.gateway.sdk.java.merchant.products.FindProductsParams;
import services.PreparaConexao;

public class GetPaymentProducts {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        FindProductsParams query = new FindProductsParams();
        query.setCountryCode("US");
        query.setCurrencyCode("USD");
        //query.setLocale("en_US");
        //query.setAmount(1000L);
        //query.setIsRecurring(true);
        //query.addHide("fields");

        PaymentProducts response = client.merchant("1908466593").products().find(query);

        Gson gson = new Gson();

        System.out.println("Resposta do Get Payment Products: " + gson.toJson(response));

    }

}
