package com.zzk.fmmall.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zzk
 * @create 2022-02-23 18:06
 */
@Component
public class PrintRunner implements ApplicationRunner {
    @Value("${server.port}")
    private String port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("http://localhost:" + port + "/swagger-ui.html");
        System.out.println("http://localhost:" + port + "/doc.html");
    }
}
