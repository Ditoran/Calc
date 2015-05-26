package calc.jahnke.im.calc.ModelClasses;

/**
 * Created by setup on 26.05.2015.
 */
public class PrimeChecker {

    int number;
    boolean isPrime;

    public PrimeChecker(int number) {
        this.number = number;
        isPrime = false;
        checkPrime();
    }

    public void checkPrime() {

        boolean[] numbers = new boolean[number + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = true;
        }
        numbers[0] = false;
        numbers[1] = false;
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i]) {
                for (int j = 2; (i * j) < numbers.length; j++) {
                    numbers[i * j] = false;
                }
            }

        }
        isPrime = numbers[number];
    }

    public boolean isPrime() {
        return isPrime;
    }
}
