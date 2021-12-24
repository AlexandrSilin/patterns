package Behavioral.observer;

public class JobSeeker {
    private final String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    public void onJobPosted(JobPost post) {
        System.out.println("Hi " + this.name + "! New job posted: " + post.getTitle());
    }
}
