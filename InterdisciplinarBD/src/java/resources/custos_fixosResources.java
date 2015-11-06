/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.custos_fixosDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.custos_fixos;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/custos_fixos")
public class custos_fixosResources {

    custos_fixosDao cfdao = new custos_fixosDao();

    public custos_fixosResources() {
    }

    @GET
    @Produces("application/json")
    public List<custos_fixos> findAll() {
        return cfdao.findAll();
    }

    @GET
    @Path("{cus_codigo}")
    @Produces("application/json")
    public custos_fixos findById(@PathParam("cus_codigo") Integer id) {
        custos_fixos cf = cfdao.findById(id);
        return cf;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(custos_fixos cf) {
        if (cf.getCus_codigo() == 0) {
            cfdao.insert(cf);
        } else {
            cfdao.update(cf);
        }
    }

    @DELETE
    @Path("{cus_codigo}")
    public void delete(@PathParam("cus_codigo") Integer id) {
        cfdao.delete(cfdao.findById(id));
    }

}
