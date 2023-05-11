import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的分数");
        int grade = scanner.nextInt();
//        抛出异常条件
        if(grade>100||grade<0){
//            抛出异常
            throw new IllegalArgumentException("分数必须在0-100之间");
        }
        System.out.println("成绩为："+grade);

    }
}