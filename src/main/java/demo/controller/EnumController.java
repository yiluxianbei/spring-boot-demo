package demo.controller;

import demo.enums.CheckState;
import demo.request.TestEnumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnumController {

    /**
     * 前端传值参照枚举类中反序列化规则，
     * 返回给前端的值参照枚举类中序列化规则
     * @param testEnumRequest
     * @return
     */
    @PostMapping("/enum")
    public TestEnumRequest testEnum(@RequestBody TestEnumRequest testEnumRequest){
        return new TestEnumRequest(CheckState.CANCEL);
    }

}
