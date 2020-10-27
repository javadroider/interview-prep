## A New Post

Enter text in [Markdown](http://daringfireball.net/projects/markdown/). Use the toolbar above, or click the **?** button for formatting help.

## 2. Add Two Numbers
   
   
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int l1Val = l1!=null?l1.val:0;
            int l2Val = l2!=null?l2.val:0;
            
            int sum = l1Val + l2Val + carry;
            carry = sum/10;
            ListNode temp = new ListNode(sum % 10);
            head.next = temp;
            head = head.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            ListNode temp = new ListNode(carry);
            head.next = temp;
        }
        return dummy.next;
    }
}
```

