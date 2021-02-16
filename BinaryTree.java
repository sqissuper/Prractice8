package binaryTree;
class BinarySearchTree {
    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;

        public BSNode (int val) {
            this.val = val;
        }
    }

    public BSNode root = null;


    public BSNode search(int val) {
        if(root == null) return null;
        BSNode cur = root;
        while (cur != null) {
            if(cur.val < val) {
                cur = cur.left;
            } else if(cur.val > val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        BSNode node = new BSNode(val);
        if(root == null) {
            root = node;
            return true;
        }
        BSNode cur = root;
        BSNode p = null;
        while(cur != null) {
            if(cur.val < val) {
                p = cur;
                cur = cur.right;
            } else if(cur.val > val) {
                p = cur;
                cur = cur.left;
            } else {
                return false;
            }
        }
        if(val < p.val) {
            p.left = node;
        } else {
            p.right = node;
        }
        return true;
    }

    public void remove(int val) {
        if(root == null) return;
        BSNode cur = root;
        BSNode p = null;
        while (cur != null) {
            if(val < cur.val) {
                p = cur;
                cur = cur.left;
            } else if(val > cur.val) {
                p = cur;
                cur = cur.right;
            } else {
                removeNode(p,cur,val);
                return;
            }
        }

    }
    public void removeNode(BSNode p,BSNode cur,int val) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if(cur == p.left) {
                p.left = cur.right;
            } else if(cur == p.right) {
                p.right = cur.right;
            }
        } else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if(cur == p.right) {
                p.right = cur.left;
            } else if(cur == p.left) {
                p.left = cur.left;
            }
        } else {
            BSNode tp = cur;
            BSNode target = cur.right;
            while(target.left != null) {
                tp = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == tp.left) {
                tp.left = target.right;
            } else {
                tp.right = target.right;
            }

        }
    }
}
public class BinaryTree {
    public static void preorder(BinarySearchTree.BSNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void midOrder(BinarySearchTree.BSNode root) {
        if(root == null) return;
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
        binarySearchTree.insert(7);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(9);

        binarySearchTree.remove(9);

        preorder(binarySearchTree.root);
        System.out.println();
        midOrder(binarySearchTree.root);
    }
}
