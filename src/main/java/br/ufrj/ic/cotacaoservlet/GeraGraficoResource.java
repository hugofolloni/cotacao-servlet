package br.ufrj.ic.cotacao;

import java.sql.Date;
import java.sql.Timestamp;

public class GeraGraficoResource {
    public static String gerarGrafico(String moeda, int dias) throws Exception {
        float[] floats = ReadingJSON.GetArrayDeCotacoes(moeda, dias);
        long[] timestamps = ReadingJSON.GetArrayDeTimetamps(moeda, dias);
        String html = "<div><canvas id=\"myChart\"></canvas></div>";
        html += "<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>";
        html += "<script>" +
                "const labels = [";
        for(int i = 1; i < dias; i++){
            html += "\"" + ReadingJSON.GetDayFromTimestamp(timestamps[dias - i]) + "\",";
        };
        html += ReadingJSON.GetDayFromTimestamp(timestamps[0]) + "];";
        html += "const data = {" +
                "labels: labels, " +
                "datasets: [{" +
                "label: \"Variação de " + moeda + " nos últimos " + dias + " dias\"," +
                "backgroundColor: \"rgb(255, 99, 132)\", " +
                "borderColor: \"rgb(255, 99, 132)\", " +
                "data: [";
        for(int i = 1; i < dias; i++){
            html += floats[dias - i] + ", ";
        }
        html += floats[0] + "]";
        html += "}]}; " +
                "const config = {" +
                "type: \"line\", " +
                "data: data, " +
                "options: {}  " +
                "};" +
                "new Chart(document.getElementById('myChart'), config);" +
                "</script>";
        return html;
    }

}