package com.nikho.springbootrest.api.service;

import com.nikho.springbootrest.api.model.Job;
import com.nikho.springbootrest.api.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<Job> returnAllJobPosts() {
        System.out.println("repo called");
        return repo.findAll();
    }




    public void addJobPost(Job jobPost) {
        repo.save(jobPost);

    }


    public Job getJob(int postId) {

        return repo.findById(postId).orElse(new Job());
    }


    public Job updateJobPost(Job jobPost) {

        return repo.save(jobPost);
    }

    public void deleteJobPost(int id) {

        repo.deleteById(id);
    }

    public void load() {

        List<Job> jobs =
                new ArrayList<>(List.of(
                        new Job(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new Job(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new Job(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new Job(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new Job(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));


        repo.saveAll(jobs);
    }

    public List<Job> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
