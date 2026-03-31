package multi_threading;

import java.time.LocalTime;
import java.util.*;

public class ThreadMonitoring {

    public static void main(String[] args) throws Exception {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        Thread[] tasks = {t1, t2};

        StateMonitor monitor = new StateMonitor(tasks);

        monitor.start();

        Thread.sleep(500); 

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        monitor.join();
    }
}

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try { 
            Thread.sleep(2000);
 
            long sum = 0;
            for (int i = 0; i < 100000; i++) {
                sum += i;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class StateMonitor extends Thread {

    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        boolean allTerminated = false;

        while (!allTerminated) {
            allTerminated = true;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                String time = LocalTime.now().toString();

                stateHistory.putIfAbsent(t.getName(), new HashSet<>());
                stateHistory.get(t.getName()).add(state);

                System.out.println("[Monitor] " + t.getName() + " is in " + state + " state at " + time);

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String name : stateHistory.keySet()) {
            System.out.println(name + " went through " + stateHistory.get(name).size() + " states" );
        }
    }
}

