package com.example;

//import io.micronaut.core.annotation.NonNull;
//import io.micronaut.context.ApplicationContextBuilder;
//import io.micronaut.context.ApplicationContextConfigurer;
//import io.micronaut.context.annotation.ContextConfigurer;
import io.micronaut.runtime.Micronaut;

import java.util.*;

public class Application {
    /*@ContextConfigurer
    public static class DefaultEnvironmentConfigurer implements ApplicationContextConfigurer {
        @Override
        public void configure(@NonNull ApplicationContextBuilder builder) {
            builder.defaultEnvironments("oraclecloud");
        }
    }*/

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }


    public static void main2(String[] args) {

        System.out.println("ARGS: " + Arrays.asList(args));

        Map<String, Object> instancePrincipal = Map.of("oci", Map.of("config", Map.of("instance-principal", Map.of("enabled", true))));
        Map<String, Object> localConfig = Map.of("oci", Map.of("config", Map.of("profile", "DEFAULT")));
        System.out.println("instancePrincipal: " + instancePrincipal);
        System.out.println("localConfig: " + localConfig);

        //oci:
        //  config:
        //    instance-principal:
        //      enabled: true

        //oci.config.profile: DEFAULT

        Micronaut.build(args)
                .mainClass(Application.class)
                .properties(instancePrincipal)
                .start();
    }
}
