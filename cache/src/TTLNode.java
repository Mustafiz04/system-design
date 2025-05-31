public class TTLNode<K, V> extends Node<K, V> {
    long expiryTime;
    long ttl;
    TTLNode(K key, V value, long ttl) {
        super(key, value);
        this.ttl = ttl;
        this.expiryTime = System.currentTimeMillis() + ttl;
    }

    public boolean isExpired() {
        if( this.ttl < 0 ) return false;
        return System.currentTimeMillis() > this.expiryTime;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
}
