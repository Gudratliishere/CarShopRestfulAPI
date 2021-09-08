package com.company.aspect.service;

import com.company.dto.ResponseDTO;
import com.company.service.impl.CompanyServiceImpl;
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
public class CompanyServiceLoggingAspect 
{
    public static final Logger LOG = Logger.getLogger(CompanyServiceImpl.class.getName());
    
    @Around("execution(* com.company.service.impl.CompanyServiceImpl.getAll())")
    public Object logAroundGetAll (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.CompanyServiceImpl.getById())")
    public Object logAroundGetById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.CompanyServiceImpl.getByName())")
    public Object logAroundGetByName (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.CompanyServiceImpl.saveCompany())")
    public Object logAroundSaveCompany (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
    
    @Around("execution(* com.company.service.impl.CompanyServiceImpl.removeCompany())")
    public Object logAroundRemoveCompany (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        Object object = joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object);
        
        return object;
    }
}
