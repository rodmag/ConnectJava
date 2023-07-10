package GC.products;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.product.PaymentProducts;
import com.ingenico.connect.gateway.sdk.java.merchant.products.FindProductsParams;
import preparaConexao.PreparaConexao;

public class GetPaymentProducts {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        FindProductsParams query = new FindProductsParams();
        query.setCountryCode("BR");
        query.setCurrencyCode("BRL");
        query.setLocale("en_US");
        query.setAmount(1000L);
        query.setIsRecurring(true);
        query.addHide("fields");

        PaymentProducts response = client.merchant("merchantId").products().find(query);

        Gson gson = new Gson();

        System.out.println("Resposta: " + gson.toJson(response));
    }

}
