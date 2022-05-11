import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputStreamTest {
    public static void main(String[] args) {
        String[] test = {"Hello", "Steve", "Unity", "Unite",
                        "Growth", "Possibilities", "Nimble", "Me",
                        "Beautiful", "Manatee", "Learn", "Elearn",
                        "See", "a", "b", "aa",
                        "bb", "ab", "ba"
                        };
        int[] syllables = {2, 1, 3, 2,
                            1, 5, 1, 1,
                            3, 3, 1, 2,
                            1, 1, 1, 1,
                            // 1, 1, 1
                            };

        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(test[0].getBytes()));

        SyllableCounter sc = new SyllableCounter();

        for(int i = 0; i < test.length; i++) {
            System.setIn(new ByteArrayInputStream(test[i].getBytes()));
            System.out.print("Expected: " + syllables[i] + "\n");
            sc.main(new String[0]);
        }

        // String x = ""; 
        // while(in.hasNext()) {
        //     x = in.nextLine(); 
        //     System.out.println(x);
        // }

    }
}