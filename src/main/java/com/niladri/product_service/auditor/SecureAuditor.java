package com.niladri.product_service.auditor;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SecureAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Niladri Sen");
    }
}
