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
import model.salarios;

/**
 *
 * @author Larissa Cardoso
 */
public class SalariosClient {

    private URI uri;
    private Client client;

    public SalariosClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/salarios")
                .port(8083).build();
        client = ClientBuilder.newClient();
    }

    public String salvarSalarios(salarios sal) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(sal, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirSalario(salarios sal) {
        Response response = client.target(uri)
                .path("/{sal_codigo}")
                .resolveTemplate("sal_codigo", sal.getSal_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<salarios> getSalarios() {
        List<salarios> sal = client.target(uri)
                .request()
                .get(new GenericType<List<salarios>>() {
                });
        return sal;
    }

    public void close() {
        client.close();
    }
}
