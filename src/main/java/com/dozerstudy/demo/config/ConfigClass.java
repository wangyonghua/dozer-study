package com.dozerstudy.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:spring-dozer.xml"})
public class ConfigClass {

}