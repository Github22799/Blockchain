package blockchain;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Blockchain implements BasicBlockchain, Iterable<BasicBlock> {

    public static final String INITIAL_HASH = "0";
    private int lastId;

    private BasicClock clock;
    private BasicHashGenerator hashGenerator;
    private BasicBlockFactory blockFactory;

    private BasicBlock head;
    private BasicBlock tail;

    public Blockchain(int lastId, BasicClock clock, BasicHashGenerator hashGenerator, BasicBlockFactory blockFactory, BasicBlock head, BasicBlock tail) {
        this.lastId = lastId;
        this.clock = clock;
        this.hashGenerator = hashGenerator;
        this.blockFactory = blockFactory;
        this.head = head;
        this.tail = tail;
    }

    @Override
    public void generateNewBlock() {
        long timestamp = clock.getTime();
        String prevHash = tail.getHash();

        BasicBlock block = blockFactory.getNewBlock(lastId++, timestamp, prevHash);
        tail.setNext(block);
        tail = block;

        String hash = hashGenerator.getHash(tail.getStringForHashing());
        tail.setHash(hash);
    }

    @Override
    public boolean validateBlocks() {

        String prevHash = INITIAL_HASH;

        BasicBlock block = head;
        do {

            String currentHash = hashGenerator.getHash(block.getStringForHashing());

            if (!isValidBlock(prevHash, currentHash, block))
                return false;

            prevHash = currentHash;
            block = block.getNext();

        } while (block != tail);

        return true;
    }

    private boolean isValidBlock(String prevHash, String currentHash, BasicBlock block) {
        return block.getPrevHash().equals(prevHash) && block.getHash().equals(currentHash);
    }

    @NotNull
    @Override
    public Iterator<BasicBlock> iterator() {
        return new BlockChainIterator(head);
    }

    public class BlockChainIterator implements Iterator<BasicBlock>
    {
        BasicBlock current;

        public BlockChainIterator(BasicBlock current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public BasicBlock next() {
            BasicBlock block = current;
            current = current.getNext();
            return block;
        }
    }
}
