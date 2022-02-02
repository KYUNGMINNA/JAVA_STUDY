package chapter09;
import java.util.regex.*;
public class ch9_32 {
    public static void main(String[] args) {
        String[] data={"bat","baby","bonus","cA","ca","co","c.","c0","car","combat","ccount","date","disc"};

        String[] pattern={".*","c[a-z]*","c[a-z]","c[a-zA-Z]","c[a-zA-Z0=9]","c.","c.*","c\\.","c\\w","c\\d","c.*t","[b|c].*",".*a.*",".*a.+","[b|c].{2}"};

        for (int x=0;x<pattern.length;x++){
            Pattern p=Pattern.compile(pattern[x]);
            System.out.printf("Pattern : "+pattern[x] + "  결과 :");
            for (int i=0;i<data.length;i++) {
                Matcher m = p.matcher(data[i]);
                if (m.matches()) {
                    System.out.print(data[i] + ",");

                }
                System.out.printf("%n");
            }
        }

    }
}
