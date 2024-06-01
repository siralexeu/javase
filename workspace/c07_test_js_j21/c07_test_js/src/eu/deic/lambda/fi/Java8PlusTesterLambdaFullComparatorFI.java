package eu.deic.lambda.fi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class Java8PlusTesterLambdaFullComparatorFI {

	public static void main(String[] args) {
		List<String> names1 = new ArrayList<String>();
		names1.add("Mary ");
		names1.add("Sam ");
		names1.add("Robert ");
		names1.add("Nick ");

		List<String> names2 = new ArrayList<String>();
		names2.add("Mary ");
		names2.add("Sam ");
		names2.add("Robert ");
		names2.add("Nick ");

		sortUsingJava7(names1);
		System.out.println(names1);

		sortUsingJava8(names2);
		System.out.println(names2);
		
		
		//BiConsumer Example
        BiConsumer<String,Integer> printKeyAndValue
                = (key,value) -> System.out.println(key+"-"+value);

        printKeyAndValue.accept("One",1);
        printKeyAndValue.accept("Two",2);

        System.out.println("##################");

        // Java 8+ Predefined Functional Interfaces
        //Java Hash-Map foreach supports BiConsumer
        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);

        dummyValues.forEach((key,value) -> System.out.println(key+"-"+value));

        System.out.println("##################");
        dummyValues.forEach(printKeyAndValue);

	}

	// sort using java 7
	private static void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// sort using java 8
	private static void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

}
