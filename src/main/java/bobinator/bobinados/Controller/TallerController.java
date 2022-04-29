package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Service.ProyectoService;
import java.util.List;
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
    
    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String postLogueo() {
        return "taller";
    }
   
    @PostMapping("/crearProyecto")
    public String CrearProyecto() throws Exception{
    Proyecto proyecto= proyectoService.CrearProyecto();
    return "taller";
    }
    
    @GetMapping("/list")
    public String listAll(Model modelo) {
	List<Proyecto> taller = proyectoService.listarProyectos();
	modelo.addAttribute("taller", taller);
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
