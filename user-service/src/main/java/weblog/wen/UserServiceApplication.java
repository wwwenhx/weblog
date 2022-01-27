package weblog.wen;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

/**
 * @author wenhx
 * @Date 2022/1/25 14:29
 * @Description
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "weblog.wen.clients", defaultConfiguration = FeignClientsConfiguration.class)
@MapperScan("weblog.wen.mapper")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
