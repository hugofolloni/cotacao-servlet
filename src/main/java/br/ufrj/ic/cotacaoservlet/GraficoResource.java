package br.ufrj.ic.cotacao;

import javax.ws.rs.*;
import java.io.FileNotFoundException;

@Path("/grafico")
public class GraficoResource {
    @GET
    @Produces("text/html")
    public static String grafico(@QueryParam("moeda") @DefaultValue("USD") String moeda, @QueryParam("dias") @DefaultValue("30") int dias){

        try {
            String grafico = GeraGraficoResource.gerarGrafico(moeda, dias);
        }catch(Exception e){e.printStackTrace();}
    }
}
