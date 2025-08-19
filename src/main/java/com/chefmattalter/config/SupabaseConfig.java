package com.chefmattalter.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SupabaseConfig {
    private final Dotenv dotenv = Dotenv.load();

    @Bean
    public DataSource dataSource() {
        String url = dotenv.get("SUPABASE_URL");
        String username = dotenv.get("SUPABASE_USERNAME");
        String password = dotenv.get("SUPABASE_PASSWORD");

        if (url == null || username == null || password == null) {
            throw new IllegalArgumentException("Missing required environment variables for database connection.");
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
