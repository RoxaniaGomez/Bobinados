/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Calculos;
import bobinator.bobinados.Entity.Cliente;
import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Trifasico;
import bobinator.bobinados.Enum.Estado;
import bobinator.bobinados.Repository.ProyectoRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class ProyectoService {

    @Autowired
    private CalculoService calculoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MonofasicoService monofasicoService;
    @Autowired
    private TrifasicoServicio trifasicoService;
       
    @Autowired
    private ProyectoRepository proyectoRepo;

    public Proyecto crearProyecto(Proyecto proyecto) throws Exception {

        Cliente cliente = clienteService.registrarUsuario(proyecto.getCliente());
        if (proyecto.getMotorMonofasico() != null) {
            Monofasico mono = monofasicoService.CargarMotor(proyecto.getMotorMonofasico());
            proyecto.setMotorMonofasico(mono);

        } else {

            Trifasico tri = trifasicoService.CargarMotor(proyecto.getMotorTrifasico());
            proyecto.setMotorTrifasico(tri);

        }
        proyecto.setAlta(true);
        proyecto.setEstado(Estado.EN_REVISION);
        return proyectoRepo.save(proyecto);
    }

    public void darBaja(String id) throws Error {
        Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
            edit.setAlta(false);
            proyectoRepo.save(edit);
        } else {
            throw new Error("No se encontró el proyecto");

        }
    }

    public List<Proyecto> listarProyectos() {
        return proyectoRepo.findAll();
    }
    public List<Proyecto> listarProyectosPorIdCliente(String idCliente) {
        return proyectoRepo.buscarProyectoPorIdCliente(idCliente);
    }

    public Proyecto buscarPorId(String id) {
        return proyectoRepo.getById(id);
    }

    public void borrarProyecto(String id) throws Error {
        Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
            edit.setAlta(false);
            proyectoRepo.delete(edit);
        } else {
            throw new Error("No se encontró el proyecto");
        }
    }

    public void darAlta(String id) throws Error {
        Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
            edit.setAlta(true);
            proyectoRepo.save(edit);
        } else {
            throw new Error("No se encontro el proyecto");

        }
    }

    public Calculos calcularProyecto(String id) {
        Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
            if (edit.getCalculo() == null) {
                Calculos calculo = calculoService.resolver(edit.getMotorTrifasico());
                edit.setCalculo(calculo);
                proyectoRepo.save(edit);
            }

            return edit.getCalculo();
        } else {
            throw new Error("No se encontro el proyecto");

        }

    }
    public void calcularPresupuestoProyecto(String id, Date fecha, Double presupuesto) {
        Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
                edit.setPresupuesto(presupuesto);
                edit.setFecha(fecha);
                edit.setEstado(Estado.PRESUPUESTADO);
                proyectoRepo.save(edit);
            

            
        } else {
            throw new Error("No se encontro el proyecto");

        }

    }

    public void modificarEstado(String id, Estado estado) {
        Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
             edit.setEstado(estado);
            proyectoRepo.save(edit);
    
    }

}
/*
    aprobar(String id)
    {
    Proyecto proyecto = melotraigoconelid
    proyecto.setEstado(Estado.Aprobar)
    }    
    */
    public void aprobar(String id) {
       Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
             edit.setEstado(Estado.APROBADO);
            proyectoRepo.save(edit);
    
    }
    }
    public void rechazar(String id) {
       Optional<Proyecto> respuesta = proyectoRepo.findById(id);
        if (respuesta.isPresent()) {
            Proyecto edit = respuesta.get();
             edit.setEstado(Estado.RECHAZADO);
            proyectoRepo.save(edit); 
    }
}

    public void modificarCliente(String id, String password, String telefono) {
         Proyecto respuesta =  proyectoRepo.buscarUnProyectoPorIdCliente(id);
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
             respuesta.getCliente().setPassword(encoder.encode(password));
             respuesta.getCliente().setTelefono(telefono);
                     
                     
            proyectoRepo.save(respuesta); 
      }

}