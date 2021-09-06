package com.company.service.inter;

import com.company.entity.Company;
import java.util.List;

/**
 *
 * @author Dunay Gudratli
 */
public interface CompanyServiceInter
{
    List<Company> getAll ();
    
    Company getById (Integer id);
    
    Company saveCompany (Company company);
    
    void removeCompany (Company company);
}
