package com.company.aspect.controller;

import com.company.controller.ModelRestController;
import com.company.dto.ResponseDTO;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Dunay Gudratli
 */
@Aspect
public class ModelControllerLoggingAspect 
{
    
    public static final Logger LOG = Logger.getLogger(ModelRestController.class.getName());
    
    @Around("execution(* com.company.controller.ModelRestController.getModels())")
    public Object logAroundGetModels (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ModelRestController.getModelById())")
    public Object logAroundGetModelById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ModelRestController.getModelByName())")
    public Object logAroundGetModelByName (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ModelRestController.addModel())")
    public Object logAroundAddModel (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ModelRestController.updateModel())")
    public Object logAroundUpdateModel (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ModelRestController.deleteModel())")
    public Object logAroundDeleteModel (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
}
