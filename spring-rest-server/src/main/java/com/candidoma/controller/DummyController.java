package com.candidoma.controller;

import com.candidoma.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
@Slf4j
public class DummyController {
    private static int MAX_SLEEP_TIME=20;

    @GetMapping(value = "/dummy/sleep/{seconds}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sleep(@PathVariable("seconds") int seconds) {
        log.info("Sleep for "+seconds+"s");
        int sleep_time=seconds;
        if ( seconds<0 ){
            log.info(seconds+"s is lower than 0s");
            sleep_time=0;
        }else if (seconds > MAX_SLEEP_TIME){
            log.info(seconds+"s is higher than "+MAX_SLEEP_TIME+"s");
            sleep_time=MAX_SLEEP_TIME;
        }
        try {
            Thread.sleep(sleep_time*1000);
        } catch (InterruptedException e) {
            log.info("Sleep interrupted by "+e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
