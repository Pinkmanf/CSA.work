import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("请输入N");
        int sum = 0,num=0,count=0;
        int N=scanner.nextInt();
        for (int i = 0; i < N; i++) {
            try {
                System.out.println("请输入第"+(i+1)+"个整数");
                num=isPositive(scanner);
//                求和
                sum+=num;
                count++;
            } catch (Exception e) {
//                抛出异常并且i减1，重新加入循环
                System.out.println("必须是正数或者0");
                i--;
            }


        }
        double result=(double) sum/count;
        System.out.println("结果为"+result);
    }

    /**
     * 判断是否为0或正数
     * @param scanner
     * @return
     */
    public static int isPositive(Scanner scanner){
        int result=scanner.nextInt();
        if (result <0) {
//            抛出异常
            throw new IllegalArgumentException("必须是正数或者0");
        }
        return result;
    }
}