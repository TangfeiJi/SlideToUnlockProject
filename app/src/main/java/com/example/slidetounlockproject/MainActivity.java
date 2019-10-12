package com.example.slidetounlockproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.qdong.slide_to_unlock_view.CustomSlideToUnlockView;

public class MainActivity extends AppCompatActivity {

    private CustomSlideToUnlockView slide_to_unlock;
    private LinearLayout pop_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slide_to_unlock=findViewById(R.id.slide_to_unlock);
        pop_layout=findViewById(R.id.pop_layout);
        initLinster();

    }

    private void initLinster() {
        CustomSlideToUnlockView.CallBack callBack = new CustomSlideToUnlockView.CallBack() {
            @Override
            public void onSlide(int distance) {
                Log.e("1111",distance+"");
            }

            @Override
            public void onUnlocked() {
                pop_layout.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this,"onUnlocked",Toast.LENGTH_LONG).show();
            }
        };
        slide_to_unlock.setmCallBack(callBack);
        pop_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop_layout.setVisibility(View.GONE);
            }
        });
    }

}
