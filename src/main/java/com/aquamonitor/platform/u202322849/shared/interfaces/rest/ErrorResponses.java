package com.aquamonitor.platform.u202322849.shared.interfaces.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Resolves a message in the language negotiated for the request.
 * @author Marlon Packard Viza Quispe
 */
@Component
public class ErrorResponses {
    private final MessageSource messages;

    public ErrorResponses(MessageSource messages) { this.messages = messages; }

    public ResponseEntity<MessageResource> response(int status, String key) {
        return ResponseEntity.status(status).body(new MessageResource(
                messages.getMessage(key, null, LocaleContextHolder.getLocale())));
    }
}
