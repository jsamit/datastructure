public static Node insert(Node root,int data) {
        
        Node temp = root;
        Node newNode = new Node(data);

        if(root == null)
            return newNode;

        while(true) {
            if(temp.data >= data) {
                if(temp.left == null)
                {
                        temp.left = newNode;
                        break;
                }
                temp = temp.left;
            }
            else if (temp.data < data) {
                if(temp.right == null)
                {
                        temp.right = newNode;
                        break;
                }
                temp = temp.right;  
            }
        }
    	return root;
    }
