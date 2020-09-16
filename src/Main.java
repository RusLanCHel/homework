public class Main {

    public static void main(String args[]){

        CoWorker a = new CoWorker("Иван Иванович Иванов", 50_000, 1995);
        System.out.printf("%s - Зарплата: %d, Возраст: %d.\n", a.getFullName(), a.getSalary(), a.getAge());

        CoWorker[] group = new CoWorker[5];
        group[0] = new CoWorker("b", 10_000, 1990);
        group[1] = new CoWorker("c", 20_000, 1985);
        group[2] = new CoWorker("d", 30_000, 1980);
        group[3] = new CoWorker("e", 40_000, 1975);
        group[4] = new CoWorker("f", 50_000, 1970);

        for(int i = 0; i < group.length; i++){
            if (group[i].getAge() > 40){
                System.out.printf("%s - Зарплата: %d, Возраст: %d.\n", group[i].getFullName(), group[i].getSalary(), group[i].getAge());
            }
        }
        System.out.println(averageOfSalary(group));
        System.out.println(averageOfAge(group));

        System.out.println(a.getID());
        System.out.println(group[1].getID());
        System.out.println(group[3].getID());


    }

    private static void upSalary(CoWorker[] group){
        for(int i = 0; i < group.length; i++){
            if(group[i].getAge() > 45){
                group[i].setSalary(group[i].getSalary() + 5000);
            }
        }
    }

    private static float averageOfSalary(CoWorker[] group){

        int sm = 0;
        for(int i = 0; i < group.length; i++){
            sm += group[i].getSalary();
        }

        return (float) (sm * 1.0 / group.length);

    }
    private static float averageOfAge(CoWorker[] group){

        int sm = 0;
        for(int i = 0; i < group.length; i++){
            sm += group[i].getAge();
        }

        return (float) (sm * 1.0 / group.length);

    }

}
