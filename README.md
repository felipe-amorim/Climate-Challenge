# Climate-Challenge
Save Humanity Challenge

This event was much more a timeout than an algorithm challenge, therefore, I would like to split my code into two sections.


1. First- The code I wrote at the first time.
````java
import java.util.ArrayList;
import java.util.Scanner;

public class SolutionOld {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            StringBuilder p = new StringBuilder(in.next());
            StringBuilder v = new StringBuilder(in.next());
            int pl = p.toString().length();
            boolean found = false;
            byte[] bpA = p.toString().getBytes();
            byte[] bvA = v.toString().getBytes();
            for (int i = 0; i <= pl; i++) {
                if (i >= bvA.length) {
                    int p0 = i - bvA.length;
                    int pn = i;
                    int pv = 0;
                    int different = 0;
                    ArrayList<Integer> vPosition = new ArrayList<>();
                    for (int pp = p0; pp < pn; pp++) {
                        vPosition.add(pp);
                        if (!(bvA[pv] == bpA[pp])) {
                            different++;
                        }
                        pv++;
                    }
                    if (different <= 1) {
                        System.out.print(vPosition.get(0) + " ");
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.print("No Match!");
            }
            System.out.println();
        }
    }
}


````
This code had many versions, however, as my problem was a timeout, this kind of sorting inside arrays using loops within the strings or keys was not optimized enough.


2. Second - The code sent to the hackerrank, in which I was highly influenced by the other Java developers related to this challenge, good to mention no function was copy-pasted.

```java
import java.util.*;

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
````

Using the method "calculatePattern" to split the indexers within the patterns (normal and reversed) and then comparing the results as per to have the final index of virus DNA, the test cases 3~9 finally passed.

The project can also be found on the repository, it is a Maven project created at [Intellij community IDE](https://www.jetbrains.com/idea/download/#section=windows)
