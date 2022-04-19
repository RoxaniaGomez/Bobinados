package bobinator.bobinados.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class CalculoDiametro {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private Double diametro;

    private Double seccion;

    private Double A2;

    private Double A3;

    private Double A5;

    private Double A7;

    private Double A10;

    private Double A15;

    private Double A20;

    private Double A25;
}
