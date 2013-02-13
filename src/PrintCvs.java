import java.io.FileWriter;
import java.io.IOException;
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
    private Set<WordAndCount> listWord;

    public PrintCvs(Set<WordAndCount> list){
        listWord = list;
    }

    public void generateCsvFile(String sFileName){
        try
        {
            FileWriter fileCsv = new FileWriter(sFileName);

            fileCsv.append("Слово");
            fileCsv.append(',');
            fileCsv.append("Частота");
            fileCsv.append(',');
            fileCsv.append("Процент");
            fileCsv.append('\n');

            Iterator it = listWord.iterator();
            WordAndCount current;
            while (it.hasNext()){
                current = (WordAndCount) it.next();

                fileCsv.append(current.getWord());
                fileCsv.append(',');
                fileCsv.write(current.getCount());
                fileCsv.append(',');
                fileCsv.append("Процент");
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
