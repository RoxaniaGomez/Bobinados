package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository  extends JpaRepository<Usuario,String> {
    @Query("Select u from Usuario u where u.username = :pepe")
    public Usuario buscarUsuarioPorUsername(@Param("pepe") String username);
    
    // otra forma sin jpql
    //si lo escribo en camelcase entonces lo puede convertir en una consulta jpql
    
    public Usuario findByUsername(String username);

}
