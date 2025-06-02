package javaLearning;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapByValue {

	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<String, Integer>();

		hm.put("Alice", 24);
		hm.put("Udit", 23);
		hm.put("saketh", 21);
		hm.put("Ali", 26);

		
		//using lambda
		Map<Object, Object> collect = hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (e1, e2) -> e1,
						() -> new LinkedHashMap<>()));
		collect.forEach((key, value) -> System.out.println(key + " " + value));

		
		// using method reference
		Map<Object, Object> collect1 = hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		collect1.forEach((key, value) -> System.out.println(key + " " + value));

		
		//Into List
		List<Entry<String, Integer>> collect2 = hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());

		collect2.forEach(t -> System.out.println(t));
	}

}
