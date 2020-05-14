package blockchain;

public class Block implements BasicBlock {

    private BasicBlock next;

    private final long Id;
    private final long timestamp;
    private final String prevHash;
    private final String hash;

    public Block(long id, long timestamp, String prevHash, String hash) {
        Id = id;
        this.timestamp = timestamp;
        this.prevHash = prevHash;
        this.hash = hash;
    }

    public Block(long id, long timestamp, String prevHash, BasicHashGenerator hashGenerator) {
        Id = id;
        this.timestamp = timestamp;
        this.prevHash = prevHash;
        this.hash = hashGenerator.getHash(getStringForHashing());
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
