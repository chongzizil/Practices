import java.util.*;

/**
 * Created by youlongli on 4/1/15.
 *
 * Reverse all words in a string (no punctuation).
 * i.e. "This is a sentence" -> "sentence a is This".
 * 1. Double reverse: First reverse the whole string, and then reverse each single word. (Other first all words, then whole string)
 *    1. Transfer the String to char array and do this in place.
 *    2. Use StringBuilder and substring method.
 * 2. Use stack. Push each word into the stack in order to reverse those words, then use StringBuilder.
 *
 * Questions:
 * 1. How to handle leading and trailing spaces, also the extra space between words.
 *    Assume all extra spaces will be ignored. i.g. "A and   B  " -> "B and A".
 *
 * follow up: There're punctuations and their positions shall be remained... punctuations: [,.!?@]
 * i.e. "This, is - an example." -> "example, an - is This."
 * 1. Double reverse + HashMap: use map to record the position of each punctuation.
 * 2. Use stack to reverse the words, yet use queue to hold the punctuations in the right place.
 *    (Treat characters between, in front of or behind of words, as single element inorder to weaver to result.)
 */
public class ReverseStrWithPunctuation {
  // Assume we do not worry about the extra spaces between words.
  public String reverseStrWithPunctuation(String str) {
    str = str.trim();
    // Use a queue since I iterate from the end of the String...
    Queue<String> wordsQueue = new LinkedList<>();
    // Use a stack since I iterate from the end of the String...
    Stack<String> punctuationsStack = new Stack<>();

    // Get all words
    int end = str.length();
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);

      if (!Character.isLetter(c)) { // Not only space do we need to ignore now.
        end = i;
      } else if (i == 0 || !Character.isLetter(str.charAt(i - 1))) {
        wordsQueue.offer(str.substring(i, end));
      }
    }

    // Get all punctuation elements...
    end = str.length();
    if (Character.isLetter(str.charAt(str.length() - 1))) {
      punctuationsStack.push("");
    }
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);

      if (Character.isLetter(c)) {
        end = i;
      } else if (i == 0 || Character.isLetter(str.charAt(i - 1))) {
        punctuationsStack.push(str.substring(i, end));
      }
    }
    if (Character.isLetter(str.charAt(0))) {
      punctuationsStack.push("");
    }

    // Generating the result
    StringBuilder sb = new StringBuilder();
    while(!wordsQueue.isEmpty()) {
      sb.append(punctuationsStack.pop());
      sb.append(wordsQueue.poll());
    }
    sb.append(punctuationsStack.pop());

    return sb.toString();
  }

  private boolean isPunctuation(char c) {
    return c == ','
    || c == '.'
    || c == '!'
    || c == '?'
    || c == '@';
  }
}