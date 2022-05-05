package bobinator.bobinados.Entity;
import bobinator.bobinados.Enum.TipoDeMotor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@DiscriminatorValue(value="trifasico")
@Entity
@Data
public class Trifasico {
    
    private boolean conexion;
       @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private TipoDeMotor tipo;
    private Integer numeroDePolos;
    private Integer numeroDeRanuras;
    private Double dInternoDEstator;
    private Double dExternoDEstator;
    private String alturaDeCabeza;
    private Double apilamientoDChapa;
    private Double potenciaEnHP;
    private Integer corrienteEnAmp;
    private Double tension;
    private Double frecuenciaEnHZ;
    private Integer capacitor;
    private Boolean esPermanente;
    private Boolean esPolo;
    
    
}
