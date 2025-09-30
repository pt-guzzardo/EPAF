package com.example.pi.locator;

import java.util.HashMap;
import java.util.Map;

/**
 * The Service Locator pattern implementation for managing and providing
 * access to application-wide services, abstracting the dependency lookup process.
 */
public class ServiceLocator {
    private static final Map<Class<?>, Object> services = new HashMap<>();

    public static <T> void registerService(Class<T> clazz, T service) {
        services.put(clazz, service);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<T> clazz) {
        return (T) services.get(clazz);
    }
}
