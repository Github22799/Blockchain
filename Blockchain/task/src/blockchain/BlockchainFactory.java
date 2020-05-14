package blockchain;

public class BlockchainFactory implements BasicBlockchainFactory {

    private long lastId;
    Clock clock = new Clock();
    HashGenerator hashGenerator = new HashGenerator();

    public BlockchainFactory(long lastId) {
        this.lastId = lastId;
    }

    @Override
    public Block generateNewBlock(long id, long timestamp, String prevHash, String hash) {
        return new Block(id, timestamp, prevHash, hash);
    }

    @Override
    public Block generateNewBlock(long id, long timestamp, String prevHash) {
        return new Block(id, timestamp, prevHash, hashGenerator);
    }

    @Override
    public Block generateNewBlock(BasicBlockchain blockchain) {
        BasicBlock lastBlock = blockchain.getLastBlock();

        long id = lastBlock.getId() + 1;
        String prevHash = lastBlock.getHash();

        return generateNewBlock(id, clock.getTime(), prevHash);
    }

    @Override
    public Blockchain getNewBlockchain() {
        Block head = generateNewBlock(0, 0, "0", "0");
        return new Blockchain(lastId, new HashGenerator(), head, head);
    }
}
