package com.jiangying;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jiangying.mapper")
@SpringBootApplication
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class,args);
    }
}
