package blockchain.Models;

import java.util.Objects;
import java.util.Random;

public class Block {
    int id;
    long timestamp;
    String hash;
    String prevHash;
    String magicNumber;
    long runtime;
    String msg;

    public Block(int id, long timestamp, String hash, String prevHash, String magicNumber, long runtime, String msg) {
        this.id = id;
        this.timestamp = timestamp;
        this.hash = hash;
        this.prevHash = prevHash;
        this.magicNumber = magicNumber;
        this.runtime = runtime;
        this.msg = msg;
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

    public String getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(String magicNumber) {
        this.magicNumber = magicNumber;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:" +
                "\n" + prevHash +
                "\nHash of the block:\n" + hash+
                "\nBlock data: " + this.msg;
    }


}
