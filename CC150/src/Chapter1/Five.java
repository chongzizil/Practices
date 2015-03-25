package Chapter1;

/**
 * Created by youlongli on 3/22/15.
 */
public class Five {
  public static int countCompression(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    char last = s.charAt(0);
    int size = 0;
    int count = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == last) {
        count++;
      } else {
        last = s.charAt(i);
        size += 1 + String.valueOf(count).length();
        count = 1;
      }
    }

    size += 1 + String.valueOf(count).length(); // Note: Do not forget the last count
    return size;
  }

  // If space is not a issue, then countCompression can be ignored, instead I think I can just get the compressed string and check its length, safe time for double calculation.
  public static String compress(String s) {
    if (countCompression(s) >= s.length()) {
      return s;
    }

    StringBuilder sb = new StringBuilder();
    char last = s.charAt(0);
    int size = 0;
    int count = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == last) {
        count++;
      } else {
        sb.append(last);
        sb.append(count);
        last = s.charAt(i);
        count = 1;
      }
    }

    sb.append(last);
    sb.append(count);
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "abbccccccde";
    int c = countCompression(str);
    String cStr = compress(str);
    System.out.println("Compression: " + cStr);
    System.out.println("Old String (len = " + str.length() + "): " + str);
    System.out.println("Potential Compression: " + c);
  }
}
