package demo.controller.http;

import com.alibaba.fastjson.JSON;
import demo.request.http.UserRequest;
import demo.response.http.UserResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 接收xml参数
 */
@Controller
@RequestMapping("/xml")
public class XmlController {

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserResponse create(@RequestBody UserRequest request) {
        return JSON.parseObject(JSON.toJSONString(request),UserResponse.class);
    }
}
