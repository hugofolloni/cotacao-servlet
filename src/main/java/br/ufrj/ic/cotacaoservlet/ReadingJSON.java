/*  Grupo 4:
Bárbara Barsi Duarte Batista da silva - DRE: 121058158
Hugo Folloni Guarilha - DRE: 121085854
Pedro Mion Braga Cordeiro - DRE: 121065919
*/

package br.ufrj.ic.cotacaoservlet;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Scanner;
import java.sql.Date;
import java.sql.Timestamp;

public class ReadingJSON {

    // Código encontrado na internet para correção de Certificados SSL
    public static void ignorarSSL() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }
    }

    /*Método pra leitura do arquivo Json, fornecido na url passada no parâmentro do método, 
    como uma String.
    */
    public static String JSONToString(String link) throws Exception {
        ignorarSSL();
        String inline = "";

        try {
            URL url = new URL(link);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
        /*
        Caso o código de status do HTTTP da url seja diferente de 200 (que indica que o 
        processamento foi bem sucedido), uma exceção é lançada, juntamente com o código de 
        status obtido na requisição.
        */
        if (responseCode != 200) {
            if(responseCode == 404){
                throw new RuntimeException("A aplicação não rodou pois os parâmetros não foram encontrados.");
            }
            else{
                throw new RuntimeException("A aplicação não rodou pelo erro de resposta: " + responseCode);
            }
        }
        /*
        Caso contrário, um Scanner lê linha por linha do arquivo Json e atribui o resultado 
        a uma String inline, que será retornada pelo método.
        */
        else {
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            scanner.close();
        }
        }catch(IOException e){
            e.printStackTrace();
        }
        return inline;

    }

    /*
    Método para obter a cotação de uma moeda de acordo com a api. Utiliza o método JSONToString
    para ler as informações de cotação de uma moeda  em relação a outra.
    */
    public static Double GetValorMoeda(String origem, String destino) throws Exception {

        // As moedas de origem e destino, passadas como parâmetros, integram a URL da api. 
        String response = JSONToString("https://economia.awesomeapi.com.br/json/last/" + origem + "-" + destino);
        
        /*
        Como a única informação desejada é a cotação da moeda em relação a uma outra, extraímos 
        apenas a informação fornecida pelo "ask", retirando os caracteres não númericos e 
        transformando a String resultante desse processo no Float a ser retornado pelo método.
        */
        String[] cortandoString = response.split("\"ask\":");
        String[] retirandoAsteriscos = cortandoString[1].split("\"");
        String resposta = retirandoAsteriscos[1];

        Double valor = Double.parseDouble(resposta);

        return valor;
    }

    /*
    Método para obter a cotação de uma moeda por um determinado período, de acordo com a api,
    para estruturar o eixo vertical do gráfico.Utiliza o método JSONToString para ler as 
    informações necessárias.
    */
    public static float[] GetArrayDeCotacoes(String moeda, int dias) throws Exception {
        float[] arrayDeValores = new float[dias + 1];

        int consertarErroApi = dias * 4;

        String response = JSONToString("https://economia.awesomeapi.com.br/" + moeda + "/" + consertarErroApi + "/");

        /*
        Novamente, como a única informação desejada é a cotação da moeda, extraímos apenas os 
        valores fornecidos pelo "ask" pela quantidade de dias informados no método. Esses valores
        são transformados e inseridos no array retornado pelo método.
        */
        String[] cortandoString = response.split("\"ask\":");

        for(int i = 0; i < dias; i++){
            String[] retirandoAsteriscos = cortandoString[i*4 + 1].split("\"");
            String valorEmString = retirandoAsteriscos[1];
            float valorDiario = Float.parseFloat(valorEmString);
            arrayDeValores[i] = valorDiario;
        }

        return arrayDeValores;
    }

    /*
    Método para obter as datas para a montagem do gráfico de acordo com o número de dias 
    passado como parâmetro. Utiliza o método JSONToString para ler as informações necessárias da api.
    */
    public static long[] GetArrayDeTimetamps(String moeda, int dias) throws Exception {
        long[] arrayDeTimestamps = new long[dias + 1];

        int consertarErroApi = dias * 4;

        String response = JSONToString("https://economia.awesomeapi.com.br/" + moeda + "/" + consertarErroApi + "/");

        String[] cortandoString = response.split("\"timestamp\":");

        for(int i = 0; i < dias; i++){
            String[] retirandoAsteriscos = cortandoString[i*4 + 1].split("\"");
            String valorEmString = retirandoAsteriscos[1];
            long valorDiario = Long.parseLong(valorEmString);
            arrayDeTimestamps[i] = valorDiario * 1000;
        }

        return arrayDeTimestamps;
    }

    // Método para obter o dia do mês que o valor da cotação foi alcançada, transformando o timestamp passado pela API para o dia do mês.
    public static String GetDayFromTimestamp(long timestamp){
        Timestamp stamp = new Timestamp(timestamp);
        Date date = new Date(stamp.getTime());
        String[] timestampDate = date.toString().split("-");
        return timestampDate[2];
    }

}