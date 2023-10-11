import java.math.BigInteger;

/**
 * CS327 P2 - RSA Real
 * @author Aidan Beck
 * @author Margaux Johnson
 * @version October 11, 2023
 *
 * We have abided by the JMU Honor Code.
 */
public class BeckAidanJohnsonMargauxRSAReal{

    public static void main (String[] args) {
        System.out.println ("Real-World Example Output");

        BigInteger p = new BigInteger ("b6fa23706cb1881090a895dd8c0321ba5200407339e487fa3d554541ff" +
                "9590277c1343f53e30da7fa7a968f7989a60e7ad996a22ae443109a0421ece3b9c29cda22edeab53a79df" +
                "ef83b101ad6f06763860cfd8f3762c96d302b5d289458960223ea5ae1eddd71d9cf4f70f69384dbc1ee023" +
                "cfebcc156b8fe5506f3c2e2498f4820a2867ff4530a0b1af6f93fbc4f28099ed840b80b2efce3046827bd9fd8" +
                "bebbc20c7932540ef7a982a533d966bf9a399fb2f96e6acfc0ca94a9be5457d2a5",
                16);
        BigInteger q = new BigInteger ("d0bf42f8ad2cd77b17a06887497f9708bad7d4cba6e2d882c112913b7" +
                "194d6a41ed5942819da31c23e42491e2367188f60228ccebf566d32bc4214461e7b65ac6e956f48f00" +
                "c8d233ef90e982bbf8d5fc55f388fe33f6bd3db0eea97c4613e984348ae88592eb70b64ecc0b33835ee" +
                "d89e6dc0dc8f74eb35e8db6f7e29ef27ec6d06cc4d99f702c864b45004c105494312ffa7ecc3a902241e6" +
                "d88d79128b6b1dd8a6b1f36a329603eca663d97269f4266d85bc0a637f648f8334cb30c224f0d",
                16);

        // e = 2^16 + 1
        BigInteger e = new BigInteger ("65537", 16);

        // 1)
        BigInteger n = p.multiply(q);

        // 2)
        int nBitLength = n.bitLength();

        // 3)
        BigInteger z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = e.modInverse(z);

        // 4)
        // m = 3
        BigInteger m = new BigInteger ("3", 16);
        BigInteger c = m.modPow(e, n);

        // 5)
        BigInteger m2 = c.modPow(d, n);

        // 6)
        // System.nanoTime() for milliseconds
        long startTime =  System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            m2 = c.modPow(d, n);
        }
        long endTime =  System.nanoTime();;

        double milliseconds = (endTime - startTime) / 1e6;
        double seconds = (double) milliseconds / 1000.0;

        // Conversions
        double bps = nBitLength / seconds;
        double kbps = bps / 1000;
        double gbps = kbps / 1000000.0;

        // Output
        System.out.println ("p = 0x" + p.toString(16));
        System.out.println ("q = 0x" + q.toString(16));
        System.out.println ("N = 0x" + n.toString(16));
        System.out.println ("Bit-length of N = " + nBitLength);
        System.out.println ("e = 0x" + e.toString(16));
        System.out.println ("d = 0x" +d.toString(16));
        System.out.println ("c = 0x" + c.toString(16));
        System.out.println ("m2 = 0x" + m2.toString(16));
        System.out.println ("RSA Decryptions took " + milliseconds + " milliseconds");
        System.out.println ("RSA Decryptions in terms of kilobits/second " + kbps);
        System.out.println ("The speed is " + gbps + " gigabit/second Internet speed.");
    }
}
