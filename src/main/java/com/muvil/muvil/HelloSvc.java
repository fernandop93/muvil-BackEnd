package com.muvil.muvil;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HelloSvc {
    @GetMapping("/test")
    public HashMap<String, String> sayHello() {
        var map = new HashMap<String, String>();
 
        map.put("greeting", "Hello");
        map.put("planet", "World");
 
        return map;
    }
}
