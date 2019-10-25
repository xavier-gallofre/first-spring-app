package es.xgani.firstSpringApp;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.repository.UserRepository;
import es.xgani.firstSpringApp.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Xavier Gallofré Nieva", DateUtils.parse("03/04/1988"))));
        };
    }
}
