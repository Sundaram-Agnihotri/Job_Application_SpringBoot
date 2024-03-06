package com.embarkx.firstjobproject.company;

import com.embarkx.firstjobproject.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //mapping the company with jobs
    //as each company have multiple jobs  onetomany annotations -> one comapny has many jobs
    //to remove the recursion in json

    @JsonIgnore
    @OneToMany(mappedBy = "company")   //means the compnay mapped with jobs relation
    private List<Job> jobs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //for jpa
    public Company() {

    }

    public Long getId() {
        return id;
    }
}
