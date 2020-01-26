/*
 its a breadth first approach so we will use Queue
*/

public static void levelOrder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();

        deque.offerLast(root);

        while(deque.size() != 0) {
            root = deque.pollFirst();
            System.out.print(root.data + " ");

            if(root.left != null)
                deque.offerLast(root.left);

            if(root.right != null)
                deque.offerLast(root.right);
        }
      
    }
