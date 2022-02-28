package br.ufrj.ic.cotacao;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/input-cotacao")
public class ParametrosResource {
    @GET
    @Produces("text/html")

    public static parametros(){
        "<!DOCTYPE html>"+
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
                "div form h2::before{"+
                    "content:'';"+
                    "position: absolute;"+
                    "height: 4px;"+
                    "width: 100px;"+
                    "bottom: 3px;"+
                    "left: 40;"+
                    "top: 0;"+
                    "margin-top: 75px;"+
                    "border-radius: 8px;"+
                    "background: linear-gradient(45deg, #8e2de2, #4a00e0);"+
                "}"+
            "</style>"+
        "</head>"+
        "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>"+
        "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >"+
            "<div style=\"display: flex; width: 30vw; flex-direction: column; background-color: #3c3c3c; padding: 20px 30px; border-radius: 15px;\">"+
                "<form method=\"GET\" action=\"/converter\"  style=\"display: flex; flex-direction: column;\">"+
                    "<h2 style=\"margin: 5px; font-weight: 700;\">Converta suas moedas</h2>"+
                    "<p>Moeda de Origem</p>"+
                    "<input type=\"text\" placeholder=\"Código da moeda de origem\" maxlength="4" name="entrada">"+
                    "<p>Moeda de Destino</p>"+
                    "<input type=\"text\" placeholder=\"Código da moeda de destino\" maxlength=\"4\" name=\"saida\">"+
                    "<p>Valor</p>"+
                    "<input type=\"number\" step=\"0.01\" min=\"0\" placeholder=\"Valor\" name=\"valor\">"+
                    "<p>Taxa de Câmbio</p>"+
                    "<input type=\"number\" step=\"0.1\" min="0" max="100" placeholder=\"Taxa de Câmbio\" name=\"taxa\">"+
                    "<p>Taxa de Imposto</p>"+
                    "<input type=\"number\" step=\"0.1\" min=\"0\" max=\"100\" placeholder=\"Taxa de Imposto\" name=\"imposto\">"+
                    "<div style=\"display: flex; flex-direction: column; align-items: center; justify-content: center\">"+
                        "<input type=\"submit\" value=\"Converter\">"+
                    "</div>"+
                "</form>"+
            "</div>"+
        "</body>"+
        "</html>";
    }

}
