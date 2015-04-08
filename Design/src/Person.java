/**
 * Created by youlongli on 4/6/15.
 *
 * http://www.careercup.com/question?id=3089709
 */
public class Person {
  String firstName;
  String middleName;
  String lastName;
  int age;

  Body body;

  public Person(String firstName, String middleName, String lastName, int age) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
    body = new Body();
  }
}

class Body {
  BodyPart head;
  BodyPart leftArm;
  BodyPart rightArm;
  BodyPart leftLeg;
  BodyPart rightLeg;

  public Body() {
    this.head = new Head();
    this.leftArm = new Arm();
    this.rightArm = new Arm();
    this.leftLeg = new Leg();
    this.rightLeg = new Leg();
  }
}

abstract class BodyPart {
}

class Arm extends BodyPart {
  public Arm() {
    super();
  }
}

class Leg extends BodyPart {
  public Leg() {
    super();
  }
}

class Head extends BodyPart {
  public Head() {
    super();
  }
}
