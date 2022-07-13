/**
 * This class models a type of beer with name, unitCost, quantity, and rating qualities.
 * 
 * @author Jacob Lange
 */
public class Beer implements Comparable<Beer> {

  private String name; // name/brand of beer
  private double unitCost; // cost of beer
  private int quantity; // quantity to be added to inventory
  private int rating; // popularity rating amongst customers of beer type on scale of 1-10

  /**
   * 4 argument constructor to create Beer object
   * 
   * @param name     - name/brand of beer
   * @param unitCost - cost of beer
   * @param quantity - quantity to be added to inventory
   * @param rating   - popularity rating amongst customers of beer type on a scale of 1-10
   */
  public Beer(String name, double unitCost, int quantity, int rating)
      throws IllegalArgumentException {
    if (unitCost <= 0.0)
      throw new IllegalArgumentException("Invalid cost. The cost must be positive");
    if (name == null || name.isBlank())
      throw new IllegalArgumentException("Invalid drink name");
    if (quantity <= 0) {
      throw new IllegalArgumentException("Invalid quantity. The quantity must be positive");
    }
    if (rating < 1 || rating > 10) {
      throw new IllegalArgumentException("Invalid popularity rating. Must be 1-10 range");
    }
    this.name = name;
    this.unitCost = unitCost;
    this.quantity = quantity;
    this.rating = rating;
  }


  /**
   * Returns the name of the beer beverage
   * 
   * @return name of beer beverage
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the cost per unit of the beer beverage
   * 
   * @return cost of beer beverage
   */
  public double getUnitCost() {
    return this.unitCost;
  }

  /**
   * Returns the total cost of the beer beverage pyrchase
   * 
   * @return cost of beer beverage purchase
   */
  public double getTotalCost() {
    return this.unitCost * this.quantity;
  }

  /**
   * Returns the quantity of this beer beverage in stock
   * 
   * @return quantity of beer beverage in stock
   */
  public int getQuantity() {
    return this.quantity;
  }


  /**
   * Returns the popularity rating of this type of beer beverage
   * 
   * @return rating of beer beverage
   */
  public int getRating() {
    return this.rating;
  }

  /**
   * Sets the new quantity of the beer beverage
   * 
   * @param amountToChange the amount to change the quantity of the beer beverage by
   */
  public void setQuantity(int amountToChange) {
    if (quantity + amountToChange < 0) {
      throw new IllegalArgumentException("Invalid change, quantity must be 0 or positive");
    }
    this.quantity = quantity + amountToChange;
  }

  /**
   * Compares this beer object to another beer object.
   * 
   * @param o The beer object to compare this object to
   * @return an integer where 1 means this is better than the parameter object.
   */
  @Override
  public int compareTo(Beer o) {
    // rank by (1)rating and (2)cost
    if (this.rating > o.getRating()) {
      return 1;
    } else if (this.rating < o.getRating()) {
      return -1;
    } else {
      // rating == rating
      if (this.unitCost - o.getUnitCost() > 0) {
        return 1;
      } else if (this.unitCost - o.getUnitCost() < 0) {
        return -1;
      } else {
        return 0;
      }
    }
  }

  /**
   * Checks whether this Beer equals to another object passed as input
   * 
   * @param obj other object to compare
   * @return true if obj refers to an Beer object with the same name and cost
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Beer)) {
      return false;
    }
    if (this.name.equals(((Beer) obj).getName())
        && Math.abs(this.unitCost - ((Beer) obj).getUnitCost()) < .001) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns a String representation of the Beer attributes
   * 
   * @return the beer as a String in the format
   */
  @Override
  public String toString() {
    return "[(Name: " + name + ") (Unit Cost: $" + unitCost + ") (Quantity: " + quantity
        + ") (Rating: " + rating + "/10)]";
  }
}
