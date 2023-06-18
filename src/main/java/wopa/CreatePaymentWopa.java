package wopa;

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

public class CreatePaymentWopa {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        Card card = new Card();
        card.setCardNumber("4507999999999991");
        card.setCvv("123");
        card.setExpiryDate("1231");

        Merchant merchant = new Merchant();
        merchant.setConfigurationId("8002408");

        RedirectionData redirectionData = new RedirectionData();
        redirectionData.setReturnUrl("https://www.uol.com.br");

        ThreeDSecure threeDSecure = new ThreeDSecure();
        threeDSecure.setSkipAuthentication(true);
        threeDSecure.setRedirectionData(redirectionData);

        CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
        cardPaymentMethodSpecificInput.setCard(card);
        cardPaymentMethodSpecificInput.setPaymentProductId(1);
        cardPaymentMethodSpecificInput.setAuthorizationMode("SALE");
        cardPaymentMethodSpecificInput.setThreeDSecure(threeDSecure);

        AmountOfMoney amountOfMoney = new AmountOfMoney();
        amountOfMoney.setAmount(4005L);
        amountOfMoney.setCurrencyCode("MXN");

        Address billingAddress = new Address();
        billingAddress.setCountryCode("MX");

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setEmailAddress("wile.e.coyote@acmelabs.com");
        contactDetails.setFaxNumber("+1234567891");
        contactDetails.setPhoneNumber("+1234567890");

        PersonalName name = new PersonalName();
        name.setFirstName("Wile");
        name.setSurname("Coyote");
        name.setSurnamePrefix("E.");
        name.setTitle("Mr.");

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setDateOfBirth("19490917");
        personalInformation.setGender("male");
        personalInformation.setName(name);

        Customer customer = new Customer();
        customer.setBillingAddress(billingAddress);
        customer.setMerchantCustomerId("1234");
        customer.setContactDetails(contactDetails);
        customer.setPersonalInformation(personalInformation);

        OrderReferences references = new OrderReferences();
        references.setDescriptor("Fast and Furry-ous");
        references.setMerchantOrderId(123456L);
        references.setMerchantReference("From_Java_0006");

        Order order = new Order();
        order.setAmountOfMoney(amountOfMoney);
        order.setCustomer(customer);
        order.setReferences(references);

        CreatePaymentRequest body = new CreatePaymentRequest();
        body.setCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput);
        body.setOrder(order);
        body.setMerchant(merchant);

        Gson gson = new Gson();

        try {
            CreatePaymentResponse response = client.merchant("1908466593").payments().create(body);

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
