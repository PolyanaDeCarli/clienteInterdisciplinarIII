/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.cidadesDao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.cidades;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/cidades")
public class cidadesResources {

    cidadesDao cidDao = new cidadesDao();

    public cidadesResources() {
    }

    @GET
    @Produces("application/json")
    public List<cidades> findAll() {
        return cidDao.findAll();
    }

    @GET
    @Path("{cid_codigo}")
    @Produces("application/json")
    public cidades findById(@PathParam("cid_codigo") Integer id) {
        cidades cid = cidDao.findById(id);
        return cid;
    }

}
