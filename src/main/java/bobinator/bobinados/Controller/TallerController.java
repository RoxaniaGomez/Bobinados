package bobinator.bobinados.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taller")
public class TallerController {

    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String postLogueo() {
        return "taller";
    }
}
