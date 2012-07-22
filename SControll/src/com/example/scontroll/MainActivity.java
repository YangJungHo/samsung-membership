package com.example.scontroll;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.Window;



public class MainActivity extends Activity {
	
	
	//TextView speed;
	//SeekBar testbar;
	
	
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   // 프로그램의 타이틀 없애기
        //setContentView(R.layout.activity_main);
        MyView vw = new MyView(this);
		setContentView(vw);
		
   
        /*speed =(TextView)findViewById(R.id.speedtext);
        
        testbar =(SeekBar)findViewById(R.id.test);
        
        testbar.setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				speed.setText(progress+"");
				
			}
			

		});*/
    }
    
    protected class MyView extends View {
    	
    	int count=0;

		public MyView(Context context) {
             super(context);
             
             timer.sendEmptyMessageDelayed(0, 10);
        }
    
        public void onDraw(Canvas canvas) {
             int cx = getWidth() / 2;       // View 의 중심점
             int cy = getHeight() / 2;
             int w = 0;                 
             int h = 0;
   
     
             Bitmap bitmap = null;
             Paint paint = new Paint();
             paint.setColor(Color.RED);                
             paint.setStyle(Paint.Style.STROKE);    // 외곽선만 그린다
             canvas.drawColor(Color.TRANSPARENT);        // View를 흰색으로 채우기
             bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rose);
             w = bitmap.getWidth() / 2;          // 회전축 계산
             h = bitmap.getHeight();

     
         canvas.drawBitmap(bitmap, 10, 10, null);                   // 10, 10 위치에 원래의 이미지 출력
         canvas.drawCircle(w + 10, h + 10, 10, paint);             // 회전축을 빨간 원으로 표시
         int n=10;
         n+=count;
         canvas.rotate(n, cx, cy);                                  // Canvas를 중심점을 회전축으로 20도 회전 
         canvas.drawBitmap(bitmap, cx - w, cy - h, null);    // 중심점에 이미지 끝이 오도록 출력
         count++;

      } // onDraw
        
        Handler timer = new Handler(){

			public void  handleMessage(Message msg) {
				invalidate();
				timer.sendEmptyMessageDelayed(0, 10);
			}
        };// Handler 
        
     } // class */

    

	

    
    
       

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
