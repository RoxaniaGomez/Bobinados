package bobinator.bobinados.Entity;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Monofasico extends Motor {

    private Integer capacitor;
    private Boolean esPermanente;
    
}
