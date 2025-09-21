import java.util.*;
import java.io.*;
public class format {
  public static void main(String[] args) throws IOException {
    BufferedReader train = new BufferedReader(new FileReader("test.csv"));
    BufferedReader train_new = new BufferedReader(new FileReader("test_new.csv"));
		PrintWriter pw = new PrintWriter("test_full.csv");

    for(int i = 0; i < 15997; i++) {
      String[] orig = train.readLine().split(",");
      String[] next = train_new.readLine().split(",");
      if(next.length == 0) {
        next = new String[] {"0.0", "0.0"};
      } else if(next.length == 1) {
        next = new String[] {next[0], "0.0"};
      } else if(next.length == 2) {
        if(next[0].equals("")) {
          next[0] = "0.0";
        }
      }
      String[] combo = new String[18];
      for(int j = 0; j < 16; j++) {
        combo[j] = orig[j];
      }
      combo[16] = next[0];
      combo[17] = next[1];
      for(int j = 0; j < 17; j++) {
        pw.print(combo[j] + ",");
      }
      pw.println(combo[17]);
    }

    pw.close();
  }
}