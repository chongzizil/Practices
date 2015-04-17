package parkinglot;

import java.util.Random;

/**
 * Created by youlongli on 4/16/15.
 */
public class Main {
  public static void main(String[] args) {
    ParkingLot lot = new ParkingLot(4);
    Random rnd = new Random();
    Vehicle v = null;

    while (v == null || lot.parkVehicle(v)) {
//      print(lot.toString());
      int r = rnd.nextInt(10) + 1;
      if (r < 1) {
        v = new Bus(r + "");
      } else if (r < 4) {
        v = new Motorcycle(r + "");
      } else {
        v = new Car(r + "");
      }
      System.out.print("\nParking a ");
      print(v.toString());
      System.out.println("");
    }
    System.out.println("Parking Failed. Final state: ");
    print(lot.toString());
  }

  public static void print(String s) {
    System.out.println(s);
  }
}
