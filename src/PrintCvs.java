import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 13.02.13
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class PrintCvs {
    private Collection<WordAndCount> listWord;
    private int generalCount;

    public PrintCvs(Collection<WordAndCount> list, int num){
        listWord = list;
        generalCount = num;
    }

    public void generateCsvFile(String sFileName){
        try
        {
            FileWriter fileCsv = new FileWriter(sFileName);

            fileCsv.append("Слово");
            fileCsv.append('\t');
            fileCsv.append("Частота");
            fileCsv.append('\t');
            fileCsv.append("Процент");
            fileCsv.append('\n');

            Iterator it = listWord.iterator();
            WordAndCount current;
            while (it.hasNext()){
                current = (WordAndCount) it.next();

                fileCsv.append(current.getWord());
                fileCsv.append('\t');
                fileCsv.append(String.valueOf(current.getCount()));
                fileCsv.append('\t');
                fileCsv.append(String.valueOf(100.f * current.getCount()/generalCount));
                fileCsv.append('\n');

            }
            fileCsv.flush();
            fileCsv.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
