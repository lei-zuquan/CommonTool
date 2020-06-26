package com.java.algorithm.tree;


import com.java.algorithm.linear.Queue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:49 上午 2020/5/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {

    private class Node {
        // 记录键
        public Key key;
        // 记录值
        public Value value;
        // 记录左子节点
        public Node left;
        // 记录右子节点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // 记录根节点
    private Node root = null;
    // 记录节点数量
    private int N = 0;

    // 向树中插入一个键值对
    /*
        插入方法put实现思想：
        1.如果当前树中没有任何一个结点，则直接把新结点当做根结点使用
        2.如果当前树不为空，则从根结点开始：
             2.1如果新结点的key小于当前结点的key，则继续找当前结点的左子结点；
             2.2如果新结点的key大于当前结点的key，则继续找当前结点的右子结点；
             2.3如果新结点的key等于当前结点的key，则树中已经存在这样的结点，替换该结点的value值即可。
     */
    //向树中添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树x中添加key-value,并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            //个数+1
            N++;
            return new Node(key, value, null, null);
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = put(x.left, key, value);
        } else {
            //新结点的key等于当前结点的key，把当前结点的value进行替换
            x.value = value;
        }
        return x;
    }

    // 根据key，从树中找出对应的值
    /*
        查询方法get实现思想：
        从根节点开始：
             1.如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
             2.如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
             3.如果要查询的key等于当前结点的key，则树中返回当前结点的value。
     */
    public Value getValue(Key key){
        Node currNode = root;

        while (currNode != null) {
            if (key.compareTo(currNode.key) < 0) {
                currNode = currNode.left;
            } else if (key.compareTo(currNode.key) > 0) {
                currNode = currNode.right;
            } else {
                return currNode.value;
            }
        }

        return null;
    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
            return get(x.right, key);
        } else if (cmp < 0) {
            //如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            return get(x.left, key);
        } else {
            //如果要查询的key等于当前结点的key，则树中返回当前结点的value。
            return x.value;
        }
    }


    // 根据key，删除树中对应的键值对
    /*
        删除方法delete实现思想：
             1.找到被删除结点；
             2.找到被删除结点右子树中的最小结点minNode
             3.删除右子树中的最小结点
             4.让被删除结点的左子树成为最小结点minNode的左子树，让被删除结点的右子树称为最小结点minNode的右子树
             5.让被删除结点的父节点指向最小结点minNode
     */
    public void delete(Key key){
        delete(root, key);
    }


    // 删除指定树x上的键为key的键值对，并返回删除后的新树
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {
            //新结点的key等于当前结点的key,当前x就是要删除的结点
            // 1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null) {
                return x.left;
            }
            // 2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                return x.right;
            }
            // 3.当前结点的左右子树都存在
            // 3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点 minNode的右子树
            minNode.left = x.left;
            minNode.right = x.right;
            //3.4让被删除结点的父节点指向最小结点minNode
            x = minNode;
            //个数-1
            N--;
        }
        return x;
    }

    // 获取树中元素的个数
    public int size(){
          return N;
    }

    //找出整个树中最小的键
    public Key min(){
        Node currNode = root;
        while (currNode.left != null) {
            currNode = currNode.left;
        }

        return currNode.key;
    }

    //找出整个树中最大的键
    public Key max(){
        Node currNode = root;
        while (currNode.right != null) {
            currNode = currNode.right;
        }

        return currNode.key;
    }

    /*
    实现过程中，我们通过前序遍历，把,把每个结点的键取出，放入到队列中返回即可。
    实现步骤：
            1.把当前结点的key放入到队列中;
            2.找到当前结点的左子树，如果不为空，递归遍历左子树
            3.找到当前结点的右子树，如果不为空，递归遍历右子树
     */

    // 使用前序遍历，获取整个树中的所有键
    public Queue<Key> preErgodic(){
        Queue<Key> queue = new Queue<>();
        preErgodic(root, queue);

        return queue;
    }

    // 使用前序遍历，把指定树x中的所有键放入到keys队列中
    private void preErgodic(Node x, Queue<Key> keys){
        if (x == null) {
            return;
        }

        keys.enqueue(x.key);

        //1.把当前结点的key放入到队列中;
        if (x.left != null) {
            preErgodic(x.left, keys);
        }

        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    // 使用中序遍历，获取整个树中的所有键
    /*
    实现步骤：
            1.找到当前结点的左子树，如果不为空，递归遍历左子树
            2.把当前结点的key放入到队列中;
            3.找到当前结点的右子树，如果不为空，递归遍历右子树
     */
    public Queue<Key> midErgodic() {
        Queue queue = new Queue();
        midErgodic(root, queue);
        return queue;
    }

    // 使用中序遍历，把指定树x中的所有键放入到keys队列中
    private void midErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }

        //1.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        //2.把当前结点的key放入到队列中;
        keys.enqueue(x.key);

        //3.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    // 使用后序遍历，获取整个树中的所有键
    /*
    实现步骤：
            1.找到当前结点的左子树，如果不为空，递归遍历左子树
            2.找到当前结点的右子树，如果不为空，递归遍历右子树
            3.把当前结点的key放入到队列中;
     */
    public Queue<Key> afterErgodic(){
        Queue queue = new Queue();
        afterErgodic(root, queue);
        return queue;
    }

    // 使用后序遍历，把指定树x中的所有键放入到keys队列中
    private void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        //1.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null){
            afterErgodic(x.left, keys);
        }

        //2.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }

        //3.把当前结点的key放入到队列中;
        keys.enqueue(x.key);
    }

    // 使用层序遍历，获取整个树中的所有键
    public Queue<Key> layerErgodic(){
        Queue<Key> keys = new Queue();
        Queue<Node> nodes = new Queue();
        nodes.enqueue(root);

        while(!nodes.isEmpty()) {
            Node n = nodes.dequeue();
            keys.enqueue(n.key);

            if (n.left != null) {
                nodes.enqueue(n.left);
            }

            if (n.right != null) {
                nodes.enqueue(n.right);
            }
        }

        return keys;
    }

    // 计算整个树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }

    // 计算指定树x的最大深度
    private int maxDepth(Node x){
        //1.如果根结点为空，则最大深度为0；
        if (x == null) {
            return 0;
        }

        //2.计算左子树的最大深度；
        int leftDepth = maxDepth(x.left);

        //3.计算右子树的最大深度；
        int rightDepth = maxDepth(x.right);

        //4.当前树的最大深度=左子树的最大深度和右子树的最大深度中的较大者+1
        int maxDepth = leftDepth > rightDepth ? leftDepth:rightDepth;
        return maxDepth + 1;
    }


}
