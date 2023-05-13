package payments;

import com.ingenico.connect.gateway.sdk.java.ApiException;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.DeclinedPaymentException;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.AmountOfMoney;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Card;
import com.ingenico.connect.gateway.sdk.java.domain.errors.definitions.APIError;
import com.ingenico.connect.gateway.sdk.java.domain.payment.CreatePaymentRequest;
import com.ingenico.connect.gateway.sdk.java.domain.payment.CreatePaymentResponse;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.*;

import java.io.File;
import java.net.URI;
import java.util.List;

public class CreatePayment {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\w104860\\OneDrive - Worldline\\Documents\\Java\\ConnectJava\\src\\main\\resources\\Caminho";
        File file = new File(filePath);
        URI propertiesUrl= file.toURI();
        Client client = Factory.createClient(propertiesUrl, "dfd1952dc924d813", "3It1Z8siQF+pxfa6TzSo64qMDq8uJ+iLS4TWnS1pCy0=");

        Card card = new Card();
        card.setCardNumber("4500600000000061");
        card.setCvv("123");
        card.setExpiryDate("1225");

        ThreeDSecure threeDSecure = new ThreeDSecure();
        threeDSecure.setSkipAuthentication(false);

        CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
        cardPaymentMethodSpecificInput.setCard(card);
        cardPaymentMethodSpecificInput.setPaymentProductId(1);
        cardPaymentMethodSpecificInput.setThreeDSecure(threeDSecure);

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

        CreatePaymentRequest body = new CreatePaymentRequest();
        body.setCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput);
        body.setOrder(order);

        try {
            CreatePaymentResponse response = client.merchant("10179").payments().create(body);
        } catch (DeclinedPaymentException e) {
            handleDeclinedPayment(e.getCreatePaymentResult());
        } catch (ApiException e) {
            handleApiErrors(e.getErrors());
        }

        //Working on implement the response.

    }

    private static void handleApiErrors(List<APIError> errors) {
    }

    private static void handleDeclinedPayment(CreatePaymentResult createPaymentResult) {
    }
}
