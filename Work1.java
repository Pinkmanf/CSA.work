import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Work1 {
    public static void main(String[] args) {
//        选择题答案
        System.out.println("1.B 2.B 3.D 4.B 5.D");


//        因为main方法是static方法,static方法可以在没有对象实例的时候直接调用，故可以直接调用main方法,但是因为没有对象实例,所以不能调用非静态方法。
//        函数有返回值时需要定义一个值去等于这个返回值


//        1.打印三角
        showTriangle(6);
//        2.颠倒字符串
        reverseString("abcdefg");
//        3.判断回文数
        isPalindrome(33211233);
//        4.水仙花数
        ShuiXianHua();
//        5、编写程序计算一个包含10个整数的数组中所包含元素的最小值和最大值之和
        arraysDemo();
    }

    public static void showTriangle(int n) {
        for (int i = 1; i <= n; i++) {
//            画出左边的空格
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
//            画出左边的*
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
//            画出右边的*
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void reverseString(String s) {
        char[] chars = s.toCharArray(); // 字符串转化为字符数组
//        数组最左边
        int left = 0;
//        数组最右边=长度-1
        int right = chars.length - 1;
        char temp;
//        交换值
        while (left <= right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        String s1 = String.valueOf(chars);//字符数组转化为字符串

        System.out.println(s+"字符串颠倒后为"+s1);
    }

    public static void isPalindrome(int num) {
        boolean flag = false;
        int a = 0;
        int n = num;
//        颠倒整数
        do {
//            分解整数的个十百位
            a = a * 10 + num % 10;
            num /= 10;
        } while (num > 0);
        if (n == a) {
            flag = true;
        }
        if (flag) {
            System.out.println(n+"是回文数");
        } else
            System.out.println(n+"不是回文数");
    }

    public static void ShuiXianHua() {
        int g = 0, s = 0, b = 0, temp , num;
//        创建ArrayList存水仙花数
        List<Integer> nums = new ArrayList<>();
        System.out.print("水仙花数有：");
        for (num = 100; num < 1000; num++) {
//            分解整数的个十百位
            temp=num;
            g = temp % 10;
            temp /= 10;
            s = temp % 10;
            b = temp / 10;
//            判断是不是水仙花数
            if (num == Math.pow(g, 3) + Math.pow(s, 3) + Math.pow(b, 3)) {
//                添加水仙花数进ArrayList
                nums.add(num);
            }
        }
        for (Integer value : nums) {
            System.out.print(value+" ");
        }
        System.out.println();
    }
    public static void arraysDemo() {
        int temp=0,j=0,max=0,min=0;
        int[] a = new int[10];
//        随机生成数组
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            a[i]= random.nextInt(0,100);
        }
        System.out.print("随机生成的数组为：");
        for (int value :
                a) {
            System.out.print(value+" ");
        }
        System.out.println();
        max=min=a[0];
//        判断数组的最大值和最小值
        while (j<9){
            j++;
            if (a[j]>max){
                max=a[j];
            } else if (a[j]<min) {
                min=a[j];
            }
        }
        System.out.println("最大值为："+max+"  最小值为："+min);
        System.out.println("最大值和最小值之和为："+(max+min));
    }
}
