package main.java.donutdungeon.hero;

public class JobEngineer { 

    private Job job;
    
    public JobEngineer(Job job) {
        this.job = job;
    }
    
    public void getJob() {
        this.job.getDescription();
    }
    
    public void makeJob() {
        this.job.setDescription();
        this.job.setAbilityList();
    }
}
