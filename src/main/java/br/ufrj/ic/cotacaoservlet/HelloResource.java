package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/listar")
public class CotacaoServletResource {
    @GET
    @Produces("text/html")
    public String hello() {
        String html = "<html><head><meta charset=\"UTF-8\"><title>Cotacao</title></head>";
        html += "
            <body>
                <h1>Testa essa porra</h1>
                <p>"+ ReadingJSON.ReadingEconomia() + "</p>
            </body></html>";
        return html;
    }
}