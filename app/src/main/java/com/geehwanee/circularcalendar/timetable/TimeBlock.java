package com.geehwanee.circularcalendar.timetable;

public class TimeBlock {
    public int startHour;   // 시작 시각 (0~23)
    public int endHour;     // 끝 시각 (0~23)
    public int color;       // 색상 (Color 값)
    public String label;    // 예: "공부", "수면"

    public TimeBlock(int startHour, int endHour, int color, String label) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.color = color;
        this.label = label;
    }
}
