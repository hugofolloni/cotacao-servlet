package br.ufrj.ic.cotacao;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
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

    public static String JSONToString(String link) throws Exception {
        ignorarSSL();
        String inline = "";

        URL url = new URL(link);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            scanner.close();
        }
        return inline;
    }

    public static float GetValorMoeda(String origem, String destino) throws Exception {
        String response = JSONToString("https://economia.awesomeapi.com.br/json/last/" + origem + "-" + destino);
        String[] cortandoString = response.split("\"ask\":");
        String[] retirandoAsteriscos = cortandoString[1].split("\"");
        String resposta = retirandoAsteriscos[1];

        float valor = Float.parseFloat(resposta);

        return valor;
    }

    public static float[] GetArrayDeCotacoes(String moeda, int dias) throws Exception {
        float[] arrayDeValores = new float[dias + 1];

        int consertarErroApi = dias * 4;

        String response = JSONToString("https://economia.awesomeapi.com.br/" + moeda + "/" + consertarErroApi + "/");

        String[] cortandoString = response.split("\"ask\":");

        for(int i = 0; i < dias; i++){
            String[] retirandoAsteriscos = cortandoString[i*4 + 1].split("\"");
            String valorEmString = retirandoAsteriscos[1];
            float valorDiario = Float.parseFloat(valorEmString);
            arrayDeValores[i] = valorDiario;
        }

        return arrayDeValores;
    }

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

    public static String GetDayFromTimestamp(long timestamp){
        Timestamp stamp = new Timestamp(timestamp);
        Date date = new Date(stamp.getTime());
        String[] timestampDate = date.toString().split("-");
        return timestampDate[2];
    }

}