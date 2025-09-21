import java.util.*;
import java.io.*;
public class format {
  public static void main(String[] args) throws IOException {
    BufferedReader train = new BufferedReader(new FileReader("train.csv"));
    BufferedReader train_new = new BufferedReader(new FileReader("train_new.csv"));
		PrintWriter pw = new PrintWriter("train_full.csv");

    for(int i = 0; i < 80001; i++) {
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
      String[] combo = new String[19];
      for(int j = 0; j < 15; j++) {
        combo[j] = orig[j];
      }
      combo[15] = next[0];
      combo[16] = next[1];
      combo[17] = orig[15];
      combo[18] = orig[16];
      for(int j = 0; j < 18; j++) {
        pw.print(combo[j] + ",");
      }
      pw.println(combo[18]);
    }

    pw.close();
  }
}