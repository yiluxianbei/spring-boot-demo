package demo.controller;

import demo.enums.CheckState;
import demo.request.TestEnumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PostMapping("/enum")
    public TestEnumRequest testEnum(@RequestBody TestEnumRequest testEnumRequest){
        return testEnumRequest;
    }
}
