package bobinator.bobinados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taller")
public class TallerController {

    @GetMapping("")
    public String postLogueo() {
	return "taller";
    }
}
