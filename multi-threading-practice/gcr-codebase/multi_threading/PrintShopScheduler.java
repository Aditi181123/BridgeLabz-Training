package multi_threading;
public class PrintShopScheduler {

    static class PrintJob implements Runnable {
        private String jobName;
        private int pages;
        private int priority;

        public PrintJob(String jobName, int pages, int priority) {
            this.jobName = jobName;
            this.pages = pages;
            this.priority = priority;
        }

        @Override
        public void run() {
            String level;

            if (priority >= 7) level = "[High Priority]";
            else if (priority >= 5) level = "[Medium Priority]";
            else level = "[Low Priority]";

            for (int i = 1; i <= pages; i++) {
                System.out.println(level + " Printing " + jobName + " - Page " + i + " of " + pages);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(jobName + " completed by " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();
        System.out.println("Starting print jobs...\n");

        Thread t1 = new Thread(new PrintJob("Job1", 10, 5));
        Thread t2 = new Thread(new PrintJob("Job2", 5, 8));
        Thread t3 = new Thread(new PrintJob("Job3", 15, 3));
        Thread t4 = new Thread(new PrintJob("Job4", 8, 6));
        Thread t5 = new Thread(new PrintJob("Job5", 12, 7));

        t1.setName("Printer-Thread-1");
        t2.setName("Printer-Thread-2");
        t3.setName("Printer-Thread-3");
        t4.setName("Printer-Thread-4");
        t5.setName("Printer-Thread-5");

        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long endTime = System.currentTimeMillis();
        System.out.println("\nAll jobs completed in " + (endTime - startTime) + " ms");
    }
}
