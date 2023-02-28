import registry.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        while (!student.setFirstName(firstName)) {
            System.out.print("First Name: ");
            firstName = scanner.nextLine();
        }

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        while (!student.setLastName(lastName)) {
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();
        }

        System.out.print("Date (yyyy/mm/dd): ");
        String date = scanner.nextLine();
        while (!student.setDate(date)) {
            System.out.print("Date (yyyy/mm/dd): ");
            date = scanner.nextLine();
        }

        System.out.print("Course: ");
        String course = scanner.nextLine();
        while (!student.setCourse(course)) {
            System.out.print("Course: ");
            course = scanner.nextLine();
        }

        System.out.print("Email Address: ");
        String email = scanner.nextLine();
        while (!student.setEmail(email)) {
            System.out.print("Email Address: ");
            email = scanner.nextLine();
        }


        System.out.println(student.getResult());
    }
}