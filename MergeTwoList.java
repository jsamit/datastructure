static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode first,last;
        
        if(head1.data < head2.data) {
            first = last = head1;
            head1 = head1.next;
            last.next = null;
        } else {
            first = last = head2;
            head2 = head2.next;
            last.next = null;
        }

        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                last.next = head1;
                last = head1;
                head1 = head1.next;
                last.next = null;
            } else {
                last.next = head2;
                last = head2;
                head2 = head2.next;
                last.next = null;
            }
        }

        if(head1 != null) 
            last.next = head1;
        else
            last.next = head2;


        return first;
    }
