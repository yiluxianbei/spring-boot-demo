package demo.controller;

import demo.response.DateTimeResponse;
import demo.request.DateTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DateTimeController {

    @PostMapping(value = "/testDateTime")
    public DateTimeResponse testDateTime(@RequestBody DateTimeRequest dateTimeRequest, HttpServletRequest request) {
        String header = request.getHeader("123");
//        Cookie[] cookies = request.getCookies();
//        Enumeration<String> parameterNames = request.getParameterNames();
        return new DateTimeResponse(dateTimeRequest.getLocalDateTime(),dateTimeRequest.getLocalDate());
    }
}
