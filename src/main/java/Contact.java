import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> numbers;

    public Contact(String name, String number) {
        this.numbers = new HashSet<>();
        this.name = name;
        this.numbers.add(number);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getNumbers() {
        return this.numbers;
    }

    public void add(String number) {
        numbers.add(number);
    }

}
