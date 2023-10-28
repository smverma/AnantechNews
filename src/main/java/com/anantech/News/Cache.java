package com.anantech.News;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class Cache<K,V> {

    ConcurrentHashMap<K,V> cache= new ConcurrentHashMap<>();




}
