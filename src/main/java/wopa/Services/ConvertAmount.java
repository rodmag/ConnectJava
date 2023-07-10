package wopa.Services;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.merchant.services.ConvertAmountParams;
import GC.services.PreparaConexao;

public class ConvertAmount {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        ConvertAmountParams query = new ConvertAmountParams();
        query.setSource("EUR");
        query.setTarget("USD");
        query.setAmount(100L);

        com.ingenico.connect.gateway.sdk.java.domain.services.ConvertAmount response = client.merchant("merchantId").services().convertAmount(query);

        Gson gson = new Gson();

        System.out.println("Resposta do Convert Amount: " + gson.toJson(response));

    }

}
