package co.yedam;

/*
 * 사원번호, 이름, 전화번호, 입사일자, 급여 항목을 필드로 선언하고
 * 필요한 메소드를 정의하세요.
 */
public class Employee {
	public String empId;       // 사원번호
	public String name;        // 이름
	public String phone;       // 전화번호
	public String hireDate;    // 입사일자
	public int salary;		   // 급여
	
	
	public Employee() {
		
	}
	
	public Employee(String empId, String name, String phone, String hireDate, int salary) {
		this.empId= empId;
		this.name=name;
		this.phone =phone;
		this.hireDate =hireDate;
		this.salary =salary;
	}
	
	public Employee(String string,int i) {
		
	}


	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", phone=" + phone + ", hireDate=" + hireDate
				+ ", salary=" + salary + "]";
	}
}
