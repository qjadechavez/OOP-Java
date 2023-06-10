import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Comment

public class Dictionary {
    private Set<String> wordSet;

    public Dictionary() {
        wordSet = new HashSet<>();
    }

    public void loadDictionaryFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    wordSet.add(word.toLowerCase());
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found.");
        }
    }

    public void addWord(String word) {
        wordSet.add(word.toLowerCase());
    }

    public boolean containsWord(String word) {
        return wordSet.contains(word.toLowerCase());
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.loadDictionaryFromFile("dictionary.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search in the dictionary: ");
        String userWord = scanner.nextLine();

        if (dictionary.containsWord(userWord)) {
            System.out.println("The word exists in the dictionary.");
        } else {
            System.out.println("The word does not exist in the dictionary.");
        }

        scanner.close();
    }
}
