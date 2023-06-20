package wopa.hostedCheckout;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.GetHostedCheckoutResponse;
import services.PreparaConexao;

public class GetHostedCheckout {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        GetHostedCheckoutResponse response = client.merchant("1908466593").hostedcheckouts().get("06492077-4d0b-71ff-8b41-7cc070aeb241");

        System.out.printf("The payment status is: " + response.getStatus());

    }

}
