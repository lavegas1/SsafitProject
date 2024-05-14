package com.ssafit.shopping.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.ssafit.review.model.dao")
@Configuration
public class MybatisConfig {

}
