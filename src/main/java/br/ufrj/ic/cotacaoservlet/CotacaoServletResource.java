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
        html += "<body> <h1>TESTE ISSO MEU DEUS</h1> <p>"+ ReadingJSON.GetValorMoeda("USD", "BRL") + "</p> </body></html>";
        return html;
    }


}