package wopa.token;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.token.TokenResponse;
import GC.services.PreparaConexao;

public class GetToken {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        TokenResponse response = client.merchant("merchantId").tokens().get("9000114769188692");

        Gson gson = new Gson();

        System.out.println("Resposta do Get Token: " + gson.toJson(response));

    }

}
