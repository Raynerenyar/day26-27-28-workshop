package sg.edu.nus.iss.workshop27.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import static sg.edu.nus.iss.workshop27.Constants.*;

@Configuration
public class MongoDBConfig {

    // Inject the mongo connection string
    @Value("${mongo.url}")
    private String mongoUrl;

    // create and initialise mongotemplate
    @Bean
    public MongoTemplate createTemplate() {

        // Create a MongoClient with the mongo connection string
        MongoClient client = MongoClients.create(mongoUrl);

        return new MongoTemplate(client, MONGO_DATABASE_NAME);
    }
}
