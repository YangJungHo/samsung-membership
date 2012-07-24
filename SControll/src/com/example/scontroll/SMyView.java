package com.example.scontroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class SMyView extends View{
	int count = 0;
	private test1 mTest;
	
	public SMyView(Context context) {
         super(context);
         mTest = (test1)context.getApplicationContext();
         timer.sendEmptyMessageDelayed(0, 10);
    }

    public void onDraw(Canvas canvas) {

         int CenterX = getWidth() / 2;	// X������
         int CenterY = (getHeight() / 2) - 100;	//	Y������
         int NeedleWidth  = 0;                 
         int NeedleHeight = 0;
         int GaugeWidth  = 0;
         int GaugeHeight = 0;
         


         Paint paint = new Paint();
         paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
         paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
         
         Bitmap Needle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
         Bitmap backGround  = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
         Bitmap NeedleResize = Bitmap.createScaledBitmap(Needle, 40, 140, true);
         Bitmap GaugeResize  = Bitmap.createScaledBitmap(backGround, 370, 370, true);
         
         NeedleWidth  = NeedleResize.getWidth() / 2;	// ȸ���� ���
         NeedleHeight = NeedleResize.getHeight();
         GaugeWidth  = GaugeResize.getWidth() / 2;
         GaugeHeight = GaugeResize.getHeight() / 2;
         
         canvas.drawBitmap(GaugeResize, CenterX - GaugeWidth, CenterY - GaugeHeight, null); //	�ӵ������� ��ġ 
         canvas.drawCircle(CenterX, CenterY, 120, paint);	// ȸ������ ���� ������ ǥ��
		 canvas.rotate(mTest.getVelocityAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
         canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY -(NeedleHeight+50), null);	// �߽����� �̹��� ���� ������ ���
         

  } // onDraw
    
    
    Handler timer = new Handler() {               // Ÿ�̸ӷ� ����� Handler
        public void handleMessage(Message msg) {
                 invalidate();                                       // onDraw() �ٽ� ����
                 timer.sendEmptyMessageDelayed(0, 10);      // 10/1000�ʸ��� ����
        }
    }; // Handler

}

class Battery extends View{
	private test1 mTest;

	public Battery(Context context) {
		super(context);
		mTest = (test1)context.getApplicationContext();
		}    	
	public void onDraw(Canvas canvas){
	
		int CenterX = (getWidth() / 2)-397;
		int CenterY = (getWidth() / 2)-442;
		int NeedleWidth  = 0;
		int NeedleHeight = 0;
    
		Paint paint = new Paint();
		paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
		paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
    
		Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
		Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
    
		NeedleWidth  = NeedleResize.getWidth() / 2;
		NeedleHeight = NeedleResize.getHeight() /2;
    
		canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
		canvas.rotate(mTest.getbatteryAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
		}

}

class fuel extends View{
	private test1 mTest;
	
	public fuel(Context context) {
        super(context);
        mTest = (test1)context.getApplicationContext();
        
   }    	
	public void onDraw(Canvas canvas){
		
		int CenterX = (getWidth() / 2)-397;
        int CenterY = (getWidth() / 2)-442;
        int NeedleWidth  = 0;
        int NeedleHeight = 0;
        
        Paint paint = new Paint();
        paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
        paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
        
        Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
        Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
        
        NeedleWidth  = NeedleResize.getWidth() / 2;
        NeedleHeight = NeedleResize.getHeight() /2;
        
        canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
        canvas.rotate(mTest.getfuelAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
        canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
	}
	
}// class

class coolant extends View{
	private test1 mTest;
	
	public coolant(Context context) {
        super(context);
        mTest = (test1)context.getApplicationContext();
   }    	
	public void onDraw(Canvas canvas){
		
		int CenterX = (getWidth() / 2)-397;
        int CenterY = (getWidth() / 2)-442;
        int NeedleWidth  = 0;
        int NeedleHeight = 0;
        
        Paint paint = new Paint();
        paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
        paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
        
        Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
        Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
        
        NeedleWidth  = NeedleResize.getWidth() / 2;
        NeedleHeight = NeedleResize.getHeight() /2;
        
        canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
        canvas.rotate(mTest.getcoolantAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
        canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
	}
	
}// class

