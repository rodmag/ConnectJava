package wopa.payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.capture.CaptureResponse;
import com.ingenico.connect.gateway.sdk.java.domain.payment.CapturePaymentRequest;
import GC.services.PreparaConexao;

public class CapturePayment {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        CapturePaymentRequest body = new CapturePaymentRequest();
        body.setAmount(4005L);

        CaptureResponse response = client.merchant("merchantId").payments().capture("10252149613", body);

        Gson gson = new Gson();

        System.out.println("Resposta do Capture Payment: " + gson.toJson(response));

    }

}
