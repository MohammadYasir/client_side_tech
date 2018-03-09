package com.forkbrainz.service.question;

import com.forkbrainz.service.data.McqData;
import com.forkbrainz.service.data.ugcnet.NetQuestion;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class QuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
    }
    
    @Bean
    public Nitrite database(){
        return Nitrite.builder()
            .filePath("app.db")
            .openOrCreate("yasir", "password");
    }
    
    @Bean(name = "CsRepository")
    public ObjectRepository<NetQuestion> ugcNetCollection(){
        return database().getRepository(NetQuestion.class);
    }
    
    @Bean(name = "McqDataRepository")
    public ObjectRepository<McqData> mcqCollection(){
        return database().getRepository(McqData.class);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
