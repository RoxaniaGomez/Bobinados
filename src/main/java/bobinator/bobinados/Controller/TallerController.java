package bobinator.bobinados.Controller;


import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Service.EmpleadoService;
import bobinator.bobinados.Service.ProyectoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/taller")
public class TallerController {
    
    
@Autowired
private ProyectoService proyectoService;
@Autowired
private EmpleadoService empleadoService;
    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String postLogueo() {
        return "taller";
    }
   
    @PostMapping("/crearProyecto")
    public String CrearProyecto(HttpSession sesion) throws Exception{
    Usuario usuario = (Usuario) sesion.getAttribute("usuario");
       
      
    Proyecto proyecto= proyectoService.CrearProyecto((Empleado) usuario,true);
    
    return "redirect:/taller";
    }
   @GetMapping("/list")
    public String list(Model modelo) {
	List<Proyecto> proyecto = proyectoService.listarProyectos();
        System.out.println("Proyecto: "+proyecto);
	modelo.addAttribute("lista", proyecto);
	return "taller";
    }
    @GetMapping("/alta")
    public String alta(@RequestParam("id") String id) {
	try {
	    proyectoService.darAlta(id);
	    return "redirect:/taller";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/taller";
	}
    }
        @GetMapping("/baja")
    public String baja(@RequestParam("id") String id) {
	try {
	    proyectoService.darBaja(id);
	    return "redirect:/taller/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/taller/list";
	}
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
	try {
	    proyectoService.borrarProyecto(id);
	    return "redirect:/taller/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/taller/list";
	}
    }
}
