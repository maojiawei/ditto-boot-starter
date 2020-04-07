package io.jovi.ditto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("io.jovi.ditto.repository")
public class GatewayApplication {
    /**
     * 程序主入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
