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
import model.pessoas;

/**
 *
 * @author Larissa Cardoso
 */
public class PessoasClient {

    private URI uri;
    private Client client;

    public PessoasClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/pessoas")
                .port(8083).build();
        client = ClientBuilder.newClient();
    }

    public String salvarPessoas(pessoas pes) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(pes, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirPessoa(pessoas pes) {
        Response response = client.target(uri)
                .path("/{pes_codigo}")
                .resolveTemplate("pes_codigo", pes.getPes_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<pessoas> getPessoas() {
        List<pessoas> pessoa = client.target(uri)
                .request()
                .get(new GenericType<List<pessoas>>() {
                });
        return pessoa;
    }

    public void close() {
        client.close();
    }

}
