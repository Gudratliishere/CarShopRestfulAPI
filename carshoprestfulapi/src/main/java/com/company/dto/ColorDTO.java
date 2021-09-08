package com.company.dto;

import com.company.entity.Color;
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
public class ColorDTO
{

    private Integer id;
    private String name;
    
    public static ColorDTO of (Color color)
    {
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setId(color.getId());
        colorDTO.setName(color.getName());
        
        return colorDTO;
    }

    @Override
    public String toString()
    {
        return "ColorDTO{" + "id=" + id + ", name=" + name + '}';
    }
}
