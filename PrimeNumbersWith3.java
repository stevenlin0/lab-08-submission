import java.util.LinkedList;

public class PrimeNumbersWith3 {
    public static void main(String[] args) {
        int n = 100; // Example value for n
        LinkedList<Integer> primeList = generatePrimes(n);
        LinkedList<Integer> primeWith3List = new LinkedList<>();

        // Filter prime numbers with '3' and move them to a new list
        for (Integer prime : primeList) {
            if (prime.toString().contains("3")) {
                primeWith3List.add(prime);
            }
        }
        // Calculate the sum of numbers in the second list
        int sum = 0;
        for (Integer prime : primeWith3List) {
            sum += prime;
        }

        System.out.println("Sum of prime numbers with '3': " + sum);
    }

    // Generate prime numbers up to n
    private static LinkedList<Integer> generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        LinkedList<Integer> primes = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}