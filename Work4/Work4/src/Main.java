
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        System.out.println("第一题");
        System.out.println(reverse(-231231));
        System.out.println("第二题");
        System.out.println(climbStairs(3));
        System.out.println("第三题");
        int[] nums={1,2};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.print("[");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

    }

    public static int reverse(int n){
//        标记正数负数
        int sign=n>=0?1:-1;

        n=Math.abs(n);

//        整型转换为字符串
        String str=Integer.toString(n);

        StringBuilder stringBuilder=new StringBuilder(str).reverse();

//        字符串转换为整型
        try {
            int x=Integer.parseInt(stringBuilder.toString());
            return sign*x;
        } catch (NumberFormatException e) {
//            抛出异常
            return 0;
        }
    }

//    动态规划
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
//如果最后一步爬了1个台阶，那么前面剩下的台阶数就是n-1个台阶，方法数为F(n-1)。
//如果最后一步爬了2个台阶，那么前面剩下的台阶数就是n-2个台阶，方法数为F(n-2)。
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


//    回溯算法
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
//        添加子集
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
//            从start索引开始遍历数组nums，对于每个元素，将其添加到子集中，并以当前元素的下一个索引作为新的start值递归调用backtrack函数。
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, result);
//            最后添加的元素从子集中移除，以便尝试其他元素的选择。
            subset.remove(subset.size() - 1);
        }
    }
}
