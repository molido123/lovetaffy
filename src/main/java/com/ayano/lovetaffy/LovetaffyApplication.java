package com.ayano.lovetaffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.sql.Timestamp;

/**
 * @author huagenda
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LovetaffyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LovetaffyApplication.class, args);
    }

}
