/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Controller;

import bobinator.bobinados.Service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author groxa
 */
@Controller
@RequestMapping("/proyecto")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyectoService;
    
    @GetMapping("/aprobar")
    public String aprobar(@RequestParam("id")String id) {
        
        proyectoService.aprobar(id);
        
        return "redirect:/cliente";
        
    }
     @GetMapping("/rechazar")
    public String rechazar(@RequestParam("id")String id) {
        
        proyectoService.rechazar(id);
        
        return "redirect:/cliente";
        
    }
    @GetMapping("/listo")
    public String listo(@RequestParam("id")String id) {
        
        proyectoService.listo(id);
        
        return "redirect:/taller";
        
    }
    @GetMapping("/retirado")
    public String retirado(@RequestParam("id")String id) {
        
        proyectoService.retirado(id);
        
        return "redirect:/taller";
        
    }
    
    
}