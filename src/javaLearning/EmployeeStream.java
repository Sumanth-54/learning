package javaLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
	String name;
	String city;
	int salary;

	public Employee(String name, String city, int salary) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}

}

public class EmployeeStream {
	// @SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {

		List<Employee> emp = Arrays.asList(new Employee("Sumanth", "Hyderabad", 100000),
				new Employee("Surendra", "Hyderabad", 90000), new Employee("Vinay", "Bangalore", 95000),
				new Employee("Ganesh", "Bangalore", 89000)
		// new Employee("Saketh", "Kodad")
		);

		Map<String, List<Employee>> collect = emp.stream().collect(Collectors.groupingBy(Employee::getCity));
		
		System.out.println(collect);

		Employee collect2 = emp.stream().sorted((a, b) -> b.getSalary() - a.getSalary()).collect(Collectors.toList())
				.getFirst();
		System.out.println(collect2);
		int[] arr = { 1, 2, 3, 1, 2, 3, 4, 5 };
		
		List<Integer> array = Arrays.stream(arr).filter(n -> n%2 == 0).boxed().collect(Collectors.toList());

		System.out.println(array);
		
		int[] distinct = Arrays.stream(arr).distinct().toArray();

		System.out.println(Arrays.toString(distinct));

	}

}
