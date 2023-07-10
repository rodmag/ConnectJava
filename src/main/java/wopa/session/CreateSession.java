package wopa.session;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.sessions.SessionRequest;
import com.ingenico.connect.gateway.sdk.java.domain.sessions.SessionResponse;
import GC.services.PreparaConexao;

public class CreateSession {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        SessionRequest body = new SessionRequest();

        SessionResponse response = client.merchant("merchantId").sessions().create(body);

        Gson gson = new Gson();

        System.out.println("Resposta do Get Token: " + gson.toJson(response));

    }

}
