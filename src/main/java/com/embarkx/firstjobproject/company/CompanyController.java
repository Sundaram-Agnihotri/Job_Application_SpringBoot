package com.embarkx.firstjobproject.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//handle the rest queries
@RestController
//define the mapping for the controller
@RequestMapping ("/companies")
public class CompanyController {
    //companycontroller works with companyservice
    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        companyService.updateCompany(company ,id);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company addded !",HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("Company Successfully Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
