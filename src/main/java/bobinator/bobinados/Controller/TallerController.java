package bobinator.bobinados.Controller;


import bobinator.bobinados.Entity.Cliente;
import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Motor;
import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Service.ClienteService;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/taller")
public class TallerController {
    
    
@Autowired
private ProyectoService proyectoService;
@Autowired
private ClienteService clienteService;
@Autowired
private MonofasicoService monofasicoService;
    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String postLogueo(Model modelo) {
        List<Proyecto> proyecto = proyectoService.listarProyectos();
	modelo.addAttribute("lista", proyecto);
       modelo.addAttribute("cliente", new Cliente());      
       modelo.addAttribute("mono", new Monofasico());  
           modelo.addAttribute("mono", new Monofasico());    
        return "taller";
    }
    @GetMapping("/form")
    public String registro(Model modelo) {
       
      modelo.addAttribute("cliente", new Cliente());
      
	return "taller";
    }
     
    @PostMapping("/save")
    public String CrearCliente(@ModelAttribute("cliente")Cliente cliente) throws Exception{
        
        clienteService.registrarUsuario(cliente);
       
//         
	    return "redirect:/taller";
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
	    return "redirect:/taller";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/taller";
	}
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
	try {
	    proyectoService.borrarProyecto(id);
	    return "redirect:/taller";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/taller";
	}
    }
}
