public class CoWorker {

    private static int nowID = 1;

    private static final int CURRENT_YEAR = 2020;

    private String FullName;
    private int Salary;
    private int BirthDay;
    private int ID;


    CoWorker(String FullName, int Salary, int BirthDay){

        this.FullName = FullName;
        this.Salary = Salary;
        this.BirthDay = BirthDay;
        this.ID = nowID;
        nowID += 1;

    }


    void setSalary(int Salary){
        this.Salary = Salary;
    }

    String getFullName(){
        return FullName;
    }
    int getSalary(){
        return Salary;
    }
    int getBirthDay(){
        return BirthDay;
    }
    int getAge(){
        return CURRENT_YEAR - BirthDay;
    }
    int getID(){
        return ID;
    }

}
