
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
  public static boolean testShelf() {
    // #TODO
    return false; // default
  }

  /**
   * Tests the functionality of Cooler.java
   * 
   * @return true if correct behavior, false otherwise.
   */
  public static boolean testCooler() {
    // #TODO
    return false; // default
  }

  /**
   * Tests the functionality of Beer.java
   * 
   * @return true if correct behavior, false otherwise.
   */
  public static boolean testBeer() {
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
  public static boolean testLiquorWine() {
    try {
      LiquorWine testDrink = new LiquorWine("Pinot Noir", 1.00, 24, 7);
    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine(null, 1.00, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("  ", 1.00, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("Jameson", 0.0, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("Jameson", -1.0, 24, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("Jameson", 1.00, 0, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("Moscato", 1.00, -1, 7);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("Moscato", 1.00, 20, 0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      LiquorWine testDrink = new LiquorWine("Moscato", 1.00, 20, 11);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    // Accessors & Mutators
    try {
      LiquorWine testDrink = new LiquorWine("Pino Grigio", 1.00, 20, 7);
      if (!testDrink.getName().equals("Pino Grigio")) {
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
      LiquorWine drinkA = new LiquorWine("Pino", 1.20, 24, 8);
      LiquorWine drinkB = new LiquorWine("Moscato", 1.00, 22, 7);
      LiquorWine drinkC = new LiquorWine("Cheaper Pino", 1.00, 22, 8);
      LiquorWine drinkD = new LiquorWine("Moscato Repeated", 1.00, 22, 7);
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
      LiquorWine drinkA = new LiquorWine("Pino", 1.20, 24, 8);
      LiquorWine drinkB = new LiquorWine("Pino", 1.20, 22, 7);
      LiquorWine drinkC = new LiquorWine("Moscato", 1.00, 22, 8);
      LiquorWine drinkD = new LiquorWine("Pino", 1.00, 22, 7);
      if (!drinkA.equals(drinkB) || drinkA.equals(drinkC) || drinkA.equals(drinkD)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    // ToString
    try {
      LiquorWine drinkA = new LiquorWine("Pino", 1.20, 24, 8);
      if (!drinkA.toString().equals("[(Name: Pino) (Unit Cost: $1.2) (Quantity: 24) (Rating: 8/10)]")) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    return true; 
  }

  /**
   * Tests the functionality of BSTNode.java
   * 
   * @return true if correct behavior, false otherwise
   */
  public static boolean testBSTNode(){
    try{
      //contructor
      Beer testDrink = new Beer("Coors Light", 1.00, 24, 7);
      BSTNode<Beer> testBeerNode1 = new BSTNode<>(testDrink);
      BSTNode<Beer> testBeerNode2 = new BSTNode<>(testDrink);
      BSTNode<Beer> testBeerNodeWithChildren = new BSTNode<>(testDrink, testBeerNode1, testBeerNode2);
      if (!testBeerNodeWithChildren.getLeft().equals(testBeerNode1)){
        return false;
      }
      if (!testBeerNodeWithChildren.getRight().equals(testBeerNode2)){
        return false;
      }

      // Accessors & Mutators
      BSTNode<Beer> testBeerNode3 = new BSTNode<>(testDrink);
      BSTNode<Beer> testBeerNode4 = new BSTNode<>(testDrink);
      testBeerNodeWithChildren.setLeft(testBeerNode3);
      testBeerNodeWithChildren.setRight(testBeerNode4);
      if (testBeerNodeWithChildren.getLeft().equals(testBeerNode1)){
        return false;
      }
      if (testBeerNodeWithChildren.getRight().equals(testBeerNode2)){
        return false;
      }
      if (!testBeerNodeWithChildren.getLeft().equals(testBeerNode3)){
        return false;
      }
      if (!testBeerNodeWithChildren.getRight().equals(testBeerNode4)){
        return false;
      }
      if (!testBeerNodeWithChildren.getData().equals(testDrink)){
        return false;
      }
    }catch (Exception e){
      return false;
    }

    return true; // default for now
  }

  /**
   * Runs all tester methods
   * 
   * @return true if all tests pass, false otherwise.
   */
  public static boolean runAllTests() {
    // #TODO

    if (!testBeer()) {
      System.out.println("beerTest() failed!");
      return false;
    }
    if (!testLiquorWine()){
      System.out.println("liquorWine() failed!");
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
