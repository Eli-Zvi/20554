/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 18/1/2023
 *  Class Name: Student.java
 */

public class Student implements Comparable<Student> {

    private String name; // name of the student
    private String lastName; // last name of the student
    private long ID; // ID of the student
    private String date; //decided not to use Date datatype because its formatting is bad

    public Student(String name, String lastName, long ID, String date)
    {
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public long getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * @return string representation of Student object
     */
    @Override
    public String toString() {
        return "Student " +
                "Legal Name: '" + name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase() + " " +
                lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase() + '\'' +
                "\nID: " + ID +
                "\nDate of Birth: " + date;
    }

    /**
     * compares 2 student objects and returns the result
     * @param s the object to be compared.
     * @return a positive integer if this.ID > s.ID
     * 0 if this.ID = s.ID
     * a negative integer if this.ID < s.ID
     */
    @Override
    public int compareTo(Student s) {
        return Long.compare(ID,s.ID);
    }
}
