package us.supercheng.algorithm.problems.leetcode.encodeanddecodetinyurl;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<String, String> map;
    final String DOMAIN = "http://abc/";

    public Solution() {
        this.map = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String s = DOMAIN + longUrl.hashCode();
        this.map.put(s, longUrl);
        return s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.map.get(shortUrl);
    }
}