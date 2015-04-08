import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 4/6/15.
 *
 * Idea: If the spreadsheet is sparse, then using a simple matrix will consume too much space.
 *       Instead, I can use Map<Integer, Map<Integer, String>> (<Row, <Col, Value>>)
 *
 * Follow up: If there are dependencies and when I update one cell, all cells depend on it will also need to update.
 * Solution: Use topological sort and then update each cell in the sorted list.
 *
 */
public class Excel {
  Map<Integer, Map<Integer, String>> spreatsheet;
  int size = 0;

  public Excel() {
    spreatsheet = new HashMap<>();
  }

  public void setValue(String value, int row, int col) {
    if (!spreatsheet.containsKey(row)) {
      spreatsheet.put(row, new HashMap<>());
    }
    spreatsheet.get(row).put(col, value);
  }

  private String getValue(int row, int col) {
    if (!spreatsheet.containsKey(row) || !spreatsheet.get(row).containsKey(col)) {
      return null;
    }

    return spreatsheet.get(row).get(col);
  }

  private boolean isRowColValid(int row, int col) {
    return row >= 0 && col >= 0;
  }
}
