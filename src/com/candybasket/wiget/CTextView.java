package com.candybasket.wiget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

/*
**
* 클래스설명 : 1. 텍스트의 줄바꿈을 공백기준이 아닌 한글자 단위로 한다.
* 			2. ellipsize 버그처리
* @version : 2011. 8. 06.
* @author : CEnA - mibany
* @출처 : http://docs.cena.co.kr/textyle/42137
* 		http://dodo4989.tistory.com/525
* 
* @적용 : 
* CTextView index_summary = (CTextView)convertView.findViewById(R.id.index_summary);
* index_summary.setText(item.getString("summary"));
* index_summary.setMaxLines(3);
*/
public class CTextView extends TextView {
   private int mAvailableWidth = 0;
   private Paint mPaint;
   private List<String> mCutStr = new ArrayList<String>();
   
   //http://dodo4989.tistory.com/525
   private static final String ELLIPSIS = "...";
   
   public interface EllipsizeListener {

       void ellipsizeStateChanged(boolean ellipsized);

   }
   private final List<EllipsizeListener> ellipsizeListeners = new ArrayList<EllipsizeListener>();

   private boolean isEllipsized;
   private boolean isStale;
   private boolean programmaticChange;
   private String fullText;
   private int maxLines = -1;
   private float lineSpacingMultiplier = 1.0f;
   private float lineAdditionalVerticalPadding = 0.0f;

   //textview line change by letter
   public CTextView(Context context) {
       super(context);
   }

   public CTextView(Context context, AttributeSet attrs) {
       super(context, attrs);
   }

   private int setTextInfo(String text, int textWidth, int textHeight) {
       // 그릴 페인트 세팅
       mPaint = getPaint();
       mPaint.setColor(getTextColors().getDefaultColor());
       mPaint.setTextSize(getTextSize());

       int mTextHeight = textHeight;

       if (textWidth > 0) {
           // 값 세팅
           mAvailableWidth = textWidth - this.getPaddingLeft() - this.getPaddingRight();

           mCutStr.clear();
           int end = 0;
           do {
               // 글자가 width 보다 넘어가는지 체크
               end = mPaint.breakText(text, true, mAvailableWidth, null);
               if (end > 0) {
                   // 자른 문자열을 문자열 배열에 담아 놓는다.
                   mCutStr.add(text.substring(0, end));
                   // 넘어간 글자 모두 잘라 다음에 사용하도록 세팅
                   text = text.substring(end);
                   // 다음라인 높이 지정
                   if (textHeight == 0) mTextHeight += getLineHeight();
               }
           } while (end > 0);
       }
       mTextHeight += getPaddingTop() + getPaddingBottom();
       return mTextHeight;
   }

   @Override
   protected void onDraw(Canvas canvas) {
       if (isStale) {
           super.setEllipsize(null);
           resetText();
       }

       // 글자 높이 지정
       float height = getPaddingTop() + getLineHeight();
       for (String text : mCutStr) {
           // 캔버스에 라인 높이 만큰 글자 그리기
           canvas.drawText(text, getPaddingLeft(), height, mPaint);
           height += getLineHeight();
       }
//       
//       
//       super.onDraw(canvas);
   }

   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
       int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
       int height = setTextInfo(this.getText().toString(), parentWidth, parentHeight);
       // 부모 높이가 0인경우 실제 그려줄 높이만큼 사이즈를 놀려줌...
       if (parentHeight == 0)
           parentHeight = height;
       this.setMeasuredDimension(parentWidth, parentHeight);
   }

   @Override
   protected void onTextChanged(final CharSequence text, final int start, final int before, final int after) {
       // 글자가 변경되었을때 다시 세팅
       setTextInfo(text.toString(), this.getWidth(), this.getHeight());
       //from ellipsize debug code
       if (!programmaticChange) {
           fullText = text.toString();
           isStale = true;
     }
   }

   @Override
   protected void onSizeChanged(int w, int h, int oldw, int oldh) {
       // 사이즈가 변경되었을때 다시 세팅(가로 사이즈만...)
       if (w != oldw) {
           setTextInfo(this.getText().toString(), w, h);
       }
   }
   
   //ellipsize bug fix
   public void addEllipsizeListener(EllipsizeListener listener) {
       if (listener == null) {
             throw new NullPointerException();
       }
       ellipsizeListeners.add(listener);
 }



 public void removeEllipsizeListener(EllipsizeListener listener) {
       ellipsizeListeners.remove(listener);
 }



 public boolean isEllipsized() {
       return isEllipsized;
 }


 @Override
 public void setMaxLines(int maxLines) {
	  super.setMaxLines(maxLines);
	  this.maxLines = maxLines;
	  isStale = true;
 }

 public int getMaxLines() {
	  return maxLines;
 }

 @Override
 public void setLineSpacing(float add, float mult) {
	  this.lineAdditionalVerticalPadding = add;
	  this.lineSpacingMultiplier = mult;
	  super.setLineSpacing(add, mult);
 }
 
 private void resetText() {
	  int maxLines = getMaxLines();
	  String workingText = fullText;
     boolean ellipsized = false;
     
     if (maxLines != -1) {
           Layout layout = createWorkingLayout(workingText);
           if (layout.getLineCount() > maxLines) {
                 workingText = fullText.substring(0, layout.getLineEnd(maxLines - 1)).trim();
                 while (createWorkingLayout(workingText + ELLIPSIS).getLineCount() > maxLines) {
                      int lastSpace = workingText.lastIndexOf(' ');
                       if (lastSpace == -1) {
                            break;
                      }
                      workingText = workingText.substring(0, lastSpace);
                 }
                 workingText = workingText + ELLIPSIS;
                 ellipsized = true;
           }
     }
     
     if (!workingText.equals(getText())) {
           programmaticChange = true;
           try {
                 setText(workingText);
           } finally {
                 programmaticChange = false;
           }
     }
     
     isStale = false;

     if (ellipsized != isEllipsized) {
           isEllipsized = ellipsized;
           for (EllipsizeListener listener : ellipsizeListeners) {
                 listener.ellipsizeStateChanged(ellipsized);
           }
     }
 }

	private Layout createWorkingLayout(String workingText) {
		return new StaticLayout(workingText, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(),
	    		  Alignment.ALIGN_NORMAL, lineSpacingMultiplier, lineAdditionalVerticalPadding, false);
	}

	@Override
	public void setEllipsize(TruncateAt where) {
		// Ellipsize settings are not respected
	}

}
