package com.company.aspect.controller;

import com.company.controller.CompanyRestController;
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
public class CompanyControllerLoggingAspect 
{

    public static final Logger LOG = Logger.getLogger(CompanyRestController.class.getName());
    
    @Around("execution(* com.company.controller.CompanyRestController.getCompanies())")
    public Object logAroundGetCompanies (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CompanyRestController.getCompanyById())")
    public Object logAroundGetCompanyById (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CompanyRestController.getCompanyByName())")
    public Object logAroundGetCompanyByName (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CompanyRestController.addCompany())")
    public Object logAroundAddCompany (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CompanyRestController.updateCompany())")
    public Object logAroundUpdateCompany (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
    
    @Around("execution(* com.company.controller.CompanyRestController.deleteCompany())")
    public Object logAroundDeleteCompany (ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOG.log(Level.SEVERE, "{0} is running!", joinPoint.getSignature().getName());
        LOG.log(Level.SEVERE, "Arguments : {0}", Arrays.asList(joinPoint.getArgs()));
        
        ResponseEntity<ResponseDTO> object = (ResponseEntity<ResponseDTO>) joinPoint.proceed();
        
        LOG.log(Level.SEVERE, "Returned value is {0}", object.getBody());
        
        return object;
    }
}
