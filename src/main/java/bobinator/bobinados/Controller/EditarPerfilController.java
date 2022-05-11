package bobinator.bobinados.Controller;


import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Service.ClienteService;
import bobinator.bobinados.Service.ProyectoService;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author anaoc
 */
@Controller
@RequestMapping("/editar")
public class EditarPerfilController {
     @Autowired
    ProyectoService proyectoService;

    @Autowired
    ClienteService clienteService;
    @GetMapping("")
    public String index(){
      
    return "editar";
    }
    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @PostMapping("/editarCliente")
   public String editarControler(@RequestParam("password") String password,@RequestParam("telefono") String telefono, HttpSession httpSession, RedirectAttributes redirectAttributes) {
         Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        try {
           
         proyectoService.modificarCliente(usuario.getId(),password,telefono);
         
        return "editar";
        } catch (Exception e) {
            if (usuario == null) {
                redirectAttributes.addFlashAttribute("error", "Debe volver a logearse");
            } else {
                redirectAttributes.addFlashAttribute("error", "Ups!, ocurrio un error");
            }
            
            return "redirect:/editar";
        }
        
        
    }

    
}