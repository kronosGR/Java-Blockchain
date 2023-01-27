package blockchain.Models;

public class Block {
    int id;
    long timestamp;
    String hash;
    String prevHash;
    long magicNumber;
    long runtime;

    public Block(int id, long timestamp, String hash, String prevHash, long magicNumber, long runtime) {
        this.id = id;
        this.timestamp = timestamp;
        this.hash = hash;
        this.prevHash = prevHash;
        this.magicNumber = magicNumber;
        this.runtime = runtime;
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

    public long getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(long magicNumber) {
        this.magicNumber = magicNumber;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:" +
                "\n" + prevHash +
                "\nHash of the block:\n" + hash +
                "\nBlock was generating for " + runtime + " seconds\n";
    }
}
