package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.*;

@Path("/resultado-lista")
public class ResultadoListaResource {
    @GET
    @Produces("text/html")
    public String resultadoLista(@DefaultValue("USD") @QueryParam("entrada") String entrada, @DefaultValue("BRL") @QueryParam("saida") String saida, @QueryParam("taxa") @DefaultValue("0") Double taxa, @QueryParam("imposto") @DefaultValue("0") Double imposto) throws Exception {
        double valorOrigem = 0;
        double valorDestino = 0;
        for(int i=0;i<CotacaoApplication.arrayNome.size();i++){
            valorOrigem+= CotacaoApplication.arrayValor.get(i);
            valorDestino += ConverterResource.printResultado(entrada,  saida, CotacaoApplication.arrayValor.get(i), taxa, imposto);
        }

        String html = "<!DOCTYPE html>" +
                "<html lang=\"pt-br\">" +
                    "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        "<title>Cotacoins</title>" +
                        "<style>" +
                            ".botao {" +
                                "display: flex;"+
                                "align-items: center;"+
                                "justify-content: center;"+
                                "background-color: #4a148c;" +
                                "border-radius: 15px;" +
                                "border: 2px solid #4a148c;" +
                                "color: white;" +
                                "padding: 10px;" +
                                "width: 40%;" +
                                "margin-top: 30px;" +
                                "font-weight: 700;" +
                                "cursor: pointer;" +
                                "transition: 0.3s ease all;" +
                            "}" +
                            ".botao:hover {" +
                                "border: 2px solid #4a148c;" +
                                "background-color: white;" +
                                "color: #4a148c;" +
                                "letter-spacing: 1px;" +
                            "}" +
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
                    "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >" +
                        "<a href=\"listar\" style=\"position: absolute; left: 0; top: 0; margin: 50px 0px 0px 50px; text-decoration: none; font-weight: 700; font-size: 40px; color: white;\"><p class=\"setinha\"><</p></a>" +
                        "<div style=\"display: flex; width: 30vw; flex-direction: column; background-color: #3c3c3c; padding: 20px 30px; border-radius: 15px;\">" +
                            "<div style=\"display: flex; flex-direction: column; \">" +
                                "<p>Conversão de " + entrada + " para " + saida + " no valor de " + ReadingJSON.GetValorMoeda(entrada, saida) + " com " + (imposto + taxa) + "% de taxas</p>";
                                for(int i=0; i<CotacaoApplication.arrayNome.size(); i++){
                                    html += "<div style=\"display: flex; width: 100%; justify-content: space-around; align-items: center; flex-direction: row;\">" +
                                        "<p>" + CotacaoApplication.arrayQuantidade.get(i) + "</p>" +
                                        "<p style='width: 40%; text-align: center;'>" + CotacaoApplication.arrayNome.get(i) + "</p>" +
                                        "<p>" + CotacaoApplication.arrayValor.get(i) + " " + entrada + "</p>" +
                                        "<p>" + ConverterResource.printResultado(entrada,  saida, CotacaoApplication.arrayValor.get(i), taxa, imposto) + " " + saida + "</p></div>";
                                     }
                                html += "<h4 style=\"margin-left: 70%;\">Valor final: " + valorDestino + " " + saida + "</h4>" +
                                "<div style='display: flex; width: 100%; flex-direction: column; align-items: center; justify-content: center'>" +
                                    "<button class='botao' style='text-decoration: none;' onclick=\"window.location.href='cotacao'\">Concluir</button>" +
                                "</div>" +
                        "</div>" +
                    "</body>" +
                "</html>";
        return html;
    }

}
