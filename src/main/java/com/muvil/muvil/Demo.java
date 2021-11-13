package com.muvil.muvil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Demo {

    @GetMapping("/iot1")
    public String sayHello() {


        Path fileName = Path.of("src/resource/ideaTramaIoT.json");
        try {
            return Files.readString(fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    

        return "";

    }
}
