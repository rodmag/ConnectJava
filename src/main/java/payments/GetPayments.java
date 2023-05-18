package payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.payment.PaymentResponse;
import preparaConexao.PreparaConexao;

import java.io.File;
import java.net.URI;

public class GetPayments {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        PaymentResponse response = client.merchant("10179").payments().get("paymentId");

        Gson gson = new Gson();

        System.out.println("Resposta: " + gson.toJson(response));

    }
}
