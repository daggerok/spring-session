package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring session demo
 *
 * @author mak
 */
@SpringBootApplication
public class SpringSessionApplication {
    /**
     * Run and go to http://localhost:8080/session/get
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }
}
