package homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextEditor {
	public static void main(String[] args) {
		try {
			edit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void edit() throws IOException {
		try (Scanner sc = new Scanner(System.in);) {
			Path file = Paths.get("C:\\git\\SourceITLectures\\build\\classes\\homework\\myfile.txt");
			String userValue = "";
			while (!userValue.equals("exit\r\n")) {
				Files.write(file, userValue.getBytes(), StandardOpenOption.APPEND);
				userValue = sc.nextLine() + "\r\n";
			}
			getStat();
		}
	}

	public static void getStat() throws IOException {
		Path file = Paths.get("C:\\git\\SourceITLectures\\build\\classes\\homework\\myfile.txt");
		Stream<String> stream = Files.lines(file);
		stream.forEach(System.out::println);
	}
}
