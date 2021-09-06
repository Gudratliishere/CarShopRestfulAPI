package com.company.dto;

import com.company.entity.Model;
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
public class ModelDTO
{

    private Integer id;
    private String name;
    private CompanyDTO company;
    
    public static ModelDTO of (Model model)
    {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setId(model.getId());
        modelDTO.setName(model.getName());
        modelDTO.setCompany(CompanyDTO.of(model.getCompany()));
        
        return modelDTO;
    }
}
