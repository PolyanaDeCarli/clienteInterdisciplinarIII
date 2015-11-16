/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.custos_variaveisDao;
import dao.salariosDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.custos_variaveis;
import model.salarios;

/**
 *
 * @author Larissa Cardoso
 */
@Path("/salarios")
public class salariosResource {

    salariosDao sDao = new salariosDao();
    custos_variaveisDao cuvDao = new custos_variaveisDao();

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
    public void save(salarios sal) throws ParseException {
        if (sal.getSal_codigo() == 0) {
            custos_variaveis cuv = new custos_variaveis();
            Date dt = new Date();
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(sal.getSal_data());
            int dia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            int mes = (cal.get(Calendar.MONTH) + 1);
            int ano = cal.get(Calendar.YEAR);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicial = sdf.parse("01/" + mes + "/" + ano);
            Date dataFinal = sdf.parse(dia + "/" + mes + "/" + ano);
            cuv.setCuv_codigo(0);
            cuv.setCuv_datainicial(dataInicial);
            cuv.setCuv_datafinal(dataFinal);
            cuv.setCuv_descricao("Salário " + sal.getCargos().getCar_descricao() + " - " + mes + "/" + ano);
            cuv.setCuv_valor(sal.getSal_valor());
            cuvDao.insert(cuv);
            sal.setCustos_variaveis(cuv);
            sDao.insert(sal);
        } else {
            custos_variaveis cuv = sal.getCustos_variaveis();
            Date dt = new Date();
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(sal.getSal_data());
            int dia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            int mes = (cal.get(Calendar.MONTH) + 1);
            int ano = cal.get(Calendar.YEAR);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicial = sdf.parse("01/" + mes + "/" + ano);
            Date dataFinal = sdf.parse(dia + "/" + mes + "/" + ano);
            cuv.setCuv_codigo(cuv.getCuv_codigo());
            cuv.setCuv_datainicial(dataInicial);
            cuv.setCuv_datafinal(dataFinal);
            cuv.setCuv_descricao("Salário " + sal.getCargos().getCar_descricao() + " - " + mes + "/" + ano);
            cuv.setCuv_valor(sal.getSal_valor());
            cuvDao.update(cuv);
            sDao.update(sal);
        }
    }

    @DELETE
    @Path("{sal_codigo}")
    public void delete(@PathParam("sal_codigo") Integer id) {
        sDao.delete(sDao.findById(id));
    }

}
