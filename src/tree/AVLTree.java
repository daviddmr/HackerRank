package tree;

class AVLTree extends BinarySearchTree {

    Node insert(Node node, String data) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(data));

        if (Integer.valueOf(data) < Integer.valueOf(node.getData()))
            node.setLeft(insert(node.getRight(), data));
        else if (Integer.valueOf(data) > Integer.valueOf(node.getData()))
            node.setRight(insert(node.getRight(), data));
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        //TODO MAYBE HAS TO CHANGE THE GET HEIGHT METHODS CALLS!
        node.setHeight(1 + Math.max(getHeight(node.getLeft()),
                getHeight(node.getRight())));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && Integer.valueOf(data) < Integer.valueOf(node.getLeft().getData()))
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && Integer.valueOf(data) > Integer.valueOf(node.getRight().getData()))
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && Integer.valueOf(data) > Integer.valueOf(node.getLeft().getData())) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && Integer.valueOf(data) < Integer.valueOf(node.getRight().getData())) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;

        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private Node rightRotate(Node node) {
        Node left = node.getLeft();
        Node rightLeft = left.getRight();

        // Perform rotation
        left.setRight(node);
        node.setLeft(rightLeft);

        // Update heights
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        left.setHeight(Math.max(getHeight(left.getLeft()), getHeight(left.getRight())) + 1);

        // Return new root
        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.getRight();
        Node leftRight = right.getLeft();

        // Perform rotation
        right.setLeft(node);
        node.setRight(leftRight);

        //  Update heights
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        right.setHeight(Math.max(getHeight(right.getLeft()), getHeight(right.getRight())) + 1);

        // Return new root
        return right;
    }

}
