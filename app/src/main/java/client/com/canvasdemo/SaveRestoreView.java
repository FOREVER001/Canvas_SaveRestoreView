package client.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SaveRestoreView extends View {
    private Paint mPaint;
    public SaveRestoreView(Context context) {
        this(context,null);
    }

    public SaveRestoreView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SaveRestoreView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(200,200,700,700,mPaint);
        int layerId=canvas.saveLayer(0,0,700,700,mPaint);//图层大小为（0，0,700,700）
        mPaint.setColor(Color.GRAY);
        Matrix matrix=new Matrix();
        matrix.setTranslate(100,100);
        canvas.setMatrix(matrix);
        canvas.drawRect(0,0,700,700,mPaint);//由于平移操作，导致绘制的矩形超出了图层的大小，所以绘制不完全
        canvas.restoreToCount(layerId);
        //会新创建一个图层，将这两行代码中操作先绘制到这个图层中，然后在将这个图层绘制到canvas上
        //这个savaLayer可以指定图层的大小，如getWidth()

        mPaint.setColor(Color.RED);
        canvas.drawRect(0,0,100,100,mPaint);

    }
}
