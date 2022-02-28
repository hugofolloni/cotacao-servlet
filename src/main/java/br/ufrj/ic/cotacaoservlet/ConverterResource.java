package br.ufrj.ic.cotacao;

import javax.ws.rs.*;

@Path("/converter")
public class ConverterResource {
    @GET
    @Produces("text/html")
    public static String converter(@QueryParam("valor") Float valor , @DefaultValue("USD") @QueryParam("entrada") String entrada, @DefaultValue("BRL") @QueryParam("saida") String saida, @QueryParam("taxa") @DefaultValue("0") float taxa, @QueryParam("imposto") @DefaultValue("0") float imposto) {
        return "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\"content=\"IE=edge\"><metaname=\"viewport\"content=\"width=devicewidth,initialscale=1.0\"><title>Converter</title></head><body><h1>valoresrecebidos:</h1><p>"+ printResultado(entrada, saida, valor, taxa, imposto) +"</p></body></html>";
    }

    public static float printResultado(String entrada, String saida, float valor, float taxa, float imposto){
        try {
            float cotacao = ReadingJSON.GetValorMoeda(entrada, saida);
            float resultado = valor*cotacao;
            float comImposto = resultado*imposto;
            float comTaxa = resultado*taxa;
            return (resultado - comImposto)- comTaxa;
        }catch(Exception e){e.printStackTrace();}

        return 0;
    }
}
