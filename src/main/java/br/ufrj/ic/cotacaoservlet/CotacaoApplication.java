/*  Grupo 4:
Bárbara Barsi Duarte Batista da silva - DRE: 121058158
Hugo Folloni Guarilha - DRE: 121085854
Pedro Mion Braga Cordeiro - DRE: 121065919
*/

package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.ArrayList;

@ApplicationPath("/api")

/* 
Api do Servlet. Aqui, são inicializadas as ArrayLists que guardam os nomes, valores e 
quantidades que são inseridos no formulário do /listar. Além disso, também há um método 
que exclui as ArrayLists, possibilitando que novas listas sejam criadas do zero.
*/

public class CotacaoApplication extends Application {
    public static ArrayList<String> arrayNome = new ArrayList<>();
    public static ArrayList<Integer> arrayQuantidade = new ArrayList<>();
    public static ArrayList<Double> arrayValor = new ArrayList<>();

    public static void excluiArray(){
        arrayNome = new ArrayList<>();
        arrayQuantidade = new ArrayList<>();
        arrayValor = new ArrayList<>();
    }
}

