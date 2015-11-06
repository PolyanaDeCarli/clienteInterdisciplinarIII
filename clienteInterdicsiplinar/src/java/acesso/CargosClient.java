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
import model.cargos;

/**
 *
 * @author Larissa Cardoso
 */
public class CargosClient {

    private URI uri;
    private Client client;

    public CargosClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/cargos")
                .port(8083).build();
        client = ClientBuilder.newClient();
    }

    public String salvarCargo(cargos cargo) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(cargo, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirCargo(cargos cargo) {
        Response response = client.target(uri)
                .path("/{car_codigo}")
                .resolveTemplate("car_codigo", cargo.getCar_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<cargos> getCargos() {
        List<cargos> cargos = client.target(uri)
                .request()
                .get(new GenericType<List<cargos>>() {
                });
        System.out.println("-" + cargos.size());
        return cargos;
    }

    public void close() {
        client.close();
    }
}
