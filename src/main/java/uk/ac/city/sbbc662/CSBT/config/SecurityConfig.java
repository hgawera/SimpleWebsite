package uk.ac.city.sbbc662.CSBT.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, 'TRUE' as enabled FROM USER WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, 'ROLE_USER' as authority FROM USER WHERE email=?")
                .passwordEncoder(new BCryptPasswordEncoder());


    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/", "/register", "/about")
                .permitAll()
                .antMatchers("/users", "/profile")
                .authenticated()
                .and()
                .formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}