package GC.hostedCheckout;

import com.ingenico.connect.gateway.sdk.java.Client;
import preparaConexao.PreparaConexao;

public class DeleteHostedCheckout {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        client.merchant("merchantId").hostedcheckouts().delete("0645e97d-f3ed-71ff-80d4-69496420393c");

    }

}
