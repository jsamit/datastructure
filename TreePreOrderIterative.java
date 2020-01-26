public static void preOrder(Node root) {
        Stack<Node> st = new Stack<>();

        while(root != null || !st.isEmpty()) {
            if(root != null) {
                System.out.print(root.data + " ");
                st.push(root);
                root = root.left;
            }
            else {
                root = st.pop().right;
            }
        }
    }
