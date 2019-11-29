package life.majiang.community.community.contorller;

import org.springframework.stereotype.Controller;

/**
 *
 */
@Controller
public class AuthorizeController {
    public String callback(){
        return "index";
    }
}
