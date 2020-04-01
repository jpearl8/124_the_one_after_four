import java.math.BigInteger;
 

class rabmil {
    public static void main(final String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter n");

        } else { 
            BigInteger n = new BigInteger(args[0]);
            BigInteger[] answer = new BigInteger[2];
            //calculate m, k
            answer = M_finder(n.subtract(BigInteger.ONE), BigInteger.ZERO);
            System.out.println(answer[0] + " " + answer[1]);
            

            // choose a
            BigInteger a = BigInteger.valueOf(2);
            boolean witness = false;
            // RabbyTest(n, answer[0], a);
            while ((witness == false) && (a.compareTo(n.subtract(BigInteger.ONE)) < 0)){
            //     //run function
                
                witness = RabbyTest(n, answer[0], a);
                a = a.add(BigInteger.ONE);
                // System.out.println("I dont know how this works");

            }
            System.out.println(a.subtract(BigInteger.ONE));
            // test for prime

        }


    }


    // returns [m, k]
    public static BigInteger[] M_finder (BigInteger n, BigInteger k){
        if (n.mod(BigInteger.valueOf(2)) == BigInteger.ZERO){
            n = n.divide(BigInteger.valueOf(2));
            k = k.add(BigInteger.ONE);
            return M_finder(n, k);
        } else {
            BigInteger[] answer = new BigInteger[]{n, k};
            return answer;
        }
    }
    
    public static boolean RabbyTest (BigInteger n, BigInteger m, BigInteger a){
        BigInteger b0 = a.modPow(m, n);
        if (b0.equals(BigInteger.ONE) || b0.equals(BigInteger.valueOf(-1))){
            return false;
        } else {
            
            BigInteger i = RabbyLong(b0, n, 0);
            if (i.equals(BigInteger.ONE)){
                System.out.println("WITNESSSSS: " + a);
                return true;
            } else {
                return false;
            }
        }
    }

    public static BigInteger RabbyLong (BigInteger b, BigInteger n, int counter){
        if (counter == 40){
            return BigInteger.valueOf(-1);
        }
        b = b.modPow(BigInteger.valueOf(2), n);
        if (b.equals(BigInteger.ONE) || b.equals(BigInteger.valueOf(-1))){
            return b;
        } else {
            return RabbyLong(b, n, counter + 1);
        }
    }
    
}