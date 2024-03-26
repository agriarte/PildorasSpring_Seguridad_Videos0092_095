package com.tallerdeapps.seguridad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder usuarios = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(usuarios.username("Pedro").password("123").roles("administrador"))
                .withUser(usuarios.username("Juan").password("123").roles("usuario"))
                .withUser(usuarios.username("Ivan").password("000").roles("defensa"))
                .withUser(usuarios.username("Maria").password("123").roles("moderador"));
    }

}
