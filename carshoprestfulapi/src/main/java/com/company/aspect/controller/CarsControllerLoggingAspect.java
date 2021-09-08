package com.company.aspect.controller;

import com.company.controller.CarsRestController;
import com.company.dto.ResponseDTO;
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
public class CarsControllerLoggingAspect 
{
    
    public static final Logger LOG = Logger.getLogger(CarsRestController.class.getName());
    
    @Around("execution(* com.company.controller.CarsRestController.getCars())")
    public Object logAroundGetCars (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CarsRestController.getCarByNumber())")
    public Object logAroundGetCarByNumber (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CarsRestController.getCarById())")
    public Object logAroundGetCarById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CarsRestController.addCars())")
    public Object logAroundAddCars (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CarsRestController.updateCars())")
    public Object logAroundUpdateCars (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CarsRestController.deleteCars())")
    public Object logAroundDeleteCars (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
}
