package com.lite.function.profiling.actuator;

import java.util.Comparator;
import java.util.HashMap;

import com.lite.function.profiling.ExecutingProfilingMethodActuator;
import com.lite.function.profiling.dto.ActuatorProfilingEndpointDTO;
import com.lite.function.profiling.dto.ExecutingProfilingMethodVal;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;


@Endpoint(id = "actuatorProfiling")
@AllArgsConstructor
public class ActuatorProfilingEndpoint {
    private final ExecutingProfilingMethodActuator executingProfilingMethodActuator;

    @ReadOperation
    public ActuatorProfilingEndpointDTO actuatorProfiling() {
        ActuatorProfilingEndpointDTO profilingEndpointDTO = new ActuatorProfilingEndpointDTO();
        var bufVal = new HashMap<String, Long>();
        executingProfilingMethodActuator.getExecutingProfilingMethodValues().forEach((s, executingProfilingMethodVals) -> {
            bufVal.put(s, executingProfilingMethodVals.stream()
                    .max(Comparator.comparing(ExecutingProfilingMethodVal::getLocalDateTime))
                    .map(ExecutingProfilingMethodVal::getDelta)
                    .orElse(0L));
        });
        profilingEndpointDTO.setExecutingProfilingMethod(bufVal);
        return profilingEndpointDTO;
    }
}
