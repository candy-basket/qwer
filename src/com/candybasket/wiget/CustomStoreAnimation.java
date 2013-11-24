package com.candybasket.wiget;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

/**
 * com.candybasket.wiget
 * CustomStoreAnimation.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 24. 오후 7:55:19
 * @Version    : 1.0.4
 * @See          : G_01 상점정보 페이지에서 버튼 나오고 들어가는 이벤트 담당 클래스
 * @Todo       
 */
public class CustomStoreAnimation {
	
	private ImageView A, B, C;
	
	private ValueAnimator animA, animB, animC;
	
	private WindowManager manager;
	private Display display;
	
	public CustomStoreAnimation(Context mContext, ImageView A, ImageView B, ImageView C){
		this.A = A;
		this.B = B;
		this.C = C;
		this.manager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		this.display = manager.getDefaultDisplay();
		//setVisible(false);
	}
	
	private void setVisible(boolean isVisible){
		if(isVisible) //보여준다
		{
			A.setVisibility(View.VISIBLE);
			B.setVisibility(View.VISIBLE);
			C.setVisibility(View.VISIBLE);
		}
		else //보여주지 않는다
		{
			A.setVisibility(View.INVISIBLE);
			B.setVisibility(View.INVISIBLE);
			C.setVisibility(View.INVISIBLE);
		}
		isVisible = !isVisible;
	}
	
	public void startAction()
	{
		//setVisible(true);
		
		if(A != null){
			createAnimationA();
	    	animA.start();
		}
		if(B != null){
			createAnimationB();
			animB.start();	
		}
		if(C != null){
			createAnimationC();
			animC.start();
		}
	}
	
	public void reverseAction()
	{
		
		//setVisible(false);
		
		if(A != null){
			createAnimationA();
	    	animA.reverse();
		}
		if(B != null){
			createAnimationB();
			animB.reverse();		
		}
		if(C != null){
			createAnimationC();
			animC.reverse();
		}
	}
	//TODO:: 화면 디바이스마다 500,400,300 값들이 변경되어야 한다!!
	public void createAnimationA(){
		if (animA == null) {
            animA = ObjectAnimator.ofFloat(A, "x", getWidth() - A.getWidth(), getWidth() - 500).setDuration(500);
            animA.setInterpolator(new AccelerateInterpolator(1.5f));
        }
	}
	
	public void createAnimationB(){
		if (animB == null) {
			animB = ObjectAnimator.ofFloat(B, "x", getWidth() - B.getWidth(), getWidth() - 400).setDuration(500);
			animB.setInterpolator(new AccelerateInterpolator(1.5f));
        }
	}
	
	public void createAnimationC(){
		if (animC == null) {
			animC = ObjectAnimator.ofFloat(C, "x", getWidth() - C.getWidth(), getWidth() - 300).setDuration(500);
			animC.setInterpolator(new AccelerateInterpolator(1.5f));
        }
	}
	
	private int getWidth(){
    	return display.getWidth();
    }
    
    private int getHeight(){
    	return display.getHeight();
    }
}
