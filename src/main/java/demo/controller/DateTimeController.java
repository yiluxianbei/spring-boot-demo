package demo.controller;

import demo.request.DateTimeRequest;
import demo.response.DateTimeResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DateTimeController {

    @PostMapping(value = "/testDateTime")
    public DateTimeResponse testDateTime(@RequestBody DateTimeRequest dateTimeRequest, HttpServletRequest request) {
        return new DateTimeResponse(dateTimeRequest.getLocalDateTime(),dateTimeRequest.getLocalDate());
    }
}
