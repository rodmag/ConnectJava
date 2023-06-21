package wopa.paymentGroups;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.product.PaymentProductGroups;
import com.ingenico.connect.gateway.sdk.java.merchant.productgroups.FindProductgroupsParams;
import GC.services.PreparaConexao;

public class GetPaymentProducts {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        FindProductgroupsParams query = new FindProductgroupsParams();
        query.setCountryCode("MX");
        query.setCurrencyCode("MXN");
        query.setLocale("en_US");
        query.setAmount(1000L);
        query.setIsRecurring(true);
        query.addHide("fields");

        PaymentProductGroups response = client.merchant("1908466593").productgroups().find(query);

        Gson gson = new Gson();

        System.out.println("Resposta do Get Payment Group: " + gson.toJson(response));

    }

}
