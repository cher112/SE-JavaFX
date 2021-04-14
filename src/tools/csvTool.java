package tools;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import vo.Live;
import vo.Student;
import vo.Trainer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

//javacsv 简单教程 io流就按这个写就好
public class csvTool{

    public static void cleanCur(String name){
        File file = new File("src/storage/"+name+".csv");
        try{
            boolean a = file.delete();
            a = file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String[] readCur(String name){
        //idea的相对路径是 src/else
        String filePath = "src/storage/"+name+".csv";
        String[] res = new String[100];
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);

            while (csvReader.readRecord()) {
                // 读表头
                System.out.println(csvReader.get(2));
                // 读一整行
                //System.out.println(csvReader.getRawRecord());
                // 读这行的特定列 get(column_index) 0-n-1
                res[0] = csvReader.get(0);
                res[1] = csvReader.get(1);
                res[2] = csvReader.get(2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
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

    public static Student[] searchStu(String text){
        String filePath = "src/storage/student.csv";
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
                    stu[i] = new Student(Sid,name, mail, pass, gender, year, height, weight, level, date,Tid);
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
    public static Trainer[] searchTrainer(String Text,int index){
        String filePath = "src/storage/trainer.csv";
        Trainer[] tra = new Trainer[100];
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
                int id = Integer.parseInt(csvReader.get(0));
                String mail = csvReader.get(1);
                String pass = csvReader.get(2);
                String gender = csvReader.get(3);
                String name = csvReader.get(4);
                String strength = csvReader.get(5);
                if(index == 0){
                    if(Objects.equals(Text, csvReader.get(0))){
                        tra[i] = new Trainer(id, mail, pass, gender, name,strength);
                        i++;
                        break;
                    }
                }else if(index ==1){
                    if(Objects.equals(Text, csvReader.get(5))){
                        tra[i] = new Trainer(id, mail, pass, gender, name,strength);
                        i++;
                    }
                }
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(i==0) return null;
        else return tra;
    }

    public static Live[] searchLive(int id,int index){
        String filePath = "src/storage/live.csv";
        Live[] lives = new Live[100];
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
                int Tid = Integer.parseInt(csvReader.get(1));
                String date = csvReader.get(2);
                System.out.println(Sid+Tid+date);
                if(index == 0){
                    if(Sid == id){
                        lives[i] = new Live(Sid,Tid,date);
                        i++;
                    }
                }else if(index ==1){
                    if(Tid == id){
                        lives[i] = new Live(Sid,Tid,date);
                        i++;
                    }
                }
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(i==0) return null;
        else return lives;

    }
}
