/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import model.maquinas;

/**
 *
 * @author Larissa Cardoso
 */
public class MaquinasClient {
    private URI uri;
       private Client client;

    public MaquinasClient() {
        uri = UriBuilder
             .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/maquinas")
             .port(8083).build();              
             client = ClientBuilder.newClient();
    }
    public String adicionarMaquina(maquinas maquina){
             Response response = client.target(uri)
             .request()
             .post(Entity.entity(maquina,MediaType.APPLICATION_XML));
             return response.getStatusInfo().getReasonPhrase();
       }
       
       public List<maquinas> getMaquinas(){
             List<maquinas> maquinas = client.target(uri)
             .request()
             .get(new GenericType<List<maquinas>>(){});
              return maquinas;
       }
       
       public void close(){
             client.close();
       }

}
