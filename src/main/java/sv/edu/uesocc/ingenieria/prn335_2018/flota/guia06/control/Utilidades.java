/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.guia06.control;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import sv.edu.uesocc.ingenieria.prn335_2018.flotadatalib.definicion.TipoParte;

/**
 *
 * @author stany
 */
@Stateless
@LocalBean
public class Utilidades {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("sv.edu.uesocc.ingenieria.prn335_2018.flota.datos_FlotaDataLib_jar_1.0-SNAPSHOTPU");
    public javax.persistence.EntityManager em=emf.createEntityManager();
    
    
    
    public void insertar(){
    }
    public void update(){
    }
    public void delete(){}
    
    public List selectAll(){
        TypedQuery query;
        query = (TypedQuery) em.createQuery("SELECT t FROM TipoParte t",TipoParte.class);
     List resultado=query.getResultList();
        return resultado;
    }
    
    
    
}
