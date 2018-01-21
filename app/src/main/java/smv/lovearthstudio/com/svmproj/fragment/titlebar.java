package smv.lovearthstudio.com.svmproj.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import smv.lovearthstudio.com.svmproj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class titlebar extends Fragment {
    View view;
    TextView mTextTitlebar;

    public titlebar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_titlebar, container, false);
        mTextTitlebar = (TextView) view.findViewById(R.id.tv_titlebar);
        return view;
    }

    public void setTitlebar(String title) {
        mTextTitlebar.setText(title);
    }

}
