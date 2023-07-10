package wopa.products;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.product.PaymentProductResponse;
import com.ingenico.connect.gateway.sdk.java.merchant.products.GetProductParams;
import GC.services.PreparaConexao;

public class GetPaymentProduct {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        GetProductParams query = new GetProductParams();
        query.setCountryCode("MX");
        query.setCurrencyCode("MXN");
        //query.setLocale("en_US");
        //query.setAmount(1000L);
        //query.setIsRecurring(true);
        //query.setForceBasicFlow(false);
        //query.addHide("fields");

        PaymentProductResponse response = client.merchant("merchantId").products().get(1, query);

        Gson gson = new Gson();

        System.out.println("Resposta do Get Payment Products: " + gson.toJson(response));

    }

}
