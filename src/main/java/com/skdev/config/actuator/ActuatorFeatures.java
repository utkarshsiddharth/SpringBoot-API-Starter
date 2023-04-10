package com.skdev.config.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class ActuatorFeatures {
    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public ActuatorFeatures() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(true));
        featureMap.put("Authentication", new Feature(true));
        featureMap.put("Socket.IO", new Feature(false));
        featureMap.put("Logger", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){
        return featureMap.get(featureName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
