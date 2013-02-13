import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 11.02.13
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class TextParsing {

    public static void main(String[] arg) throws IOException {
        //System.setProperty("encoding","1551");

        Reader in = null;
        BufferedReader br = null;
        int length = 0;
        HashSet<WordAndCount> wordList = new HashSet<>();

            try {
                in = new InputStreamReader(new BufferedInputStream((new FileInputStream(arg[0]))));
                File f = new File(arg[0]);
                length = (int) f.length();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Файл не найден");
            }

        StringBuilder incompleteWord = new StringBuilder();
        char symbol = '!';
        
        for(int i = 0; i <= length; i++){
            symbol = (char) in.read();
            if (Character.isLetterOrDigit(symbol)){
                incompleteWord.append(symbol);
            }else {
                String completeWord = incompleteWord.toString();              //сформировал слово
                incompleteWord.delete(0, completeWord.length());
                WordAndCount word = new WordAndCount(completeWord);

                if ( !wordList.contains(word)){                               //если слова нет, то добавить в список
                    wordList.add(word);
                }
                else{                                                         //если такое слово есть, то увеличить счетчик
                    Iterator it = wordList.iterator();
                    WordAndCount current;
                    while (it.hasNext()){
                        current = (WordAndCount) it.next();
                        if ( current.equals(word) ){
                            current.addCount();
                            break;
                        }
                    }
                }
            }
        }

        TreeSet<WordAndCount> orderList = new TreeSet<>();
        Iterator iter = wordList.iterator();
        WordAndCount current;

        while (iter.hasNext()){
            current = (WordAndCount) iter.next();
            orderList.add(current);
        }

        PrintCvs pc = new PrintCvs(orderList);

        pc.generateCsvFile("C:\\Text\\result.cvs");


    }
}
