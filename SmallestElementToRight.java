import java.util.Vector;
import java.util.Stack;

public class SmallestElementToRight {
    public static Vector<Integer> smallestElementRight(int arr[], int n) {
        Stack<Integer> s = new Stack<>();
        Vector<Integer> v = new Vector<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            
            // Pop elements from the stack that are greater than or equal to the current element
            while (!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }

            // If the stack is empty, there's no smaller element to the right

            // Otherwise, the top element of the stack is the smallest element to the right
            if (s.isEmpty()) {
                v.add(-1); // No smaller element found
            } else {
                v.add(s.peek()); // Smallest element to the right
            }

            // Push the current element onto the stack
            s.push(arr[i]);
        }
        return v; // Return the vector containing smallest elements to the right
    }

    public static void main(String[] args) {
        int arr[] = {1, 7, 3, 9, 2};
        int n = arr.length;

        // Get the vector of smallest elements to the right
        Vector<Integer> result = smallestElementRight(arr, n);

        // Print the result in reverse order
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}
