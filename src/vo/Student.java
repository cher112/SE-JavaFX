package vo;

public class Student {
    private int id;
    private String name;
    private String pass;
    public Student(int a,String b,String c){
        id = a;
        name = b;
        pass = c;
    }
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setPass(String pass){this.pass = pass;}
    public String getPass() {return pass;}
}
