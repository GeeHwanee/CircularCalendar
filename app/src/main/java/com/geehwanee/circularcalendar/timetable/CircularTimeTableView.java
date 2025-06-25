package com.geehwanee.circularcalendar.timetable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CircularTimeTableView extends View {

    private List<TimeBlock> timeBlocks = new ArrayList<>();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF = new RectF();


    public CircularTimeTableView(Context context) {
        super(context);
    }

    public CircularTimeTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTimeBlocks(List<TimeBlock> blocks) {
        this.timeBlocks = blocks;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int size = Math.min(getWidth(), getHeight());
        float padding = 40f;
        rectF.set(padding, padding, size - padding, size - padding);

        float startAngle = -90f; // 12시 방향
        for (TimeBlock block : timeBlocks) {
            float sweepAngle = ((block.endHour - block.startHour + 24) % 24) * 360f / 24f;
            paint.setColor(block.color);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);

            // 라벨(텍스트) 표시 (옵션)
            float midAngle = startAngle + sweepAngle / 2;
            float radius = (size - 2 * padding) / 2.5f;
            float x = (float)(getWidth()/2 + radius * Math.cos(Math.toRadians(midAngle)));
            float y = (float)(getHeight()/2 + radius * Math.sin(Math.toRadians(midAngle)));
            paint.setColor(Color.BLACK);
            paint.setTextSize(32f);
            canvas.drawText(block.label, x, y, paint);

            startAngle += sweepAngle;
        }
    }
}
