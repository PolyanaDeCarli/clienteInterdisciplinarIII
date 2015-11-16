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
import model.custos_fixos;

/**
 *
 * @author Larissa Cardoso
 */
public class CustosFixosClient {

    private URI uri;
    private Client client;

    public CustosFixosClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/custos_fixos")
                .port(8083).build();
        client = ClientBuilder.newClient();
    }

    public String salvarCustos(custos_fixos custo) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(custo, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirCusto(custos_fixos custo) {
        Response response = client.target(uri)
                .path("/{cus_codigo}")
                .resolveTemplate("cus_codigo", custo.getCus_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<custos_fixos> getCusto() {
        List<custos_fixos> custo = client.target(uri)
                .request()
                .get(new GenericType<List<custos_fixos>>() {
                });
        return custo;
    }

    public void close() {
        client.close();
    }
}
