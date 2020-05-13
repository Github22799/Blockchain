package blockchain;

public class BlockchainFactory implements BasicBlockchainFactory {
    @Override
    public Block getNewBlock(long id, long timestamp, String prevHash) {
        return new Block(id, timestamp, prevHash);
    }

    @Override
    public Blockchain getNewBlockchain() {
        BlockchainFactory factory = new BlockchainFactory();
        long timestamp = new Clock().getTime();
        Block head = factory.getNewBlock(1, timestamp, "0");
        head.setHash(new HashGenerator().getHash(head.getStringForHashing()));
        return new Blockchain(2, new Clock(), new HashGenerator(), factory, head, head);
    }
}
