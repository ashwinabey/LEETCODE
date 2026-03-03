import java.util.*;

class Task {
    int freq;
    int time;

    public Task(int f, int t) {
        this.freq = f;
        this.time = t;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int time = 0;
        
        PriorityQueue<Task> max = 
            new PriorityQueue<>((a, b) -> b.freq - a.freq);
        
        Queue<Task> queue = new LinkedList<>();
        
        int[] counts = new int[26];

        // Count freq
        for (char t : tasks) {
            counts[t - 'A']++;
        }

        for (int c : counts) {
            if (c > 0) {
                max.add(new Task(c, 0));
            }
        }

        while (!max.isEmpty() || !queue.isEmpty()) {
            
            time++;
            
            if (!max.isEmpty()) {
                Task current = max.poll();
                current.freq--;
                
                if (current.freq > 0) {
                    current.time = time + n;
                    queue.add(current);
                }
            }

            if (!queue.isEmpty() && queue.peek().time == time) {
                max.add(queue.poll());
            }
        }
        
        return time;
    }
}