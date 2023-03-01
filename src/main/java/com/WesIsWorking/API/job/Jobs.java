package com.WesIsWorking.API.job;

import jakarta.persistence.Id;
import java.util.UUID;

public class Jobs {

    @Id
    private String id;
    private String userName;
    private String jobName;
    private String description;
    private Double cost;
    private int likes;

    //this sets Static ID's without needing to add ids in the constructor
    public Jobs() {
        this.id = UUID.randomUUID().toString();
    }

    public Jobs( String userName, String jobName, String description, Double cost, int likes) {
        this.id = UUID.randomUUID().toString(); // this
        this.userName = userName;
        this.jobName = jobName;
        this.description = description;
        this.cost = cost;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", likes=" + likes +
                '}';
    }
}
