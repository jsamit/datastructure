/*
  Iterative Method for Inorder Traveral
*/

public static void inOrder(Node root) {
        Stack<Node> st = new Stack<>();

        while(root != null || !st.isEmpty()) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }
