package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.CalculoDiametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlambreRepository extends JpaRepository<CalculoDiametro, String> {

    @Query("Select u from CalculoDiametro u where u.diametro = :pepe")
    public CalculoDiametro BuscarDiametroPorId(@Param("pepe") String CalculoDiametro);
    
}
