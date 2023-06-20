package wopa.payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.payment.CancelPaymentResponse;
import services.PreparaConexao;

public class CancelPayment {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        CancelPaymentResponse response = client.merchant("1908466593").payments().cancel("10252149460");

        Gson gson = new Gson();

        System.out.println("Resposta do Cancel Payment: " + gson.toJson(response));

    }

}
