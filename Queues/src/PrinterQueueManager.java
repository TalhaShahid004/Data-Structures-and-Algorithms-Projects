public class PrinterQueueManager {
    private ArrayPriorityQueue<Job> printerQueue;

    public PrinterQueueManager(int queueSize) {
        printerQueue = new ArrayPriorityQueue<>(queueSize);
    }

    public void enqueueJob(Job job) {
        printerQueue.Enqueue(job);
    }

    public void printNextJob() {
        Job nextJob = printerQueue.Dequeue();
        if (nextJob != null) {
            System.out.println("Printing: " + nextJob);
        } else {
            System.out.println("No jobs to print.");
        }
    }

    public Job peekNextJob() {
        return printerQueue.peek();
    }

    public String getQueueStatus() {
        return printerQueue.toString();
    }
}
