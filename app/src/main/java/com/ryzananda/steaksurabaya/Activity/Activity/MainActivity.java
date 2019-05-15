package com.ryzananda.steaksurabaya.Activity.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryzananda.steaksurabaya.R;

import java.lang.reflect.Type;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Button btnUp, btnIn;
    TextView tv_slgn, tv_sloogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIn=findViewById(R.id.btnIn);
        btnUp=findViewById(R.id.btnUp);
        tv_slgn=findViewById(R.id.tv_slgn);
        tv_sloogan=findViewById(R.id.tv_slogan);

        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Nabila.ttf");
        tv_sloogan.setTypeface(face);

        Typeface facee=Typeface.createFromAsset(getAssets(),"fonts/Nabila.ttf");
        tv_slgn.setTypeface(facee);



        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, SignInActivity.class);
                startActivity(in);

            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent up=new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(up);
            }
        });


    }



}
