package com.company.aspect.controller;

import com.company.controller.ColorRestController;
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
public class ColorControllerLoggingAspect 
{
    
    public static final Logger LOG = Logger.getLogger(ColorRestController.class.getName());
    
    @Around("execution(* com.company.controller.ColorRestController.getColors())")
    public Object logAroundGetColors (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ColorRestController.getColorById())")
    public Object logAroundGetColorById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ColorRestController.getColorByName())")
    public Object logAroundGetColorByName (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ColorRestController.addColor())")
    public Object logAroundAddColor (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ColorRestController.updateColor())")
    public Object logAroundUpdateColor (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ColorRestController.deleteColor())")
    public Object logAroundDeleteColor (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
}
