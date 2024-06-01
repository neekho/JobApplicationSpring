package com.nikho.springbootrest.api.repo;

import com.nikho.springbootrest.api.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer>{

    List<Job> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


}
