package com.company;

public class Primes {

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int n)
    {
        for (int i = 2; i < n; i++ ) {
          int v = n % i;
          if (v == 0) {
              return false;

          }
        }
        return true;
    }
}