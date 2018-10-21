package com.xinkao.xinkao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.exceptions.HyphenateException;
import com.xinkao.xinkao.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsList extends Fragment {
    private View contactsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contactsList = inflater.inflate(R.layout.fragment_contact_list,null);
//        contactsList.findViewById(R.id.ec_layout_contacts_list);
//        getChildFragmentManager().beginTransaction().add(R.id.ec_layout_contacts_list, contactListFragment).commit();

        return contactsList;

    }
    private Map<String, EaseUser> getContacts() {
        Map<String, EaseUser> map = new HashMap<>();
        try {
            List<String> userNames = EMClient.getInstance().contactManager().getAllContactsFromServer();
//            KLog.e("......有几个好友:" + userNames.size());
            for (String userId : userNames) {
//                KLog.e("好友列表中有 : " + userId);
                map.put(userId, new EaseUser(userId));
            }
        } catch (HyphenateException e) {
            e.printStackTrace();
        }
        return map;
    }
}
