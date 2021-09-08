package com.company.dto;

import com.company.entity.Company;
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
public class CompanyDTO
{

    private Integer id;
    private String name;

    public static CompanyDTO of(Company company)
    {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());

        return companyDTO;
    }

    @Override
    public String toString()
    {
        return "CompanyDTO{" + "id=" + id + ", name=" + name + '}';
    }
}
