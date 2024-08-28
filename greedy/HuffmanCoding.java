import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

// Node class for Huffman Tree
class Node {
    char character;
    int frequency;
    Node left, right;

    // Constructor
    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = this.right = null;
    }
}

// Comparator for PriorityQueue to build the Huffman Tree
class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return Integer.compare(n1.frequency, n2.frequency);
    }
}

public class HuffmanCoding {

    // Function to build Huffman Tree and generate codes
    private static void buildHuffmanTree(char[] characters, int[] frequencies) {
        // Create a priority queue to build the Huffman Tree
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());

        // Build the initial heap with single-node trees
        for (int i = 0; i < characters.length; i++) {
            minHeap.add(new Node(characters[i], frequencies[i]));
        }

        // Merge nodes until only one node remains
        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();

            Node merged = new Node('-', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;

            minHeap.add(merged);
        }

        // Generate Huffman codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(minHeap.peek(), "", huffmanCodes);

        // Print Huffman Codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Recursive function to generate Huffman codes
    private static void generateHuffmanCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.character, code);
        }

        generateHuffmanCodes(root.left, code + '0', huffmanCodes);
        generateHuffmanCodes(root.right, code + '1', huffmanCodes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int numChars = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        char[] characters = new char[numChars];
        int[] frequencies = new int[numChars];

        // Input characters and frequencies from the user
        System.out.println("Enter the characters and their frequencies:");
        for (int i = 0; i < numChars; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            characters[i] = scanner.nextLine().charAt(0);
            System.out.print("Frequency of " + characters[i] + ": ");
            frequencies[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        // Build Huffman Tree and print Huffman Codes
        buildHuffmanTree(characters, frequencies);

        scanner.close();
    }
}




/*

Enter the number of characters: 4
Enter the characters and their frequencies:
Character 1: A
Frequency of A: 5
Character 2: B
Frequency of B: 9
Character 3: C
Frequency of C: 12
Character 4: D
Frequency of D: 13



Huffman Codes:
A: 110
B: 10
C: 0
D: 11


*/
