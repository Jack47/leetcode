package pagination;

import java.util.*;

public class Pagination {
    class Record {
        int id;
        String content;
        public Record(int id, String content) {
            this.id = id;
            this.content = content;
        }
    }

    public String[] paginate(int num, String[] results) {
       List<Record> records = Arrays.asList(parseCSV(results));
       Iterator<Record> iter = records.iterator();
       Set<Integer> set = new TreeSet<Integer>();
       List<String> ret = new LinkedList<String>();
       int count = 0 ; // count paged doc
       boolean isPadding = false;

       // iterate and find elements in every page
       // in each page, we don't allow duplicate host id
       while(iter.hasNext()) {
          Record r = iter.next();
          if(!set.contains(r.id) || isPadding) {
             ret.add(r.content);
             iter.remove();
             count++;
          }
          if (count > 0 && count % num == 0 && count < results.length) {
              ret.add("");
              set.clear();
              isPadding = false;
          }
          if(!iter.hasNext() && count < results.length) { // needs padding
             isPadding = true;
             iter = records.iterator();
          }
       }
       return ret.toArray(new String[0]);
    }

    Record[] parseCSV(String[] results) {
        Record[] ret = new Record[results.length];
        for(int i = 0; i < results.length; i++) {
           ret[i] = new Record(parseID(results[i]), results[i]);
        }
        return ret;
    }
    int parseID(String s) {
        int i =0;
        while(i < s.length() && s.charAt(i) != ',') {
           i++;
        }
        return Integer.parseInt(s.substring(0, i));
    }

}
