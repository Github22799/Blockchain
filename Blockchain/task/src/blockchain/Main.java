package blockchain;

public class Main {

    public static void generateBlocks(Blockchain blockchain, int numberOfBlocks) {
        for (int i = 0; i < numberOfBlocks; i++)
            blockchain.generateNewBlock();
    }

    public static void printBlockchian(Blockchain blockchain) {
        for (var block : blockchain)
            System.out.println("Block:\n" + block.toString());
    }

    public static void main(String[] args) {

        BlockchainFactory factory = new BlockchainFactory();
        var blockchain = factory.getNewBlockchain();

        generateBlocks(blockchain, 5);

        printBlockchian(blockchain);

        // System.out.println(blockchain.validateBlocks());

    }
}
