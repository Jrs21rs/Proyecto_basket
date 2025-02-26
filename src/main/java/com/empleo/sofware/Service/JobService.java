package com.empleo.sofware.Service;
import com.empleo.sofware.Entidades.Job;
import com.empleo.sofware.Repositorios.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class JobService {
        @Autowired
        private JobRepository jobRepository;

        public List<Job> getAllJobs() {
            return jobRepository.findAll();
        }

        public Job createJob(Job job) {
            return jobRepository.save(job);
        }
    }

