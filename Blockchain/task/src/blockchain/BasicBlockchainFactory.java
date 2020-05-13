package blockchain;

public interface BasicBlockchainFactory {
    BasicBlock getNewBlock(long id, long timestamp, String prevHash);
    BasicBlockchain getNewBlockchain();
}
