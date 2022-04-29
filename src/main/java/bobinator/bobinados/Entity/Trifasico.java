package bobinator.bobinados.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;
@DiscriminatorValue(value="trifasico")
@Entity
@Data
public class Trifasico extends Motor{
    
    private boolean conexion;
    
}
