package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit_Gender,edit_Ages;
    TextView txt_Result;
    Button btnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_Gender = findViewById(R.id.edit_Gender);
        edit_Ages = findViewById(R.id.edit_Ages);
        txt_Result = findViewById(R.id.txt_Resulr);
        btnDo = findViewById(R.id.btn_Do);

        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //取得使用者輸入的性別和年齡
                String strsex = edit_Gender.getText().toString();
                int iAge =Integer.parseInt(edit_Ages.getText().toString());

                //從字串資源 (string.xml) 取出預先定義好的 suggestion 字串
                String strSug = getString(R.string.suggestion);

                //比對輸入的性別是否為 male
                if (strsex.equals(getString(R.string.male))){
                    if (iAge < 28)
                        strSug += getString(R.string.not_hurry);
                    else if (iAge > 33)
                        strSug += getString(R.string.get_married);
                    else
                        strSug += getString(R.string.find_couple);
                }else {
                if (iAge < 25)
                    strSug += getString(R.string.not_hurry);
                else if (iAge <30)
                    strSug += getString(R.string.get_married);
                else
                    strSug += getString(R.string.find_couple);
                }
                //把結果顯示在 txt_Result 元件中
                txt_Result.setText(strSug);
            }
        });
    }

}
