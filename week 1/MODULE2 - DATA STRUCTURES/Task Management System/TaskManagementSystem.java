class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    static Task head = null;

    // Add Task
    static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }

        System.out.println("Task Added");
    }

    // Search Task
    static void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("\nTask Found:");
                System.out.println("ID: " + temp.taskId +
                        ", Name: " + temp.taskName +
                        ", Status: " + temp.status);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    // Traverse Tasks
    static void traverseTasks() {
        Task temp = head;

        System.out.println("\nTask List:");
        while (temp != null) {
            System.out.println("ID: " + temp.taskId +
                    ", Name: " + temp.taskName +
                    ", Status: " + temp.status);
            temp = temp.next;
        }
    }

    // Delete Task
    static void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task List is Empty");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted");
        }
    }

    public static void main(String[] args) {

        // Add Tasks
        addTask(101, "Design UI", "Pending");
        addTask(102, "Develop Backend", "In Progress");
        addTask(103, "Testing", "Pending");

        // Display Tasks
        traverseTasks();

        // Search Task
        searchTask(102);

        // Delete Task
        deleteTask(102);

        // Display Updated Tasks
        System.out.println("\nUpdated Task List:");
        traverseTasks();
    }
}