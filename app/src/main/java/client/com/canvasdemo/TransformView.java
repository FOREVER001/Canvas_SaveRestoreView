package client.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class TransformView extends View {
    private Paint mPaint;
    public TransformView(Context context) {
        this(context,null);
    }

    public TransformView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TransformView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.RED);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        旋转操作
//        canvas.translate(50,50);
//        canvas.drawRect(0,0,400,400,mPaint);
//        canvas.rotate(45);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(0,0,400,400,mPaint);

//        //围绕旋转中心旋转
////        canvas.drawRect(100,100,400,400,mPaint);
////        canvas.rotate(45,250,250);//px,py表示旋转中心的坐标
////        mPaint.setColor(Color.GRAY);
////        canvas.drawRect(100,100,400,400,mPaint);

//        canvas.drawRect(0,0,200,200,mPaint);
//        canvas.skew(1,0);//在x轴方向倾斜45度，相当于Y轴逆时针旋转45度
////        canvas.skew(0,1);//在y轴方向倾斜45度，相当于x轴顺时针旋转45度
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(0,0,200,200,mPaint);


        //切割
//        canvas.drawRect(200,200,700,700,mPaint);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(200,800,700,900,mPaint);
//        canvas.clipRect(200,200,700,700);//画布被裁剪
//        canvas.drawCircle(100,100,100,mPaint);//坐标超出裁剪区域无法绘制
//        canvas.drawCircle(300,300,100,mPaint);//坐标区域在裁剪范围内，绘制成功

        //反向裁剪
//        canvas.drawRect(200,200,700,700,mPaint);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(200,800,700,900,mPaint);
//        canvas.clipOutRect(200,200,700,700);//画布裁剪外的区域
//        canvas.drawCircle(100,100,100,mPaint);//  坐标区域在裁剪范围内，绘制成功
//        canvas.drawCircle(300,300,100,mPaint);//坐标超出裁剪区域，无法绘制


        canvas.drawRect(0,0,400,400,mPaint);
        Matrix matrix=new Matrix();
//        matrix.setTranslate(50,50);//平移
//        matrix.setRotate(45);//旋转
           matrix.setScale(0.5f,0.5f);//缩放
        canvas.setMatrix(matrix);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(0,0,400,400,mPaint);



    }
}
