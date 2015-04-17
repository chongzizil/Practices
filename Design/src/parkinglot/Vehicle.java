package parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 4/16/15.
 */
public abstract class Vehicle {
  protected String plate;
  protected int spotNeeded;
  protected VehicleType type;
  protected List<ParkingSpot> spots;

  public String getPlate() {
    return plate;
  }

  public int getSpotNeeded() {
    return spotNeeded;
  }

  public VehicleType getType() {
    return type;
  }

  public void park(ParkingSpot spot) {
    spots.add(spot);
  }

  public void leave() {
    for (ParkingSpot spot : spots) {
      spot.removeVehicle();
    }
    spots.clear();
  }
}
