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
import model.materia_prima;

/**
 *
 * @author Larissa Cardoso
 */
public class MateriaPrimaClient {

    private URI uri;
    private Client client;

    public MateriaPrimaClient() {
        uri = UriBuilder
                .fromUri("http://localhost:8083/InterdisciplinarBD/webresources/materia_prima")
                .port(8083).build();
        client = ClientBuilder.newClient();

    }

    public String salvarMateriaPrima(materia_prima materia) {
        Response response = client.target(uri)
                .request()
                .post(Entity.entity(materia, MediaType.APPLICATION_XML));
        return response.getStatusInfo().getReasonPhrase();
    }

    public String excluirMateriaPrima(materia_prima materia) {
        Response response = client.target(uri)
                .path("/{mat_codigo}")
                .resolveTemplate("mat_codigo", materia.getMat_codigo())
                .request(MediaType.APPLICATION_XML)
                .delete();
        return response.getStatusInfo().getReasonPhrase();
    }

    public List<materia_prima> getMateriaPrima() {
        List<materia_prima> mat_prima = client.target(uri)
                .request()
                .get(new GenericType<List<materia_prima>>() {
                });
        return mat_prima;
    }

    public void close() {
        client.close();
    }

}
