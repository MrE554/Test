public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Vasya", "+0 123 234 132");
        phonebook.add("Vasya", "+4 123 154 7");
        phonebook.add("Petya", "+123 12312 312");
        phonebook.add("Petya", "+0 001 02 03");
        System.out.println(phonebook.get("Vasya"));
        System.out.println(phonebook.get("Petya"));
    }
}
