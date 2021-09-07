package com.company.repository;

import com.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dunay Gudratli
 */
public interface CompanyRepository extends JpaRepository<Company, Integer>
{
    Company findByName (String name);
}
