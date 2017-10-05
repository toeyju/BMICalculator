package com.example.bmicalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mHeightEditText, mWeightEditText;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = mHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);

                Double weight = Double.valueOf(mWeightEditText.getText().toString());

                Double bmi = weight / ((height / 100) * (height / 100));

                String bmiText = getBmiText(bmi);

                String result = String.format("ค่า BMI ที่ได้ %.1f\n\nอยู่ในเกณฑ์ : %s",bmi,bmiText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); // จำ
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }
        });
    }
    private String getBmiText(Double bmi) {

        String bmiText = "";
        if(bmi < 18.5){
            bmiText = "น้าหนักน้อยกว่าปกติ";
        } else if(bmi < 25){
            bmiText = "น้าหนักปกติ";
        } else if(bmi < 30){
            bmiText = "น้าหนักมากกว่าปกติ (ท้วม)";
        } else {
            bmiText = "น้าหนักมากกว่าปกติมาก (อ้วน)";
        }
        return bmiText;
    }
}// ปืดคลาส MainActivity








// โค้ดที่ต้องการให้ทำงานเมื่อปุ่ม OK ใน Dialog ถูกคลิก
//  finish(); // ปิดแอคทิวิตีปัจจุบัน





              /*  String result = "ค่า BMI ที่ได้ คือ" + String.valueOf(bmi);
                result += "\n\n อยู่ในเกณฑ์ :" + bmiText;*/
















/*Toast t = Toast.makeText(
                        MainActivity.this,
                        "ค่า BMI ที่ได้ คือ" + String.valueOf(bmi),
                        Toast.LENGTH_LONG
                );
                t.show();*/



    /*    วิธีที่ ๅ : private class MyListenner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // โค้ดที่เราต้องการให้ทำงาน เมื่อปุ่มถูกคลิก
            Toast t = Toast.makeText(
                    MainActivity.this, //context
                    "Hello",           // ข้อความที่ต้องการแสดงใน Toast
                    Toast.LENGTH_SHORT // ระยะเวลาในการแสดง Toast
            );
            t.show();
        }
    }*/
    /*  // การสร้างออบเจ็คที่เป็น Listener ของปุ่ม
        MyListenner listener = new MyListenner();
        // กำหนดออบเจ็คที่เป็น Listener ให้กับปุ่ม
        mCalculateButton.setOnClickListener(listener);*/

    // ปิดเมธอด Oncreate