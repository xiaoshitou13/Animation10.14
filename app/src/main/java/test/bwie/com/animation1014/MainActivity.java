package test.bwie.com.animation1014;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 渐变
     */
    private Button mJb;
    /**
     * 平移
     */
    private Button mPy;
    /**
     * 缩放
     */
    String byc ;
    private Button mSf;
    /**
     * 旋转
     */
    private Button mXz;
    private ImageView mImage;
    private Button mjh;
    private float curslationx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mJb = (Button) findViewById(R.id.jb);
        mJb.setOnClickListener(this);
        mPy = (Button) findViewById(R.id.py);
        mPy.setOnClickListener(this);
        mSf = (Button) findViewById(R.id.sf);
        mSf.setOnClickListener(this);
        mXz = (Button) findViewById(R.id.xz);
        mXz.setOnClickListener(this);
        mjh = (Button) findViewById(R.id.jh);
        mjh.setOnClickListener(this);
        mImage = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jb:
                ObjectAnimator jbd = ObjectAnimator.ofFloat(mImage,"alpha",1f,0f,1f);
                jbd.setDuration(2000);
                jbd.start();
                break;
            case R.id.py:
                curslationx = mImage.getTranslationX();
                ObjectAnimator pys = ObjectAnimator.ofFloat(mImage,"translationX", curslationx,-500f, curslationx);
                pys.setDuration(2000);
                pys.start();
                break;
            case R.id.sf:
                ObjectAnimator sfs = ObjectAnimator.ofFloat(mImage,"scaleX",1f,5f,1f);
                sfs.setDuration(2000);
                sfs.start();
                break;
            case R.id.xz:
                ObjectAnimator animator = ObjectAnimator.ofFloat(mImage, "rotation", 0f, 360f);
                animator.setDuration(2000);
                animator.start();
                break;
            case R.id.jh:
//                ObjectAnimator moveIn = ObjectAnimator.ofFloat(mImage, "translationX", -500f, 0f);
//                ObjectAnimator rotate = ObjectAnimator.ofFloat(mImage, "rotation", 0f, 360f);
//                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mImage, "alpha", 1f, 0f, 1f);
//                AnimatorSet animSet = new AnimatorSet();
//                animSet.play(rotate).with(fadeInOut).after(moveIn);
//                animSet.setDuration(5000);
//                animSet.start();
                SetAnimation(mImage);
                break;
        }
    }


    public void SetAnimation(final View v){

        final ObjectAnimator animator = ObjectAnimator.ofFloat(v,byc,1f,0f,1f);
        animator.setDuration(2000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
               float f = (float) animator.getAnimatedValue();
                v.setAlpha(f);
                v.setScaleY(f);
                v.setRotationX(f);
                v.setTranslationX(f);
            //    animator.setInterpolator(new  );  //  插值器
            }
        });
    }
}
