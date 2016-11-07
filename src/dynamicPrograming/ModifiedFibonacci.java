package dynamicPrograming;

import java.math.BigInteger;

public class ModifiedFibonacci {
	public static void main(String[] args) {
/*		Scanner scanner = new Scanner(System.in);
		int first = scanner.nextInt();
		int second = scanner.nextInt();
		int n = scanner.nextInt();*/
		
		int first = 0;
		int second = 1;
		int n = 5;
		
		BigInteger ti1 = BigInteger.valueOf(second);
		BigInteger ti2 = BigInteger.valueOf(first);
		BigInteger ti = BigInteger.ZERO;
		for (int i = 3; i <= n; i++) {
			ti = ti2.add(ti1.pow(2));
			ti2 = ti1;
			ti1 = ti;
		}
		System.out.println(ti.toString());
	}
}
