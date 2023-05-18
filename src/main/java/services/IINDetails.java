package services;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsRequest;
import com.ingenico.connect.gateway.sdk.java.domain.services.GetIINDetailsResponse;
import preparaConexao.PreparaConexao;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class IINDetails {
    public static void main(String[] args) throws URISyntaxException {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        GetIINDetailsRequest body = new GetIINDetailsRequest();
        body.setBin("4485592758359790");

        GetIINDetailsResponse response = client.merchant("10179").services().getIINdetails(body);

        System.out.println("The card country is: " + response.getCountryCode());
        System.out.println("The card paymentID is: " + response.getPaymentProductId());

    }

}
