import java.util.LinkedHashMap;

/**
 * Created by youlongli on 4/15/15.
 */
public class ShortenUrl {
  private static char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

  public static void main(String[] args) {
    System.out.println(Base10ToBase62(62));
  }

  public static String Base36ToBase62(String s) {
    return "";
  }

  public static String Base62ToBase36(String s) {
    return "";
  }

  private static int Base62ToBase10(String s) {
    int rst = 0;
    int pow = 0;

    for (int i = 0; i < s.length(); i++) {
      rst += (s.charAt(i));
    }

    return rst;
  }

  private static String Base10ToBase62(int num) {
    StringBuilder sb = new StringBuilder();

    while (num > 0) {
      sb.append(map[(num - 1) % 62]);
      num = (num - 1) / 62;
    }

    return sb.toString();
  }
}
