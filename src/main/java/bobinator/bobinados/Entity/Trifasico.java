package bobinator.bobinados.Entity;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Trifasico extends Motor{
    
    private boolean conexion;
    
}
