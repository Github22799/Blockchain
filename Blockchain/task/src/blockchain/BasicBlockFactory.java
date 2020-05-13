package blockchain;

public interface BasicBlockFactory {
    BasicBlock getNewBlock(long id, long timestamp, String prevHash);
}
