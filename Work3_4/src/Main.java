public class Main {
    public static void main(String[] args) {
        MyDate birthday=new MyDate(2001,1,1);
        Employee employee=new Employee("pinkman",2020,birthday) {
//            必须重写抽象方法
            @Override
            public double earnings() {
                return 100;
            }
        };
        System.out.println(employee);
    }
}