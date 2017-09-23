package com.ex.phongtoda.dang_ki_tim_gia_su;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton RdNam, RdNu;
    RadioGroup RdGroup;
    Button btnDky;
    EditText edTenHS, edLop, edsdt, edque2, edluong, edmon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RdNam = (RadioButton) findViewById(R.id.radioNam);
        RdNu = (RadioButton) findViewById(R.id.radioNu);
        RdGroup = (RadioGroup) findViewById(R.id.RadioGroup1);
        btnDky = (Button) findViewById(R.id.btnDangKy2);
        edTenHS = (EditText) findViewById(R.id.edTenHS);
        edLop = (EditText) findViewById(R.id.edLop);
        edsdt = (EditText) findViewById(R.id.edsdt);
        edque2 = (EditText) findViewById(R.id.edque2);
        edluong = (EditText) findViewById(R.id.edluong);
        edmon2 = (EditText) findViewById(R.id.edmon2);

        btnDky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ten = edTenHS.getText().toString();
                Ten = Ten.trim();
                if (Ten.length() < 3) {
                    edTenHS.requestFocus();
                    edTenHS.selectAll();
                    Toast.makeText(MainActivity.this, " Tên phải hơn 3 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }

                String Lop = edLop.getText().toString();
                Lop = Lop.trim();
                if (Lop.length() <= 12) {
                    edsdt.requestFocus();
                    edsdt.selectAll();
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập lớp", Toast.LENGTH_SHORT).show();
                    return;
                }
                String Sdt = edsdt.getText().toString();
                Sdt = Sdt.trim();
                if (Sdt.length() < 10 && Sdt.length() != 0) {
                    edsdt.requestFocus();
                    edsdt.selectAll();
                    Toast.makeText(MainActivity.this, " Số điện thoại không hợp lê", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Sdt.length() == 0) {
                    edsdt.requestFocus();
                    edsdt.selectAll();
                    Toast.makeText(MainActivity.this, " Bạn chưa nhập só điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                   String DC = edque2.getText().toString();
                  DC.trim();
                   if (DC.length() < 3) {
                    edque2.requestFocus();
                    edque2.selectAll();
                    Toast.makeText(MainActivity.this, "Hãy nhập lại địa chỉ", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mon = edmon2.getText().toString();
                if (mon.matches("")) {
                    edmon2.requestFocus();
                    edmon2.selectAll();
                    Toast.makeText(MainActivity.this, " Bạn phải nhập ít nhất một môn học", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!RdNam.isChecked() && !RdNu.isChecked()) {
                    Toast.makeText(MainActivity.this, "Bạn chưa chọn giới tính", Toast.LENGTH_SHORT).show();
                    return;
                }


                String Luong = edluong.getText().toString();
                Luong.trim();
                if (Luong.matches("")) {
                    edluong.requestFocus();
                    edluong.selectAll();
                    Toast.makeText(MainActivity.this, "Bạn phải nhập vào tiền lương", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Ten.matches("") && !Lop.matches("") && !Sdt.matches("") && !mon.matches("") && !Luong.matches("") && (RdNam.isChecked() || RdNu.isChecked())) {

                    Intent intent = new Intent(MainActivity.this, Congratulation.class);
                    startActivity(intent);
                }


            }

        });

        RdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radioNam:
                        break;
                    case R.id.radioNu:
                        break;
                }
            }
        });
    }
}







