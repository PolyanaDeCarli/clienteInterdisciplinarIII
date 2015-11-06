/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.materia_primaDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.materia_prima;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/materia_prima")
public class materia_primaResource {

    materia_primaDao mpDao = new materia_primaDao();

    public materia_primaResource() {
    }

    @GET
    @Produces("application/json")
    public List<materia_prima> findAll() {
        return mpDao.findAll();
    }

    @GET
    @Path("{mat_codigo}")
    @Produces("application/json")
    public materia_prima findById(@PathParam("mat_codigo") Integer id) {
        materia_prima mp = mpDao.findById(id);
        return mp;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(materia_prima mp) {
        if (mp.getMat_codigo() == 0) {
            mpDao.insert(mp);
        } else {
            mpDao.update(mp);
        }
    }

    @DELETE
    @Path("{mat_codigo}")
    public void delete(@PathParam("mat_codigo") Integer id) {
        mpDao.delete(mpDao.findById(id));
    }
}
