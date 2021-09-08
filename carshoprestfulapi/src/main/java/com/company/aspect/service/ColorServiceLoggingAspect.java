package com.company.aspect.service;

import com.company.dto.ResponseDTO;
import com.company.service.impl.ColorServiceImpl;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dunay Gudratli
 */
@Aspect
@Component
public class ColorServiceLoggingAspect 
{
    public static final Logger LOG = Logger.getLogger(ColorServiceImpl.class.getName());
    
    @Around("execution(* com.company.service.impl.ColorServiceImpl.getAll())")
    public Object logAroundGetAll (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ColorServiceImpl.getById())")
    public Object logAroundGetById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ColorServiceImpl.getByName())")
    public Object logAroundGetByName (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ColorServiceImpl.saveColor())")
    public Object logAroundSaveColor (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ColorServiceImpl.removeColor())")
    public Object logAroundRemoveColor (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
}
