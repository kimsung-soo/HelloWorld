package co.yedam;


import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		// 앱을 실행하는 클래스.
		EmpDAO dao = new EmpDAO();

		// 사용자의 입력을 처리하도록 작성하세요.
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			// 이곳에 메뉴작성.
			// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료
			System.out.println("----------------------------------------------------");
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.println("선택 >>");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("사번입력>> ");
				String empId = scn.nextLine();

				System.out.println("이름입력>> ");
				String name = scn.nextLine();

				System.out.println("전화번호입력>> ");
				String phone = scn.nextLine();

				System.out.println("입사일입력>> ");
				String hireDate = scn.nextLine();

				System.out.println("급여입력>> ");
				int salary = Integer.parseInt(scn.nextLine());

				Employee emp = new Employee(empId, name, phone, hireDate, salary);
				dao.add(emp);
				System.out.println("등록 완료.");
				break;

			case 2:
			    System.out.println("사원 목록:");
			    System.out.println("사번    이름     전화번호  ");
			    for (Employee list : dao.list()) {
			        System.out.printf(" %s  %s  %s\n", 
			        		list.getEmpId(), list.getName(), list.getPhone());							
			    }
			    break;

			case 3:
				try {
					System.out.print("수정할 사번>> ");
					  String id = scn.nextLine();
			            Employee change = dao.Id(id);

					if (change!= null) {
						System.out.print("사번 급여>> ");
						int sal = Integer.parseInt(scn.nextLine());
						change.setSalary(sal);
						
						if (dao.update(change)) {
							System.out.println("급여 수정 완료");
						} else {
							System.out.println(" 급여 수정 실패");
						}
					}
				} catch (Exception e) {
				}
				break;

			case 4:
				System.out.print("사번 >>> ");
				String deleteId = scn.nextLine();

				if (dao.delete(deleteId)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;

			case 5:
			    System.out.print("입사일자>> ");
			    String date = scn.nextLine();

			    for (Employee day : dao.list()) {
			        if (day.getHireDate().equals(date)) { 
			            System.out.printf(" %s  %s   %s\n", 
			                day.getEmpId(), day.getName(),  day.getHireDate());							
			        }
			    }
			    break;
				
			case 6:
				System.out.println("프로그램을 종료합니다.");
				scn.close();
				return;

			}// end of switch

		}
		System.out.println("end of prog.");
	} // end of main.
}
