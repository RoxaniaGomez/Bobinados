package bobinator.bobinados.Controller;


import bobinator.bobinados.Entity.Cliente;
import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Motor;
import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Service.EmpleadoService;
import bobinator.bobinados.Service.MonofasicoService;
import bobinator.bobinados.Service.MotorService;
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
@Autowired
private MonofasicoService monofasicoService;
    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String postLogueo() {
        return "taller";
    }
    @GetMapping("/pedirDatosMonofasico")
    public String registro(Model modelo) {
        modelo.addAttribute("numero-polo", "");
	modelo.addAttribute("numero-ranuras", "");
        modelo.addAttribute("d-interno", "");
        modelo.addAttribute("d-Externo", "");
	modelo.addAttribute("apilamiento-chapa", "");
	modelo.addAttribute("potencia", "");
        modelo.addAttribute("corriente", "");
	modelo.addAttribute("tension", "");
	modelo.addAttribute("frecuencia", "");
        modelo.addAttribute("username");
	return "taller";
    }
    @PostMapping("/crearProyecto")
    public String CrearProyecto(HttpSession sesion,
    @RequestParam("numero-polo") Double numeroPolo,
    @RequestParam("numero-ranuras") String numeroRanuras,
    @RequestParam("d-interno") String dInterno,
    @RequestParam("apilamiento-chapa") String apilamientoDeChapa,
    @RequestParam("potencia") String potencia,
    @RequestParam("corriente") String corriente,
    @RequestParam("tension") String tension,
    @RequestParam("frecuencia") String frecuencia,
    @RequestParam("username") String username,Model modelo) throws Exception{
    Usuario usuario = (Usuario) sesion.getAttribute("usuario");
//    Motor mono = monofasicoService.
////    
////      
//    Proyecto proyecto= proyectoService.CrearProyecto((Empleado) usuario,username,true);
//    
    return "taller/list";
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
