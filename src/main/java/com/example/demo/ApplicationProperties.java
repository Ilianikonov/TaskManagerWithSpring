package com.example.demo;

import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ApplicationProperties {

    //@Value("${application.manager.type}")
    private String managerType;
    //@Value("${application.manager.logging.enable}")
    private boolean managerLoggingEnable;

//    public ApplicationProperties() {
//        System.out.println(this);
//    }

        public ApplicationProperties(@Value("${application.manager.type}") String managerType, @Value("${application.manager.logging.enable}") boolean managerLoggingEnable) {
        this.managerType = managerType;
        this.managerLoggingEnable = managerLoggingEnable;
    }
    @PostConstruct
    public void init(){
        log.info(toString());
    }

    public String getManagerType() {
        return managerType;
    }

    public boolean getManagerLoggingEnable() {
        return managerLoggingEnable;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{\n" +
                "managerType='" + managerType + "'\n" +
                ", managerLoggingEnable='" + managerLoggingEnable + "'\n" +
                '}';
    }
}
