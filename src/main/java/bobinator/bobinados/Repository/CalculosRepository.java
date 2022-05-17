package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Calculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CalculosRepository extends JpaRepository<Calculos,String>{
     @Query("Select u from Calculos u where u.id = :pepe")
    public Calculos buscarMotorPorId(@Param("pepe") Integer id);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public Calculos findById(Integer id);
}
