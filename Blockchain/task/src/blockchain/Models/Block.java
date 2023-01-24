package blockchain.Models;

public class Block {
    int id;
    long timestamp;
    String hash;
    String prevHash;

    public Block(int id, long timestamp, String hash, String prevHash) {
        this.id = id;
        this.timestamp = timestamp;
        this.hash = hash;
        this.prevHash = prevHash;
    }

    public Block(int id, long timestamp, String hash) {
        this(id, timestamp, hash, "0");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nHash of the previous block:" +
                "\n" + prevHash +
                "\nHash of the block:\n" + hash + '\n';
    }
}
