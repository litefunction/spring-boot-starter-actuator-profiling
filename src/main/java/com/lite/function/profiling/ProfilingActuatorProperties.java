package com.lite.function.profiling;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "profiling.actuator")
@Component
public class ProfilingActuatorProperties {
    private Integer maxCountList = 100;
    private Boolean enabler = true;
}
