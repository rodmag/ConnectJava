package wopa.captures;

import com.google.gson.Gson;
import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.domain.capture.CaptureResponse;
import GC.services.PreparaConexao;

public class GetCapture {

    public static void main(String[] args) {

        //Utiliza API e Secret key configurada no arquivo PreparaConexao.
        Client client = PreparaConexao.startConection();

        CaptureResponse response = client.merchant("1908466593").captures().get("10252149460");

        Gson gson = new Gson();

        System.out.println("Resposta do Get Capture: " + gson.toJson(response));

    }

}
