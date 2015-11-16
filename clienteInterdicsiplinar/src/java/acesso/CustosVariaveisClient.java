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
import model.custos_variaveis;

/**
 *
 * @author Larissa Cardoso
 */
public class CustosVariaveisClient {

    private URI uri;
    private Client client;

    public CustosVariaveisClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/custos_variaveis")
                .port(8083).build();
        client = ClientBuilder.newClient();

    }

    public String salvarCustosVariaveis(custos_variaveis cv) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(cv, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirCustoVariaveis(custos_variaveis cv) {
        Response response = client.target(uri)
                .path("/{cuv_codigo}")
                .resolveTemplate("cuv_codigo", cv.getCuv_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<custos_variaveis> getCustosVariaveis() {
        List<custos_variaveis> cuv = client.target(uri)
                .request()
                .get(new GenericType<List<custos_variaveis>>() {
                });
        return cuv;
    }

    public void close() {
        client.close();
    }

}
