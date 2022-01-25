package weblog.wen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

/**
 * @author wenhx
 * @Date 2022/1/25 15:00
 * @Description
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "feign.api.clients", defaultConfiguration = FeignClientsConfiguration.class)
public class LogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogServiceApplication.class, args);
    }
}
