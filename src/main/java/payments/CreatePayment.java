package payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.ApiException;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.DeclinedPaymentException;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.AmountOfMoney;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Card;
import com.ingenico.connect.gateway.sdk.java.domain.errors.definitions.APIError;
import com.ingenico.connect.gateway.sdk.java.domain.payment.CreatePaymentRequest;
import com.ingenico.connect.gateway.sdk.java.domain.payment.CreatePaymentResponse;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.*;
import services.PreparaConexao;

import java.util.List;

public class CreatePayment {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        Card card = new Card();
        card.setCardNumber("4500600000000061");
        card.setCvv("123");
        card.setExpiryDate("1225");

        CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
        cardPaymentMethodSpecificInput.setCard(card);
        cardPaymentMethodSpecificInput.setPaymentProductId(1);

        AmountOfMoney amountOfMoney = new AmountOfMoney();
        amountOfMoney.setAmount(4005L);
        amountOfMoney.setCurrencyCode("BRL");

        Address billingAddress = new Address();
        billingAddress.setCountryCode("BR");

        Customer customer = new Customer();
        customer.setBillingAddress(billingAddress);
        customer.setMerchantCustomerId("1234");

        Order order = new Order();
        order.setAmountOfMoney(amountOfMoney);
        order.setCustomer(customer);

        OrderReferences orderReferences = new OrderReferences();
        orderReferences.setMerchantReference("teste1327");
        order.setReferences(orderReferences);

        CreatePaymentRequest body = new CreatePaymentRequest();
        body.setCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput);
        body.setOrder(order);

        Gson gson = new Gson();

        try {
            CreatePaymentResponse response = client.merchant("10179").payments().create(body);

            System.out.println("Resposta: " + gson.toJson(response));

        } catch (DeclinedPaymentException e) {
            handleDeclinedPayment(e.getCreatePaymentResult());
            e.printStackTrace();
        } catch (ApiException e) {
            handleApiErrors(e.getErrors());
            e.printStackTrace();
        }

    }

    private static void handleApiErrors(List<APIError> errors) {
    }

    private static void handleDeclinedPayment(CreatePaymentResult createPaymentResult) {
    }
}
