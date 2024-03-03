package com.embarkx.firstjobproject.job.impl;

import com.embarkx.firstjobproject.job.Job;
import com.embarkx.firstjobproject.job.JobRespository;
import com.embarkx.firstjobproject.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

//tell that it is service
//on marking this as service spring boot mke availabe on run time and it will injected to the controller by building the constructor on controller
@Service
public class JobServiceImp implements JobService {
//    private List<Job> jobs = new ArrayList<>();
//    define a jobrepository object
    JobRespository jobRespository;

    public JobServiceImp(JobRespository jobRespository) {
        this.jobRespository = jobRespository;
    }

    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobRespository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRespository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRespository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRespository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRespository.findById(id);
        if (jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRespository.save(job);

            return true;
        }

        return false;

    }
}
