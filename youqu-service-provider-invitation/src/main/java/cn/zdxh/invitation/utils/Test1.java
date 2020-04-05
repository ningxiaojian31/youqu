package cn.zdxh.invitation.utils;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        String arg1 = scanner.nextLine();
        String arg2 = scanner.nextLine();
        String[] opts = arg1.split(" ");
        String[] res = arg2.split(" ");
        String[] lines = null;
        if (opts != null && opts.length == 2){
            int number = Integer.valueOf(opts[1]);
            lines = new String[number];
            Scanner sc = new Scanner(System.in);
            for (int i = 0 ; i < number; i++){
                lines[i] = sc.nextLine();
            }
        }
        for (int i = 0;i < lines.length;i++){
            String[] result = lines[i].split(" ");
            if ("Q".equals(result[0])){
                //取最大
                String temp = "0";
                for (int n = Integer.valueOf(result[1]) - 1; n < Integer.valueOf(result[2]); n++){
                    if (Integer.valueOf(temp) < Integer.valueOf(res[n])){
                        temp = res[n];
                    }
                }
                System.out.println(temp);
            } else if ("U".equals(result[0])) {
                //替换
                res[Integer.valueOf(result[1]) - 1] = result[2];
            }
        }
    }
}
