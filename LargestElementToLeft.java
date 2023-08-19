import java.util.Vector;
import java.util.Stack;

public class LargestElementToLeft {

    // Method to find the nearest largest element to the left for each element in the array
    public static Vector<Integer> largestElementToLeft(int arr[], int n) {
        Stack<Integer> s = new Stack<>();   // Stack to store indices of elements
        
        Vector<Integer> v = new Vector<>(); // Vector to store results

        for (int i = 0; i < n; i++) {

            if (s.size() == 0) {
                s.push(-1);  // If the stack is empty, no larger element to the left

            } else if (s.size() > 0 && s.peek() >= arr[i]) {
                v.add(s.peek());  // If the top element in the stack is greater or equal, add it to the result

            } else if (s.size() > 0 && s.peek() < arr[i]) {
                while (s.size() > 0 && s.peek() < arr[i]) {
                    s.pop();  // Pop elements from the stack until a greater element is found or stack becomes empty
                }

                if (s.size() == 0) {
                    v.add(-1);  // If stack is empty, no larger element to the left
                } else {
                    v.add(s.peek());  // Add the current larger element to the result
                }
                
            }
            s.push(arr[i]);  // Push the current element onto the stack
        }
        return v;  // Return the vector containing the results
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 1};
        int n = arr.length;

        Vector<Integer> result = largestElementToLeft(arr, n);

        // Print the results in reverse order
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}
