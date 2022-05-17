/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author groxa
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Entity
@Data
public class Calculos{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    
    private Double diametroDelAlmbreMM;
    private Double PesoDelAlambreKG;
    private Integer paso1;
    private Integer paso2;
    private Integer paso3;
    private Integer grupos;
    private Integer ranuraPorPoloPorFase;
    private Integer numeroDeBobinaPorGrupo;
    private Integer amplitudDeGrupo;
    private Double pasoPolar;
    private Double flujoMagnetico;
    private Double vueltasPorBobinas;
    private Double seccionDelAlambre;
}
