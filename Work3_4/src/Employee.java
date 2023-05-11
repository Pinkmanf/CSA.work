/**
 * 抽象类
 */
abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    /**
     * 构造方法
     * @param name
     * @param number
     * @param birthday
     */
    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    //    toString输出json格式方法
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }

    /**
     * 抽象方法
     * @return
     */
    public abstract double earnings();
    


}
