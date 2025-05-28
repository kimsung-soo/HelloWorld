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
            System.out.println("5. 산책 일정 삭제");
            System.out.println("6. 강아지 등록 삭제");
            System.out.println("7. 종료");
            System.out.print("선택>>  ");
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1:
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
                    List<Dogs> dogList = dogDAO.getDogList();
                    for (Dogs d : dogList) {
                        System.out.println(d);
                    }
                    break;
                    
                case 3:
                	System.out.println("강아지 ID >> ");
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
                	 List<WalkSchedules> walk = scheduleDAO.getWalkSchedules();
                     for (WalkSchedules walk1 : walk) {
                         System.out.println(walk1);
                     }
                     break;
                     
                case 5:  System.out.print("삭제할 강아지 ID >> ");
                int deleteId = Integer.parseInt(scn.nextLine());
                System.out.print("삭제할 산책 일시 >> ");
                String deleteTime = scn.nextLine();
                int delResult = scheduleDAO.deleteSchedule(deleteId, deleteTime);
                if (delResult > 0) {
                    System.out.println("🐶삭제 완료");
                } else {
                    System.out.println("❌삭제 실패");
                }
                break;
                
                case 6:
                    System.out.print("삭제할 강아지 ID >> ");
                    int dogIdDelete = Integer.parseInt(scn.nextLine());

                    int delresult = dogDAO.deleteDog(dogIdDelete);
                    if (delresult > 0) {
                        System.out.println("🐶강아지 삭제 완료");
                    } else {
                        System.out.println("❌삭제 실패 ");
                    }
                    break;

                             	
                case 7:
                    System.out.println("프로그램 종료");
                    scn.close();
                    System.exit(0);
                    break;

                // 다른 메뉴도 추가 가능

             
            }
        }
    }
}
