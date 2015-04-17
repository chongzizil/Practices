package parkinglot;

/**
 * Created by youlongli on 4/16/15.
 */
public class ParkingSpot {
  private VehicleType type;
  private Vehicle vehicle;
  private int row;
  private int col;
  private Level level;

  public ParkingSpot(Level level, VehicleType type, int row, int col) {
    this.level = level;
    this.type = type;
    this.row = row;
    this.col = col;
  }

  private boolean isAvailable() {
    return vehicle == null;
  }

  private boolean canFit(Vehicle vehicle) {
    return type.compareTo(vehicle.getType()) >= 0;
  }

  public boolean canPark(Vehicle vehicle) {
    return isAvailable() && canFit(vehicle);
  }

  public void park(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public void removeVehicle() {
    level.spotFreed();
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  @Override
  public String toString() {
    if (isAvailable()) {
      return " ";
    }

    return vehicle.toString();
  }
}
