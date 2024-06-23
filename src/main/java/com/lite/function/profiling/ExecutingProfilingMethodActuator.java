package com.lite.function.profiling;

import com.lite.function.profiling.dto.ExecutingProfilingMethodVal;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@AllArgsConstructor
public class ExecutingProfilingMethodActuator {

    private final ProfilingActuatorProperties profilingActuatorProperties;
    private final Map<String, List<ExecutingProfilingMethodVal>> executingProfilingMethodValues = new ConcurrentHashMap<>();

    public void addVal(String name, long val) {
        if (profilingActuatorProperties.getEnabler()) {
            synchronized (executingProfilingMethodValues) {
                var executingProfilingMethodVals = executingProfilingMethodValues.computeIfAbsent(name, k -> new ArrayList<>());
                if (executingProfilingMethodVals.size() >= this.profilingActuatorProperties.getMaxCountList()) {
                    executingProfilingMethodVals.remove(0);
                }

                executingProfilingMethodVals.add(ExecutingProfilingMethodVal.builder()
                        .delta(val)
                        .localDateTime(LocalDateTime.now())
                        .build());
            }
        }
    }

}
