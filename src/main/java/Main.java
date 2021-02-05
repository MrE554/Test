public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Egor Egorovich", "Senior Engineer",
                "egor@egor.ru", "200 456 234 133 01", 200_000, 32);
        employees[1] = new Employee("Darya Daryavna", "Junior Programmes",
                "darya@mail.com", "9 346 645 101", 80_000, 24);
        employees[2] = new Employee("Fedor Fedorov", "Senior Architect",
                "fedor@werm.ru", "1 34 133 01", 450_000, 43);
        employees[3] = new Employee("Johan Johavich", "Senior Engineer",
                "johan@google.com", "86 123 5345 1", 300_000, 36);
        employees[4] = new Employee("Roman Romanovich", "DevOPS",
                "roman@rm.eu", "34 224 623 81", 180_000, 33);

        for (Employee employee : employees) {
            employee.info();
        }
    }
}
