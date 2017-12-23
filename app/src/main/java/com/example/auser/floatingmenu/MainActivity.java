package com.example.auser.floatingmenu;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean bool=true;
    LinearLayout linear_translate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView);
        linear_translate=(LinearLayout)findViewById(R.id.linear_transfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        System.out.println(fab.getSize());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                if (bool) {
                    linear_translate.setVisibility(View.VISIBLE);
//                    imageView.setVisibility(View.VISIBLE);
                    playViewAnimationTranslate();
                    bool=false;
                }else {
                    playViewAnimationTranslate2();
                    bool = true;
                    linear_translate.setVisibility(View.INVISIBLE);
//                    imageView.setVisibility(View.INVISIBLE);

                }
            }
        });



//        fab.set  android:layout_width="60dp"
//        fab.setSize(60dp);
//        fab.setImageResource();
//        fab.setBackground(R.id.d);
    }

    public void addHouseData(View target){
        Log.d("anin","addHouseData");


    }

    public void editPerson(View target){
        Log.d("anin","editPersion");

    }

//    在 activity_main.xml 中，
//    將 FloatingActionButton 的大小調整為 60dp X 60dp，並在根元素加入背 景 background.png


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    ImageView imageView;


    //移動動畫開始
    void playViewAnimationTranslate(){
        //要先產生一個動畫物件,並參數的地方要設定動畫資源
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        imageView.startAnimation(animation);
        linear_translate.startAnimation(animation);

    }

    //移動動畫開始
    void playViewAnimationTranslate2(){
        //要先產生一個動畫物件,並參數的地方要設定動畫資源
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_translate2);
        imageView.startAnimation(animation);
        linear_translate.startAnimation(animation);

    }
    //底下兩個二選一
    void playPorpertyAnimationFromXML(){
        AnimatorSet set=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.animator);//決定前面寫到的動畫效困是用那一種動畫,先後順序
        set.setTarget(imageView);
        set.start();
    }



//
//    void playPropertyAnimation(){
//        ObjectAnimator oaRotate =ObjectAnimator.ofFloat(MainActivity.this,"rotation",0,360);
//        oaRotate.setDuration(1000);
//        oaRotate.setRepeatCount(5);  //若是採用依序播放動畫方式,第一段動畫的播放次數不可設為無限,否則其他動畫看不到
//        oaRotate.setRepeatMode(ObjectAnimator.REVERSE);
//        oaRotate.addListener(new Animator.AnimatorListener() {//監聽動畫事件,非必要
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                Toast.makeText(MainActivity.this,"第一段動畫結束",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//        });
//        //建立移動動畫
//        //第二個參數是表示水平方向移動,Y表示上下移動,
//        //第三個參數是從0移動到400
//        ObjectAnimator oaForad=ObjectAnimator.ofFloat(imageView ,"x",0,400);
//        oaForad.setDuration(3000);
//        oaForad.setRepeatCount(ObjectAnimator.INFINITE);
//        oaForad.setRepeatMode(ObjectAnimator.REVERSE);
//
////        oaForad.setInterpolator(ObjectAnimator.);
//
//        AnimatorSet as=new AnimatorSet();//決定前面寫到的動畫效困是用那一種動畫,先後順序
//        as.playSequentially(oaRotate,oaForad);//先旋轉再平移
//        as.start();
//    }

}
