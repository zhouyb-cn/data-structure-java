import java.util.*;

class TopK {

    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<String>();

        // Map<String, Integer> count = new HashMap<String, Integer>();
        // for (String word : words) {
        //     count.put(word, count.getOrDefault(word, 0) + 1);
        // }

        PriorityQueue<String> minHeap = new PriorityQueue<>((n1, n2) -> {
            // return count.get(n1) == count.get(n2) ? n2.compareTo(n1) : count.get(n1) - count.get(n2);
            return n1.compareTo(n2);
        });

        // for (String key : count.keySet()) {
        //     minHeap.add(key);
        //     if (minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        // }

        for (String word : words) {
            minHeap.add(word);
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        // Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        String[] words = {"i", "love", "java"};
        System.out.println(topK.topKFrequent(words, 2));
    }
}