package Cache;

// Least Frequently Used cache
public class LFUCache {
    protected class Item {
        public Item(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 0;
            this.prev = -1;
            this.next = -1;
        }

        public int key; // incase of collision
        public int freq;
        public int value;
        public int prev; // store prev item index which has lower priority than this item.
        public int next; // store next item index which has high priority than this item.
    }

    protected Item[] items;
    protected int capacity;
    protected int head;
    protected int zeroFreqTail;

    public LFUCache(int capacity) {
        this.capacity = 0;
        this.items = new Item[capacity];
        head = -1;
        zeroFreqTail = -1;
    }

    public int get(int key) {
        int pos = key % items.length;

        int count = 0;
        for (; count < capacity && items[pos] != null; pos = (pos + 1) % items.length) {
            if (items[pos].key == key) {
                break;
            }
            count++;
        }
        if (items[pos] == null || count == capacity) {
            return -1;
        }
        items[pos].freq++;

        // find new position for key
        if (items[pos].next != -1 && items[pos].freq >= items[items[pos].next].freq) {
            if (items[pos].prev >= 0) {
                items[items[pos].prev].next = items[pos].next;
            }
            items[items[pos].next].prev = items[pos].prev;
            int i;
            for (i = items[pos].next; items[i].next != -1 && items[i].freq <= items[pos].freq; i
                    = items[pos].next) {
            }
            if (head == pos) {
                head = items[pos].next;
            }
            if (zeroFreqTail == pos) { // use previous
                zeroFreqTail = items[pos].prev;
            }
            if (items[i].freq <= items[pos].freq) {
                items[pos].next = items[i].next;
                items[i].next = pos;
                items[pos].prev = i;
            } else { // items[i].freq > items[pos].freq
                items[pos].prev = items[i].prev;
                items[items[i].prev].next = pos;
                items[i].prev = pos;
                items[pos].next = i;
            }
        }
        return items[pos].value;
    }

    public void put(int key, int value) {
        int pos = key % items.length;
        // find pos
        if (capacity == items.length) { // evict
            pos = head;
            head = items[head].next;
            // advance head
            if (head >= 0) {
                items[head].prev = -1;
            }
            // backtrack zeroFreqTail
            if (pos == zeroFreqTail) {
                zeroFreqTail = -1;
            }
        } else {
            int count = 0;
            for (; count <= capacity; pos = (pos + 1) % items.length) {
                if (items[pos] == null) {
                    break;
                }
                count++;
            }
            assert (count <= capacity);
            items[pos] = new Item(key, value);
            this.capacity++;
        }

        items[pos].freq = 0;
        items[pos].key = key;
        items[pos].value = value;

        // place this item to the trail of the zero freq list.
        items[pos].prev = zeroFreqTail;
        // this item's is more fresh that other `freq=0` items
        if (zeroFreqTail < 0) { // self is new head, is new zeroFreqTail
            items[pos].next = head;
            if (head >= 0) {
                items[head].prev = pos;
            }
            head = pos;
        }
        else {
            items[pos].next = items[zeroFreqTail].next;
            items[zeroFreqTail].next = pos;
            if (items[pos].next >= 0) {
                items[items[pos].next].prev = pos;
            }
        }
        zeroFreqTail = pos;

//        if (zeroFreqTail < 0 && (pos != head)) {
//            items[pos].next = head;
//            if (head >= 0) {
//                items[head].prev = pos;
//            }
//            head = pos;
//        }
//        else if (zeroFreqTail >= 0) {
//            items[pos].next = items[zeroFreqTail].next;
//            if (items[zeroFreqTail].next >= 0) {
//                items[items[zeroFreqTail].next].prev = pos;
//            }
//            items[zeroFreqTail].next = pos;
//        }

        if (this.capacity == 1) {
            head = pos;
        }

    }
}
