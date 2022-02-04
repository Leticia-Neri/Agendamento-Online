
package com.example.demo.security;

import org.hibernate.validator.cfg.defs.RangeDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests((requests) -> {
//            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
//        });
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/salvarPaciente", "/api/deletar/{id}", "/api/atualizar/{id}").hasRole("ADMIN")
                .antMatchers("/enderecos/salvarEndereco", "/enderecos/deletar/{id}", "/enderecos/atualizar/{id}").hasRole("ADMIN")
                .antMatchers("/agendamentos/salvarAgendamento", "/agendamentos/deletar/{id}", "/agendamentos/atualizar/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

       auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

//        auth
//                .inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("user").password(encoder.encode("user")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
    }

}






