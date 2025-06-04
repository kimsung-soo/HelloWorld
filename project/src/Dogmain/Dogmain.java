package Dogmain;

import java.util.List;
import java.util.Scanner;

import Dogvalue.Dogs;
import Dogvalue.WalkSchedules;
import dogDAO.DogDAO;
import dogDAO.SchedulesDAO;

// 메인 클래스: 강아지와 산책 일정 관리 콘솔 프로그램 실행
public class Dogmain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);  // 사용자 입력을 받기 위한 Scanner 객체 생성
        DogDAO dogDAO = new DogDAO();          // 강아지 관련 DB 작업을 처리하는 DAO 객체 생성
        SchedulesDAO scheduleDAO = new SchedulesDAO();  // 산책 일정 관련 DB 작업 DAO 객체 생성

      
        while (true) {
            // 메뉴 출력
            System.out.println("==============================");
            System.out.println("==== 🐾강아지 산책 스케줄러 🐾======");
            System.out.println("==============================");
            System.out.println("1. 강아지 등록");              
            System.out.println("2. 강아지 전체 목록 조회");      
            System.out.println("3. 산책 일정 등록");           
            System.out.println("4. 산책 일정 전체 조회");         
            System.out.println("5. 강아지 번호로 산책일정 조회");  
            System.out.println("6. 산책 일정 삭제");            
            System.out.println("7. 강아지 등록 삭제");           
            System.out.println("8. 종료");                      
            System.out.print("선택>>  ");

            // 메뉴 선택 입력 받기 (문자열 -> 정수 변환)
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1:  // 강아지 등록
                    System.out.println("====================================");
                    System.out.println("===========🐶 강아지 등록=============");
                    System.out.println("===================================="); 
                    try {
                      
                        System.out.print("강아지ID >> ");
                        int id = Integer.parseInt(scn.nextLine());  

                     
                        System.out.print("강아지 이름 >> ");
                        String name = scn.nextLine();

                    
                        System.out.print("강아지 품종 >> ");
                        String breed = scn.nextLine();

                     
                        System.out.print("강아지 나이 >> ");
                        int age = Integer.parseInt(scn.nextLine());

                        // 입력 받은 정보를 기반으로 Dogs 객체 생성
                        Dogs dogs = new Dogs(id, name, breed, age);

                        // DB에 강아지 등록 시도
                        int result = dogDAO.insertDog(dogs); 
                        if (result > 0) {
                            System.out.println("🐶등록 완료"); 
                        } else {
                            System.out.println("❌등록 실패"); 
                        }
                    } catch (NumberFormatException e) {
                        // 숫자 입력이 잘못된 경우 처리
                        System.out.println("숫자 형식이 올바르지 않습니다.");
                    }
                    break;

                case 2:  // 강아지 전체 목록 조회
                    System.out.println("====================================");
                    System.out.println("==========🐶 강아지 등록 조회==========");
                    System.out.println("===================================="); 
                    List<Dogs> dogList = dogDAO.getDogList();  // DB에서 전체 강아지 리스트 조회
                    for (Dogs d : dogList) {
                        System.out.println(d);  // 각 강아지 정보 출력 (toString() 호출)
                    }
                    break;

                case 3:  // 산책 일정 등록
                    System.out.println("====================================");
                    System.out.println("=========== 🏃‍ 산책 일정 추가=========");
                    System.out.println("====================================");            
                    System.out.println("강아지 번호를 입력하세요>> ");
                    int DogId = Integer.parseInt(scn.nextLine());  
                    System.out.println("산책 날짜를 입력하세요.>> ");
                    String dateTime = scn.nextLine();               
                    System.out.println("장소를 입력하세요. >>");
                    String location = scn.nextLine();               
                    System.out.println("산책시간을 입력하세요 >>");
                    int walktime = Integer.parseInt(scn.nextLine()); 

                    // WalkSchedules 객체 생성 (산책 일정 정보)
                    WalkSchedules ws = new WalkSchedules(DogId, dateTime, location, walktime);
                    int result = scheduleDAO.insert(ws);  // DB에 산책 일정 등록 시도
                    if (result > 0) {
                        System.out.println("🐶등록 완료");  
                    } else {
                        System.out.println("❌등록 실패");  
                    }
                    break;

                case 4:  // 산책 일정 전체 조회
                    System.out.println("====================================");
                    System.out.println("===========📋 산책 일정 조회=========");
                    System.out.println("====================================");
                    List<WalkSchedules> walk = scheduleDAO.getWalkSchedules();  // 모든 산책 일정 조회
                    for (WalkSchedules run : walk) {
                        System.out.println(run);  // 각 산책 일정 출력
                    }
                    break;

                case 5:  // 강아지 번호로 산책 일정 조회
                    System.out.println("====================================");
                    System.out.println("=====  🏃‍ 강아지 번호로 산책일정 조회=====");
                    System.out.println("====================================");
                    System.out.print("강아지 번호를 입력하세요: ");
                    int dogId = Integer.parseInt(scn.nextLine());  // 조회할 강아지 번호 입력

                    SchedulesDAO dao = new SchedulesDAO();
                    List<String> schedules = dao.getSchedulesByDogId(dogId);  // 해당 강아지 산책 일정 조회

                    if (schedules.isEmpty()) {
                        System.out.println("해당 강아지의 산책 일정이 없습니다.");  
                    } else {
                        for (String schedule : schedules) {
                            System.out.println(schedule);  // 일정 하나씩 출력
                        }
                    }
                    break;

                case 6:  // 산책 일정 삭제
                    System.out.println("====================================");
                    System.out.println("===========🗑️ 산책 일정 삭제===========");
                    System.out.println("====================================");
                    System.out.print("삭제할 산책 일정의 강아지 번호를 입력하세요>> ");
                    int deleteId = Integer.parseInt(scn.nextLine());  // 삭제할 강아지 ID 입력
                    System.out.print("삭제할 날짜를 입력하세요  >> ");
                    String deleteTime = scn.nextLine();  // 삭제할 산책 날짜/시간 입력
                    int delResult = scheduleDAO.deleteSchedule(deleteId, deleteTime);  // 삭제 시도
                    if (delResult > 0) {
                        System.out.println("🐶해당 산책 일정이  삭제되었습니다!");  
                    } else {
                        System.out.println("❌산책일정이 삭제 실패했습니다.");  
                    }
                    break;

                case 7:  // 강아지 등록 삭제
                    System.out.println("====================================");
                    System.out.println("==========🗑️ 강아지 등록 삭제==========");
                    System.out.println("====================================");
                    System.out.print("삭제할 강아지 ID >> ");
                    int dogIdDelete = Integer.parseInt(scn.nextLine());  // 삭제할 강아지 ID 입력

                    int delresult = dogDAO.deleteDog(dogIdDelete);  // 강아지 삭제 시도
                    if (delresult > 0) {
                        System.out.println("🐶강아지 삭제 완료"); 
                    } else {
                        System.out.println("❌삭제 실패 ");  
                    }
                    break;

                case 8:  // 프로그램 종료
                    System.out.println("프로그램 종료");
                    scn.close();  // Scanner 자원 해제
                    System.exit(0);  // 프로그램 종료
                    break;

                
            }
        }
    }
}
