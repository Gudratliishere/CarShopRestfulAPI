package com.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Dunay Gudratli
 */
@Getter 
@Setter
@NoArgsConstructor
public class ResponseDTO
{
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object object;
    
    public static ResponseDTO of (Object object)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        
        return responseDTO;
    }
    
    public static ResponseDTO of (Object object, String succesMessage)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setSuccessMessage(succesMessage);
        
        return responseDTO;
    }
    
    public static ResponseDTO of (Object object, String errorMessage, Integer errorCode)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setErrorMessage(errorMessage);
        responseDTO.setErrorCode(errorCode);
        
        return responseDTO;
    }
}