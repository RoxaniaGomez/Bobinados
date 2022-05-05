/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Controller;

import bobinator.bobinados.Service.MonofasicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author groxa
 */
@Controller
@RequestMapping("/monofasico")
public class MonofascoController {
    @Autowired
    MonofasicoService monofasicoService;
    
    @GetMapping("")
    public String registro(Model modelo) {
        modelo.addAttribute("polos", "");
	modelo.addAttribute("ranuras", "");
        modelo.addAttribute("diametroInterno", "");
        modelo.addAttribute("diametroExterno", "");
	modelo.addAttribute("amplitud", "");
	modelo.addAttribute("potencia", "");
         modelo.addAttribute("corriente", "");
	modelo.addAttribute("tension", "");
        modelo.addAttribute("frecuenciaenHZ", "");
        modelo.addAttribute("capacitor", "");
	modelo.addAttribute("isPrmanente", "");
	modelo.addAttribute("isPolo", "");
	return "taller";
    }
   
    
}
