package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * 国际化错误码
 */
@RestController
@RequestMapping("/i18n")
public class I18nController {

    @Autowired
    private MessageSource messageSource;
    @GetMapping("/test")
    public String test(){
        String message = messageSource.getMessage("K-050103", new Object[]{}, Locale.CHINA);
        return message;
    }

    @GetMapping("/testParams")
    public String testParams(){
        String message = messageSource.getMessage("K-050101", new Object[]{123,5,6}, Locale.CHINA);
        return message;
    }
}
