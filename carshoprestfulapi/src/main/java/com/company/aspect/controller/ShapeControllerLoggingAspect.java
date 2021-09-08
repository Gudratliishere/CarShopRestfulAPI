package com.company.aspect.controller;

import com.company.controller.ShapeRestController;
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
public class ShapeControllerLoggingAspect 
{
    public static final Logger LOG = Logger.getLogger(ShapeRestController.class.getName());
    
    @Around("execution(* com.company.controller.ShapeRestController.getShapes())")
    public Object logAroundGetShapes (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ShapeRestController.getShapeById())")
    public Object logAroundGetShapeById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ShapeRestController.getShapeByForm())")
    public Object logAroundGetShapeByForm (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ShapeRestController.addShape())")
    public Object logAroundAddShape (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ShapeRestController.updateShape())")
    public Object logAroundUpdateShape (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.ShapeRestController.deleteShape())")
    public Object logAroundDeleteShape (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
}
