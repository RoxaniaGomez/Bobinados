package bobinator.bobinados.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class MotorTrifasico {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private Integer numeroPolo;

    private Integer numeroRanura;

    private Double corrienteAMP;

    private Double tension;

    private Integer frecuenciaHz;

    private Double diametroExterno;

    private Double diametroInterno;

    private Integer potencia;

    private Integer apilamientoDeChapa;

    private Boolean esConcentrico;

    @OneToOne
    private Alambre alambre;

    @OneToOne
    private Polo polo;

    private Integer grupoDeBobina;

    private Integer ranuraPorFases;

    private Integer amplitudDelGrupo;

    private Integer bobinasPorGrupo;
    
    private Boolean alta;
}
