package com.example.cjcu.listview1116;

import android.support.constraint.solver.LinearSystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv=(ListView)findViewById(R.id.ListView);
        //取得輸入的值
        String [] cityArray=getResources().getStringArray(R.array.cityname);
        ArrayAdapter<String>  ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityArray);

        String data[][]={
                {"牡羊座","3月21日～4月20日"},
                {"金牛座","4月21日～5月20日"},
                {"雙子座","5月21日～6月20日"},
                {"巨蟹座","6月21日～7月20日"},
                {"獅子座","7月21日～8月20日"},
                {"處女座","8月21日～9月20日"},
                {"天秤座","9月21日～10月20日"},
                {"天蠍座","10月21日～11月20日"},
                {"射手座","11月21日～12月20日"},
                {"魔羯座","12月21日～1月20日"},
                {"水瓶座","1月21日～2月20日"},
                {"雙魚座","2月21日～3月20日"}
        };

        lv.setAdapter(ad);
        //方法一，建立一個.java
        //方法二
        AdapterView.OnItemClickListener Onclick= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("星座%s",data[position][0]+"日期%s"+data[position][1]);

            }
        };

        lv.setOnItemClickListener(Onclick);

        /*//方法三，使用lambda
        AdapterView.OnItemClickListener Onclick2=(AdapterView<?> parent,View view,int position,long id)->{//
            Log.i("ZN","onclick3");
        };
        lv.setOnItemClickListener(Onclick2);*/



        List<Map<String,Object>> item=new ArrayList<Map<String,Object>>();

        for(int i=0;i<data.length;i++){
         Map<String,Object> temp=new HashMap<String,Object>();
         temp.put("name",data[i][0]);
         temp.put("data",data[i][1]);
         item.add(temp);
        }

        SimpleAdapter sa =new SimpleAdapter(this,item,R.layout.simpleadapterlayout,new String[]{"name","data"},new int[]{R.id.tv_name,R.id.tv_date});
        lv.setAdapter(sa);

    }
}
