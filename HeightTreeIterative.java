public static int height(Node root) {
      	
        Deque<Node> deq = new ArrayDeque<>();

        int height = 0;

        deq.offerLast(root);

        while(true) {
            if(deq.isEmpty())
                return height-1;
            height++;

            int nodeCountAtLevel = deq.size();
            while(nodeCountAtLevel-- > 0) {
            
                root = deq.pollFirst();
                if(root.left != null)
                    deq.offerLast(root.left);

                if(root.right != null)
                    deq.offerLast(root.right);
            }
        }
    }
