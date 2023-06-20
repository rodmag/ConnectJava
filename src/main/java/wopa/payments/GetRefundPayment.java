package wopa.payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.refund.RefundsResponse;
import services.PreparaConexao;

public class GetRefundPayment {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        RefundsResponse response = client.merchant("1908466593").payments().refunds("10252149704");

        Gson gson = new Gson();

        System.out.println("Resposta do Get Refund Payment: " + gson.toJson(response));

    }

}
