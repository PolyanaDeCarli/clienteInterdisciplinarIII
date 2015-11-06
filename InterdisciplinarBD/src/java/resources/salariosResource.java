/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.salariosDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.salarios;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/salarios")
public class salariosResource {

    salariosDao sDao = new salariosDao();

    public salariosResource() {
    }

    @GET
    @Produces("application/json")
    public List<salarios> findAll() {
        return sDao.findAll();
    }

    @GET
    @Path("{sal_codigo}")
    @Produces("application/json")
    public salarios findById(@PathParam("sal_codigo") Integer id) {
        salarios sal = sDao.findById(id);
        return sal;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(salarios sal) {
        if (sal.getSal_codigo() == 0) {
            sDao.insert(sal);
        } else {
            sDao.update(sal);
        }
    }

    @DELETE
    @Path("{sal_codigo}")
    public void delete(@PathParam("sal_codigo") Integer id) {
        sDao.delete(sDao.findById(id));
    }

}
