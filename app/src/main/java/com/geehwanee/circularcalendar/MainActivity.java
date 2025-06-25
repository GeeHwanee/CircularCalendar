package com.geehwanee.circularcalendar;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.geehwanee.circularcalendar.timetable.CircularTimeTableView;
import com.geehwanee.circularcalendar.timetable.TimeBlock;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Custom View 찾기
        CircularTimeTableView circularView = findViewById(R.id.circularTimeTable);

        // 2. 시간표 데이터 생성(샘플)
        List<TimeBlock> blocks = new ArrayList<>();
        blocks.add(new TimeBlock(0, 7, Color.parseColor("#90caf9"), "수면"));
        blocks.add(new TimeBlock(7, 9, Color.parseColor("#a5d6a7"), "아침"));
        blocks.add(new TimeBlock(9, 12, Color.parseColor("#ffe082"), "공부"));
        blocks.add(new TimeBlock(12, 13, Color.parseColor("#ffab91"), "점심"));
        blocks.add(new TimeBlock(13, 18, Color.parseColor("#ce93d8"), "공부"));
        blocks.add(new TimeBlock(18, 19, Color.parseColor("#ffcc80"), "저녁"));
        blocks.add(new TimeBlock(19, 22, Color.parseColor("#b0bec5"), "자유"));
        blocks.add(new TimeBlock(22, 24, Color.parseColor("#90caf9"), "수면"));

        // 3. Custom View에 데이터 전달
        circularView.setTimeBlocks(blocks);




    }
}