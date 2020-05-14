package blockchain;

public interface BasicBlockchain {
    BasicBlock getLastBlock();
    void acceptNewBlock(BasicBlock block);
    boolean validateBlocks();
}
