public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final int salary;
    private final int age;

    public Employee(String fullName, String position, String email,
                    String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Full name: " + fullName +
                "; Position: " + position +
                "; Email: " + email +
                "; Phone number: " + phoneNumber +
                "; Salary: " + salary +
                "; Age: " + age);
    }
}
