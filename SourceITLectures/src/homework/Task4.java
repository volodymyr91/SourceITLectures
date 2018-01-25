package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Callable;

public class Task4 {
	static int a[][];

	public static void main(String[] args) throws InterruptedException {
		int m = 4;
		int n = 100;
		a = new int[m][n];
		Random rand = new Random();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = rand.nextInt(1000);
			}
		}

		long iniTime = System.currentTimeMillis();

		int maxValue = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				Thread.sleep(1);
				if (a[i][j] > maxValue) {
					maxValue = a[i][j];
				}
			}
		}

		System.out.println("max value(hard version):" + maxValue);
		System.out.println("time ms:" + (System.currentTimeMillis() - iniTime));

		Task4 t4 = new Task4();
		ArrayList<Integer> array = new ArrayList<Integer>();
		iniTime = System.currentTimeMillis();
		for (int i = 0; i < m; i++) {
			array.add((t4.new ThreadTask4(i)).call());
		}
		System.out.println("max value:" + Collections.max(array));
		System.out.println("time ms:" + (System.currentTimeMillis() - iniTime));
	}

	private class ThreadTask4 implements Callable<Integer> {
		int id;

		public ThreadTask4(int i) {
			id = i;
		}

		public Integer call() {
			int maxValue = a[id][0];
			try {
				for (int i = 1; i < a[id].length; i++) {
					Thread.sleep(1);
					if (maxValue < a[id][i]) {
						maxValue = a[id][i];
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return maxValue;
		}
	}
}
