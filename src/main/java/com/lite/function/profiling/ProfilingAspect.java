package com.lite.function.profiling;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class ProfilingAspect {
    private final ExecutingProfilingMethodActuator executingProfilingMethodActuator;

    @Around("@annotation(com.lite.function.profiling.ActuatorProfiling)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        ActuatorProfiling myAnnotation = (ActuatorProfiling)method.getAnnotation(ActuatorProfiling.class);
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        this.executingProfilingMethodActuator.addVal(myAnnotation.name(), executionTime);
        return proceed;
    }

    public ProfilingAspect(final ExecutingProfilingMethodActuator executingProfilingMethodActuator) {
        this.executingProfilingMethodActuator = executingProfilingMethodActuator;
    }
}
