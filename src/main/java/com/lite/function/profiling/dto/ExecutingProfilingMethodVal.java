package com.lite.function.profiling.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class ExecutingProfilingMethodVal {
    Long delta;
    LocalDateTime localDateTime;
}
