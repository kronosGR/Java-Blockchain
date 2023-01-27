import java.util.List;

class Test {
    public static void main1(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator);

        caretaker.save(); // []
        originator.addNumber(10); // [10]

        caretaker.restore(); // []
        originator.addNumber(12); // [12]

        caretaker.restore(); // List of numbers should be [] not [12]!

        if (!originator.getNumbers().equals(List.of())) {
            System.out.println("Error: Memento was modified!");
        }
    }
}