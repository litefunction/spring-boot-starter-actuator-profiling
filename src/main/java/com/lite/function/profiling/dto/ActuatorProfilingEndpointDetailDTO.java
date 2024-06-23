package com.lite.function.profiling.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class ActuatorProfilingEndpointDetailDTO {
    private String name;
    private List<ExecutingProfilingMethodVal> executingProfilingMethodVals;
}
