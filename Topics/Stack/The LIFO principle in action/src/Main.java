import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        Deque<Integer> tmp = new ArrayDeque<>() ;

        for (int i=0; i<total;i++){
            tmp.push(sc.nextInt());
        }

        Stream.of(tmp.toArray()).forEach(t -> System.out.println(t));
    }
}