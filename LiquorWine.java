
public class LiquorWine implements Comparable<LiquorWine> {

  private String name; // name of beverage
  private double unitCost; // cost of beverage
  private int quantity; // quantity of beverage in stock
  private int rating; // rating of beverage

  public LiquorWine(String name, double unitCost, int quantity, int rating) throws IllegalArgumentException{
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
   * Returns the name of the beverage
   * 
   * @return name of beverage
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the cost per unit of the beverage
   * 
   * @return cost of beverage
   */
  public double getUnitCost() {
    return this.unitCost;
  }

  /**
   * Returns the cost of the beverage purchase
   * 
   * @return total cost of beverage purhcase
   */
  public double getTotalCost() {
    return this.unitCost * this.quantity;
  }

  /**
   * Returns the quantity of this beverage in stock
   * 
   * @return quantity of beverage in stock
   */
  public int getQuantity() {
    return this.quantity;
  }


  /**
   * Returns the popularity rating of this type of beverage
   * 
   * @return rating of beverage
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
   * Compares this LiquorWine object to another LiquorWine object.
   * 
   * @param o The liquorWine object to compare this object to
   * @return an integer where 1 means this is better than the parameter object.
   */
  @Override
  public int compareTo(LiquorWine o) {
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
    if (!(obj instanceof LiquorWine)) {
      return false;
    }
    if (this.name.equals(((LiquorWine) obj).getName())
        && Math.abs(this.unitCost - ((LiquorWine) obj).getUnitCost()) < .001) {
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

