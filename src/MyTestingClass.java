import java.util.Random;

class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    // Custom hashCode implementation to avoid collisions and ensure uniform distribution
    @Override
    public int hashCode() {
        return id; // Use a unique identifier for hashing
    }

    @Override
    public String toString() {
        return "TestObject{" + "id=" + id + '}';
    }
}

public class HashTableTester {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        Random random = new Random();

        // Adding 10000 random elements to the hash table
        for (int i = 0; i < 10000; i++) {
            int randomId = random.nextInt(10000); // Random ID for testing class
            MyTestingClass key = new MyTestingClass(randomId);
            table.put(key, i);
        }

        // Count elements in each bucket
        int[] bucketSizes = new int[table.M];
        for (int i = 0; i < table.chainArray.length; i++) {
            HashNode<MyTestingClass, Integer> node = table.chainArray[i];
            while (node != null) {
                bucketSizes[i]++;
                node = node.next;
            }
        }

        // Print number of elements in each bucket
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i]);
        }
    }
}
