package com.example.jni;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jni.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        System.loadLibrary("jni");
    }

    private TextView txtView;
    private EditText txtInput;
    private Button enterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView =findViewById(R.id.txtViewID);
        txtInput =findViewById(R.id.txtInputID);
        enterBtn =findViewById(R.id.enterInputID);
        enterBtn.setOnClickListener(this);
    }

    public native int  getTxtLen(String txt);
    private  void enterText(){
        String  txt =txtInput.getText().toString();
        int txtLen=getTxtLen(txt);
        txtView.setText("text lenght: "+ txtLen);
    }

    @Override
    public void onClick(View view) {
        if(view==enterBtn){
            enterText();
        }
    }
}