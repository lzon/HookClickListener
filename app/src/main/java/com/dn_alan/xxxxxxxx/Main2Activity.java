package com.dn_alan.xxxxxxxx;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main2Activity extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        v = findViewById(R.id.button);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "别点啦，再点我咬你了...", Toast.LENGTH_SHORT).show();
            }
        });


        //所以，这个hook动作，必须在setOnClickListener之后，不然就不起作用
        //这个hook的作用，是 用我们自己创建的点击事件代理对象，替换掉之前的点击事件。
        HookSetOnClickListenerHelper.hook(this, this.v);
    }
}
