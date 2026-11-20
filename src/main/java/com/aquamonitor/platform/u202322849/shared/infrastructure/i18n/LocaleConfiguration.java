package com.aquamonitor.platform.u202322849.shared.infrastructure.i18n;

import java.util.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * Selects English by default and Spanish when requested.
 * @author Marlon Packard Viza Quispe
 */
@Configuration
public class LocaleConfiguration {
    @Bean
    LocaleResolver localeResolver() {
        var resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        resolver.setSupportedLocales(List.of(Locale.ENGLISH, Locale.forLanguageTag("es")));
        return resolver;
    }
}
