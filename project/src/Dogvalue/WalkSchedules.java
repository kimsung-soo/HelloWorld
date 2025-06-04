package Dogvalue;

public class WalkSchedules {
  public int dogId;
  public String dateTime;
  public String location;
  public int walkTime;

    public WalkSchedules() {}

    public WalkSchedules(int dogId, String dateTime, String location, int walkTime) {
        this.dogId = dogId;
        this.dateTime = dateTime;
        this.location = location;
        this.walkTime = walkTime;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWalkTime() {
        return walkTime;
    }

    public void setWalkTime(int walkTime) {
        this.walkTime = walkTime;
    }

    @Override
    public String toString() {
        return "강아지 번호:" + dogId + ", 산책날짜: " + dateTime + ", 장소: " + location + ", 산책시간: " + walkTime + "분";
    }
}