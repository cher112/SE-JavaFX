import vo.Student;
import tools.csvstreamTool;
import vo.Trainer;

public class Test{
    public static void main(String[] args){
        //Student a = new Student(1,"chen zhi","wsds123e);
        //csvstreamTool.write("CurUser", new String[]{"3","qiyelin123","1563270359@qq.com","amaK0qWs","male","21","180","70","1","2021-10-10,3"});
        //csvstreamTest.read("test.csv");
        //Student[] stu = csvstreamTool.search("qiyelin123");
        //System.out.println(stu[0].getPass());
        //Trainer[] t = csvstreamTool.searchTrainer("1",0);
        csvstreamTool.cleanCur("CurLive");
        //csvstreamTest.create("chenzhi");
    }
}