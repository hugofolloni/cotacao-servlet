/*  Grupo 4:
Bárbara Barsi Duarte Batista da silva - DRE: 121058158
Hugo Folloni Guarilha - DRE: 121085854
Pedro Mion Braga Cordeiro - DRE: 121065919
*/

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
                        "<link rel=\"icon\" href=\"https://cdn-icons-png.flaticon.com/512/1175/1175277.png\" type=\"image/x-icon\" />"+
                        "<style>"+
                            "{scrollbar-width: auto;scrollbar-color: #8f54a0 #ffffff; } ::-webkit-scrollbar {width: 16px;}::-webkit-scrollbar-track {background: #ffffff;}::-webkit-scrollbar-thumb; background-color: #8f54a0;border-radius: 10px;border: 3px solid #ffffff;}"+
                "span {font-size: 12px;}"+
                            ".botao {display: flex; align-items: center; justify-content: center; width: 100px; height: 40px; font-weight: 700; text-decoration: none; color: #eaeaea; background-color: #4A148C; padding: 10px; border-radius: 10px; cursor: pointer; border: 2px solid #4A148C;}"+
                            ".botao:hover {border: 2px solid #4a148c; background-color: white; color: #4a148c; letter-spacing: 1px;}"+
                        "</style>"+
                        "</head>"+
                        "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>"+
                        "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: column; width: 100vw; height: 100vh; overflow-x: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins'\"; >"+
                            "<header>"+
                                "<h1>Cotacoins</h1>"+
                            "</header>"+
                            "<div style='background-color: #3c3c3c; border-radius: 12px; display: flex; justify-content: center; align-itens: center; padding: 20px; width: 50vw;'><p style='font-size: 14px;'>Bem vindo ao Cotacoins, o melhor site de conversão de moedas de toda a internet. " +
                                "Nosso site possui 3 funcionalidades:<br>" +
                                "<br>" +
                                "Converter - Converte um determinado valor de uma moeda para outra, possibilitando a inserção de taxas e impostos. <br>" +
                                "Lista - Converte os valores de uma lista de itens nomeados de uma moeda para outra, possibilitando a inserção de taxas e impostos.<br>" +
                                "Histórico - Exibe o histórico de uma moeda em relação ao BRL (real brasileiro) ao longo do tempo.<br>" +
                                "<br>" +
                                "Todas as operações do site exigem o uso dos códigos das moedas correspondentes. Abaixo, você encontrará alguns desses códigos.<br>" +
                            "</p></div>"+
                            "<div style=\"margin: 20px 0px; width: 50vw; height: 20vh; display: flex; flex-direction: row; justify-content: space-around; align-items: center;\">"+
                                "<a class='botao' href=\"input-converter\">Converter</a>"+
                                "<a class='botao' href=\"listar\">Lista</a>" +
                                "<a class='botao' href=\"input-grafico\">Histórico</a>"+
                            "</div>"+
                            "<div style=\"width: 35vw; height: auto; background-color: #3c3c3c; display: flex; flex-direction: column; padding: 1%; border-radius: 10px; align-items: center; justify-content: space-around;\">"+
                                "<h2>Alguns códigos para conversão</h2>" +
                                "<div style='display: flex; flex-direction: row; width: 100%; justify-content: space-around;'>" +
                                    "<div style=\"width: auto; height: 100%; display: flex; flex-direction: column; align-items: flex-start; justify-content: space-around;\">"+
                                        "<span> - Dólar - USD</span><span> - Real - BRL</span><span> - Euro - EUR</span><span> - Iene - JPY</span><span> - Peso Argentino - ARS</span><span> - Libra Esterlina - GBP</span><span> - Dólar Australiano - AUD</span><span> - Bitcoin - BTC</span><span> - Sol do Peru - PEN</span><span> - Peso Mexicano - MXN</span>"+
                                    "</div>"+
                                    "<div style=\"width: auto; height: 100%; display: flex; flex-direction: column; align-items: flex-start; justify-content: space-around;\">"+
                                        "<span> - Yuan Chinês - CNY </span><span> - Rand Sul-Africano - ZAR</span><span> - Ethereum - ETH</span><span> - Guarani Paraguaio - PYG</span><span> - Peso Uruguaio - UYU</span><span> - Rublo Russo - RUB</span><span> - Rúpia Indiana - INR</span><span> - Coroa Dinamarquesa - DKK</span><span> - Franco Suíço - CHF</span>"+
                                    "</div>"+
                                "</div>" +
                                "<p>Para todas as combinações disponíveis, clique <a style='text-decoration:none; color: white; font-weight: 600;' target='_blank' href='https://economia.awesomeapi.com.br/xml/available'>aqui</a>.</p>" +
                            "</div>"+
                        "</body>"+
                        "</html>";
        return html;
    }
}