package wopa.Services;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetPrivacyPolicyResponse;
import com.ingenico.connect.gateway.sdk.java.merchant.services.PrivacypolicyParams;
import GC.services.PreparaConexao;

public class GetPrivacyPolicy {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        PrivacypolicyParams query = new PrivacypolicyParams();
        query.setLocale("en_US");
        query.setPaymentProductId(1);

        GetPrivacyPolicyResponse response = client.merchant("1908466593").services().privacypolicy(query);

        Gson gson = new Gson();

        System.out.println("Resposta do Get Privacy Policy: " + gson.toJson(response));


    }

}
