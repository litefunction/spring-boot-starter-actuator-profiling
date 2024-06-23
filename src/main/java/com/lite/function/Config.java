package com.lite.function;

import com.lite.function.profiling.ExecutingProfilingMethodActuator;
import com.lite.function.profiling.ProfilingActuatorProperties;
import com.lite.function.profiling.ProfilingAspect;
import com.lite.function.profiling.actuator.ActuatorProfilingEndpoint;
import com.lite.function.profiling.actuator.ActuatorProfilingDetailEndpoint;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties()
public class Config {

    @Bean
    public ProfilingActuatorProperties ProfilingActuatorPropertiesBean() {
        return new ProfilingActuatorProperties();
    }

    @Bean
    public ExecutingProfilingMethodActuator ExecutingProfilingMethodBean(ProfilingActuatorProperties properties) {
        return new ExecutingProfilingMethodActuator(properties);
    }

    @Bean
    public ProfilingAspect ProfilingAspectBean(ExecutingProfilingMethodActuator executingProfilingMethodActuator) {
        return new ProfilingAspect(executingProfilingMethodActuator);
    }

    @Bean
    public ActuatorProfilingEndpoint ActuatorProfilingEndpointBean(ExecutingProfilingMethodActuator executingProfilingMethodActuator) {
        return new ActuatorProfilingEndpoint(executingProfilingMethodActuator);
    }

    @Bean
    public ActuatorProfilingDetailEndpoint ActuatorProfilingEndpointDetailBean(ExecutingProfilingMethodActuator executingProfilingMethodActuator) {
        return new ActuatorProfilingDetailEndpoint(executingProfilingMethodActuator);
    }
}
