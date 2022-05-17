package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Monofasico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MonofasicoRepository  extends JpaRepository<Monofasico,String>{
    @Query("Select u from Monofasico u where u.id = :pepe")
    public Monofasico buscarMotorPorId(@Param("pepe") Integer id);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public Monofasico findByNumDeMotor(String numDeMotor);
}