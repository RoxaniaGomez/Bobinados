package bobinator.bobinados.Entity;

import bobinator.bobinados.Enum.polo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Data
abstract public class Motor {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fabricante;
    private String Nacionalidad;
    private String numDeMotor;
    private String modelo;
    private String regimenDeServicio;

    private String notas;
    

    private String tipoDeAislacion;
    private Integer numeroDePolos;
    private Integer numeroDeRanuras;

    private Double dInternoDEstator;

    private Double dExternoDEstator;
    private String alturaDeCabeza;
    private Double apilamientoDChapa;

    private Double potenciaEnHP;

    private Double corrienteEnAmp;
    private polo polo;
    private Double tension;//380
    private Double diametroAlambre;
    private Double frecuenciaEnHZ;//50hz
}
