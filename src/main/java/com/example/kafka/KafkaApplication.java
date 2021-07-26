package com.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication
@Slf4j
public class KafkaApplication {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext application = SpringApplication.run(KafkaApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("spring.port");
        String path = env.getProperty("spring.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Kafka is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + ip + ":" + port + path + "doc.html\n" +
                "----------------------------------------------------------");
    }

}
