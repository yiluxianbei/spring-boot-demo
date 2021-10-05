package demo.controller.http;

import com.alibaba.fastjson.JSON;
import demo.request.http.UserRequest;
import demo.response.http.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping("/post")
    public UserResponse post(@RequestBody UserRequest request){
        return JSON.parseObject(JSON.toJSONString(request),UserResponse.class);
    }
}
