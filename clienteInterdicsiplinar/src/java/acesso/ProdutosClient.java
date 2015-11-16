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
import model.produto;

/**
 *
 * @author Larissa Cardoso
 */
public class ProdutosClient {

    private URI uri;
    private Client client;

    public ProdutosClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/produto")
                .port(8083).build();
        client = ClientBuilder.newClient();
    }

    public String salvarProdutos(produto pro) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(pro, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirProduto(produto pro) {
        Response response = client.target(uri)
                .path("/{pro_codigo}")
                .resolveTemplate("pro_codigo", pro.getPro_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<produto> getProdutos() {
        List<produto> produto = client.target(uri)
                .request()
                .get(new GenericType<List<produto>>() {
                });
        return produto;
    }

    public void close() {
        client.close();
    }
}
