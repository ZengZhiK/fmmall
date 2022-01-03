package com.zzk.fmmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zzk
 * @create 2021-12-17 11:14
 */
@SpringBootApplication
@MapperScan("com.zzk.fmmall.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // System.out.println("http://localhost:8080/swagger-ui.html");
        System.out.println("http://localhost:8080/doc.html");
    }
}
