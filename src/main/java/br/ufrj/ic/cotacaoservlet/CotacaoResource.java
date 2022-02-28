package br.ufrj.ic.cotacao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.FileNotFoundException;

@Path("/cotacao")
public class CotacaoResource {
    @GET
    @Produces("text/html")
    public String cotacao() {
        try{
            return CotacaoApplication.leHTML();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "deu ruim";
    }
}