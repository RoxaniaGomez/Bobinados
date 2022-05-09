package bobinator.bobinados.Entity;
import bobinator.bobinados.Enum.Conexion;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Trifasico extends Motor{
    
    private Conexion conexion;
    
}
