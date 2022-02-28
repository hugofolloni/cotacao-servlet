package br.ufrj.ic.cotacao;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@ApplicationPath("/api")
public class CotacaoApplication extends Application {

    public static String leHTML() throws FileNotFoundException{
        try {
            String html="";
            File arquivo = new File("C:\\Users\\Pedro\\IdeaProjects\\teste\\src\\main\\java\\com\\example\\teste\\teste.html");
            Scanner sc = new Scanner(arquivo);
            while(sc.hasNextLine()){
                html += sc.nextLine();
            }
            return html;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return System.getProperty("user.dir");
    }

}