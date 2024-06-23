package com.lite.function.profiling.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ActuatorProfilingEndpointDTO {
    @JsonProperty("executingProfilingMethod")
    private Map<String, Long> executingProfilingMethod = new HashMap<>();

    @JsonProperty("executingProfilingMethod")
    public void setExecutingProfilingMethod(final Map<String, Long> executingProfilingMethod) {
        this.executingProfilingMethod = executingProfilingMethod;
    }

}
