import java.util.Stack;
import java.util.Vector;

public class LargestElementToRight {

    public static Vector<Integer> largestElementToRight(int arr[], int n) {

        Stack<Integer> s = new Stack<>();  // Stack to store elements for comparison
        Vector<Integer> v = new Vector<>(); // Vector to store the results
        
        for (int i = n - 1; i >= 0; i--) { // Traverse the array from right to left
            if (s.size() == 0) {
                v.add(-1); // If stack is empty, no greater element to the right, add -1

            } else if (s.size() > 0 && s.peek() >= arr[i]) {
                v.add(s.peek()); // If stack top is greater or equal, add it as the next greater element

            } else if (s.size() > 0 && s.peek() < arr[i]) {
                // If stack top is smaller, pop elements until a greater element is found

                while (s.size() > 0 && s.peek() < arr[i]) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(-1); // If no greater element found, add -1
                    
                } else {
                    v.add(s.peek()); // Add the new stack top as the next greater element
                }
            }
            s.push(arr[i]); // Push the current element onto the stack
        }
        return v; // Return the vector containing the results
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 7, 1, 9};
        int n = arr.length;
        Vector<Integer> result = largestElementToRight(arr, n); // Get the results
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " "); // Print the results in reverse order
        }
    }
}
