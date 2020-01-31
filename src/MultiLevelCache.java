import java.util.*;

class LruCache {
    private Deque<String> queue;
    private Map<String, String> map;
    private int cacheSize;
    private int readTime;
    private int writeTime;

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    public int getReadTime() {
        return this.readTime;
    }

    public void setWriteTime(int writeTime) {
        this.writeTime = writeTime;
    }

    public int getWriteTime() {
        return this.writeTime;
    }

    public boolean containsKey(String key) {
        return this.map.containsKey(key);
    }

    public LruCache(int cacheSize) {
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
        this.cacheSize = cacheSize;
    }

    public void writeVal(String key, String value) {
        if(!this.map.containsKey(key)) {
            if(this.queue.size() == this.cacheSize) {
                String storedKey = queue.removeLast();
                map.remove(storedKey);
            }
            map.put(key, value);
        } else {
            String elem = null;
            for (String s : queue) {
                if (s.equals(key)) {
                    elem = s;
                    break;
                }
            }
            queue.remove(elem);
        }
        queue.push(key);
    }

    public String readVal(String key) {
        return this.map.get(key);
    }
}

public class MultiLevelCache {
    private int levels;
    private LruCache[] LruCaches;

    public MultiLevelCache(int levels) {
        this.levels = levels;
        LruCaches = new LruCache[levels];
    }

    private void writeToCache(String key, String value) {
        int time = 0;
        String val;
        for(int i = 0; i < this.levels; i++) {
            val = LruCaches[i].readVal(key);
            time += LruCaches[i].getReadTime();
            if(val != null) {
                break;
            } else {
                LruCaches[i].writeVal(key, value);
                time += LruCaches[i].getWriteTime();
            }
        }
        System.out.println("Write time: " +  time);
    }

    private void readFromCache(String key) {
        int readTime = 0;
        String value = null;
        for(int i = 0; i < this.levels; i++) {
            value = LruCaches[i].readVal(key);
            readTime += LruCaches[i].getReadTime();
            if(value != null) {
                break;
            }
        }
        System.out.println("Value at " + key + " is " + value);
        System.out.println("Read time: " +  readTime);
    }

    private void printStats() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int levels = in.nextInt();

        MultiLevelCache multiLevelCache = new MultiLevelCache(levels);
        for(int i = 0; i < levels; i++) {
            int cacheSize = in.nextInt();
            multiLevelCache.LruCaches[i] = new LruCache(cacheSize);
        }

        for(int i = 0; i < levels; i++) {
            int readTime = in.nextInt();
            multiLevelCache.LruCaches[i].setReadTime(readTime);
        }

        for(int i = 0; i < levels; i++) {
            int writeTime = in.nextInt();
            multiLevelCache.LruCaches[i].setWriteTime(writeTime);
        }

        // This I have included to understand the number of operations
        // that the user would do
        int numOps = in.nextInt();

        for(int i = 0; i< numOps; i++) {
            String op = in.next();
            switch (op) {
                case "WRITE":
                    String key = in.next();
                    String value = in.next();
                    multiLevelCache.writeToCache(key, value);
                    break;
                case "READ":
                    String key_ = in.next();
                    multiLevelCache.readFromCache(key_);
                    break;
                case "STATS":
                    break;
            }
        }
    }
}
