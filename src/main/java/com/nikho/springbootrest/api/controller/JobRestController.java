package com.nikho.springbootrest.api.controller;

import com.nikho.springbootrest.api.model.Job;
import com.nikho.springbootrest.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class JobRestController {


    @Autowired
    private JobService service;


    @GetMapping(path="jobs", produces = {"application/json", "application/xml"})
    @ResponseBody
    public List<Job> allJobs() {

        List<Job> jobPosts = service.returnAllJobPosts();

        System.out.println(jobPosts);


        return jobPosts;
    }


    @GetMapping("job/{jobID}")
    public Job getJobByID(@PathVariable("jobID") int jobID) {
        return service.getJob(jobID);
    }

    @PostMapping(path = "jobPost", consumes = {"application/json"})
    public Job addJobPost(@RequestBody Job jobPost) {
        service.addJobPost(jobPost);

        return service.getJob(jobPost.getPostId());
    }


    @PutMapping("job/{jobID}")
    public Job updateJobPost(@RequestBody Job jobPost, @PathVariable("jobID") int jobID) {
        service.updateJobPost(jobPost);

        return service.getJob(jobID);
    }

    @DeleteMapping("job/{jobID}")
    public String deleteJobPost(@PathVariable("jobID") int jobID) {

        service.deleteJobPost(jobID);

        return "Job Post Deleted with Job ID: " + jobID;
    }


    @GetMapping("search/{keyword}")
    public List<Job> searchJobPost(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }



}
