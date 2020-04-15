package tree;

class BinaryTree {

    private Node root;

    Node getRoot() {
        return root;
    }

    void setRoot(Node root) {
        this.root = root;
    }

    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int hLeft;
        int hRight;

        hLeft = getHeight(node.left);
        hRight = getHeight(node.right);

        if (hRight > hLeft) {
            return hRight + 1;
        } else {
            return hLeft + 1;
        }
    }

    void createMockToInOrderTest() {
        Node n1 = new Node("I");
        Node n2 = new Node("N");
        Node n3 = new Node("O");
        Node n4 = new Node("-");
        Node n5 = new Node("R");
        Node n6 = new Node("D");
        Node n7 = new Node("R");
        Node n8 = new Node("E");

        n2.left = n1;
        n2.right = n3;
        n3.left = n4;
        n3.right = n5;
        n5.left = n6;
        n6.left = n7;
        n6.right = n8;

        this.root = n2;
    }

    void createMockToPostOrderTest() {
        Node n1 = new Node("P");
        Node n2 = new Node("O");
        Node n3 = new Node("S");
        Node n4 = new Node("T");
        Node n5 = new Node("-");
        Node n6 = new Node("O");
        Node n7 = new Node("R");
        Node n8 = new Node("D");
        Node n9 = new Node("E");
        Node n0 = new Node("R");

        n0.left = n6;
        n0.right = n9;
        n6.left = n1;
        n6.right = n5;
        n5.left = n2;
        n5.right = n4;
        n4.right = n3;
        n9.left = n8;
        n8.right = n7;

        this.root = n0;
    }

    class Node {
        private String data;
        private Node left;
        private Node right;
        private int height;

        Node(String data) {
            this.data = data;
        }

        String getData() {
            return data;
        }

        Node getLeft() {
            return left;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        Node getRight() {
            return right;
        }

        void setRight(Node right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
