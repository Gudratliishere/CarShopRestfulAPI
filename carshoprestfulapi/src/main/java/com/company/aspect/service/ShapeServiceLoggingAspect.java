package com.company.aspect.service;

import com.company.dto.ResponseDTO;
import com.company.service.impl.ShapeServiceImpl;
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
public class ShapeServiceLoggingAspect 
{
    public static final Logger LOG = Logger.getLogger(ShapeServiceImpl.class.getName());
    
    @Around("execution(* com.company.service.impl.ShapeServiceImpl.getAll())")
    public Object logAroundGetAll (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ShapeServiceImpl.getById())")
    public Object logAroundGetById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ShapeServiceImpl.getByForm())")
    public Object logAroundGetByForm (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ShapeServiceImpl.saveShape())")
    public Object logAroundSaveShape (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.ShapeServiceImpl.removeShape())")
    public Object logAroundRemoveShape (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
}
