package Behavioral.observer;

public class Example {
    public static void main(String[] args) {
        EmploymentAgency agency = new EmploymentAgency();
        agency.attach(new JobSeeker("seeker1"));
        agency.attach(new JobSeeker("seeker2"));
        agency.addJob(new JobPost("job1"));
        agency.addJob(new JobPost("job2"));
    }
}
