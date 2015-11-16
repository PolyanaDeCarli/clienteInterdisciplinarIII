/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.materiaprima_produtosDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.materiaprima_produtos;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/materiaprima_produtos")
public class materiaprima_produtosResource {

    materiaprima_produtosDao matpDao = new materiaprima_produtosDao();

    public materiaprima_produtosResource() {
    }

    @GET
    @Produces("application/json")
    public List<materiaprima_produtos> findAll() {
        return matpDao.findAll();
    }

    @GET
    @Path("{mp_codigo}")
    @Produces("application/json")
    public materiaprima_produtos findById(@PathParam("mp_codigo") Integer id) {
        materiaprima_produtos mp = matpDao.findById(id);
        return mp;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(materiaprima_produtos mp) {
        if (mp.getMp_codigo() == 0) {
            matpDao.insert(mp);
        } else {
            matpDao.update(mp);
        }
    }

    @DELETE
    @Path("{mp_codigo}")
    public void delete(@PathParam("mp_codigo") Integer id) {
        matpDao.delete(matpDao.findById(id));
    }
}
