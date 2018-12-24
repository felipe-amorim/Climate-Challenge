import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int j=0;j<tc;j++) {
            String person = in.next();
            String virus = in.next();
            int []pattern1 = calculatePattern(virus+"%"+person);
            int []pattern2 = calculatePattern(new StringBuilder(virus).reverse().toString()+"%"+new StringBuilder(person).reverse().toString());
            final int to = virus.length() + person.length() + 1;
            pattern1 = Arrays.copyOfRange(pattern1, virus.length()+1, to);
            pattern2 = Arrays.copyOfRange(pattern2, virus.length()+1, to);
            for(int i=0;i<pattern2.length/2;i++) {
                int t = pattern2[i];
                pattern2[i] = pattern2[pattern2.length-i-1];
                pattern2[pattern2.length-i-1] = t;
            }
            StringBuilder resultBuilder = new StringBuilder();
            for(int i=0;i<person.length();i++) {
                if (i+virus.length()-1<person.length()) {
                    final int i1 = pattern2[i + virus.length() - 1];
                    if (pattern1[i]+ i1 >= virus.length()-1) {
                        resultBuilder.append(i+" ");
                    }
                }
            }
            String result = resultBuilder.length() > 0 ? resultBuilder.toString() : "No Match!";
            System.out.println(result);
        }
        in.close();
    }


    static int[]calculatePattern(String input) {
        int len = input.length();
        int[]pattern=new int[len];
        for (int i=1, l=0, r=0; i<len; ++i) {
            if (i <= r)
                pattern[i] = Math.min (r-i+1, pattern[i-l]);
            while (i+pattern[i] < len && input.charAt(pattern[i]) == input.charAt(i+pattern[i]))
                ++pattern[i];
            if (i+pattern[i]-1 > r) {
                l = i;
                r = i+pattern[i]-1;
            }
        }
        return pattern;
    }
}