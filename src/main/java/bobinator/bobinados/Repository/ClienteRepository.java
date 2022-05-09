/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author groxa
 */

public interface ClienteRepository extends JpaRepository<Cliente,String> {
    
     @Query("Select u from Usuario u where u.username = :pepe")
    public Cliente buscarUsuarioPorUsername(@Param("pepe") String username);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public Cliente findByUsername(String username);
}
