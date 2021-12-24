package Behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class EmploymentAgency {
    private final List<JobSeeker> observers;

    public EmploymentAgency() {
        observers = new ArrayList<>();
    }

    public void attach(JobSeeker seeker) {
        observers.add(seeker);
    }

    public void addJob(JobPost post) {
        for (JobSeeker seeker : observers) {
            seeker.onJobPosted(post);
        }
    }
}
