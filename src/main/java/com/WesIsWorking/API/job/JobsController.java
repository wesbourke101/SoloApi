package com.WesIsWorking.API.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    private static List<Jobs> jobsList = new ArrayList<>();

    static {
        jobsList.add(new Jobs("Bourke", "Fix Your Bike", " sadkflasdfklj asdfj kadslf jaklsdflkasdjflsafj", 12.02, 1));
        jobsList.add(new Jobs("Tom", "Build a House", "asdfdasf asdjfkasdjjadfa", 12.02, 1));
        jobsList.add(new Jobs("YesPlease", "Bring people together", "asdfdasf", 12.02, 1));
    }

    @GetMapping("/") //this is literally just a forward slash
    public List<Jobs> getAllJobs() {
        return jobsList;
    }

    @GetMapping("/{id}")
    public Jobs getJobById(@PathVariable String id) {
        return jobsList.stream()
                .filter(job -> job.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/")
    public Jobs createJob(@RequestBody Jobs job) {
        jobsList.add(job);
        return job;
    }

    @PutMapping("/{id}")
    public Jobs updateJob(@PathVariable String id, @RequestBody Jobs job) {
        Jobs existingJob = jobsList.stream()
                .filter(j -> j.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (existingJob != null) {
            existingJob.setUserName(job.getUserName());
            existingJob.setJobName(job.getJobName());
            existingJob.setDescription(job.getDescription());
            existingJob.setCost(job.getCost());
            existingJob.setLikes(job.getLikes());
        }
        return existingJob;
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable String id) {
        boolean removed = jobsList.removeIf(job -> job.getId().equals(id));
        return removed ? "Job with ID " + id + " deleted." : "Job with ID " + id + " not found.";
    }
}
