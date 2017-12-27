package homework;

import java.io.File;

public class FileCounter {
	private static int amount = 0;

	public static void main(String[] args) {
		String path = "C:\\Program Files (x86)";
		System.out.println(countFiles(path));
	}

	public static int countFiles(String path) {
		if (path == null) {
			return 0;
		}
		File file = new File(path);
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				countFiles(path + "/" + f.getName());
			}
			if (f.isFile()) {
				amount++;
			}
		}
		return amount;
	}

}
