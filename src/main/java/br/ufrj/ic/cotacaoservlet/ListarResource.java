package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.*;

@Path("/listar")
public class ListarResource {
    @GET
    @Produces("text/html")
    public static String listar(@QueryParam("valor") @DefaultValue("0") double valor, @QueryParam("nome") String nome, @QueryParam("quantidade") @DefaultValue("1") int quantidade, @QueryParam("index") @DefaultValue("-1") int index){
        criarLista(valor, nome, quantidade);
        apagarItem(index);

        String disabled = "";

        if(CotacaoApplication.arrayNome.size() == 0){
            disabled = "disabled";
        }

        String html = "<!DOCTYPE html>" +
            "<html lang='pt-br'>" +
            "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<title>Cotacoins</title>" +
                "<style>" +
                    "span { font-size: 12px; }" +
                    "form p {color: white; margin-bottom: 10px; }" +
                    "form input[type=text], form input[type=number]{ background-color: #3c3c3c; border: 1px white solid; border-radius: 15px;  color: white; padding: 10px; padding-left: 20px; transition: 0.3s ease all; outline: none; }" +
                    "form input[type=text]:focus, form input[type=number]:focus { border: 1px solid #866ba7; }" +
                    "form input[type=submit], .botao {" +
                        "display: flex;"+
                        "align-items: center;"+
                        "justify-content: center;"+
                        "background-color: #4a148c;" +
                        "border-radius: 15px;" +
                        "border: 2px solid #4a148c;" +
                        "color: white;" +
                        "padding: 10px;" +
                        "width: auto;" +
                        "margin-top: 30px;" +
                        "font-weight: 700;" +
                        "cursor: pointer;" +
                        "transition: 0.3s ease all;" +
                    "}" +
                    "input::-webkit-outer-spin-button, input::-webkit-inner-spin-button { -webkit-appearance: none; +margin: 0; +} input[type=number] { -moz-appearance: textfield; }" +
                    "form input[type=submit]:hover, .botao:hover, .botao:disabled {" +
                        "border: 2px solid #4a148c;" +
                        "background-color: white;" +
                        "color: #4a148c;" +
                        "letter-spacing: 1px;" +
                    "}" +
                    "div form h2::after{" +
                        "content:'';" +
                        "position: relative;" +
                        "height: 4px;" +
                        "width: 100px;" +
                        "margin-top: 1px;" +
                        "border-radius: 8px;" +
                        "background: linear-gradient(45deg, #8e2de2, #4a00e0);" +
                    "}" +
                    ".setinha{ transition: 0.3s ease all; + }" +
                    ".setinha:hover{ color: #8e2de2; + }" +
                    "</style>" +
            "</head>" +
            "<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>" +
            "<body style=\"padding: 0; margin: 0; box-sizing: border-box; display: flex; flex-direction: row; width: 100vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; align-items: center; justify-content: space-around; background-color: #1c1c1c; color: #eaeaea; font-family: 'Poppins';\" >" +
                    "<a href='cotacao' style='position: absolute; left: 0; top: 0; margin: 50px 0px 0px 50px; text-decoration: none; font-weight: 700;  font-size: 40px;  color: white; '><p class='setinha'><</p></a>" + 
                    "<div style='display: flex; width: 20vw; flex-direction: column; background-color: #3c3c3c; padding: 20px 30px; border-radius: 15px;'>" +
                        "<form method='GET' action='listar'  style='display: flex; flex-direction: column;'>" +
                            "<h2 style='margin: 5px; font-weight: 700;'>Converta seus itens</h2>" +
                            "<p>Nome do item</p>" +
                            "<input type='text' placeholder='Nome do item' name='nome' required>" +
                            "<p>Valor</p>" +
                            "<input type='number' step='0.01' min='0' placeholder='Valor' name='valor' required>" +
                            "<p>Quantidade</p>" +
                            "<input type='number' step='1' min='0' placeholder='Quantidade' value='1' name='quantidade'>" +
                            "<div style='display: flex; flex-direction: column; align-items: center; justify-content: center'>" +
                                "<input type='submit' value='Adicionar'>" +
                            "</div>" +
                        "</form>" +
                    "</div>" +
                    "<div style='display: flex; width: 20vw; flex-direction: column; background-color: #3c3c3c; padding: 20px 30px; border-radius: 15px;'>" +
                        "<h2>Itens</h2>";
                        for(int i = 0; + i < CotacaoApplication.arrayNome.size(); i++){
                            html += "<div style='display: flex; flex-direction: row; align-items: center; justify-content: space-around'><span>"+ CotacaoApplication.arrayNome.get(i) + "</span><span>" + CotacaoApplication.arrayValor.get(i) + "</span><span>" + CotacaoApplication.arrayQuantidade.get(i) +"</span>"+
                                    "<form action=\"listar\" method=\"GET\">"+
                                    "<input type=\"text\" style='display: none;' name=\"index\" value=\""+ i +"\"></input>" +
                                    "<input class='botao' type=\"submit\" value=Apagar style='margin-top: 0;'>"+
                                    "</form>"+
                                    "</div>";
                        }
                html += "<div style='display: flex; width: 100%; flex-direction: column; align-items: center; justify-content: center'>" +
                            "<button "+disabled+ " class='botao' style='text-decoration: none;' onclick=\"window.location.href='moedas-lista'\">Concluir</button>" +
                        "</div>" +
                    "</div>" +
            "</body>" +
            "</html>";
        return html;
    }

    public static void criarLista(Double valor, String nomeDoItem, Integer quantidade){
        if (!(valor == 0 || nomeDoItem.isEmpty())){
            CotacaoApplication.arrayValor.add(valor);
            CotacaoApplication.arrayNome.add(nomeDoItem);
            CotacaoApplication.arrayQuantidade.add(quantidade);
        }
    }

    public static void apagarItem(int index){
        if (index >=0){
            CotacaoApplication.arrayValor.remove(index);
            CotacaoApplication.arrayNome.remove(index);
            CotacaoApplication.arrayQuantidade.remove(index);
        }
    }
    

}