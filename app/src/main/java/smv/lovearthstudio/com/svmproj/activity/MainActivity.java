package smv.lovearthstudio.com.svmproj.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import libsvm.svm;
import smv.lovearthstudio.com.svmproj.R;
import smv.lovearthstudio.com.svmproj.fragment.CollectionFragment;
import smv.lovearthstudio.com.svmproj.fragment.PredictFragment;
import smv.lovearthstudio.com.svmproj.fragment.SensorFragment;
import smv.lovearthstudio.com.svmproj.svm.SVM;

import static java.io.File.separator;
import static smv.lovearthstudio.com.svmproj.svm.SVM.inputStreamToArray;
import static smv.lovearthstudio.com.svmproj.util.Constant.dir;
import static smv.lovearthstudio.com.svmproj.util.Constant.modelFileName;
import static smv.lovearthstudio.com.svmproj.util.Constant.rangeFileName;
import static smv.lovearthstudio.com.svmproj.util.Constant.train;
import static smv.lovearthstudio.com.svmproj.util.Constant.trainFileName;
import static smv.lovearthstudio.com.svmproj.util.PermissionUtil.requestWriteFilePermission;

public class MainActivity extends AppCompatActivity {

    //Button mBtnTest, mBtnReal, mBtnCollectionData;
    SVM mSvm;
    ViewPager pager = null;
    PagerTabStrip tabStrip = null;
    //ArrayList<View> viewContainter = new ArrayList<View>();
    //ArrayList<String> titleContainer = new ArrayList<String>();
    public String TAG = "tag";

    List<Fragment> pagers;
    List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pager = (ViewPager) this.findViewById(R.id.pg_main);
        tabStrip = (PagerTabStrip) this.findViewById(R.id.tab_strip);
        //取消tab下面的长横线
        tabStrip.setDrawFullUnderline(false);
        //设置tab的背景色
        tabStrip.setBackgroundColor(0);
        //设置当前tab页签的下划线颜色
        tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.colorPrimary));
        tabStrip.setTextSpacing(200);

//        View view1 = LayoutInflater.from(this).inflate(R.layout.fragment_collection, null);
//        View view2 = LayoutInflater.from(this).inflate(R.layout.fragment_predict, null);
//        View view3 = LayoutInflater.from(this).inflate(R.layout.fragment_sensor, null);
//        //viewpager开始添加view
//        viewContainter.add(view1);
//        viewContainter.add(view2);
//        viewContainter.add(view3);

        //页签项
        titles = new ArrayList<>();
        titles.add("采集数据");
        titles.add("测试模型");
        titles.add("真实数据");


        pagers = new ArrayList<>();
        pagers.add(new CollectionFragment());
        pagers.add(new PredictFragment());
        pagers.add(new SensorFragment());

        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

       /* pager.setAdapter(new PagerAdapter() {

            //viewpager中的组件数量
            @Override
            public int getCount() {
                return viewContainter.size();
            }
                      //滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                ((ViewPager) container).removeView(viewContainter.get(position));
            }
                      //每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(viewContainter.get(position));
                return viewContainter.get(position);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleContainer.get(position);
            }
        });*/

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
                Log.d(TAG, "--------changed:" + arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                Log.d(TAG, "-------scrolled arg0:" + arg0);
                Log.d(TAG, "-------scrolled arg1:" + arg1);
                Log.d(TAG, "-------scrolled arg2:" + arg2);
            }

            @Override
            public void onPageSelected(int arg0) {
                Log.d(TAG, "------selected:" + arg0);
            }
        });

        requestWriteFilePermission(this);
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.pg_main, new CollectionFragment())
                .commit();

        crateDataDir();

        copyFileToSd();

        //findView();

        loadModelAndRange();
    }

    /**
     * copy model 和 range文件到sd卡
     */
    private void copyFileToSd() {
        try {
            copyFileToSd(getAssets().open("model"), dir + separator + modelFileName);
            copyFileToSd(getAssets().open("range"), dir + separator + rangeFileName);
            copyFileToSd(getAssets().open("train"), dir + separator + trainFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * copy文件到sd卡
     */
    private void copyFileToSd(InputStream in, String targetFilePath) {
        FileOutputStream fileOutputStream = null;
        File file = new File(targetFilePath);
        if (file.exists()) {        // 如果文件已经存在就结束
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(targetFilePath);
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = in.read(b)) != -1) {
                fileOutputStream.write(b, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建数据目录
     */
    private void crateDataDir() {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File trainFile = new File(dir + separator + train);
        if (!trainFile.exists()) {
            trainFile.mkdirs();
        }
    }

    /**
     * 加载model和range
     */
    private void loadModelAndRange() {
        try {
            mSvm = new SVM(svm.svm_load_model(
                    new BufferedReader(new InputStreamReader(new FileInputStream(dir + separator + modelFileName)))),
                    inputStreamToArray(new FileInputStream(dir + separator + rangeFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id找到view
     */
//    private void findView() {
//        mBtnTest = (Button) findViewById(R.id.btn_test);
//        mBtnReal = (Button) findViewById(R.id.btn_real);
//        mBtnCollectionData = (Button) findViewById(R.id.btn_collection_data);
//        mBtnCollectionData.setEnabled(false);
//    }

//    public void btnClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_collection_data:
//                mBtnCollectionData.setEnabled(false);
//                mBtnTest.setEnabled(true);
//                mBtnReal.setEnabled(true);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new CollectionFragment()).commit();
//                break;
//            case R.id.btn_test:
//                mBtnCollectionData.setEnabled(true);
//                mBtnTest.setEnabled(false);
//                mBtnReal.setEnabled(true);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new PredictFragment()).commit();
//                break;
//            case R.id.btn_real:
//                mBtnCollectionData.setEnabled(true);
//                mBtnTest.setEnabled(true);
//                mBtnReal.setEnabled(false);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new SensorFragment()).commit();
//                break;
//        }
//    }
    public boolean predictUnscaledTrain(String[] unScaleData) {
        return mSvm.predictUnscaledTrain(unScaleData);
    }

    public double predictUnscaled(String[] unScaleData) {
        return mSvm.predictUnscaled(unScaleData, false);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return pagers.get(position);
        }

        @Override
        public int getCount() {
            return pagers.size();
        }
    }

}
