package wopa.payments;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.ApiException;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.DeclinedRefundException;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.AmountOfMoney;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.ContactDetailsBase;
import com.ingenico.connect.gateway.sdk.java.domain.errors.definitions.APIError;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.AddressPersonal;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.PersonalName;
import com.ingenico.connect.gateway.sdk.java.domain.refund.RefundRequest;
import com.ingenico.connect.gateway.sdk.java.domain.refund.RefundResponse;
import com.ingenico.connect.gateway.sdk.java.domain.refund.definitions.RefundCustomer;
import com.ingenico.connect.gateway.sdk.java.domain.refund.definitions.RefundReferences;
import com.ingenico.connect.gateway.sdk.java.domain.refund.definitions.RefundResult;
import GC.services.PreparaConexao;

import java.util.List;

public class CreateRefund {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        AmountOfMoney amountOfMoney = new AmountOfMoney();
        amountOfMoney.setAmount(4005L);
        amountOfMoney.setCurrencyCode("MXN");

        PersonalName name = new PersonalName();
        name.setSurname("Coyote");

        AddressPersonal address = new AddressPersonal();
        address.setCountryCode("US");
        address.setName(name);

        ContactDetailsBase contactDetails = new ContactDetailsBase();
        contactDetails.setEmailAddress("wile.e.coyote@acmelabs.com");
        contactDetails.setEmailMessageType("html");

        RefundCustomer customer = new RefundCustomer();
        customer.setAddress(address);
        customer.setContactDetails(contactDetails);

        RefundReferences refundReferences = new RefundReferences();
        refundReferences.setMerchantReference("Refund_WOPA_001");

        RefundRequest body = new RefundRequest();
        body.setAmountOfMoney(amountOfMoney);
        body.setCustomer(customer);
        body.setRefundDate("20140306");
        body.setRefundReferences(refundReferences);

        Gson gson = new Gson();

        try {
            RefundResponse response = client.merchant("merchantId").payments().refund("10252135573", body);

            System.out.println("Resposta do Create Refund: " + gson.toJson(response));

        } catch (DeclinedRefundException e) {
            handleDeclinedRefund(e.getRefundResult());
        } catch (ApiException e) {
            handleApiErrors(e.getErrors());
        }

    }

    private static void handleApiErrors(List<APIError> errors) {
    }

    private static void handleDeclinedRefund(RefundResult refundResult) {
    }

}
