package com.ssafit.shopping.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.ssafit.shopping.model.dao")
@Configuration
public class MybatisConfig {

}
