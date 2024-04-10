public class Main {
    public static void main(String[] args) {
        int n = 100; // Change n for different range

        LinkedList primeList = new LinkedList();
        primeList.populatePrimes(n);

        LinkedList digitThreePrimes = primeList.getPrimesWithDigitThree(primeList);

        int sum = digitThreePrimes.getSum();
        System.out.println("Sum of primes with digit '3' between 0 and " + n + ": " + sum);
    }
}