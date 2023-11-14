package app;

import app.components.SingletonComponent;
import app.components.TransientComponent;
import app.components.ClientComponent;
import app.models.*;
import app.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpLabApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpLabApplication.class, args);
    }

}
