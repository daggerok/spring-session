package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession
public class SpringSessionConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {

        // check 'x-auth-token' header in the response
        // now session in the browser will be recreated each refresh, because it's not in cookie anymore
        return new HeaderHttpSessionStrategy();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // curl -v http://user:pwd@localhost:8080
        // ...
        // < x-auth-token: c211edfd-b499-469c-8b54-f3b199d10bce
        // ...
        // curl -v -H 'x-auth-token: c211edfd-b499-469c-8b54-f3b199d10bce' http://localhost:8080
        // or by httpie:
        // http :8080 x-auth-token:c211edfd-b499-469c-8b54-f3b199d10bce
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
    }
}
