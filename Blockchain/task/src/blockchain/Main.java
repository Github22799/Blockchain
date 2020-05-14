package blockchain;

public class Main {

    public static void generateBlocks(Blockchain blockchain, int numberOfBlocks) {
        BlockchainFactory factory = new BlockchainFactory(0);
        for (int i = 0; i < numberOfBlocks; i++)
            blockchain.acceptNewBlock(factory.generateNewBlock(blockchain));
    }

    public static void printBlockchain(Blockchain blockchain) {
        for (var block : blockchain)
            System.out.println("Block:\n" + block.toString());
    }

    public static void main(String[] args) {

        BlockchainFactory factory = new BlockchainFactory(0);
        var blockchain = factory.getNewBlockchain();

        generateBlocks(blockchain, 5);

        printBlockchain(blockchain);

        System.out.println(blockchain.validateBlocks());

    }
}
