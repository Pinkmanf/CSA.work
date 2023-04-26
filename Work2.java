package org.example;

import java.util.ArrayList;
import java.util.List;

public class Work2 {
    public static void main(String[] args) {

        System.out.println("<-------第一题------->");
        Monkey monkey = new Monkey("吉吉国王");
        People people = new People("张三");

        monkey.speak();
        people.speak();
        people.think();

        System.out.println("<-------第二题------->");
        Car car = new Car((byte) 4, 1400.0, (byte) 5);
        car.setActualLoader((byte) 6);
        car.display();

        System.out.println("---------------------------------");
        Truck truck = new Truck((byte) 6, 17000, (byte) 3, 5000);
        truck.setActualLoader((byte) 3);
        truck.setActualPayload(6000);
        truck.display();

        System.out.println("<-------第三题------->");
        String a = "2131243249", b = "13324897393";
        System.out.println(a + "+" + b + "=" + getSum(a, b));


        System.out.println("<-------第四题------->");
        System.out.println("矩形为7x3时，到达右下角的不同路径有：" + uniquePaths(7, 3) + "条");

        System.out.println("<-------第五题------->");
        String[] strs={"abcd","abstract","about","abroad"};
        System.out.println("公共前缀为:"+longestCommonPrefix(strs));

    }

    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        List<Integer> lc = new ArrayList<Integer>();
        String c = "";
//        将a和b都转化为整型并按顺序存入arrayList
        for (int i = a.length() - 1; i >= 0; --i) {
            la.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');
        }
//        用于进位
        int carry = 0;
        int i = 0;
        while (i < la.size() || i < lb.size() || carry != 0) {
//            判断是否超过了arrayList的长度
            int x = i < la.size() ? la.get(i) : 0;
            int y = i < lb.size() ? lb.get(i) : 0;
            int sum = x + y + carry;
//            将和的个位加入arrayList
            lc.add(sum % 10);
//            计算进位
            carry = sum / 10;
            i++;
        }
//        将arrayList的值转化为String类型
        StringBuilder sb = new StringBuilder();
        for (int j = lc.size() - 1; j >= 0; j--) {
            sb.append(lc.get(j));
        }
        c = sb.toString();
        return c;
    }

    public static int uniquePaths(int m, int n) {
//        动态规划方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[][] dp = new int[m][n];
//        只右移可到的点的路径都只有一种
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
//        只下移可到的点的路径都只有一种
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

//        动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
//        判断strs是否为空
        if(strs==null||strs.length==0){
            return  "";
        }
        ans=strs[0];
        for (int i = 1; i < strs.length; i++) {
//            如果没有找到公共前缀就将前缀缩减一位
            while (strs[i].indexOf(ans)!=0){
                ans=ans.substring(0, ans.length()-1);
//                如果缩减到前缀为空后则代表没有前缀
                if(ans.isEmpty()){
                    return "";
                }
            }
        }

        return ans;
    }


}

class Monkey {
    private String name;

    public Monkey(String s) {
        this.name = s;
    }

    public void speak() {
        System.out.println("咿咿呀呀........");
    }
}

class People extends Monkey {

    public People(String s) {
        super(s);
    }

    //    重写父类中的方法
    @Override
    public void speak() {
        System.out.println("小样儿，不错嘛！会说话了！！！");
    }

    public void think() {
        System.out.println("别说话!认真思考!");
    }
}

class Vehicle {
    private byte wheels;
    private double weight;

    //    构造方法
    public Vehicle(byte wheels, double weight) {
        this.weight = weight;
        this.wheels = wheels;
        System.out.println("车轮的个数是:" + wheels + " 车重:" + weight + "kg");
    }

}

class Car extends Vehicle {
    private byte loader;
    private byte actualLoader;

    public Car(byte wheels, double weight, byte loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    public void setActualLoader(byte actualLoader) {
        this.actualLoader = actualLoader;
    }

    public byte getActualLoader() {
        return actualLoader;
    }


    public void display() {
        System.out.print("这是一辆小车，能载" + loader + "人，实载" + getActualLoader() + "人");
//        判断是否超员
        if (getActualLoader() > loader) {
            System.out.println(",你超员了！！！");
        } else {
            System.out.println();
        }
    }
}

class Truck extends Vehicle {
    private byte loader;
    private double payload;
    private byte actualLoader;
    private double actualPayload;

    public Truck(byte wheels, double weight, byte loader, double payload) {
        super(wheels, weight);
        this.loader = loader;
        this.payload = payload;
    }

    public void setActualLoader(byte actualLoader) {
        this.actualLoader = actualLoader;
    }

    public void setActualPayload(double actualPayload) {
        this.actualPayload = actualPayload;
    }

    public byte getActualLoader() {
        return actualLoader;
    }

    public double getActualPayload() {
        return actualPayload;
    }

    public void display() {
        System.out.print("这是一辆卡车，能载" + loader + "人，实载" + getActualLoader() + "人");
        if (getActualLoader() > loader) {
            System.out.println(",你超员了！！！");
        } else {
            System.out.println();
        }
        System.out.print("这是一辆卡车，核载" + payload + "kg，你已装载" + getActualPayload() + "kg");
//        判断是否超载
        if (getActualPayload() > payload) {
            System.out.println(",你超载了！！！");
        } else {
            System.out.println();
        }

    }
}

