import java.util.NoSuchElementException;

// BST for hard alcohol, wines

public class Shelf {

    private BSTNode<LiquorWine> root; // root node of shelf BST
    private int size; // size of the self

   
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public boolean findDrink(String name, double unitCost, int quantity, int rating){
       LiquorWine drink = new LiquorWine(name, unitCost, quantity, rating);
        
        if (isEmpty()){
            return false;
        }

        return findDrinkHelper(drink, root);      
    }

    protected static boolean findDrinkHelper(LiquorWine targetDrink, BSTNode<LiquorWine> curr){

        if (curr == null){
            return false;
        }

        if (targetDrink.equals(curr.getData())){
            return true;
        }

        int comparison = curr.getData().compareTo(targetDrink);

        if (comparison < 0){
            return findDrinkHelper(targetDrink, curr.getRight());
        }else{
            return findDrinkHelper(targetDrink, curr.getLeft());
        }

    }

    public boolean addDrink (LiquorWine newDrink) throws NullPointerException{
        if (newDrink == null){
            return false;
        }        
        if (isEmpty()){
            root = new BSTNode<LiquorWine>(newDrink);
            size++;
            return true;
        }else{
            if (addDrinkHelper(newDrink, root)){
                size++;
                return true;
            }else{
                return false;
            }
        }
    }

    protected static boolean addDrinkHelper(LiquorWine newDrink, BSTNode<LiquorWine> curr){

        int comparison = curr.getData().compareTo(newDrink);

        if (comparison < 0){

            if (curr.getRight() == null){
                curr.setRight(new BSTNode<LiquorWine>(newDrink));
                return true;
            }else{
                return addDrinkHelper(newDrink, curr.getRight());
            }

        }else if (comparison > 0){

            if (curr.getLeft() == null){
                curr.setLeft(new BSTNode<LiquorWine>(newDrink));
                return true;
            }else{
                return addDrinkHelper(newDrink, curr.getLeft());
            }


        }else{
            return false;
        }

    }

    public void removeDrink (String name, double unitCost, int quantity, int rating) throws NoSuchElementException{
        LiquorWine drink = new LiquorWine(name, unitCost, quantity, rating);
        root = removeDrinkHelper(drink, root);
        size--;
    }
    
    protected static BSTNode<LiquorWine> removeDrinkHelper(LiquorWine targetDrink, BSTNode<LiquorWine> curr) throws NoSuchElementException{
        if (curr == null) {
            throw new NoSuchElementException("null!");
          }
          if (targetDrink.compareTo(curr.getData()) == 0) {
            // conduct remove operation
            // current may be a leaf (has no children), set current to null.
            if (curr.getLeft() == null && curr.getRight() == null) {
              curr = null;
              return curr;
            } else if (curr.getLeft() == null && curr.getRight() != null
                || curr.getLeft() != null && curr.getRight() == null) {
              // current may have only one child, set current to that child (whether left or right child)
              if (curr.getLeft() == null) {
                curr = curr.getRight();
                return curr;
              } else {
                curr = curr.getLeft();
                return curr;
              }
            } else {
              // two children
              BSTNode<LiquorWine> newNode = new BSTNode<LiquorWine>(getSuccessor(curr));
              newNode.setLeft(curr.getLeft());
              newNode.setRight(curr.getRight()); 
              curr = newNode;
              curr.setRight(removeDrinkHelper(curr.getData(), curr.getRight()));
              return curr;
            }
          } else {
            // recursive case
            int compare = curr.getData().compareTo(targetDrink);
            if (compare < 0) {
              // check down right branch
              curr.setRight(removeDrinkHelper(targetDrink, curr.getRight()));
              return curr;
            } else { // don't need to account for compare == 0 because this shouldn't be allowed
              // compare > 0
              // check down left branch
              curr.setLeft(removeDrinkHelper(targetDrink, curr.getLeft()));
              return curr;
            }
          }
    }

    protected static LiquorWine getSuccessor (BSTNode<LiquorWine> node){
        if (node.getRight() == null) {
            return node.getData();
          }
          node = node.getRight();
          while (node.getLeft() != null) {
            node = node.getLeft(); //farthest left on the node's right subtree
          }
          return node.getData();
    }

    @Override
    public String toString(){
        return toStringHelper(root);
    }

    protected static String toStringHelper(BSTNode<LiquorWine> curr){
      if (curr== null) {
        return "";
      }
      String result = "";
      result += toStringHelper(curr.getLeft());
      result += curr.getData() + "\n";
      result += toStringHelper(curr.getRight());
      return result;
    }
}