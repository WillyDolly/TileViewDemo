package com.popland.pop.tileviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hai on 06/08/2017.
 */

public class SampleCallout extends RelativeLayout {
TextView title , subTitle;
    public int getDIP(Context context,int pixel){
        //convert pixel to a float value
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,pixel,context.getResources().getDisplayMetrics());
    }
    public SampleCallout(Context context) {
        super(context);
        //first RelativeLayout's child
        LinearLayout subLayoutA = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0XFF313231);
        gradientDrawable.setCornerRadius(getDIP(context,4));
        subLayoutA.setBackgroundDrawable(gradientDrawable);
        subLayoutA.setId(R.id.subLayoutA);
        LayoutParams Rparams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        addView(subLayoutA,Rparams);

        //second RelativeLayout's child
        Triangle triangle = new Triangle(context);
        LayoutParams Nparams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        //position triangle at the center of subLayoutA's bottom edge
        Nparams.addRule(RelativeLayout.BELOW,subLayoutA.getId());
        Nparams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(triangle,Nparams);

        //subLayoutA's child
        LinearLayout labels = new LinearLayout(context);
        labels.setOrientation(LinearLayout.VERTICAL);
        LayoutParams Lparams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        subLayoutA.addView(labels);

        title = new TextView(context);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP,21);
        subTitle = new TextView(context);
        subTitle.setTypeface(Typeface.SANS_SERIF);
        subTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        LayoutParams Tparams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        labels.addView(title,Tparams);
        labels.addView(subTitle,Tparams);
    }

    public void setText(CharSequence T,CharSequence S){
        title.setText(T);
        subTitle.setText(S);
    }

    private class Triangle extends View {
        Paint paint = new Paint();
        Path path = new Path();

        Triangle(Context context){
            super(context);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(0xFF313231);

            //add 2 lines to specified coordinates
            path.lineTo(getDIP(context,20),0);
            path.lineTo(getDIP(context,10),getDIP(context,15));
            Log.i("getDIP: ",getDIP(context,20)+"_"+getDIP(context,15)+"_"+getDIP(context,10));
            //close contour(line joins the same height points)
            path.close();
        }

        //manage view's content
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(getDIP(getContext(),20),getDIP(getContext(),15));
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path,paint);
            super.onDraw(canvas);
        }
    }
}
