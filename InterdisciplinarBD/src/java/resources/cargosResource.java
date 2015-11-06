/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.cargosDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.cargos;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/cargos")
public class cargosResource {

    cargosDao cdao = new cargosDao();

    public cargosResource() {
    }

    @GET
    @Produces("application/json")
    public List<cargos> findAll() {
        return cdao.findAll();
    }

    @GET
    @Path("{car_codigo}")
    @Produces("application/json")
    public cargos findById(@PathParam("car_codigo") Integer id) {
        cargos c = cdao.findById(id);
        return c;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(cargos c) {
        if (c.getCar_codigo() == 0) {
            cdao.insert(c);
        } else {
            cdao.update(c);
        }
    }

    @DELETE
    @Path("{car_codigo}")
    public void delete(@PathParam("car_codigo") Integer id) {
        cdao.delete(cdao.findById(id));
    }
}
