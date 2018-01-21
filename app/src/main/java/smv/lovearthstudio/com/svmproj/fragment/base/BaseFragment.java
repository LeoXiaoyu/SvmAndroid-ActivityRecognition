package smv.lovearthstudio.com.svmproj.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Fragment的父类
 *
 * @author zhaoliang 2016-10-3
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        findView();
        setOnClickListener();
        setOnItemSelectListener();
    }

    /**
     * 查找控件
     */
    protected abstract void findView();

    /**
     * 设置点击事件
     */
    protected abstract void setOnClickListener();

    /**
     * 设置itemSelectListener
     */
    protected abstract void setOnItemSelectListener();
}
