package tools;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import vo.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

//javacsv 简单教程 io流就按这个写就好
public class csvstreamTool implements csvstream{

    private static Object Student;

    public static void read(String name){
        //idea的相对路径是 src/else
        String filePath = "src/storage/"+name;

        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);

            // 读表头
            csvReader.readHeaders();
            System.out.println(csvReader.getHeader(0)+"         "+csvReader.getHeader(1));
            while (csvReader.readRecord()){
                // 读一整行
                //System.out.println(csvReader.getRawRecord());
                // 读这行的特定列 get(column_index) 0-n-1
                System.out.print(csvReader.get(0));
                System.out.print("    ");
                System.out.print(csvReader.get(1));
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String name,String[] str){
        //用string数组按行写入csv

        String filePath = "src/storage/"+name+".csv";
        File f = new File(filePath);
        try {

            // 创建CSV写对象
            BufferedWriter writer = new BufferedWriter(new FileWriter(f,true));
            //用java.io不覆盖写csv
            CsvWriter csvWriter  = new CsvWriter(writer,',');
            //覆盖写csv
            //CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            // csv的表头和内容没区别，规定好数据就不需要写表头了
            csvWriter.writeRecord(str,false);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create(String name){
        File file = new File("src/storage/"+name+".csv");
        try{
            if(!file.exists()){
                boolean a = file.createNewFile();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Student[] search(String text){
        String filePath = "src/storage/test.csv";
        Student[] stu = new Student[100];
        int i = 0;
        int j = 0;
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);

            // 读表头
            csvReader.readHeaders();
            //System.out.println(csvReader.getHeader(0)+"         "+csvReader.getHeader(1));
            while (csvReader.readRecord() && j<100){
                // 读一整行
                //System.out.println(csvReader.getRawRecord());
                // 读这行的特定列 get(column_index) 0-n-1
                int Sid = Integer.parseInt(csvReader.get(0));
                String name = csvReader.get(1);

                if(Objects.equals(name, text)){
                    String mail = csvReader.get(2);
                    String pass = csvReader.get(3);
                    String gender = csvReader.get(4);
                    int year = Integer.parseInt(csvReader.get(5));
                    int height = Integer.parseInt(csvReader.get(6));
                    int weight  = Integer.parseInt(csvReader.get(7));
                    int level = Integer.parseInt(csvReader.get(8));
                    String date = csvReader.get(9);
                    int Tid = Integer.parseInt(csvReader.get(10));
                    stu[i] = new Student(Sid,name, mail, pass, gender, year, height, weight, level, date);
                    i++;
                }
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(i==0) return null;
        else return stu;
    }
}
