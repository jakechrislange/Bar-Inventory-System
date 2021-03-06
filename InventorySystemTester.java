
// could also add a class to print accounting statements/entries for bought/sold inventory including
// profit/loss.

/**
 * Tester class for Bar Inventory System classes: Shelf, Cooler, LiquorWine,
 * Beer
 * 
 * @author Jacob Lange
 *
 */
public class InventorySystemTester {

  /**
   * Tests the functionality of Shelf.java
   * 
   * @return true if correct behavior, false otherwise.
   */
  public static boolean shelfTest() {
    // #TODO
    return false; // default
  }

  /**
   * Tests the functionality of Cooler.java
   * 
   * @return true if correct behavior, false otherwise.
   */
  public static boolean coolerTest() {
    // #TODO
    return false; // default
  }

  /**
   * Tests the functionality of Beer.java
   * 
   * @return true if correct behavior, false otherwise.
   */
  public static boolean beerTest() {
    // test constructor. Valid object. Invalid name, cost, quantity, rating.
    try {
      Beer testDrink = new Beer("Coors Light", 1.00, 24, 7);
    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer(null, 1.00, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("  ", 1.00, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("Coors Light", 0.0, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("Coors Light", -1.0, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("Coors Light", 1.00, 0, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("Coors Light", 1.00, -1, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("Coors Light", 1.00, 20, 0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Beer testDrink = new Beer("Coors Light", 1.00, 20, 11);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    // Accessors & Mutators
    try {
      Beer testDrink = new Beer("Coors Light", 1.00, 20, 7);
      if (!testDrink.getName().equals("Coors Light")) {
        return false;
      }
      if (Math.abs(testDrink.getUnitCost() - 1.00) > .001) {
        return false;
      }
      if (Math.abs(testDrink.getTotalCost() - 20) > .001) {
        return false;
      }
      if (testDrink.getQuantity() != 20) {
        return false;
      }
      if (testDrink.getRating() != 7) {
        return false;
      }
      testDrink.setQuantity(2); // +2
      if (testDrink.getQuantity() != 22 && Math.abs(testDrink.getTotalCost() - 22) > .001) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    // CompareTo
    try {
      Beer drinkA = new Beer("Miller", 1.20, 24, 8);
      Beer drinkB = new Beer("Coors", 1.00, 22, 7);
      Beer drinkC = new Beer("Cheaper Miller", 1.00, 22, 8);
      Beer drinkD = new Beer("Coors Repeated", 1.00, 22, 7);
      if (drinkA.compareTo(drinkB) != 1 || drinkB.compareTo(drinkA) != -1) {
        return false;
      }
      if (drinkA.compareTo(drinkC) != 1 || drinkC.compareTo(drinkA) != -1) {
        return false;
      }
      if (drinkB.compareTo(drinkD) != 0) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    // Equals
    try {
      Beer drinkA = new Beer("Miller", 1.20, 24, 8);
      Beer drinkB = new Beer("Miller", 1.20, 22, 7);
      Beer drinkC = new Beer("Coors", 1.00, 22, 8);
      Beer drinkD = new Beer("Miller", 1.00, 22, 7);
      if (!drinkA.equals(drinkB) || drinkA.equals(drinkC) || drinkA.equals(drinkD)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    // ToString
    try {
      Beer drinkA = new Beer("Miller", 1.20, 24, 8);
      if (!drinkA.toString().equals("[(Name: Miller) (Unit Cost: $1.2) (Quantity: 24) (Rating: 8/10)]")) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    return true; // default
  }

  /**
   * Tests the functionality of LiquorWine.java
   * 
   * @return true if correct behavior, false otherwise
   */
  public static boolean liquorWineTest() {
    // #TODO

    return false; // default
  }

  /**
   * Runs all tester methods
   * 
   * @return true if all tests pass, false otherwise.
   */
  public static boolean runAllTests() {
    // #TODO

    if (!beerTest()) {
      System.out.println("beerTest() failed!");
      return false;
    }

    return true;
  }

  /**
   * The main method
   * 
   * @param args (unused)
   */
  public static void main(String args[]) {
    if (runAllTests()) {
      System.out.println("All tests passed!");
    }
  }
}
