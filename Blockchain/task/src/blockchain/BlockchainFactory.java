package blockchain;

public class BlockchainFactory implements BasicBlockchainFactory {
    @Override
    public Blockchain getNewBlockchain() {
        BlockFactory factory = new BlockFactory();
        long timestamp = new Clock().getTime();
        Block head = factory.getNewBlock(1, timestamp, "0");
        head.setHash(new HashGenerator().getHash(head.getStringForHashing()));
        return new Blockchain(2, new Clock(), new HashGenerator(), factory, head, head);
    }
}
