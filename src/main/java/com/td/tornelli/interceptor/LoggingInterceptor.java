package com.td.tornelli.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.nio.charset.StandardCharsets;


@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        if (!(request instanceof ContentCachingRequestWrapper)) {
            log.warn("Request non wrappata correttamente. Il body non sarà leggibile.");
        }

        log.info("[REQUEST] {} {}", request.getMethod(), request.getRequestURI());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {

        if (request instanceof ContentCachingRequestWrapper reqWrapper) {
            String body = new String(reqWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
            if (!body.isBlank()) {
                log.info("[REQUEST BODY] {}", body);
            }
        }

        if (response instanceof ContentCachingResponseWrapper resWrapper) {
            String body = new String(resWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
            log.info("[RESPONSE BODY] {}", body);

            try {
                resWrapper.copyBodyToResponse(); // obbligatorio per non rompere la risposta
            } catch (Exception e) {
                log.error("Errore durante copyBodyToResponse", e);
            }
        }

        log.info("[RESPONSE] {} {} - status: {}", request.getMethod(), request.getRequestURI(), response.getStatus());
    }
}