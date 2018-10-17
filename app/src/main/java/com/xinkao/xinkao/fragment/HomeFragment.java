package com.xinkao.xinkao.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.adapter.HomeAdapter;
import com.xinkao.xinkao.bean.HomeBean;
import com.xinkao.xinkao.utils.HttpUtils;
import com.xinkao.xinkao.utils.JsonTools;

import java.util.List;

/**
 * Create by 钱 on 2018/9/26 0026.
 */
public class HomeFragment extends Fragment {
    private ListView mListView;
    private final String apiUrl = "http://api.cclive.xinkaoyun.com/cc/teacher/getRooms?teacherId=530";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, null);
        mListView = homeView.findViewById(R.id.lv_home);
        new pullApi().execute();
        return homeView;
    }

    class pullApi extends AsyncTask<HomeBean, Void, List<HomeBean>> {
        @Override
        protected void onPostExecute(List<HomeBean> homeBeans) {
            super.onPostExecute(homeBeans);
            HomeAdapter mAdapter = new HomeAdapter(getActivity(),homeBeans);
            mListView.setAdapter(mAdapter);
        }

        @Override
        protected List<HomeBean> doInBackground(HomeBean... homeBeans) {
            List<HomeBean> homeBeanList;
            String jsonString = HttpUtils.sendGetMethod(apiUrl);
            homeBeanList = JsonTools.parseList(jsonString);
            return homeBeanList;
        }
    }

}
