package del.alnat.httpstatusmocker.controller;

import dev.alnat.httpstatusmocker.HTTPStatusMocker;
import dev.alnat.httpstatusmocker.controller.AppController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by @author AlNat on 09.08.2020.
 * Licensed by Apache License, Version 2.0
 */
@WebMvcTest(AppController.class)
@ContextConfiguration(classes={HTTPStatusMocker.class})
public class AppControllerTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test all http statuses")
    void testAllCorrectStatuses() throws Exception {
        for (HttpStatus status : HttpStatus.values()) {
            log.debug("Test {} code", status.value());
            mockMvc.perform(get("/" + status.value()))
                    .andExpect(status().is(status.value()));
            log.debug("{} success tests", status.value());
        }
    }

    @Test
    @DisplayName("Test incorrect argument")
    void testIncorrectStatus() throws Exception {
        mockMvc.perform(get("/6000"));
    }

    @Test
    @DisplayName("Test delay")
    void testDelay() throws Exception {
        mockMvc.perform(get("/200?delay=1"))
                .andExpect(status().isOk());
    }

}
