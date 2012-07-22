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
        requestWindowFeature(Window.FEATURE_NO_TITLE);   // ���α׷��� Ÿ��Ʋ ���ֱ�
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
             int cx = getWidth() / 2;       // View �� �߽���
             int cy = getHeight() / 2;
             int w = 0;                 
             int h = 0;
   
     
             Bitmap bitmap = null;
             Paint paint = new Paint();
             paint.setColor(Color.RED);                
             paint.setStyle(Paint.Style.STROKE);    // �ܰ����� �׸���
             canvas.drawColor(Color.TRANSPARENT);        // View�� ������� ä���
             bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rose);
             w = bitmap.getWidth() / 2;          // ȸ���� ���
             h = bitmap.getHeight();

     
         canvas.drawBitmap(bitmap, 10, 10, null);                   // 10, 10 ��ġ�� ������ �̹��� ���
         canvas.drawCircle(w + 10, h + 10, 10, paint);             // ȸ������ ���� ������ ǥ��
         int n=10;
         n+=count;
         canvas.rotate(n, cx, cy);                                  // Canvas�� �߽����� ȸ�������� 20�� ȸ�� 
         canvas.drawBitmap(bitmap, cx - w, cy - h, null);    // �߽����� �̹��� ���� ������ ���
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
