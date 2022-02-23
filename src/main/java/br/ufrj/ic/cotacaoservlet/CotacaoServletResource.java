package br.ufrj.ic.cotacaoservlet;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;



@Path("/listar")
public class CotacaoServletResource {
    @GET
    @Produces("text/html")
    public String hello() throws IOException {
        String html = "<html><head><meta charset=\"UTF-8\"><title>Cotacao</title></head>";
        html += "<body> <h1>TESTE ISSO MEU DEUS</h1> <p>"+ JSONToFloat("USD", "BRL") + "</p> </body></html>";
        return html;
    }

    public static float JSONToFloat(String origem, String destino) {
        float valor = 0;
        try {

            String link = "https://economia.awesomeapi.com.br/json/last/" + origem + "-" + destino;

            URL url = new URL(link);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                int posicaoAnterior = inline.indexOf('k') + 4;
                String stringSplitada = inline.substring(posicaoAnterior);
                int posicaoPosterior = stringSplitada.indexOf('"');

                valor = Float.parseFloat(stringSplitada.substring(0, posicaoPosterior));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
    }


}