package wopa.hostedCheckout;

import com.ingenico.connect.gateway.sdk.java.Client;
import GC.services.PreparaConexao;

public class DeleteHostedCheckout {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        client.merchant("merchantId").hostedcheckouts().delete("06492085-abb7-71ff-a29f-0da3c59732a3");



    }

}
