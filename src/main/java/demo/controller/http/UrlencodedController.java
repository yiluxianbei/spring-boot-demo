package demo.controller.http;

import com.alibaba.fastjson.JSON;
import demo.response.http.UserResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
@RequestMapping("/urlencoded")
public class UrlencodedController {

    @PostMapping(value = "/post")
    public UserResponse post(@RequestParam Map<String,Object> map){
        return JSON.parseObject(JSON.toJSONString(map),UserResponse.class);
    }
}
