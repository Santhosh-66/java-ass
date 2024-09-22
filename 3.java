public class TextJustification {    
    public static String[] fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int currentIndex = 0;
        String[] result = new String[n];  
        int resultIndex = 0;
        while (currentIndex < n) {
            int totalChars = words[currentIndex].length();
            int last = currentIndex + 1;
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            int numberOfWords = last - currentIndex;
            StringBuilder line = new StringBuilder()
            if (last == n || numberOfWords == 1) {
                for (int i = currentIndex; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalSpaces = maxWidth - totalChars + (numberOfWords - 1);
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);
                for (int i = currentIndex; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= spacesBetweenWords; j++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result[resultIndex++] = line.toString();
            currentIndex = last;
        }
        String[] finalResult = new String[resultIndex];
        for (int i = 0; i < resultIndex; i++) {
            finalResult[i] = result[i];
        }        
        return finalResult;
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        String[] justifiedText = fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}
