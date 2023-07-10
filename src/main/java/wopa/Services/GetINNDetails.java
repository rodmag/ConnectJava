package wopa.Services;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsRequest;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsResponse;
import GC.services.PreparaConexao;

public class GetINNDetails {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        GetIINDetailsRequest body = new GetIINDetailsRequest();
        body.setBin("4567350000427977");

        GetIINDetailsResponse response = client.merchant("merchantId").services().getIINdetails(body);

        Gson gson = new Gson();

        System.out.println("Resposta do Get INN Details: " + gson.toJson(response));

    }

}
