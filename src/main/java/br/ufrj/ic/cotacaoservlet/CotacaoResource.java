package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/cotacao")
public class CotacaoResource {
    @GET
    @Produces("text/html")

    /*
    Endpoint inicial do Servlet. O método abaixo retorna um html que informa 
    os códigos das principais moedas, além de botões que indicam as áreas de 
    conversão e do histórico de uma moeda.
    */

    public String cotacao() {
        CotacaoApplication.excluiArray();
        String html =   "<!DOCTYPE html><html lang=\"pt-br\">"+
                        "<head>"+
                        "<meta charset=\"UTF-8\">"+
                        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"+
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        "<title>Cotacoins</title>"+
                        "<style>"+
                            "span {font-size: 12px;}"+
                            "a {display: flex; align-items: center; justify-content: center; width: 100px; height: 40px; font-weight: 700; text-decoration: none; color: #eaeaea; background-color: #4A148C; padding: 10px; border-radius: 10px; cursor: pointer; border: 2px solid #4A148C;}"+
                            "a:hover {border: 2px solid #4a148c; background-color: white; color: #4a148c; letter-spacing: 1px;}"+
                        "</style>"+
                        "</head>"+
                        "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>"+
                        "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >"+

                            "<header>"+
                                "<h1>Cotacoins</h1>"+
                            "</header>"+
                            "<div style=\"margin: 20px 0px; width: 50vw; height: 20vh; display: flex; flex-direction: row; justify-content: space-around; align-items: center;\">"+
                                "<a href=\"input-converter\">Cotação</a>"+
                                "<a href=\"listar\">Lista</a>" +
                                "<a href=\"input-grafico\">Histórico</a>"+
                            "</div>"+
                        "<div style=\"width: 40vw; height: auto; background-color: #3c3c3c; display: flex; flex-direction: column; padding: 20px; border-radius: 10px; align-items: center; justify-content: space-around;\">"+
                        "<h2>Alguns códigos para conversão</h2>" +
                        "<div style='display: flex; flex-direction: row; width: 100%; justify-content: space-around;'>" +
                        "<div style=\"width: 40%; height: 100%; display: flex; flex-direction: column; align-items: f[lex-star]t; justify-content: space-around;\">"+
                        "<span> - Dólar - USD</span><span> - Real - BRL</span><span> - Euro - EUR</span><span> - Iene - JPY</span><span> - Peso Argentino - ARS</span><span> - Libra Esterlina - GBP</span><span> - Dólar Australiano - AUD</span><span> - Riyal Saudita - SAR</span><span> - Franco Suíço - CHF</span><span> - Coroa Dinamarquesa - DKK</span><span> - Bitcoin - BTC</span><span> - Sol do Peru - PEN</span><span> - Peso Mexicano - MXN</span>"+
                        "</div>"+
                        "<div style=\"width: 40%; height: 100%; display: flex; flex-direction: column; align-items: flex-start; justify-content: space-around;\">"+
                        "<span> - Yuan Chinês - CNY </span><span> - Rand Sul-Africano - ZAR</span><span> - Rúpia de Sri Lanka - LKR</span><span> - Ethereum - ETH</span><span> - Nova Lira Turca - TRY</span><span> - Guarani Paraguaio - PYG</span><span> - Peso Uruguaio - UYU</span><span> - Rublo Russo - RUB</span><span> - Coroa Norueguesa - NOK</span><span> - Rúpia Indiana - INR</span><span> - Coroa Checa -CZK</span><span> - Dólar Neozelandês - NZD</span>"+
                        "</div>"+
                        "</div>" +
                        "</div>"+
                        "</body>"+
                        "</html>";
        return html;
    }
}