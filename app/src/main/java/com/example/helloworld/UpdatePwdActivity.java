package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

import java.util.Objects;

/**
 * @author dell
 */
public class UpdatePwdActivity extends AppCompatActivity {

    private ActivityUpdatePwdBinding mBinding;
    String pwd,pwdOk,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        Intent intent = getIntent();
        phone = Objects.requireNonNull(intent.getStringExtra("phone"));
        Log.i("UpdatePwdActivity", phone);

        mBinding.buttonConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd = mBinding.newPwd.getText().toString().trim();
                pwdOk = mBinding.confirmPwd.getText().toString().trim();
                String toast;
                SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                String error = "0";
                String spPwd = sp.getString("pwd_" + phone, error);
                if ("".equals(pwd) || "".equals(pwdOk)) {
                    toast = "请填写新密码，不含空格";
                } else if (pwd.length() != 6) {
                    toast = "密码长度必须为6位";
                } else if (!pwd.equals(pwdOk)) {
                    toast = "两次输入的密码不一致";
                } else if (pwd.equals(spPwd)) {
                    toast = "新密码不能是近期使用过的密码";
                } else {
                    sp.edit().putString("pwd_" + phone, pwd).apply();
                    finish();
                    toast="密码重置成功";
                }
                    Toast.makeText(UpdatePwdActivity.this,toast,Toast.LENGTH_LONG).show();
                }
        });
    }
}