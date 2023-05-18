package hostedCheckout;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.AmountOfMoney;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.CreateHostedCheckoutRequest;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.CreateHostedCheckoutResponse;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.definitions.HostedCheckoutSpecificInput;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.Customer;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.Order;
import preparaConexao.PreparaConexao;

import java.io.File;
import java.net.URI;

public class CreateHostedCheckout {
    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        HostedCheckoutSpecificInput hostedCheckoutSpecificInput = new HostedCheckoutSpecificInput();
        hostedCheckoutSpecificInput.setLocale("en_GB");
        hostedCheckoutSpecificInput.setVariant("testVariant");

        AmountOfMoney amountOfMoney = new AmountOfMoney();
        amountOfMoney.setAmount(2345L);
        amountOfMoney.setCurrencyCode("BRL");

        Address billingAddress = new Address();
        billingAddress.setCountryCode("BR");

        Customer customer = new Customer();
        customer.setBillingAddress(billingAddress);
        customer.setMerchantCustomerId("1234");

        Order order = new Order();
        order.setAmountOfMoney(amountOfMoney);
        order.setCustomer(customer);

        CreateHostedCheckoutRequest body = new CreateHostedCheckoutRequest();
        body.setHostedCheckoutSpecificInput(hostedCheckoutSpecificInput);
        body.setOrder(order);

        CreateHostedCheckoutResponse response = client.merchant("10179").hostedcheckouts().create(body);

        System.out.println("RETURNMAC: " + response.getRETURNMAC());
        System.out.println("hostedCheckoutId: " + response.getHostedCheckoutId());
        System.out.println("partialRedirectUrl: " + "https://payment." + response.getPartialRedirectUrl());

    }

}
