package life.majiang.community.community.contorller;

import life.majiang.community.community.dto.AccessTokenDTO;
import life.majiang.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *授权登录
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="status")String status){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("Iv1.e66413412bfa19fc");
        accessTokenDTO.setClient_secret("d0c008a002c109522c274789f1f8f506bd26d3b5");
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(status);
        githubProvider.getAccessToken(accessTokenDTO);



        return "index";
    }
}
