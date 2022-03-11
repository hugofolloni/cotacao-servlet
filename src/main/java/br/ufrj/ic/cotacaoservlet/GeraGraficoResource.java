/*  Grupo 4:
Bárbara Barsi Duarte Batista da silva - DRE: 121058158
Hugo Folloni Guarilha - DRE: 121085854
Pedro Mion Braga Cordeiro - DRE: 121065919
*/

package br.ufrj.ic.cotacaoservlet;

public class GeraGraficoResource {

    /*
    Método para a montagem do gráfico. Utiliza as informações fornecidas pelo Json
    para desenhar um gráfico da cotação de uma determinada moeda por uma quantidade de dias, 
    (ambos fornecidos como parâmetro do método) através do html e da biblioteca chart.js.
    */
    public static String gerarGrafico(String moeda, int dias) throws Exception {
        float[] floats = ReadingJSON.GetArrayDeCotacoes(moeda, dias);
        long[] timestamps = ReadingJSON.GetArrayDeTimetamps(moeda, dias);
        String html = "<div><canvas id=\"myChart\"></canvas></div>";
        html += "<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>";
        html += "<script>" +
                "const labels = [";
        // Monta a lista de labels do gráfico, que atuaram como os X, ou as datas para cada valor de cotação.
        for(int i = 1; i < dias; i++){
            html += "\"" + ReadingJSON.GetDayFromTimestamp(timestamps[dias - i]) + "\",";
        };
        // Delimita o último label, para não ocorrer adição de vírgula.
        html += ReadingJSON.GetDayFromTimestamp(timestamps[0]) + "];";
        html += "const data = {" +
                "labels: labels, " +
                "datasets: [{" +
                "label: \"Variação de " + moeda + " nos últimos dias\"," +
                "backgroundColor: \"#4a148c \", " +
                "borderColor: \"#4a148c \", " +
                "data: [";
        // Adiciona os pontos no gráfico, que serão as cotações, para cada uma das labels do gráfico.
        for(int i = 1; i < dias; i++){
            html += floats[dias - i] + ", ";
        }
        // Assim como acima, adiciona o último ponto, para não ocorrer adição de vírgula.
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