import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class CalculateAverageSalary {

    private static double calcAverageSalary(Collection<Integer> salaries) {
        // write your code here
        return DoubleStream.of(salaries.stream().mapToDouble(n -> (double)n).toArray()).average().orElse(0.0);
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> salaries = scanner.tokens()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(calcAverageSalary(salaries));
    }
}