/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.produtoDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.produto;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/produto")
public class produtoResource {

    produtoDao proDao = new produtoDao();

    public produtoResource() {
    }

    @GET
    @Produces("application/json")
    public List<produto> findAll() {
        return proDao.findAll();
    }

    @GET
    @Path("{pro_codigo}")
    @Produces("application/json")
    public produto findById(@PathParam("pro_codigo") Integer id) {
        produto pro = proDao.findById(id);
        return pro;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(produto pro) {
        if (pro.getPro_codigo() == 0) {
            proDao.insert(pro);
        } else {
            proDao.update(pro);
        }
    }

    @DELETE
    @Path("{pro_codigo}")
    public void delete(@PathParam("pro_codigo") Integer id) {
        proDao.delete(proDao.findById(id));
    }

}
