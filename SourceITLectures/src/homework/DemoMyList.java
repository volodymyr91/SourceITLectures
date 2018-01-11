package homework;

public class DemoMyList {
	public static void main(String[] args) {
		testList();
		// testList2();
	}

	private static void testList() {
		DefaultMyList<Integer> intList = new DefaultMyList<>();
		intList.add(10);
		intList.add(2);
		intList.add(7);
		intList.add(37);
		intList.add(8);
		System.out.println(intList.size() + " size");
		System.out.println(intList.remove(6) + " removed");
		System.out.println(intList.remove(7) + " removed");
		System.out.println(intList.size() + " size");
		System.out.println(intList.contains(37));
		DefaultMyList<Integer> intList2 = new DefaultMyList<>();
		intList2.add(2);
		intList2.add(37);
		intList2.add(10);
		System.out.println(intList.containsAll(intList2) + " containsAll");
		System.out.println(intList);
		intList2.clear();
		System.out.println("After clear():" + "\n" + intList2);
	}

	private static void testList2() {
		DefaultMyList<String> strList = new DefaultMyList<>();
		strList.add("Hello");
		strList.add("Hola");
		strList.add("Hallo");
		strList.add("Hi");
		strList.add("Ahoy");
		System.out.println(strList.remove("Hi"));
		System.out.println(strList.remove("Privet"));
		System.out.println(strList.contains("Hallo"));
		System.out.println(strList);
	}
}
