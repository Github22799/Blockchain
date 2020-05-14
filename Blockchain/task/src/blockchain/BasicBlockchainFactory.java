package blockchain;

public interface BasicBlockchainFactory {
    Block generateNewBlock(long id, long timestamp, String prevHash, String hash);
    BasicBlock generateNewBlock(long id, long timestamp, String prevHash);
    BasicBlock generateNewBlock(BasicBlockchain blockchain);
    BasicBlockchain getNewBlockchain();
}
