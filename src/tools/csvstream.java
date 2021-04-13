package tools;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.nio.charset.Charset;
public interface csvstream {

    static void read(String name){}

    static void write(String name, String[] str){}
}
