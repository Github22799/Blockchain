package blockchain;

public interface BasicBlock {
    void setNext(BasicBlock block);
    BasicBlock getNext();
    long getId();
    long getTimestamp();
    String getPrevHash();
    String getHash();
    String getStringForHashing();
    String toString();
}
