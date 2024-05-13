import java.util.Random;
public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        Random random = new Random();

        //adding 10000 random elements to hashtable
        for (int i = 0; i < 10000; i++) {
            int randKey = random.nextInt(100); // Random key for testing
            table.put(randKey, "Value-" + i);
        }

        //print number of elements in each bucket
        int numberOfChains = table.getNumberOfChains();
        int[] bucketCounts = new int[numberOfChains];

        //counting elements in each bucket
        for (int i = 0; i < numberOfChains; i++) {
            MyHashTable.HashNode<Integer, String> node = table.chainArray[i];
            while (node != null) {
                bucketCounts[i]++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + bucketCounts[i] + " elements");
        }

        //creating BST with integer keys and string values
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");

        //use iterator to traverse the tree in ascending order of keys
        Iterable<Integer> keys = tree.iterable();
        for (Integer key : keys) {
            System.out.println("Key is " + key + " and value is " + tree.get(key));
        }

        //deleting an element
        tree.delete(3);

        //outputting the value for key 3 after deletion
        System.out.println("Value for key 3 after deletion: " + tree.get(3));
    }

}