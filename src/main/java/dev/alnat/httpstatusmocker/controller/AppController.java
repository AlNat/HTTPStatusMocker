package dev.alnat.httpstatusmocker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by @author AlNat on 09.08.2020.
 * Licensed by Apache License, Version 2.0
 */
@Controller
@RequestMapping("/")
public class AppController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String main() {
        return "index";
    }

    // Disable favicon
    @GetMapping("/favicon.ico")
    @ResponseBody
    public String favicon() {
        return "";
    }

    @RequestMapping("/{code}")
    public ResponseEntity<String> mock(
            @PathVariable(value = "code") Integer code,
            @RequestParam(value = "delay", required = false) Integer delay)
            throws Exception {
        if (delay != null && delay > 0) {
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
                log.error("Error in sleep during request: {}", e.getMessage());
                throw new Exception("Error in sleep during request!", e);
            }
        }

        HttpStatus status = HttpStatus.resolve(code);
        if (status == null) return new ResponseEntity<>("Invalid code!", HttpStatus.valueOf(500));

        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }

}
