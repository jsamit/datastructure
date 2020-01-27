 static List<Integer> inOrder(Node root) {
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while(root != null || !st.isEmpty()) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                list.add(root.data);
                root = root.right;
            }
        } 
        return list;
    }
    boolean checkBST(Node root) {
        /*for(int val : inOrder(root)) {
            System.out.println(val);
        }*/
        return isSorted(inOrder(root));
    }

    static boolean isSorted(List<Integer> list) {
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
