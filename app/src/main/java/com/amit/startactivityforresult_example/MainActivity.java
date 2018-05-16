package com.amit.startactivityforresult_example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/*Reference: https://www.youtube.com/watch?v=KeG0Rm8wyO4
* http://jakewharton.github.io/butterknife/
* https://www.androidhive.info/2017/10/android-working-with-butterknife-viewbinding-library/ */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String fromSecond = data.getStringExtra("fromSecond");

        if (requestCode==1){
            if (resultCode== Activity.RESULT_OK){
                textView2.setText(fromSecond);
            }else{
                textView2.setText("SecondActivity failed to send data");
            }
        }
    }
}
