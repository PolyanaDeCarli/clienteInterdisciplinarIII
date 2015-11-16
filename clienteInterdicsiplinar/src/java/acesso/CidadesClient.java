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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import model.cidades;

/**
 *
 * @author Larissa Cardoso
 */
public class CidadesClient {
    private URI uri;
    private Client client;

    public CidadesClient() {
           uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/cidades")
                .port(8083).build();
        client = ClientBuilder.newClient();
    }
      public List<cidades> getCidades() {
        List<cidades> cidade = client.target(uri)
                .request()
                .get(new GenericType<List<cidades>>() {
                });
        return cidade;
    }

    public void close() {
        client.close();
    }
}
