package linked_list;
import java.util.*;


class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskSchedular {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        TaskList list = new TaskList();
	        int choice;

	        do {
	            System.out.println("\n--- Task Scheduler ---");
	            System.out.println("1. Add Task at Beginning");
	            System.out.println("2. Add Task at End");
	            System.out.println("3. Add Task at Position");
	            System.out.println("4. Remove Task by ID");
	            System.out.println("5. View Current Task");
	            System.out.println("6. Move to Next Task");
	            System.out.println("7. Display All Tasks");
	            System.out.println("8. Search Task by Priority");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();

	            int id, priority, pos;
	            String name, duedate;
	            
	            switch(choice) {
	            case 1 : 
	            	list.addbegin(new Task(1, "Design", 1, "10-10-2025"));
	            	break;
	            case 2 :
	            	list.addend(new Task(2, "Coding", 2, "12-10-2025"));
	            	break;
	            case 3 :
	            	list.addposition(new Task(4, "Deployment", 1, "18-10-2025"), 2);
	            	break;
	            case 4 :
	            	System.out.println("Enter id");
	            	id = sc.nextInt();
	            	list.removeByID(id);
	            	break;

                case 5:
                    list.viewCurrentTask();
                    break;

                case 6:
                    list.moveToNextTask();
                    break;

                case 7:
                    list.displayAllTasks();
                    break;

                case 8:
                    System.out.print("Enter Priority to search: ");
                    priority = sc.nextInt();
                    list.searchByPriority(priority);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
           
	            }
	        }
	        while(choice != 0);
	}
}
class TaskList {
	Task head = null;
	Task tail = null;
	Task curr = null;
	
	public void addbegin(Task task) {
		if(head == null) {
			head = tail = curr = task;
			task.next = head;
		}
		task.next = head;
		head = task;
		tail.next = head;
	}

	public void addend(Task task) {
		if(head == null) {
			head = tail = curr = task;
			task.next = head;
		}
		tail.next = task;
		tail = task;
		tail.next = head;
	}

	
	public void addposition(Task task, int pos) {
		if(pos <= 1 || head == null) {
			addbegin(task);
		}
		Task temp = head;
		for(int i = 1 ; i < pos - 1 && temp.next != null ; i++) {
			temp = temp.next;
		}
		task.next = temp.next;
		temp.next = task;
		
		if(temp == tail) {
			tail = task;
		}
	}

	public void removeByID(int id) {
		if(head == null) {
			System.out.println("List is Empty...");
			return;
		}
		Task temp = head;
		if(head.id == id) {
			if(head == tail) {
				head = tail = curr =  null;
			}
			head = head.next;
			tail.next = head;
		}
		 if(tail.id == id) {
			while(temp.next != tail) {
				temp = temp.next;
			}
			temp.next = head;
			temp = tail;
		 }
		 else {
			 Task prev = temp;
			 temp = temp.next;

			 while (temp != head) {
				 if (temp.id == id) {
					 prev.next = temp.next;
					 return;
				 }
				 prev = temp;
				 temp = temp.next;
			 }
		 }

	}

    public void viewCurrentTask() {
        if (curr == null) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Current Task: ID=" + curr.id + ", Name=" + curr.name + ", Priority=" + curr.priority + ", Due=" + curr.dueDate);
        }
    }

    public void moveToNextTask() {
        if (curr != null) {
            curr = curr.next;
            viewCurrentTask();
        } else {
            System.out.println("No tasks available.");
        }
    }
    
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID=" + temp.id + ", Name=" + temp.name + ", Due=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
			System.out.println("No tasks with priority " + priority);
		}
    }
	
	public void displayAllTasks() {
		if (head == null) {
			System.out.println("Task list is empty.");
			return;
		}

		Task temp = head;
		do {
			System.out.println("ID=" + temp.id + ", Name=" + temp.name + ", Priority=" + temp.priority + ", Due=" + temp.dueDate);
			temp = temp.next;
		} while (temp != head);
	}

}
