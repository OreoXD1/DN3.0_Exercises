import java.util.Scanner;

 class TaskManagement {
    private Node head;

    public TaskManagement() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.task.getTaskId() != taskId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManagement system = new TaskManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Traverse Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();

                    Task task = new Task(id, name, status);
                    system.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task foundTask = system.searchTask(searchId);
                    if (foundTask != null) {
                        System.out.println("Task found: " + foundTask);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteTask(deleteId);
                    break;

                case 4:
                    system.traverseTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
 class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
