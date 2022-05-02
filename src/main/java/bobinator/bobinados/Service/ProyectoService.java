/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Cliente;
import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class ProyectoService{
     @Autowired
    private ProyectoRepository proyectoRepo;
  
     
    public Proyecto CrearProyecto(Empleado empleado,String username, Boolean alta) throws Exception {
	Proyecto proyecto =new Proyecto();
        Cliente cliente= new Cliente();
        ClienteService clienteService;
       proyecto.setEmpleado(empleado);
//
//       clienteService.registrarUsuario(" ", username,"","1234", "1234");
       proyecto.setAlta(true);
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

    
}
