
public class HashTable {

    public static void main(String args[]) {

        HashTable table = new HashTable();
        table.put("aa", "Bob");
        table.put("bb", "Tim");
        table.put("cc", "asd");
        table.put("dd", "dsa");
        table.put("ee", "qwe");
        table.put("ff", "ewq");
    }

    private String[] table;
    private int numItems;

    private HashTable() {
        this.table = new String[10];
        this.numItems = 0;
    }

    private void put(String key, String value) {
        int idx = hashStringToInt(key, table.length);

        if (table[idx] == null) {
            table[idx] = value;
            numItems++;
            setLoadFactor();
        }
    }

    private void edit(String key, String value) {
        int idx = hashStringToInt(key, table.length);
        table[idx] = value;
        numItems++;
        setLoadFactor();
    }

    private void remove(String key) {
        int idx = hashStringToInt(key, table.length);
        table[idx] = null;
    }

    private String get(String key) {
        int idx = hashStringToInt(key, table.length);

        if (table[idx] != null) {
            return table[idx];
        } else {
            return "";
        }
    }

    private int hashStringToInt(String str, int hashTableSize) {
        int hash = 17;

        for (int i = 0; i < str.length(); i++) {
            hash = (13 * hash * str.charAt(i)) % hashTableSize;
        }

        return hash;
    }

    private void increaseArraySize() {
        String[] table = new String[this.table.length + 100];

        for (String key : this.table) {
            int index = hashStringToInt(key, table.length);
            table[index] = key;
        }
    }

    private void setLoadFactor() {
        double loadFactor = (double) numItems / (double) table.length;

        if (loadFactor > 0.8) {
            increaseArraySize();
        }
    }
}
