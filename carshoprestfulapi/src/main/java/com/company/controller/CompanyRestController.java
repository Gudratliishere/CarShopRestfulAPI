package com.company.controller;

import com.company.dto.CompanyDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Company;
import com.company.service.inter.CompanyServiceInter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dunay Gudratli
 */
@RestController
public class CompanyRestController
{

    public static final Logger LOG = Logger.getLogger(CarsRestController.class.getName());

    @Autowired
    private CompanyServiceInter companyService;

    @GetMapping("/company")
    public ResponseEntity<ResponseDTO> getCompanies()
    {
        List<Company> companies = companyService.getAll();
        List<CompanyDTO> companyDTOs = new ArrayList<>();

        companies.forEach((company) -> companyDTOs.add(CompanyDTO.of(company)));

        return ResponseEntity.ok(ResponseDTO.of(companyDTOs, "Successfully got!"));
    }

    @GetMapping("/company/id/{id}")
    public ResponseEntity<ResponseDTO> getCompanyById(
            @PathVariable("id") Integer id
    )
    {
        Company company = companyService.getById(id);

        CompanyDTO companyDTO = (company == null) ? null : CompanyDTO.of(company);

        return ResponseEntity.ok(ResponseDTO.of(companyDTO, "Successfully got!"));
    }

    @GetMapping("/company/name/{name}")
    public ResponseEntity<ResponseDTO> getCompanyByName(
            @PathVariable("name") String name
    )
    {
        Company company = companyService.getByName(name);

        CompanyDTO companyDTO = (company == null) ? null : CompanyDTO.of(company);

        return ResponseEntity.ok(ResponseDTO.of(companyDTO, "Successfully got!"));
    }

    @PostMapping("/company")
    public ResponseEntity<ResponseDTO> addCompany(
            @RequestBody CompanyDTO companyDTO
    )
    {
        Company company;
        try
        {
            if (companyDTO.getName().trim().isEmpty())
                throw new NullPointerException();
            company = companyService.getByName(companyDTO.getName());
            if (company != null)
                return ResponseEntity.ok(ResponseDTO.of(companyDTO, "There is company with this name already!", 409));

            company = new Company();
            company.setName(companyDTO.getName());
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(companyDTO, "Any of properties can not be null!", 409));
        }

        company = companyService.saveCompany(company);

        return ResponseEntity.ok(ResponseDTO.of(CompanyDTO.of(company), "Successfully added!"));
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<ResponseDTO> updateCompany(
            @PathVariable("id") Integer id,
            @RequestBody CompanyDTO companyDTO
    )
    {
        Company company;
        try
        {
            if (companyDTO.getName().trim().isEmpty())
                throw new NullPointerException();
            company = companyService.getById(id);
            if (company == null)
                return ResponseEntity.ok(ResponseDTO.of(company, "Company not found!", 409));

            if (companyService.getByName(companyDTO.getName()) != null
                    && !Objects.equals(companyService.getByName(companyDTO.getName()).getId(), id))
                return ResponseEntity.ok(ResponseDTO.of(companyDTO, "There is company with this name already!", 409));

            company.setName(companyDTO.getName());
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(companyDTO, "Any of properties can not be null!", 409));
        }

        company = companyService.saveCompany(company);

        return ResponseEntity.ok(ResponseDTO.of(CompanyDTO.of(company), "Successfully updated!"));
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<ResponseDTO> deleteCompany(
            @PathVariable("id") Integer id
    )
    {
        Company company = companyService.getById(id);

        companyService.removeCompany(company);

        return ResponseEntity.ok(ResponseDTO.of(CompanyDTO.of(company), "Successfully deleted!"));
    }
}
