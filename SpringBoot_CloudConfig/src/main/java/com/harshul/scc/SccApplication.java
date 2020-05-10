package com.harshul.scc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@Slf4j
@SpringBootApplication
@EnableConfigServer
public class SccApplication {

    public static void main(String[] args) {
        log.info("Starting Application:::::::");

        SpringApplication.run(SccApplication.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                log.info("@@@@@@@@@@@@@@@@@@@@@@@@@ APP IS SHUTTING DOWN @@@@@@@@@@@@@@@@@@@@@@@@@");
            }
        });
    }

}
