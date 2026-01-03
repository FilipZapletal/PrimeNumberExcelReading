package PrimeNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeTest {

    @Test
    public void testPrimeNumbers() {
        assertTrue(FileRead.isPrime(29));
        assertTrue(FileRead.isPrime(13));
        assertTrue(FileRead.isPrime(3));
        assertTrue(FileRead.isPrime(7));
    }

    @Test
    public void testNonPrimeNumbers(){
        assertFalse(FileRead.isPrime(16));
        assertFalse(FileRead.isPrime(4));
        assertFalse(FileRead.isPrime(15));
        assertFalse(FileRead.isPrime(100));
    }

    @Test
    public void testEdgeCases(){
        assertFalse(FileRead.isPrime(0));
        assertTrue(FileRead.isPrime(2));
        assertFalse(FileRead.isPrime(1));
    }

    @Test
    public void testNegativeNumbers(){
        assertFalse(FileRead.isPrime(-5));
        assertFalse(FileRead.isPrime(-13));
    }
}
