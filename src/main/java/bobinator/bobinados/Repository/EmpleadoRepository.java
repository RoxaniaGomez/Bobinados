package bobinator.bobinados.Repository;
import bobinator.bobinados.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{
        @Query("Select u from Usuario u where u.username = :pepe")
    public Empleado buscarUsuarioPorUsername(@Param("pepe") String username);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public Empleado findByUsername(String username);
}
