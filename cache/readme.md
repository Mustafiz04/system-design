# README

## 1. Problem Statement
Implement a caching mechanism with Least Recently Used (LRU) eviction policy. The cache should support basic operations like adding, retrieving, and deleting key-value pairs, with an optional time-to-live (TTL) feature.

## 2. Requirements
- **Language**: Java
- **Features**:
  - Add key-value pairs to the cache.
  - Retrieve values by key.
  - Delete key-value pairs.
  - Automatically evict the least recently used item when the cache reaches its capacity.
  - Support for optional TTL for cache entries.
- **Thread Safety**: The cache should handle concurrent access.

## 3. Core Entities
- **Node**: Represents a single entry in the cache, storing the key, value, and pointers to the previous and next nodes.
- **Cache**: Interface defining the basic operations for a cache.
- **LRUCache**: Implementation of the `Cache` interface using a doubly linked list and a hash map for efficient LRU eviction.

## 4. Class Design
### `Node<K, V>`
- Represents a doubly linked list node.
- **Fields**:
  - `key`
  - `value`
  - `prev`
  - `next`
- **Methods**:
  - Getters and setters for all fields.

### `Cache<K, V>`
- Interface defining the cache operations.
- **Methods**:
  - `add(K key, V value)`
  - `get(K key)`
  - `delete(K key)`
  - `add(K key, V value, long ttl)` (default implementation)

### `LRUCache<K, V>`
- Implements the `Cache` interface.
- **Fields**:
  - `HashMap<K, Node<K, V>> map`: Stores key-node mappings.
  - `Node<K, V> head, tail`: Dummy head and tail for the doubly linked list.
  - `int capacity`: Maximum size of the cache.
- **Methods**:
  - `add(K key, V value)`: Adds a key-value pair to the cache.
  - `get(K key)`: Retrieves a value by key and moves the node to the front.
  - `delete(K key)`: Removes a key-value pair from the cache.
  - **Helper methods**:
    - `moveToFront`
    - `addToFront`
    - `remove`

## 5. Design Patterns Used
- **Singleton**: Ensures a single instance of the cache (if required in future extensions).
- **Factory**: Can be used to create different types of caches (e.g., LRU, FIFO).
- **Decorator**: The TTL feature can be implemented as a decorator over the base cache.

## 6. Example Usage
```java
public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.add(1, "A");
        cache.add(2, "B");
        cache.add(3, "C");

        System.out.println(cache.get(1)); // Output: A
        cache.add(4, "D"); // Evicts key 2
        System.out.println(cache.get(2)); // Output: null
    }
}


// Stategy Patter for different eviction policies