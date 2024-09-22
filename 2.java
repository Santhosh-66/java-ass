public class WordEncryption {
    public static String encryptString(String input1, int input2) {
        StringBuilder encrypted = new StringBuilder();
        String[] words = input1.split(" "); // Split the input into words
        for (String word : words) {
            encrypted.append(encryptWord(word, input2)).append(" "); // Encrypt each word
        }
        return encrypted.toString().trim(); // Return the encrypted string
    }
    private static String encryptWord(String word, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                char encryptedChar = encryptCharacter(ch, key);
                result.append(encryptedChar);
            } else {
                result.append(ch); // If it's not a letter, keep it as is
            }
        }
        return result.toString();
    }
    private static char encryptCharacter(char ch, int key) {
        boolean isLower = Character.isLowerCase(ch);
        int charValue = isLower ? ch - 'a' : ch - 'A'; // Calculate base 0 character value
        int encryptedValue = (charValue + key) % 26; // Encryption formula
        char encryptedChar = (char) (encryptedValue + (isLower ? 'A' : 'a'));
        return encryptedChar;
    }
    public static void main(String[] args) {
        WordEncryption encryption = new WordEncryption();
        String input1 = "Wipro Tech";
        int input2 = 20;
        System.out.println("Encrypted string: " + WordEncryption.encryptString(input1, input2)); 
    }
}
