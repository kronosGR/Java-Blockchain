import java.lang.annotation.ElementType;
import java.util.*;

class Originator {
    private int[][] array;

    public Originator(int[][] array) {
        this.array = array.clone();
    }

    public void setNumber(int position, int number) {
        array[position / array[0].length][position % array[0].length] = number;
    }

    public int[][] getArray() {
        return array.clone();
    }

    public Memento getMemento() {
        // TODO implement this method
        return new Memento(this.array);
    }

    public void setMemento(Memento memento) {
        // TODO implement this method
        this.array = Arrays.stream(memento.arr).map(int[]::clone).toArray(int[][]::new);
    }

    static class Memento {
        // TODO implement this class
        private int[][] arr;

        public Memento(int[][] array) {
           this.arr = Arrays.stream(array).map(int[]::clone).toArray(int[][]::new);
        }
    }
}

class Caretaker {
    private final Originator originator;
    private Originator.Memento snapshot = null;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void save() {
        snapshot = originator.getMemento();
    }

    public void restore() {
        if (snapshot != null) {
            originator.setMemento(snapshot);
        }
    }
}