package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Enum.Estado;
import bobinator.bobinados.Service.ClienteService;
import bobinator.bobinados.Service.ProyectoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    ClienteService clienteService;

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("")
    public String index(Model modelo, HttpSession httpSession, RedirectAttributes redirectAttributes) {
         Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        try {
           
         List<Proyecto> proyectos = proyectoService.listarProyectosPorIdCliente(usuario.getId());
         modelo.addAttribute("proyectos", proyectos);
        return "cliente";
        } catch (Exception e) {
            if (usuario == null) {
                redirectAttributes.addFlashAttribute("error", "Debe volver a logearse");
            } else {
                redirectAttributes.addFlashAttribute("error", "Ups!, ocurrio un error");
            }
            
            return "redirect:/";
        }
        
        
    }
    @GetMapping("/modificarEstado")
    public String modificarEstado(@RequestParam("id") String id,@RequestParam("estado") Estado estado) {
        try {
            proyectoService.modificarEstado(id,estado);
            return "redirect:/taller";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/taller";
        }
    }
}