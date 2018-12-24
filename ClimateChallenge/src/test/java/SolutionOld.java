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

