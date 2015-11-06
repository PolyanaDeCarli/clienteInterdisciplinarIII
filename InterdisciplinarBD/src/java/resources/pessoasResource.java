/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.pessoasDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.pessoas;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/pessoas")
public class pessoasResource {

    pessoasDao pDao = new pessoasDao();

    public pessoasResource() {
    }

    @GET
    @Produces("application/json")
    public List<pessoas> findAll() {
        return pDao.findAll();
    }

    @GET
    @Path("{pes_codigo}")
    @Produces("application/json")
    public pessoas findById(@PathParam("pes_codigo") Integer id) {
        pessoas p = pDao.findById(id);
        return p;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(pessoas p) {
        if (p.getPes_codigo() == 0) {
            pDao.insert(p);
        } else {
            pDao.update(p);
        }
    }

    @DELETE
    @Path("{pes_codigo}")
    public void delete(@PathParam("pes_codigo") Integer id) {
        pDao.delete(pDao.findById(id));
    }

}
