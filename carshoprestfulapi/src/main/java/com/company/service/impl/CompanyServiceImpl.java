package com.company.service.impl;

import com.company.entity.Company;
import com.company.repository.CompanyRepository;
import com.company.service.inter.CompanyServiceInter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dunay Gudratli
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyServiceInter
{
    
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll()
    {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Integer id)
    {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company saveCompany(Company company)
    {
        return companyRepository.save(company);
    }

    @Override
    public void removeCompany(Company company)
    {
        companyRepository.delete(company);
    }

    @Override
    public Company getByName(String name)
    {
        return companyRepository.findByName(name);
    }

}
