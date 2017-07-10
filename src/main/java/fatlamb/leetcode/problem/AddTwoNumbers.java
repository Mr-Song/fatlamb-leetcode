package fatlamb.leetcode.problem;

/**
 * Created by 58 on 2017/7/7.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
   public static void main(String[] args){
       ListNode l1 = new ListNode(9);
       l1.next = new ListNode(9);
       ListNode l2 = new ListNode(1);
       ListNode result = new AddTwoNumbers().addTwoNumbers(l2 , l1);
       System.out.print(result.val);
   }


    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1 ;
        ListNode current = l1 ;
        ListNode add1 = l1 ;
        ListNode add2 = l2 ;
        boolean carray = false ;
        while (add1 != null && add2 != null){
            int currentval = add1.val + add2.val ;
            if(carray){
                currentval++ ;
                carray = false ;
            }
            if (currentval > 9){
                carray = true ;
                currentval -= 10 ;
            }
            current.val = currentval ;
            if (current.next != null){
                current = current.next;
            }else if (add2.next != null){
                current.next = add2.next ;
                current = current.next;
                break;
            }else if (carray){
                current.next = new ListNode(1);
                carray = false ;
                break;
            }

            add1 = add1.next;
            add2 = add2.next;
        }

        while (carray){
            int currentval = current.val + 1 ;
            carray = false ;
            if(currentval > 9){
                currentval -= 10 ;
                carray = true ;
            }
            current.val = currentval ;
            if(current.next != null){
                current = current.next;
            }else if (carray){
                current.next = new ListNode(1);
                break;
            }

        }

        return  result ;
    }

    public ListNode addTwoNumbersGood(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
