package blockchain;

public class BlockFactory implements BasicBlockFactory {
    @Override
    public Block getNewBlock(long id, long timestamp, String prevHash) {
        return new Block(id, timestamp, prevHash);
    }
}
