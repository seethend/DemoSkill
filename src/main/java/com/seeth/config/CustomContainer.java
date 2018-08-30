package com.seeth.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomContainer implements
  WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
 
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.setContextPath("");
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println(System.getenv("PORT"));
//        System.out.println(System.getenv("HOSTNAME"));
//        System.getenv().forEach((k, v) -> {
//            System.out.println(k + ":" + v);
//        });
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        factory.setPort(Integer.valueOf(System.getenv("PORT")));
//        factory.setPort(Integer.valueOf("9000"));
    }
}