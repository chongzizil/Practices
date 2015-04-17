package parkinglot;

import java.util.ArrayList;

/**
 * Created by youlongli on 4/16/15.
 */
public class Car extends Vehicle {
  public Car(String plate) {
    this.plate = plate;
    this.spotNeeded = 1;
    this.type = VehicleType.COMPACT;
    this.spots = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "C";
  }
}
