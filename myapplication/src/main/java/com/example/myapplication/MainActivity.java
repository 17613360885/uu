package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.util.LargeImageView;

import java.io.InputStream;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import qdx.stickyheaderdecoration.NormalDecoration;

public class MainActivity extends AppCompatActivity {
    private Button mBut;
    private LargeImageView mIm;
    private InputStream mStream;
    private RecyclerView mMyRecycle;
    /**
     * 测试
     */
    private TextView mMyHeard;
    private ArrayList<Car> mCars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView ();
    }
    public void initView () {
                mMyRecycle = (RecyclerView) findViewById(R.id.my_recycle);

                mCars = new ArrayList<>();
                mCars.add(new Car("奥迪", "A"));
                mCars.add(new Car("阿尔法罗密欧", "A"));
                mCars.add(new Car("阿斯顿马丁", "A"));
                mCars.add(new Car("ALPINA", "A"));
                mCars.add(new Car("安凯客车", "A"));


                mCars.add(new Car("本田", "B"));
                mCars.add(new Car("别克", "B"));
                mCars.add(new Car("奔驰", "B"));
                mCars.add(new Car("宝马", "B"));
                mCars.add(new Car("保时捷", "B"));
                mCars.add(new Car("比亚迪", "B"));
                mCars.add(new Car("北京", "B"));
                mCars.add(new Car("宾利", "B"));
                mCars.add(new Car("巴博斯", "B"));
                mCars.add(new Car("布加迪威龙", "B"));

                mCars.add(new Car("长安", "C"));
                mCars.add(new Car("长城", "C"));

                mCars.add(new Car("大众", "D"));
                mCars.add(new Car("东南", "D"));
                mCars.add(new Car("东风", "D"));
                mCars.add(new Car("DS", "D"));
                mCars.add(new Car("道奇", "D"));
                mCars.add(new Car("东风小康", "D"));

                mMyRecycle.setLayoutManager(new LinearLayoutManager(this));
                RlvCarAdapter rlvAdapter = new RlvCarAdapter(mCars);
                //返回头布局的内容
                final NormalDecoration decoration = new NormalDecoration() {
                    @Override
                    public String getHeaderName(int i) {
                        return mCars.get(i).headLetter;
                    }
                };
                //自定义头布局,可不设置
        /*decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int i) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_header, null);
                TextView tv = inflate.findViewById(R.id.tv);
                tv.setText(mCars.get(i).headerName);

                return inflate;
            }
        });*/
                mMyRecycle.addItemDecoration(decoration);
                //头布局的点击事件
                decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
                    @Override
                    public void headerClick(int i) {
                        Toast.makeText(MainActivity.this, mCars.get(i).headLetter, Toast.LENGTH_SHORT).show();
                    }
                });
                mMyRecycle.setAdapter(rlvAdapter);
            }



    }


