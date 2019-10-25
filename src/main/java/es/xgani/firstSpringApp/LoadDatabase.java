package es.xgani.firstSpringApp;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
@Slf4j
public class LoadDatabase {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Xavier Gallofré Nieva", SIMPLE_DATE_FORMAT.parse("03/04/1988"))));
        };
    }
}
