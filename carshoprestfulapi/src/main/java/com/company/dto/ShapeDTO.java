package com.company.dto;

import com.company.entity.Shape;
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
public class ShapeDTO
{

    private Integer id;
    private String form;
    
    public static ShapeDTO of (Shape shape)
    {
        ShapeDTO shapeDTO = new ShapeDTO();
        shapeDTO.setId(shape.getId());
        shapeDTO.setForm(shape.getForm());
        
        return shapeDTO;
    }
}
