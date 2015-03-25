package Chapter1;

/**
 * Created by youlongli on 3/22/15.
 */
public class Four {
  public static void replaceSpaces(char[] str, int length) {
    int i = length - 1;
    int j = str.length - 1;

    for (; i >= 0; i--) {
      char c = str[i];
      if (c != ' ') {
        str[j--] = c;
      } else {
        str[j--] = '0';
        str[j--] = '2';
        str[j--] = '%';
      }
    }
  }

  public static void main(String[] args) {
    String str = "abc d e f";
    char[] arr = new char[str.length() + 3 * 2];
    for (int i = 0; i < str.length(); i++) {
      arr[i] = str.charAt(i);
    }

    System.out.println("\"" + new String(arr) + "\"");
    replaceSpaces(arr, str.length());
    System.out.println("\"" + new String(arr) + "\"");
  }
}
