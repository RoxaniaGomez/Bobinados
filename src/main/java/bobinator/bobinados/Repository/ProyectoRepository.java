/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author groxa
 */
public interface ProyectoRepository extends JpaRepository<Proyecto,String> {
   
    
     @Query("Select u from Proyecto u where u.id = :pepe")
    public Proyecto buscarProyectoPorId(@Param("pepe") String id);
    
   

}
