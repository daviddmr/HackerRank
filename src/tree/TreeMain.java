package tree;

public class TreeMain {
    public static void main(String args[]) {
//        BinaryTree tree = new BinaryTree();
//        tree.createMockToInOrderTest();
//        tree.inOrderTraversal(tree.getRoot());
//        System.out.println("\n Height:" + tree.getHeight(tree.getRoot()));
//        tree.createMockToPostOrderTest();
//        tree.postOrderTraversal(tree.getRoot());
//        System.out.println("\n Height:" + tree.getHeight(tree.getRoot()));

//        BinarySearchTree tree1 = new BinarySearchTree();
//
        String[] list = {"61", "89", "66", "43", "51", "16", "55", "11", "79", "77", "82", "32"};
        String[] listToSearch = {"1", "61", "89", "3"};
//

        AVLTree tree1 = new AVLTree();
        for (String str : list) {
            tree1.insert(null, str);
        }
//
//        tree1.inOrderTraversal(tree1.getRoot());
//
        for (String str : listToSearch) {
            BinarySearchTree search = tree1.search(str);
            if (search != null) {
                System.out.println("Element found");
            } else {
                System.out.println("Element not found");
            }
        }
    }
}
