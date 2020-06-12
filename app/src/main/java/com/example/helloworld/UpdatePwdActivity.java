package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

/**
 * @author dell
 */
public class UpdatePwdActivity extends AppCompatActivity {

    private ActivityUpdatePwdBinding mBinding;
    String pwd,pwdOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd = mBinding.newPwd.getText().toString().trim();
                pwdOk = mBinding.confirmPwd.getText().toString().trim();
                String toast;
                if (pwd.length()!= 6) {
                    toast="密码长度为六位";
                } else if (!pwd.equals(pwdOk)) {
                    toast="两次密码不一致";
                } else {
                    SharedPreferences sp =getSharedPreferences("user_info",MODE_PRIVATE);
                    String phone = getIntent().getStringExtra("phone_");
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("pwd_"+phone,pwd);
                    editor.apply();
                    Intent intent = new Intent(UpdatePwdActivity.this, MainActivity.class);
                    startActivity(intent);
                    toast="修改成功,请重新登录";
                    }
                    Toast.makeText(UpdatePwdActivity.this,toast,Toast.LENGTH_LONG).show();
                }
        });
    }
}