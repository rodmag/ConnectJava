package GC.hostedCheckout;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.GetHostedCheckoutResponse;
import preparaConexao.PreparaConexao;

public class GetHostedCheckout {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        GetHostedCheckoutResponse response = client.merchant("10179").hostedcheckouts().get("0645e96b-08ba-71ff-90ae-3dad09bf3184");

        System.out.printf("The payment status is: " + response.getStatus());

    }
}
