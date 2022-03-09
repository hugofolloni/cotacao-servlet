package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/moedas-lista")
public class MoedasListaResource {
    @GET
    @Produces("text/html")

    public String parametros(){
        String html = "<!DOCTYPE html>"+
                "<html lang=\"pt-br\">"+
                "<head>"+
                "<meta charset=\"UTF-8\">"+
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"+
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                "<title>Cotacoins</title>"+
                "<style>"+
                "span { font-size: 12px; }"+
                "form p {color: white; margin-bottom: 10px;}"+
                "form input[type=text], form input[type=number]{ background-color: #3c3c3c; border: 1px white solid; border-radius: 15px;  color: white; padding: 10px; padding-left: 20px; transition: 0.3s ease all; outline: none; }"+
                "form input[type=text]:focus, form input[type=number]:focus { border: 1px solid #866ba7;}"+
                "form input[type=submit] {"+
                "background-color: #4a148c;"+
                "border-radius: 15px;"+
                "border: 2px solid #4a148c;"+
                "color: white;"+
                "padding: 10px;"+
                "width: 40%;"+
                "margin-top: 30px;"+
                "font-weight: 700;"+
                "cursor: pointer;"+
                "transition: 0.3s ease all;"+
                "}"+
                "input::-webkit-outer-spin-button, input::-webkit-inner-spin-button { -webkit-appearance: none;margin: 0;} input[type=number] { -moz-appearance: textfield;}"+
                "form input[type=submit]:hover {"+
                "border: 2px solid #4a148c;"+
                "background-color: white;"+
                "color: #4a148c;"+
                "letter-spacing: 1px;"+
                "}"+
                "div form h2::after{"+
                "content:'';"+
                "position: relative;"+
                "height: 4px;"+
                "width: 100px;"+
                "margin-top: 1px;"+
                "border-radius: 8px;"+
                "background: linear-gradient(45deg, #8e2de2, #4a00e0);"+
                "}"+
                ".setinha{ transition: 0.3s ease all; }" +
                ".setinha:hover{ color: #8e2de2; }" +
                "</style>" +
                "</head>"+
                "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>"+
                "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >"+
                    "<a href=\"listar\" style=\"position: absolute; left: 0; top: 0; margin: 50px 0px 0px 50px; text-decoration: none; font-weight: 700; font-size: 40px; color: white;\"><p class=\"setinha\"><</p></a>" +
                    "<div style=\"display: flex; width: 30vw; flex-direction: column; background-color: #3c3c3c; padding: 20px 30px; border-radius: 15px;\">"+
                        "<form method=\"GET\" action=\"resultado-lista\"  style=\"display: flex; flex-direction: column;\">"+
                            "<h2 style=\"margin: 5px; font-weight: 700;\">Converta seus itens</h2>"+
                            "<p>Moeda de Origem</p>"+
                            "<input type=\"text\" placeholder=\"Código da moeda de origem\" maxlength=\"4\" name=\"entrada\" onkeyup=\"this.value = this.value.toUpperCase();\">"+
                            "<p>Moeda de Destino</p>"+
                            "<input type=\"text\" placeholder=\"Código da moeda de destino\" maxlength=\"4\" name=\"saida\" onkeyup=\"this.value = this.value.toUpperCase();\">"+
                            "<p>Taxa de Câmbio</p>"+
                            "<input type=\"number\" step=\"0.1\" min=\"0\" max=\"100\" placeholder=\"Taxa de Câmbio\" name=\"taxa\">"+
                            "<p>Taxa de Imposto</p>"+
                            "<input type=\"number\" step=\"0.1\" min=\"0\" max=\"100\" placeholder=\"Taxa de Imposto\" name=\"imposto\">"+
                            "<div style=\"display: flex; flex-direction: column; align-items: center; justify-content: center\">"+
                                "<input type=\"submit\" value=\"Converter\">"+
                            "</div>"+
                        "</form>"+
                    "</div>"+
                "</body>"+
                "</html>";
        return html;
    }

}
