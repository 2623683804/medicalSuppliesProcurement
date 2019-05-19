package com.kaiyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.kaiyuan.dao")
public class MedicalsuppliesprocurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalsuppliesprocurementApplication.class, args);
    }

}

