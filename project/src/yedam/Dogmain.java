package yedam;

import java.util.List;
import java.util.Scanner;

public class Dogmain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DogDAO dogDAO = new DogDAO();
        SchedulesDAO scheduleDAO = new SchedulesDAO();

        while (true) {
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
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1:
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

                        Dogs dogs = new Dogs(id, name, breed, age);

                        int result = dogDAO.insertDog(dogs); 
                        if (result > 0) {
                            System.out.println("🐶등록 완료");
                        } else {
                            System.out.println("❌등록 실패");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("숫자 형식이 올바르지 않습니다. 다시 입력하세요.");
                    }
                    break;
                    
                case 2:
                	System.out.println("====================================");
                	System.out.println("==========🐶 강아지 등록 조회==========");
                	System.out.println("===================================="); 
                    List<Dogs> dogList = dogDAO.getDogList();
                    for (Dogs d : dogList) {
                        System.out.println(d);
                    }
                    break;
                    
                case 3:
                	System.out.println("====================================");
            	    System.out.println("=========== 🏃‍ 산책 일정 추가=========");
            	    System.out.println("====================================");            
                	System.out.println("강아지 번호를 입력하세요>> ");
                	int DogId =Integer.parseInt(scn.nextLine());
                	System.out.println("산책 날짜>> ");
                	String dateTime =scn.nextLine();
                	System.out.println("장소 >>");
                	String location =scn.nextLine();
                	System.out.println("산책시간 >>");
                	int walktime =Integer.parseInt(scn.nextLine());
                	
                	 WalkSchedules ws = new WalkSchedules(DogId, dateTime, location, walktime);
                     int result = scheduleDAO.insert(ws);
                     if (result > 0) {
                         System.out.println("🐶등록 완료");
                     } else {
                         System.out.println("❌등록 실패");
                     }
                     break;
                     
                case 4:
                	System.out.println("====================================");
                	System.out.println("===========📋 산책 일정 조회=========");
                	System.out.println("====================================");
                	 List<WalkSchedules> walk = scheduleDAO.getWalkSchedules();
                     for (WalkSchedules walk1 : walk) {
                         System.out.println(walk1);
                     }
                     break;
                     
                case 5:
                	System.out.println("====================================");
                	System.out.println("=====  🏃‍ 강아지 번호로 산책일정 조회=====");
                	System.out.println("====================================");
                    System.out.print("강아지 번호를 입력하세요: ");
                    int dogId = Integer.parseInt(scn.nextLine());

                    SchedulesDAO dao = new SchedulesDAO();
                    List<String> schedules = dao.getSchedulesByDogId(dogId);

                    if (schedules.isEmpty()) {
                        System.out.println("해당 강아지의 산책 일정이 없습니다.");
                    } else {
                        for (String schedule : schedules) {
                            System.out.println(schedule);
                        }
                    }
                    break;

                     
                case 6: 
                	System.out.println("====================================");
                	System.out.println("===========🗑️ 산책 일정 삭제===========");
                	System.out.println("====================================");
                	System.out.print("삭제할 산책 일정의 강아지 번호를 입력하세요>> ");
                int deleteId = Integer.parseInt(scn.nextLine());
                System.out.print("삭제할 날짜/시간을 입력하세요  >> ");
                String deleteTime = scn.nextLine();
                int delResult = scheduleDAO.deleteSchedule(deleteId, deleteTime);
                if (delResult > 0) {
                    System.out.println("🐶해당 산책 일정이  삭제되었습니다!");
                } else {
                    System.out.println("❌산책일정이 삭제 실패했습니다.");
                }
                break;
                
                case 7:
                	System.out.println("====================================");
                	System.out.println("==========🗑️ 강아지 등록 삭제==========");
                	System.out.println("====================================");
                    System.out.print("삭제할 강아지 ID >> ");
                    int dogIdDelete = Integer.parseInt(scn.nextLine());

                    int delresult = dogDAO.deleteDog(dogIdDelete);
                    if (delresult > 0) {
                        System.out.println("🐶강아지 삭제 완료");
                    } else {
                        System.out.println("❌삭제 실패 ");
                    }
                    break;
                                                           	
                case 8:
                    System.out.println("프로그램 종료");
                    scn.close();
                    System.exit(0);
                    break;

                // 다른 메뉴도 추가 가능

             
            }
        }
    }
}