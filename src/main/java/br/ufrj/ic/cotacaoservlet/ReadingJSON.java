package br.ufrj.ic.cotacaoservlet;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ReadingJSON {

    public static String JSONToString(String link){
        String inline = "";
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inline;
    }

    public static float GetValorMoeda(String origem, String destino){
        String response = JSONToString("https://economia.awesomeapi.com.br/json/last/" + origem + "-" + destino);
        int posicaoAnterior = response.indexOf('k') + 4;
        String stringSplitada = response.substring(posicaoAnterior);
        int posicaoPosterior = stringSplitada.indexOf('"');

        float valor = Float.parseFloat(stringSplitada.substring(0, posicaoPosterior));

        return valor;
    }

    public static float[] GetArrayDeCotacoes(String moeda, int dias){
        float[] arrayDeValores = new float[dias];

        int consertarErroApi = dias * 4;

        String response = JSONToString("https://economia.awesomeapi.com.br/" + moeda + "/" + consertarErroApi + "/");

        for(int i = 0; i < dias; i++){
            String[] cortandoString = response.split("\"ask\":");
            String[] retirandoAsteriscos = cortandoString[i*4 + 1].split("\"");
            String valorEmString = retirandoAsteriscos[1];
            float valorDiario = Float.parseFloat(valorEmString);
            arrayDeValores[i] = valorDiario;
        }

        return arrayDeValores;
    }

}
