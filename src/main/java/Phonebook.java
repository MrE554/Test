import java.util.HashSet;
import java.util.Set;

public class Phonebook {
    private Set<Contact> contacts;

    public Phonebook() {
        this.contacts = new HashSet<>();
    }

    public void add(String name, String number) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contact.add(number);
                return;
            }
        }
        contacts.add(new Contact(name, number));
    }

    public String get(String name) {
        StringBuilder info = new StringBuilder();
        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                info.append(contact.getNumbers());
                return name + ": " + info.toString();
            }
        }
        return "There is no contact with this name: " + name;
    }

}
