package blockchain;

public interface BasicBlock {
    void setNext(BasicBlock block);
    BasicBlock getNext();
    long getId();
    long getTimestamp();
    String getPrevHash();
    void setHash(String hash);
    String getHash();
    String getStringForHashing();
    String toString();
}
