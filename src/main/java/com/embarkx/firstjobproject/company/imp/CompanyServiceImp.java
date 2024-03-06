package com.embarkx.firstjobproject.company.imp;

import com.embarkx.firstjobproject.company.Company;
import com.embarkx.firstjobproject.company.CompanyRepository;
import com.embarkx.firstjobproject.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService {
    //we need to return all company from database
    private CompanyRepository companyRepository;
    //initialise it with constructor

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companytoUpdate = companyOptional.get();
            companytoUpdate.setDescription(company.getDescription());
            companytoUpdate.setName(company.getName());
            companytoUpdate.setJobs(company.getJobs());
            companyRepository.save(companytoUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
          companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long Id) {
        if(companyRepository.existsById(Id)) {
            companyRepository.deleteById(Id);
            return true;
        }else{
        return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}
