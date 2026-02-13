package org.algos.MathORNumberTheory.PollardRHOAlgo;

//        Pollard Rho is a probabilistic integer factorization
//        algorithm used to find a non-trivial factor of a composite number efficiently.
//        It works well for large numbers where trial division is slow.

//          How the Algorithm :
//
//        Goal: find a factor d of n such that 1 < d < n
//
//      Choose a polynomial function:
//        f(x) = (x² + c) mod n
//
//        Start with two values:
//
//        x → moves one step
//
//        y → moves two steps (cycle detection like Floyd)
//
//        Repeatedly compute:
//
//        x = f(x)
//
//        y = f(f(y))
//
//        At each step, compute:
//
//        d = gcd(|x − y|, n)
//
//        Outcomes:
//
//        d == 1 → continue
//
//        d == n → failure, restart with different c
//
//        1 < d < n → factor found

//example n = 91

import java.io.*;
import java.math.BigInteger;
import java.util.Random;

class Main {

    static final Random rnd = new Random();

    static BigInteger f(BigInteger x, BigInteger c, BigInteger n) {
        return x.multiply(x).add(c).mod(n);
    }

    static BigInteger pollardRho(BigInteger n) {
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return BigInteger.TWO;

        BigInteger x = new BigInteger(n.bitLength(), rnd).mod(n);

        BigInteger y = x;

        BigInteger c = new BigInteger(n.bitLength(), rnd).mod(n);

        BigInteger d = BigInteger.ONE;

        while (d.equals(BigInteger.ONE)) {
            x = f(x, c, n);
            y = f(y, c, n);
            y = f(y, c, n);
            d = x.subtract(y).abs().gcd(n);
        }

        return d.equals(n) ? BigInteger.ONE : d;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        BigInteger n = new BigInteger("91");

        BigInteger factor = pollardRho(n);

        out.println("Number : " + n);

        out.println("Factor: " + factor);
        out.println("Other : " + n.divide(factor));

        out.flush();
    }
}

