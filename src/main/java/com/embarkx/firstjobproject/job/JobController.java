package com.embarkx.firstjobproject.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
//    end point to return all the jobs
    private List<Job> jobs = new ArrayList<>();

//    mapping
    @GetMapping("/jobs")  //endpoints

    public List<Job> findAll(){
        return jobs;

    }
}
