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






}