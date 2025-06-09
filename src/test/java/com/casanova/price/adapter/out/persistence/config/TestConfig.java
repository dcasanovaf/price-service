package com.casanova.price.adapter.out.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

/**
 * The type Test config.
 */
@ComponentScan("com.casanova.price.adapter.out.persistence")
@ActiveProfiles("test")
public class TestConfig {}
