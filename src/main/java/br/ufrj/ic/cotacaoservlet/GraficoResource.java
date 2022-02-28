package br.ufrj.ic.cotacao;

import javax.ws.rs.*;
import java.io.FileNotFoundException;

@Path("/grafico")
public class GraficoResource {
    @GET
    @Produces("text/html")
    public static String grafico(@QueryParam("moeda") @DefaultValue("USD") String moeda, @QueryParam("dias") @DefaultValue("30") int dias){

        try {
            String grafico = "<div style='width: 80vw; height: 70vh;'> " + GeraGraficoResource.gerarGrafico(moeda, dias) + "</div>";
        }catch(Exception e){e.printStackTrace();}
    }
}
