package demo.controller;

import demo.enums.CheckState;
import demo.request.TestEnumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnumController {

    /**
     * 前端传枚举的顺序，
     * 返回给前端的枚举也是枚举的顺序
     * @param testEnumRequest
     * @return
     */
    @PostMapping("/enum")
    public TestEnumRequest testEnum(@RequestBody TestEnumRequest testEnumRequest){
        return new TestEnumRequest(CheckState.CANCEL);
    }

    public static void main(String[] args) {
        System.out.println(CheckState.CANCEL.ordinal());
    }
}
