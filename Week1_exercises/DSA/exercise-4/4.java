import java.util.Scanner;

 class EmployeeManagement {
    private Employee[] employees;
    private int count;

     EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

     void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Employee array is full.");
        }
    }

     Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

     void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
        } else {
            System.out.println("Employee not found.");
        }
    }

     void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

     public static void main(String[] args) {
        EmployeeManagement system = new EmployeeManagement(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Traverse Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    Employee employee = new Employee(id, name, position, salary);
                    system.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee foundEmployee = system.searchEmployee(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found: " + foundEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteEmployee(deleteId);
                    break;

                case 4:
                    system.traverseEmployees();
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
 class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

     Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

     int getEmployeeId() {
        return employeeId;
    }

     String getName() {
        return name;
    }

     String getPosition() {
        return position;
    }

     double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

