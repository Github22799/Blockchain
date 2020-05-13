package blockchain;

public class Block implements BasicBlock {

    private BasicBlock next;

    private long Id;
    private long timestamp;
    private String prevHash;
    private String hash;

    public Block(long id, long timestamp, String prevHash) {
        Id = id;
        this.timestamp = timestamp;
        this.prevHash = prevHash;
    }

    @Override
    public void setNext(BasicBlock next) {
        this.next = next;
    }

    @Override
    public BasicBlock getNext() {
        return next;
    }

    @Override
    public long getId() {
        return Id;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String getPrevHash() {
        return prevHash;
    }

    @Override
    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public String getStringForHashing() {
        return "" + Id + timestamp + prevHash;
    }

    @Override
    public String toString() {
        return  "Id: " + getId() + '\n' +
                "Timestamp: " + timestamp + '\n' +
                "Hash of the previous block:\n" +
                prevHash + '\n' +
                "Hash of the block:\n" +
                hash + '\n';
    }
}
