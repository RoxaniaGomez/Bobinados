/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author groxa
 */

@Entity
@Data
public class Monofasico extends Motor {
    private Integer capacitor;
    private Boolean esPermanente;
    private Boolean esPolo;
}
