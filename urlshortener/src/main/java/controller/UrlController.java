package com.urlshortener.urlshortener.controller;

import com.urlshortener.urlshortener.dto.ShortenUrlRequest;
import com.urlshortener.urlshortener.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    // Create short URL
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(
            @Valid @RequestBody ShortenUrlRequest request,
            HttpServletRequest httpRequest
    )
    {
        String shortCode = service.shortenUrl(request.getUrl());

        String baseUrl = httpRequest.getRequestURL()
                .toString()
                .replace(httpRequest.getRequestURI(), "");

        String shortUrl = baseUrl + "/" + shortCode;

        return ResponseEntity.ok(shortUrl);
    }

    // Redirect to original URL
    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        String originalUrl = service.getOriginalUrl(code);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
