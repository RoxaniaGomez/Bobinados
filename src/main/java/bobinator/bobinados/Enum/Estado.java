package bobinator.bobinados.Enum;

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
