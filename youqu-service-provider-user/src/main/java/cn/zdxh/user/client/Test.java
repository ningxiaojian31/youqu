package cn.zdxh.user.client;

/**
 * @author ningxj
 * @date 2020-1-26 23:03
 */
public class Test {

    static void Count(int[] num){
        int[] result = new int[4];
        for (int i=0; i< num.length; i++) {
            int temp = num[i];
            for(int j=0; j< num.length; j++) {
                if(i != j) {
                    result[i] +=  num[j] - temp;
                }
            }
            System.out.println("result"+i+"="+result[i]);
        }
    }
    public static void main(String[] args){
        int[] num = new int[]{129,91,52,94};
        Count(num);
    }
}
