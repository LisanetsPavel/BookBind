package ua.nlu.scan.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc8 on 02.03.16.
 */
@Service
public class BookCacheService {

    private final Map<String, Integer> cache = new HashMap<>();

    public void add(String bookId, Integer cursor) {
        cache.put(bookId, cursor);

    }

    public boolean contains(String bookId) {
        return cache.containsKey(bookId);
    }

    public int get(String bookId) {

        return cache.get(bookId);

    }

}
