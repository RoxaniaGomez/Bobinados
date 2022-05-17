/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Enum;

/**
 *
 * @author groxa
 */
public enum Estado {
    EN_REVISION("En revision"),
    PRESUPUESTADO("Presupuestado"),
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado"),
    LISTO_PARA_RETIRAR("Listo para retirar"),
    ENTREGADO("Entregado");
    
    
    private Estado(String texto) {
        this.texto = texto;
    }
    
    private String texto;
    
    public String getTexto() {
        return this.texto;
    }
}
