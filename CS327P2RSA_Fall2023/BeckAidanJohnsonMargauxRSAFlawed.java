import java.math.BigInteger;

/**
 * CS327 P2 - RSA Flawed
 * @author Aidan Beck
 * @author Margaux Johnson
 * @version October 11, 2023
 *
 * We have abided by the JMU Honor Code.
 */
public class BeckAidanJohnsonMargauxRSAFlawed {

    public static void main (String[] args) {
        System.out.println ("****************Part II output begins***************");

        // 1)
        BigInteger n = new BigInteger ("748567674651481801995116447644070267796617508884470018882963",16);
        int nBitLength = n.bitLength();

        // 2)
        // sage: factor(748567674651481801995116447644070267796617508884470018882963)
        // 853523075843604572088273872419 * 877032731553992233643010599377
        BigInteger p = new BigInteger ("853523075843604572088273872419", 16);
        BigInteger q = new BigInteger ("877032731553992233643010599377", 16);

        // 3)
        BigInteger e = new BigInteger ("65537", 16);
        BigInteger z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = e.modInverse(z);

        // 4)
        // m = 3
        BigInteger m = new BigInteger ("3", 16);
        BigInteger c = m.modPow(e, n);

        // 5)
        BigInteger m2 = c.modPow(d, n);

        // Output
        System.out.println ("N = 0x" + n.toString(16));
        System.out.println ("p = 0x" + p.toString(16));
        System.out.println ("q = 0x" + q.toString(16));
        System.out.println ("Bit-length of N = " + nBitLength);
        System.out.println ("d = 0x" + d.toString(16));
        System.out.println ("c = 0x" + c.toString(16));
        System.out.println ("m2 = 0x" + m2.toString(16));
    }
}
