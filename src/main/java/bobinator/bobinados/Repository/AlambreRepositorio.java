/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.CalculoDiametro;
import bobinator.bobinados.Entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author groxa
 */
@Repository
public interface AlambreRepositorio   extends JpaRepository<CalculoDiametro,String> {
     @Query("Select u from CalculoDiametro u where u.diametro = :pepe")
    public CalculoDiametro buscarDiametroPorId(@Param("pepe") String CalculoDiametro);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public CalculoDiametro findByUserId(String id);

}
