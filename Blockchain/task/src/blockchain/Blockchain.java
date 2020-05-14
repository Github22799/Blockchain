package blockchain;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Blockchain implements BasicBlockchain, Iterable<BasicBlock> {

    public static final String INITIAL_HASH = "0";
    private long lastId;

    private BasicHashGenerator hashGenerator;

    private BasicBlock head;
    private BasicBlock tail;

    public Blockchain(long lastId, BasicHashGenerator hashGenerator, BasicBlock head, BasicBlock tail) {
        this.lastId = lastId;
        this.hashGenerator = hashGenerator;
        this.head = head;
        this.tail = tail;
    }

    @Override
    public BasicBlock getLastBlock() {
        return tail;
    }

    @Override
    public void acceptNewBlock(BasicBlock block) {

        String blockHash = hashGenerator.getHash(block.getStringForHashing());

        if (!isValidLastBlock(block, blockHash))
            return;

        lastId++;

        tail.setNext(block);
        tail = block;
    }

    private boolean isValidLastBlock(BasicBlock block, String blockHash) {
        return  block.getId() == lastId + 1 &&
                tail.getHash().equals(block.getPrevHash()) &&
                blockHash.equals(block.getHash());
    }

    @Override
    public boolean validateBlocks() {

        String prevHash = INITIAL_HASH;

        BasicBlock block = head.getNext();

        while (block != null)
        {
            String currentHash = hashGenerator.getHash(block.getStringForHashing());

            if (!isValidLastBlock(prevHash, currentHash, block))
                return false;

            prevHash = currentHash;
            block = block.getNext();
        }

        return true;
    }

    private boolean isValidLastBlock(String prevHash, String currentHash, BasicBlock block) {
        return block.getPrevHash().equals(prevHash) && block.getHash().equals(currentHash);
    }

    @NotNull
    @Override
    public Iterator<BasicBlock> iterator() {
        return new BlockchainIterator(head);
    }

    public class BlockchainIterator implements Iterator<BasicBlock>
    {
        BasicBlock current;

        public BlockchainIterator(BasicBlock current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public BasicBlock next() {
            current = current.getNext();
            return current;
        }
    }
}
