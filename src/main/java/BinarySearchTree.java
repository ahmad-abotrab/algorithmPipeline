package main.java;

class BinarySearchTree {
    // Root of the Binary Search Tree
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Function to insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // This method mainly calls searchRec()
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A utility function to search a given key in BST
    boolean searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null)
            return false;
        if (root.key == key)
            return true;

        // Key is greater than root's key
        if (root.key < key)
            return searchRec(root.right, key);

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Function to do inorder traversal of BST
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create the following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println();

        // Search for a key
        int keyToSearch = 40;
        if (tree.search(keyToSearch)) {
            System.out.println("Key " + keyToSearch + " found in the BST.");
        } else {
            System.out.println("Key " + keyToSearch + " not found in the BST.");
        }
    }
}
