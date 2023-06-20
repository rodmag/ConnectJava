package wopa.token;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.CardWithoutCvv;
import com.ingenico.connect.gateway.sdk.java.domain.token.UpdateTokenRequest;
import com.ingenico.connect.gateway.sdk.java.domain.token.definitions.CustomerToken;
import com.ingenico.connect.gateway.sdk.java.domain.token.definitions.TokenCard;
import com.ingenico.connect.gateway.sdk.java.domain.token.definitions.TokenCardData;
import services.PreparaConexao;

public class UpdateToken {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        Address billingAddress = new Address();
        billingAddress.setCountryCode("MX");

        CustomerToken customer = new CustomerToken();
        customer.setBillingAddress(billingAddress);

        CardWithoutCvv cardWithoutCvv = new CardWithoutCvv();
        cardWithoutCvv.setCardNumber("****************");
        cardWithoutCvv.setExpiryDate("****");

        TokenCardData data = new TokenCardData();
        data.setCardWithoutCvv(cardWithoutCvv);

        TokenCard card = new TokenCard();
        card.setCustomer(customer);
        card.setData(data);

        UpdateTokenRequest body = new UpdateTokenRequest();
        body.setCard(card);
        body.setPaymentProductId(1);

        client.merchant("1908466593").tokens().update("9000114769188692", body);

    }

}
