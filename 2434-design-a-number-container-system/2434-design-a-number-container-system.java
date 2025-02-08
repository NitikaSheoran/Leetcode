import java.util.*;

class NumberContainers {
    private HashMap<Integer, Integer> container; 
    private HashMap<Integer, TreeSet<Integer>> minIdx; 

    public NumberContainers() {
        container = new HashMap<>();
        minIdx = new HashMap<>();
    }

    public void change(int index, int number) {
        if (container.containsKey(index)) {
            int prevNum = container.get(index);
            if (minIdx.containsKey(prevNum)) {
                minIdx.get(prevNum).remove(index); 
                if (minIdx.get(prevNum).isEmpty()) {
                    minIdx.remove(prevNum);
                }
            }
        }

        container.put(index, number);

        minIdx.putIfAbsent(number, new TreeSet<>()); 
        minIdx.get(number).add(index);
    }

    public int find(int number) {
        if (minIdx.containsKey(number) && !minIdx.get(number).isEmpty()) {
            return minIdx.get(number).first(); 
        }
        return -1;
    }
}
