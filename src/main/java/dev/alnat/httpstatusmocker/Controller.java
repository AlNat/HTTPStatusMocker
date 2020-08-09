package dev.alnat.httpstatusmocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by @author AlNat on 09.08.2020.
 * Licensed by Apache License, Version 2.0
 */
@RestController
@RequestMapping("/")
public class Controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
        if (status == null) throw new Exception("Invalid code");

        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }

}
