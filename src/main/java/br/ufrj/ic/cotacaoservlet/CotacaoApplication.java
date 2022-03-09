package br.ufrj.ic.cotacaoservlet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.ArrayList;

@ApplicationPath("/api")
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

