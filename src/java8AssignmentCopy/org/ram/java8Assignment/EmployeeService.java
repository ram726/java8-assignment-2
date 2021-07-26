package java8AssignmentCopy.org.ram.java8Assignment;
import java.util.List;
public interface EmployeeService {
	
	//program1
		public void addEmployeeRecord();
		public void displayEmployeeFromParticularDepartment(String departmentName);
		public double totalSalaryOfAllEmployees();
		public Employee displayEmployeeWithMaximumSalary();
		public void sortEmployeeByDepartmentInIncreaasingAndBySalariesInDecreasingOrder();
		
		//program2
		public void showEmployeePerDeparmentInMap();
		public void countTotalEmployeePerDepartment();
		public void countAverageSalariesPerDepartment();
		public List<Employee> first5EmployeeFromTheList();
		public void employeeFrom2ndIndexTo5thIndex();
}
