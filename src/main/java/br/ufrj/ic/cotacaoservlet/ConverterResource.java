/*  Grupo 4:
Bárbara Barsi Duarte Batista da silva - DRE: 121058158
Hugo Folloni Guarilha - DRE: 121085854
Pedro Mion Braga Cordeiro - DRE: 121065919
*/

package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.*;
@Path("/converter")
public class ConverterResource {
    @GET
    @Produces("text/html")

    /*
    Enpoint que retorna um html que mostra ao usuário a conversão realizada pelo método 
    printResultado com as informações fornecidas no formulário do /input-converter.
     */

    public String converter(@QueryParam("valor") Double valor , @DefaultValue("USD") @QueryParam("entrada") String entrada, @DefaultValue("BRL") @QueryParam("saida") String saida, @QueryParam("taxa") @DefaultValue("0") Double taxa, @QueryParam("imposto") @DefaultValue("0") Double imposto) throws Exception {
        String html = "<!DOCTYPE html>" +
                    "<html lang=\"pt-br\">" +
                    "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        "<title>Cotacoins</title>" +
                        "<link rel=\"icon\" href=\"https://cdn-icons-png.flaticon.com/512/1175/1175277.png\" type=\"image/x-icon\" />"+
                        "<style>" +
                            "{scrollbar-width: auto;scrollbar-color: #8f54a0 #ffffff; } *::-webkit-scrollbar {width: 16px;}*::-webkit-scrollbar-track {background: #ffffff;}*::-webkit-scrollbar-thumb; background-color: #8f54a0;border-radius: 10px;border: 3px solid #ffffff;}"+
                            "div h2::after{"+
                                "content:'';"+
                                "position: relative;"+
                                "height: 4px;"+
                                "width: 100px;"+
                                "margin-top: 1px;"+
                                "border-radius: 8px;"+
                               " background: linear-gradient(45deg, #8e2de2, #4a00e0);" +
                            "}" +
                        ".setinha{ transition: 0.3s ease all; }" +
                        ".setinha:hover{ color: #8e2de2; }" +
                    "</style>" +
                    "</head>" +
                    "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>" +
                    "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >" +
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
    public static Double printResultado(String entrada, String saida, Double valor, Double taxa, Double imposto){
        Double resultado = 0.0;
        try {
            Double cotacao = ReadingJSON.GetValorMoeda(entrada, saida);
            Double result = valor * cotacao;
            Double comImposto = result * imposto / 100;
            Double comTaxa = (result - comImposto) * taxa / 100;
            resultado = (result - comImposto) - comTaxa;
            Double arredondador = Double.parseDouble(Long.toString(Math.round(resultado*100)));
            resultado = (arredondador/100);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(resultado<0){resultado=0.0;}
        return resultado;
    }
}
