package wopa.token;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.CardWithoutCvv;
import com.ingenico.connect.gateway.sdk.java.domain.token.CreateTokenRequest;
import com.ingenico.connect.gateway.sdk.java.domain.token.CreateTokenResponse;
import com.ingenico.connect.gateway.sdk.java.domain.token.definitions.CustomerToken;
import com.ingenico.connect.gateway.sdk.java.domain.token.definitions.TokenCard;
import com.ingenico.connect.gateway.sdk.java.domain.token.definitions.TokenCardData;
import GC.services.PreparaConexao;

public class CreateToken {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        Address billingAddress = new Address();
        billingAddress.setCountryCode("MX");

        CustomerToken customer = new CustomerToken();
        customer.setBillingAddress(billingAddress);

        CardWithoutCvv cardWithoutCvv = new CardWithoutCvv();
        cardWithoutCvv.setCardNumber("4716610716618692");
        cardWithoutCvv.setExpiryDate("1027");

        TokenCardData data = new TokenCardData();
        data.setCardWithoutCvv(cardWithoutCvv);

        TokenCard card = new TokenCard();
        card.setCustomer(customer);
        card.setData(data);

        CreateTokenRequest body = new CreateTokenRequest();
        body.setCard(card);
        body.setPaymentProductId(1);

        CreateTokenResponse response = client.merchant("merchantId").tokens().create(body);

        Gson gson = new Gson();

        System.out.println("Resposta do Create Token: " + gson.toJson(response));

    }

}
