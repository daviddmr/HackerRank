package hashTable;

public class HashTableWC {

    public static void main(String args[]) {
        HashTableWC hashTable = new HashTableWC();

        hashTable.put("k1", "v1");
        hashTable.put("k2", "v2");
        hashTable.put("k3", "v3");
        hashTable.put("k4", "v4");

        System.out.println("Key: k1 | Value: " + hashTable.get("k1").value);
        System.out.println("Key: k2 | Value: " + hashTable.get("k2").value);
        System.out.println("Key: k3 | Value: " + hashTable.get("k3").value);
        System.out.println("Key: k4 | Value: " + hashTable.get("k4").value);
    }

    private Node[] hashTable;
    private int numItems;

    private HashTableWC() {
        this.hashTable = new Node[3];
        this.numItems = 0;
    }

    private void put(String key, String value) {
        int idx = hashStringToInt(key, hashTable.length);

        if (hashTable[idx] == null) {
            Node node = new Node(key, value);
            hashTable[idx] = node;

            numItems++;
            checkLoadFactor(numItems);
        } else {
            hashTable[idx] = getNextFreeNode(hashTable[idx], key, value);
        }
    }

    private Node get(String key) {
        int idx = hashStringToInt(key, hashTable.length);

        if (hashTable[idx] != null) {
            if (hashTable[idx].key.equals(key)) {
                return hashTable[idx];
            } else if (hashTable[idx].next != null) {
                return getChainedNode(hashTable[idx].next, key);
            }
        }

        return null;
    }

    private void remove(String key) {
        int idx = hashStringToInt(key, hashTable.length);

        Node node = get(key);
        if (node != null) {
            if (node.next == null) {
                node = null;
                numItems--;
            } else {
//                node.prev = node.next;
                numItems--;
            }
        }
    }

    private Node getChainedNode(Node node, String key) {
        if (node.key.equals(key)) {
            return node;
        } else if (node.next != null) {
            return getChainedNode(node.next, key);
        }

        return null;
    }

    private Node getNextFreeNode(Node node, String key, String value) {
        Node nextNode;
        if (node.next == null) {
            nextNode = new Node(key, value);
        } else {
            nextNode = getNextFreeNode(node.next, key, value);
        }

        node.next = nextNode;
        return node;
    }

    private int hashStringToInt(String str, int hashTableSize) {
        int hash = 17;

        for (int i = 0; i < str.length(); i++) {
            hash = (13 * hash * str.charAt(i)) % hashTableSize;
        }

        return hash;
    }

    private void increaseArraySize() {
        Node[] table = new Node[this.hashTable.length * 2 + 1];

        for (Node item : this.hashTable) {
            if (item != null && item.key != null) {
                int index = hashStringToInt(item.key, table.length);
                table[index] = item;
            }
        }

        this.hashTable = table;
    }

    private void checkLoadFactor(int numItems) {
        double loadFactor = (double) numItems / (double) hashTable.length;

        if (loadFactor >= 0.8) {
            increaseArraySize();
        }
    }

    class Node {
        private String key;
        private String value;
        private Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
