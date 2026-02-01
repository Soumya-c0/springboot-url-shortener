package com.urlshortener.urlshortener.service;

import com.urlshortener.urlshortener.exception.UrlNotFoundException;
import com.urlshortener.urlshortener.model.UrlMapping;
import com.urlshortener.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    // Generate and store short URL
    public String shortenUrl(String originalUrl) {
        String shortCode = UUID.randomUUID()
                .toString()
                .substring(0, 6);

        UrlMapping mapping = new UrlMapping();
        mapping.setShortCode(shortCode);
        mapping.setOriginalUrl(originalUrl);
        mapping.setCreatedAt(LocalDateTime.now());

        repository.save(mapping);

        return shortCode;
    }

    // Fetch original URL for redirect
    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .orElseThrow(() ->
                        new UrlNotFoundException("Short URL not found: " + shortCode)
                )
                .getOriginalUrl();
    }
}
