import java.math.BigInteger;
 

class ee {
    public static void main(final String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter n e");

        } else { 
            BigInteger[] answer = new BigInteger[3];
            BigInteger a = new BigInteger(args[0]);
            BigInteger b = new BigInteger(args[1]);
            // System.out.println(a);
            // int a = Integer.parseInt(args[0]);
            // int b = Integer.parseInt(args[1]);
            answer = extend_euc_big(a, b);
            System.out.println("FINAL ANSWER: " + answer[2]);

        }


    }
    
    public static int[] extend_euc (int a, int b) {
        int k;
        int[] answer = new int[3]; 
        // System.out.println("a: " + a + "| b: " + b);
        if (b == 0) {
            answer[0] = a;
            answer[1] = 1;
            answer[2] = 0;
            // System.out.println("k: DNE" + "| x: " + answer[1] + "| y: " + answer[2]);
            return answer;
        } else {
            k = (a - (a % b)) / b;
            int test = a % b;
            System.out.println("A MOD B IS " + test);
            answer = extend_euc(b, a % b);
            int temp_x = answer[1];
            int temp_y = answer[2];
            answer[1] = temp_y;
            answer[2] = temp_x - k*temp_y;
            // System.out.println("k: " + k + "| x: " + answer[1] + "| y: " + answer[2]);
            return answer;
        }
        

    }
    public static BigInteger[] extend_euc_big (BigInteger a, BigInteger b) {
        BigInteger k;
        BigInteger[] answer = new BigInteger[3]; 
        // System.out.println("a: " + a + "| b: " + b);
        if (b == BigInteger.valueOf(0)) {
            answer[0] = a;
            answer[1] = BigInteger.valueOf(1);
            answer[2] = BigInteger.valueOf(0);
        //     // System.out.println("k: DNE" + "| x: " + answer[1] + "| y: " + answer[2]);
            return answer;
        } else {
            k = (a.subtract(a.mod(b))).divide(b);
            answer = extend_euc_big(b, a.mod(b));
            BigInteger temp_x = answer[1];
            BigInteger temp_y = answer[2];
            answer[1] = temp_y;
            answer[2] = temp_x.subtract(k.multiply(temp_y));
            return answer;
        //     k = (a - (a % b)) / b;
        //     int test = a % b;
        //     System.out.println("A MOD B IS " + test);
        //     answer = extend_euc(b, a % b);
        //     int temp_x = answer[1];
        //     int temp_y = answer[2];
        //     answer[1] = temp_y;
        //     answer[2] = temp_x - k*temp_y;
        //     // System.out.println("k: " + k + "| x: " + answer[1] + "| y: " + answer[2]);
        //     return answer;
        }
        

    }
    
}