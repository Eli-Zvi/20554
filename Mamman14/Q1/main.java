/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 18/1/2023
 *  Class Name: main
 */

public class main {

    public static void main(String[] args) {

        Student student = new Student("eli","argaman",92684639,"17/01/1999");
        Student student2 = new Student("Oded","menahem",74629387,"17/12/1998");
        Student student3 = new Student("Idan","admoni",99389129,"4/5/2000");

        try {
            //create a new table with Student objects as its keys and their average grade as the value
            AssociationTable<Student,Integer> studentTable = new AssociationTable<>(new Student[]{student, student2, student3}, new Integer[]{80, 85,90});
            System.out.println(studentTable);

            Student student4 = new Student("Eric","rubin",91834212,"17/10/1990");
            studentTable.add(student4 ,60); //insert new student
            System.out.println("New Student " + student4.getName() + " " + student4.getLastName() + " added\n");
            System.out.println(studentTable);

            studentTable.add(student4,100); //change the grade value of student
            System.out.println("Student " + student4.getName() + " " + student4.getLastName() + "'s grade has changed\n");

            studentTable.remove(student); //remove student
            System.out.println("Student" + student.getName() + " " + student.getLastName() + " removed\n");
            System.out.println(studentTable);

        }catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
