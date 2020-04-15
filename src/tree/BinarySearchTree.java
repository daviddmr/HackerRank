package tree;

class BinarySearchTree extends BinaryTree {

    BinarySearchTree() {
    }

    private BinarySearchTree(Node node) {
        this.setRoot(node);
    }

    void insert(String value) {
        Node parent = null;
        Node node = this.getRoot();

        while (node != null) {
            parent = node;

            if (Integer.valueOf(value) < Integer.valueOf(node.getData())) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (parent == null) {
            setRoot(new Node(value));
        } else if (Integer.valueOf(value) < Integer.valueOf(parent.getData())) {
            parent.setLeft(new Node(value));
        } else {
            parent.setRight(new Node(value));
        }
    }

    BinarySearchTree search(String value) {
        return search(value, getRoot());
    }

    private BinarySearchTree search(String value, Node node) {
        if (node == null) {
            return null;
        }

        if (node.getData().equals(value)) {
            return new BinarySearchTree(node);
        }

        if (Integer.valueOf(value) < Integer.valueOf(node.getData())) {
            return search(value, node.getLeft());
        } else {
            return search(value, node.getRight());
        }
    }
}
