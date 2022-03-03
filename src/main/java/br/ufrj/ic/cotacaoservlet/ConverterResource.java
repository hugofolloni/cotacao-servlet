package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.*;

@Path("/converter")
public class ConverterResource {
    @GET
    @Produces("text/html")
    public String converter(@QueryParam("valor") Float valor , @DefaultValue("USD") @QueryParam("entrada") String entrada, @DefaultValue("BRL") @QueryParam("saida") String saida, @QueryParam("taxa") @DefaultValue("0") float taxa, @QueryParam("imposto") @DefaultValue("0") float imposto) throws Exception {
        String html = "<!DOCTYPE html>" +
                    "<html lang=\"pt-br\">" +
                    "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        "<title>Cotacoins</title>" +
                        "<style>" +
                            "div h2::before{" +
                               " content:'';" +
                                "position: absolute;" +
                                "height: 4px;" +
                                "width: 100px;" +
                                "bottom: 3px;" +
                               " left: 40;" +
                                "top: 0;" +
                                "margin-top: 185px;" +
                                "border-radius: 8px;" +
                               " background: linear-gradient(45deg, #8e2de2, #4a00e0);" +
                            "}" +
                        ".setinha{ transition: 0.3s ease all; }" +
                        ".setinha:hover{ color: #8e2de2; }" +
                    "</style>" +
                    "</head>" +
                    "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>" +
                    "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >" +
                "<a href=\"input-converter\" style=\"position: absolute; left: 0; top: 0; margin: 50px 0px 0px 50px; text-decoration: none; font-weight: 700; font-size: 40px; color: white;\"><p class=\"setinha\"><</p></a>" +
                "<div style=\"display: flex; width: 30vw; flex-direction: column; background-color: #3c3c3c; padding: 20px 30px; border-radius: 15px;\">" +
                            "<h2>Conversão de " + entrada + " para " + saida  + "</h2>" +
                            "<p>Valor inicial: " + valor + " " + entrada + "</p>" +
                            "<p>Cotação unitária: " + ReadingJSON.GetValorMoeda(entrada, saida) + "</p>" +
                            "<p>Taxa de Câmbio: " + taxa + "%</p>" +
                            "<p>Taxa de imposto: " + imposto + "%</p>" +
                            "<h4 style=\"margin-left: 25px;\">Valor final: " + printResultado(entrada, saida, valor, taxa, imposto) + " " + saida + "</h4>" +
                        "</div>" +
                    "</body>" +
                    "</html>";
        return html;
    }

    /*
    Método para o cálculo da conversão da moeda, considerando possíveis taxas e impostos.
    Contém um try-catch para uma eventual exceção.
    */
    public static float printResultado(String entrada, String saida, float valor, float taxa, float imposto){
        float resultado = 0;
        try {
            float cotacao = ReadingJSON.GetValorMoeda(entrada, saida);
            float result = valor * cotacao;
            float comImposto = result * imposto / 100;
            float comTaxa = result * taxa / 100;
            resultado = Math.round(((result - comImposto) - comTaxa) * 10000) /100;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
}
