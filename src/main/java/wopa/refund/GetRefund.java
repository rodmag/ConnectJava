package wopa.refund;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.refund.RefundResponse;
import GC.services.PreparaConexao;

public class GetRefund {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        RefundResponse response = client.merchant("merchantId").refunds().get("10252135573");

        Gson gson = new Gson();

        System.out.println("Resposta do Get Refund: " + gson.toJson(response));

    }
}
