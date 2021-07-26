package java8AssignmentCopy.org.ram.java8Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeServiceImpl implements EmployeeService {
	
	List<Employee> empList=new ArrayList();
	
	/*Adding Employee Record in the arraylist
	 * */
	public void addEmployeeRecord() {
		empList.add(new Employee("Sachin", "Tendulakr", "Sales", 15400));
		empList.add(new Employee("M.S.", "Dhoni", "IT", 85613));
		empList.add(new Employee("Virat", "Kohli", "Finance", 36415));
		empList.add(new Employee("Anil", "Kumble", "Sales", 69451));
		empList.add(new Employee("Irfan", "Pathan", "IT", 42156));
		empList.add(new Employee("Saurabh", "Ganguli", "Finance", 56946));
		empList.add(new Employee("Harbhajan", "Singh", "IT", 23514));
	}
	
	/*Create a method with one parameter department and print 
	 *the list of employees in that department
	 * */
	public void displayEmployeeFromParticularDepartment(String departmentName) {
		System.out.println("Employee who works in "+departmentName+" department is: ");
		
		List<Employee> list= empList.stream().filter(dept->dept
			.getDepartmentName()==departmentName)
	.collect(Collectors.toList());
			
	System.out.println(list);
		System.out.println("---------------------------------------------------------");
		
	}
	
	//Create a method to print the total Salaries of all employees	
	public double totalSalaryOfAllEmployees() {
		double sumSalary= empList.stream().mapToDouble(i->i.getSalary()).sum();
		System.out.println("Total salary of all Employees is: "+sumSalary);
		System.out.println("---------------------------------------------------------");
		return sumSalary;
	}
	
	/*Create a method to print the employee with the highest salary
	 * */
	@Override
	public Employee displayEmployeeWithMaximumSalary() {
		System.out.println("Employee With Highest Salary is: ");
		
	Employee e= empList.stream().max((s1,s2)->
	(s1.getSalary()<s2.getSalary())?-1:
			(s1.getSalary()>s2.getSalary())?1:0).get();
	System.out.println("maximum salary of "+e.getFirstName()+" "+e.getLastName()+
			" salary is :"+e.getSalary());
	
		System.out.println("---------------------------------------------------------");
		return e;
	}
	//using consumer interface to print employee information
			Consumer<Employee> consumer=e->{
				System.out.println(e.getFirstName()+" "+e.getLastName()+", "
									+e.getDepartmentName() +", "+e.getSalary());
			};
			
			
	//Create a method to sort and Print the List of employees by Department  
	//and then sort based on the decreasing order of their salaries 
		@Override
	public void sortEmployeeByDepartmentInIncreaasingAndBySalariesInDecreasingOrder() {
		
			//sorting department wise
		List<Employee>sortedDeptList = empList.stream().sorted((dept1,dep2)->
			dept1.getDepartmentName().compareTo(dep2.getDepartmentName()))
				.collect(Collectors.toList());
		
		//sorting decreasing salary wise		
		List<Employee>sortedSalaryList =empList.stream().sorted((sal1,sal2)->
		(sal1.getSalary()<sal2.getSalary())?1:
				(sal1.getSalary()>sal2.getSalary())?-1:0)
			.collect(Collectors.toList());
		
		System.out.println("Sorting Employee Record Department wise");
		for(Employee e:sortedDeptList) {
			consumer.accept(e); 				
		}
		System.out.println("****************");
		System.out.println("Sorting Employee Record decreasing salary wise");
		for(Employee e:sortedSalaryList) {
			consumer.accept(e); 				
		}
		System.out.println("---------------------------------------------------------");
	}

		//Create a method to print the list of employees per department
			//in a Map structure. So the output should be like below
			//Map("IT", List (Emp1, Emp2)); Map("Sales", List (Emp3, Emp4)); 
	@Override
	public void showEmployeePerDeparmentInMap() {
		System.out.println("list of employees per department in a Map structure");
		List<Employee> tempList=new ArrayList<>();
		Map<String, List<Employee>> map=empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentName));
		
		System.out.println(map);
		System.out.println("---------------------------------------------------------");
	}
		
	/*Create a method to count total employees per department
	 * */
	@Override
	public void countTotalEmployeePerDepartment() {
		System.out.println("Employees working in each deparment.");
		Map<String, Long> map= empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentName,
						Collectors.counting()));
		System.out.println(map);
		System.out.println("---------------------------------------------------------");
	}
	
	/*Create a method to print average salaries per department
	 * */
	public void countAverageSalariesPerDepartment() {
		System.out.println("Average salaries per deparment is");
		Map<String, Double> map= empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentName,
						Collectors
						.averagingDouble(i->i.getSalary())));
		System.out.println(map);
		System.out.println("---------------------------------------------------------");
	}
	
	/*Create a method to print the first 5 employees of the list
	(You have to create more employees in the original list to achieve this)*/
	@Override
	public List<Employee> first5EmployeeFromTheList() {
		System.out.println("first 5 employees of the list");
		List<Employee> list=empList.stream().limit(5)
				.collect(Collectors.toList());
		System.out.println(list);
		System.out.println("---------------------------------------------------------");
		return list;
		
	}
	
	/*Create a method to print the employees from 2nd index to 5th index 
	 * (You have to create more employees in the original list to achieve this)
	 * */
	@Override
	public void employeeFrom2ndIndexTo5thIndex() {
		System.out.println("employees from 2nd index to 5th index");
		IntStream.range(2,6).mapToObj(o->empList.get(o)).forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
	}
}