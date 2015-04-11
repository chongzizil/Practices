package datastructure;

/**
 * Created by youlongli on 4/11/15.
 */
public class Interval {
  private int beg;
  private int end;

  public Interval(int beg, int end) {
    this.beg = beg;
    this.end = end;
  }

  public boolean doOverlap(Interval i) {
    return this.beg <= i.end && this.end >= i.beg;
  }

  public int getBeg() {
    return beg;
  }

  public void setBeg(int beg) {
    this.beg = beg;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  @Override
  public String toString() {
    return "[" + beg + ", " + end + "]";
  }
}
