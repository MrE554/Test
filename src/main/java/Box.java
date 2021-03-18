import interfaces.Eatable;

import java.util.ArrayList;
import java.util.Collection;

public class Box<E extends Eatable> {
    private ArrayList<E> storage = new ArrayList<>();

    public void add(E eatable) {
        storage.add(eatable);
    }

    public E get(int index) {
        return storage.get(index);
    }

    public Collection<? extends E> getAll() {
        return storage;
    }

    public Collection<? extends E> giveAway() {
        Object tmp = storage.clone();
        storage.clear();
        return (Collection<? extends E>) tmp;
    }

    public int getWeight() {
        int length = storage.size();
        if (length <= 0) {
            return 0;
        }
        return storage.size() * storage.get(0).getWeight();
    }

    public void pourOver(Box<E> box) {
        storage.addAll(box.getAll());
    }

    public boolean compare(Box<? extends Eatable> o) {
        return getWeight() >= o.getWeight();
    }
}
