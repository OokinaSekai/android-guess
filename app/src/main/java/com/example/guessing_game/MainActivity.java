package com.example.guessing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText tv1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/consola.ttf");
        btn=(Button) findViewById(R.id.btn);
        tv=(TextView) findViewById(R.id.text1);
        tv1=(EditText) findViewById(R.id.text2);
        btn.setTypeface(typeFace);
        tv.setTypeface(typeFace);
        tv1.setTypeface(typeFace);
        tv1.addTextChangedListener(new MyTextWatcher());
    }

    private class MyTextWatcher implements TextWatcher
    {
        Button btn=(Button) findViewById(R.id.btn);
        ImageView smile=(ImageView) findViewById(R.id.smile);
        ImageView cry=(ImageView) findViewById(R.id.cry);
        TextView tv=(TextView) findViewById(R.id.text1);
        Button plus=(Button) findViewById(R.id.plus);
        Button min=(Button) findViewById(R.id.min);

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            String str0="The computer only considers a number between 1 to 1000";
            btn.setEnabled(false);
            tv.setText(str0);
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String str0="The computer only considers a number between 1 to 1000";
            btn.setEnabled(true);
            tv.setText(str0);
            btn.setVisibility(View.VISIBLE);
            smile.setVisibility(View.INVISIBLE);
            cry.setVisibility(View.INVISIBLE);
        }

        public void afterTextChanged(Editable s) {
            btn.setEnabled(true);
            if(s.toString().equals(""))
                btn.setEnabled(false);
            btn.setVisibility(View.VISIBLE);
            smile.setVisibility(View.INVISIBLE);
            cry.setVisibility(View.INVISIBLE);
        }
    }


    int num=(int)(1+Math.random()*(1000-1+1));
    public void btnClick(View v)
    {
        tv=(TextView) findViewById(R.id.text1);
        tv1=(EditText) findViewById(R.id.text2);
        int guess=Integer.parseInt(tv1.getText().toString());
        Button plus=(Button) findViewById(R.id.plus);
        Button min=(Button) findViewById(R.id.min);
        ImageView smile=(ImageView) findViewById(R.id.smile);
        ImageView cry=(ImageView) findViewById(R.id.cry);

        String str1="Perfect!";
        String str2="Opps！smaller";
        String str3="Opps！bigger";

        plus.setVisibility(View.VISIBLE);
        min.setVisibility(View.VISIBLE);

        if(guess==num)
        {
            tv.setText(str1);
            btn.setVisibility(View.INVISIBLE);
            smile.setVisibility(View.VISIBLE);
        }
        if(guess<num)
        {
            tv.setText(str3);
            plus.setEnabled(true);
            min.setEnabled(false);
            btn.setVisibility(View.INVISIBLE);
            cry.setVisibility(View.VISIBLE);
        }
        if(guess>num)
        {
            tv.setText(str2);
            min.setEnabled(true);
            plus.setEnabled(false);
            btn.setVisibility(View.INVISIBLE);
            cry.setVisibility(View.VISIBLE);
        }
   }

   public void plusclick(View v)
   {
       EditText tv1=(EditText) findViewById(R.id.text2);
       int guess=Integer.parseInt(tv1.getText().toString());
       guess=guess+1;
       tv1.setText(String.valueOf(guess));
   }

    public void minusclick(View v)
    {
        EditText tv1=(EditText) findViewById(R.id.text2);
        int guess=Integer.parseInt(tv1.getText().toString());
        guess=guess-1;
        tv1.setText(String.valueOf(guess));
    }
}
