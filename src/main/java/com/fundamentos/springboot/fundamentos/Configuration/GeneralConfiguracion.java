package com.fundamentos.springboot.fundamentos.Configuration;

import com.fundamentos.springboot.fundamentos.been.MyBeanWhitPropirtiesImplement;
import com.fundamentos.springboot.fundamentos.been.MyBeanWhitPrperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguracion {

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWhitPrperties funcion(){
        return  new MyBeanWhitPropirtiesImplement(name,apellido);
    }
}
