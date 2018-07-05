package Misc;

import java.util.Collection;
import java.util.concurrent.Callable;

public class Reduce {
    Callable<Integer> caller;
    public <T> T reduce(Collection<T> collection, T init) {
       T ret = init;
       for(T v : collection) {
            ret = caller(ret, v);
       }
       return ret;
    }
}
