import java.util.HashMap;

public class MaxDistance {
    public static void main(String args[]) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};

        System.out.println(getMaxDistance(arr));
        System.out.println(getMaxDistanceLow(arr));
    }

    // Time performance
    private static int getMaxDistance(int[] arr) {
        int arrSize = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxDistance = 0;

        for (int i = 0; i < arrSize; i++) {

            if (map.containsKey(arr[i])) {
                maxDistance = Math.max(maxDistance, i - map.get(arr[i]));
            } else {
                map.put(arr[i], i);
            }
        }

        return maxDistance;
    }

    // Space performance
    private static int getMaxDistanceLow(int[] arr) {
        int arrSize = arr.length;

        int maxDistance = 0;

        for (int i = 0; i < arrSize - 1; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                if (arr[i] == arr[j]) {
                    maxDistance = Math.max(maxDistance, Math.abs(j - i));
                }
            }
        }

        return maxDistance;
    }
}
