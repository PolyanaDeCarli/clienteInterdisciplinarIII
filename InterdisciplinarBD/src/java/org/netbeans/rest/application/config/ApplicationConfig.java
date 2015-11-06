/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Larissa Cardoso
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(resources.cargosResource.class);
        resources.add(resources.cidadesResources.class);
        resources.add(resources.custos_fixosResources.class);
        resources.add(resources.custos_variaveisResources.class);
        resources.add(resources.maquinasResource.class);
        resources.add(resources.materia_primaResource.class);
        resources.add(resources.pessoasResource.class);
        resources.add(resources.produtoResource.class);
        resources.add(resources.salariosResource.class);
        
    }
    
}
