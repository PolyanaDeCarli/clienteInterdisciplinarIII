/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.custos_fixosDao;
import dao.maquinasDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.custos_fixos;
import model.maquinas;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/maquinas")
public class maquinasResource {

    maquinasDao mdao = new maquinasDao();
    custos_fixosDao cusDao = new custos_fixosDao();

    public maquinasResource() {
    }

    @GET
    @Produces("application/json")
    public List<maquinas> findAll() {
        return mdao.findAll();
    }

    @GET
    @Path("{maq_codigo}")
    @Produces("application/json")
    public maquinas findById(@PathParam("maq_codigo") Integer id) {
        maquinas m = mdao.findById(id);
        return m;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void save(maquinas m) {
        if (m.getMaq_codigo() == 0) {
            custos_fixos cus = new custos_fixos();
            cus.setCus_descricao("Depreciação Máquina " + m.getMaq_descricao());
            //calcula o valor da depreciacao da máquina
            cus.setCus_valor((m.getMaq_valor() / m.getMaq_depreciacao()) / 12);
            cusDao.insert(cus);
            m.setCustos_fixos(cus);
            mdao.insert(m);
        } else {
            custos_fixos cus = m.getCustos_fixos();
            //calcula o valor da depreciacao da máquina
            cus.setCus_valor((m.getMaq_valor() / m.getMaq_depreciacao()) / 12);
            cusDao.update(cus);
            m.setCustos_fixos(cus);
            mdao.update(m);
        }
    }

    @DELETE
    @Path("{maq_codigo}")
    public void delete(@PathParam("maq_codigo") Integer id) {
        mdao.delete(mdao.findById(id));
    }

}
