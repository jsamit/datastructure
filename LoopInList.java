static boolean hasCycle(SinglyLinkedListNode head) {

        SinglyLinkedListNode fan = head;
        SinglyLinkedListNode actor = head;

        do {
            fan = fan.next;
            actor = (actor.next != null) ? actor.next.next : null;

        } while(fan != actor && actor != null);

        return fan == actor ? true : false;
    }
