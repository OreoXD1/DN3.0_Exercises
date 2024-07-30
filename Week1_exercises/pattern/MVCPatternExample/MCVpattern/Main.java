// Main.java
public class Main {
    public static void main(String[] args) {
        // Creating the model
        Student student = new Student("Bhuvan Bam", 12345, "A");

        // Creating the view
        StudentView view = new StudentView();

        // Creating the controller
        StudentController controller = new StudentController(student, view);

        // Displaying initial details
        controller.updateView();

        // Updating model data
        controller.setStudentName("Bhuvan Bam");
        controller.setStudentId(67890);
        controller.setStudentGrade("B");

        // Displaying updated details
        controller.updateView();
    }
}
