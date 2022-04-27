package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Entity.MotorTrifasico;
import bobinator.bobinados.Service.EmpleadoService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String index() {
        return "taller";
    }
}
//
//    @Autowired
//    private EmpleadoService empleadoService;
//
//    @GetMapping("")
//    public String formulario(Model modelo) {
//	MotorTrifasico datos = new MotorTrifasico();
//	modelo.addAttribute("datos", datos);
//	return "empleadoBobinado"; //Html
//    }
//
//    @GetMapping("/modificar")
//    public String formulario(@RequestParam(name = "id", required = true) String id, Model modelo) {
//	Empleado datos = empleadoService.buscarPorId(id);
//	modelo.addAttribute("datos", datos);
//	return "empleadoBobinado";
//    }
//
////    @PostMapping("/save")
////    public String formularioData(@RequestParam("nombre") Integer nombre,@RequestParam("id") String id,
////	    Model modelo, @RequestParam(name = "modificar", required = false) String modificar) {
////	Empleado datos = new Empleado();
////	try {
////	 
////	    datos.setId(id);
////	   
////	    empleadoService.
////	    modelo.addAttribute("datos", datos);
////	    if (modificar != null) {
////		return "redirect:/empleadoBobinado/list";
////	    }
////	    return "empleadoBobinado";
////	} catch (Exception ex) {
////	    ex.printStackTrace();
////	    modelo.addAttribute("datos", datos);
////	    modelo.addAttribute("error", ex.getMessage());
////	    return "empleadoBobinado";
////	}
////    }
//
////    @GetMapping("/list")
////    public String listAll(Model modelo) {
////	List<MotorTrifasico> datos = empleadoService.listarDatosl();
////	modelo.addAttribute("listaDeDatos", datos);
////	return "datos-listar";
////    }
////
////    @GetMapping("/alta")
////    public String alta(@RequestParam("id") String id) {
////	try {
////	    empleadoService.altaDatos(id);
////	    return "redirect:/empleadoBobinado/list";
////	} catch (Exception e) {
////	    e.printStackTrace();
////	    return "redirect:/empleadoBobinado/list";
////	}
////    }
////
////    @GetMapping("/delete") //Baja
////    public String delete(@RequestParam("id") String id) {
////	try {
////	    empleadoService.borrarDatos(id);
////	    return "redirect:/empleadoBobinado/list";
////	} catch (Exception e) {
////	    e.printStackTrace();
////	    return "redirect:/empleadoBobinado/list";
////	}
////    }
////
////    @GetMapping("/eliminar")
////    public String eliminarDatos(@RequestParam("id") String id) {
////	try {
////	    empleadoService.eliminarDatos(id);
////	    return "redirect:/empleadoBobinado/list";
////	} catch (Exception e) {
////	    e.printStackTrace();
////	    return "redirect:/empleadoBobinado/list";
////	}
////    }
//}
