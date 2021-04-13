import vo.Student;
import tools.csvstreamTool;
public class Test{
    public static void main(String[] args){
        //Student a = new Student(1,"chen zhi","wsds123e);
        //csvstreamTest.write("test.csv", new String[]{"4","YAGHO"});
        //csvstreamTest.read("test.csv");
        Student[] stu = csvstreamTool.search("chee");
        System.out.println(stu[0].getPass());
        //csvstreamTest.create("chenzhi");
    }
}