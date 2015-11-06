/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.custos_variaveisDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.custos_variaveis;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/custos_variaveis")
public class custos_variaveisResources {

    custos_variaveisDao cvdao = new custos_variaveisDao();

    public custos_variaveisResources() {
    }

    @GET
    @Produces("application/json")
    public List<custos_variaveis> findAll() {
        return cvdao.findAll();
    }

    @GET
    @Path("{cuv_codigo}")
    @Produces("application/json")
    public custos_variaveis findById(@PathParam("cuv_codigo") Integer id) {
        custos_variaveis cv = cvdao.findById(id);
        return cv;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(custos_variaveis cv) {
        if (cv.getCuv_codigo() == 0) {
            cvdao.insert(cv);
        } else {
            cvdao.update(cv);
        }
    }

    @DELETE
    @Path("{cuv_codigo}")
    public void delete(@PathParam("cuv_codigo") Integer id) {
        cvdao.delete(cvdao.findById(id));
    }
}
