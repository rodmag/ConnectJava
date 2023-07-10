package wopa.paymentGroups;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.product.PaymentProductGroupResponse;
import com.ingenico.connect.gateway.sdk.java.merchant.productgroups.GetProductgroupParams;
import GC.services.PreparaConexao;

public class GetPaymentProductGroup {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        GetProductgroupParams query = new GetProductgroupParams();
        query.setCountryCode("MX");
        query.setCurrencyCode("MXN");
        //query.setLocale("en_US");
       // query.setAmount(1000L);
      //  query.setIsRecurring(true);
     //   query.addHide("fields");

        PaymentProductGroupResponse response = client.merchant("merchantId").productgroups().get("1", query);

        Gson gson = new Gson();

        System.out.println("Resposta do Get Payment Product Group: " + gson.toJson(response));

    }

}
