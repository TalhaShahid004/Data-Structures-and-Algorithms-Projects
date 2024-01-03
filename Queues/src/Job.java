public class Job implements Comparable<Job> {
    private String jobName;
    private int jobSize;

    public Job(String jobName, int jobSize) {
        this.jobName = jobName;
        this.jobSize = jobSize;
    }

    public String getJobName() {
        return jobName;
    }

    public int getJobSize() {
        return jobSize;
    }

    @Override
    public int compareTo(Job otherJob) {
        // Compare jobs based on their size (shortest job first)
        return Integer.compare(this.jobSize, otherJob.getJobSize());
    }

    @Override
    public String toString() {
        return jobName + " (Size: " + jobSize + ")";
    }
}
