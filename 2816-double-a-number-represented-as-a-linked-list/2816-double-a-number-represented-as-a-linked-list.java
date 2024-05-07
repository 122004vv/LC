//Please Upvote if you find this solution simple & easy! ;)
//This is not the optimized solution , but a simple brute-force approach with Big-Integer
//This solution is beginner friendly , as they can understand and view how the job is done

//Import Big Integer Library
import java.math.BigInteger;
class Solution {
    public ListNode doubleIt(ListNode head) {
        //Create a String Builder to append the numerical values and use a while loop to iterate the node values
        StringBuilder sb = new StringBuilder();
        while (head!=null) {
            sb.append(head.val);
            head = head.next;
        }
        //Store the (2*num) value as BigInteger & convert it into a string
        BigInteger num = new BigInteger(sb.toString()).multiply(BigInteger.valueOf(2));
        String str = num.toString();
        //Create the head ListNode
        ListNode h = new ListNode(str.charAt(0) - '0');
        ListNode curr = h;
        //Start the loop and take the digits , create a ListNode with every value and add them as curr.next
        for (int i = 1; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            ListNode nd = new ListNode(digit);
            //Update curr node to the next
            curr.next = nd;
            curr = curr.next;
        }
        //Return the head ListNode 
        return h;
    }
}