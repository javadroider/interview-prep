package com.javadroider.interviewprep.systemdesign;

import java.util.HashMap;
import java.util.Map;

public class URLService {
    Map<String, Integer> ltos;
    Map<Integer, String> stol;
    static int COUNTER=1;
    String elements;

    URLService() {
        ltos = new HashMap<String, Integer>();
        stol = new HashMap<Integer, String>();
        COUNTER = 1;
        elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }


    public static void main(String[] args) {
        URLService urlService = new URLService();
        String tinyUrl = urlService.longToShort("http://shibboleth.1660669.n2.nabble.com/SP-Expiring-the-User-Session-Why-td7592288.html");
        System.out.println(tinyUrl);
        System.out.println(urlService.longToShort("http://shibboleth.1660669.n2.nabble.com/SP-Expiring-the-User-Session-Why-td7592288.html"));
        System.out.println(urlService.shortToLong(tinyUrl));
    }

    public String longToShort(String url) {
        String shorturl = base10ToBase62(COUNTER);
        ltos.put(url, COUNTER);
        stol.put(COUNTER, url);
        COUNTER++;
        return "http://tiny.url/" + shorturl;
    }

    public String shortToLong(String url) {
        url = url.substring("http://tiny.url/".length());
        int n = base62ToBase10(url);
        return stol.get(n);
    }

    private int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;

    }

    private int convert(char c) {
        if (c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }

    private String base10ToBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt(n % 62));
            n /= 62;
        }
        while (sb.length() != 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

}