package wopa.payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.payment.PaymentResponse;
import GC.services.PreparaConexao;

public class GetPayment {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        PaymentResponse response = client.merchant("merchantId").payments().get("10252135573");

        Gson gson = new Gson();

        System.out.println("Resposta do Get Payment: " + gson.toJson(response));

    }

}
