/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author groxa
 */
public interface MotorRepository extends JpaRepository<Motor,String> {
        @Query("Select u from Motor u where u.id = :pepe")
    public Motor buscarMotorPorId(@Param("pepe") Integer id);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public Motor findByNumDeMotor(String numDeMotor);
}
