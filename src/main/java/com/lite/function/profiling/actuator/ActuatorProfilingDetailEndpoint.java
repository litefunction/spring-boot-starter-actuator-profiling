package com.lite.function.profiling.actuator;

import java.util.*;
import java.util.stream.Collectors;

import com.lite.function.profiling.ExecutingProfilingMethodActuator;
import com.lite.function.profiling.dto.ActuatorProfilingEndpointDetailDTO;
import com.lite.function.profiling.dto.ExecutingProfilingMethodVal;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;

@Endpoint(
        id = "actuatorProfilingDetail"
)
@AllArgsConstructor
public class ActuatorProfilingDetailEndpoint {
    private final ExecutingProfilingMethodActuator executingProfilingMethodActuator;

    @ReadOperation
    public ActuatorProfilingEndpointDetailDTO actuatorProfilingDetail(@Selector String name) {
        return ActuatorProfilingEndpointDetailDTO.builder().name(name).executingProfilingMethodVals(
                        Optional.ofNullable(executingProfilingMethodActuator.getExecutingProfilingMethodValues().get(name)).orElse(new ArrayList<>()).stream()
                        .sorted(Comparator.comparing(ExecutingProfilingMethodVal::getLocalDateTime))
                        .collect(Collectors.toList()))
                .build();
    }
}
