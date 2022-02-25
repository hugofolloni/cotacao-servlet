package br.ufrj.ic.cotacaoservlet;

import java.io.*;

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
    public String hello() throws Exception {
        String html = "<html><head><meta charset=\"UTF-8\"><title>Cotacao</title></head>";
        html += "<body> <h1>TESTE ISSO MEU DEUS</h1> <p>"+ ReadingJSON.GetValorMoeda("USD", "BRL") + "</p>";
        html += "</body></html>";
        return html;
    }


}