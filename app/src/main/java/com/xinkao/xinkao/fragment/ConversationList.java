package com.xinkao.xinkao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.xinkao.xinkao.R;
import com.xinkao.xinkao.activity.ChatActivity;

/**
 * Create by 钱 on 2018/9/26 0026.
 */
public class ConversationList extends Fragment {
    private View chatView;
    //Fragment管理对象
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chatView = inflater.inflate(R.layout.fragment_conversation_list, null);
        //        chatView.findViewById(R.id.back_iv).setVisibility(View.GONE);
                final EditText userId = chatView.findViewById(R.id.user_id);
//        fragmentManager = getChildFragmentManager();
        final ContactsList contactsList = new ContactsList();
        chatView.findViewById(R.id.btn_chat_begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(getContext(),ChatActivity.class);
                        intent.putExtra(EaseConstant.EXTRA_USER_ID,"13557599007");
                        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                        startActivity(intent);
                        startActivity(new Intent(getContext(),ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID,userId.getText().toString().trim()));
//                            chatView.findViewById(R.id.btn_chat_begin).setVisibility(View.GONE);
//                            fragmentTransaction=fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.ec_layout_conversation_lv,contactsList,null);
//                            fragmentTransaction.addToBackStack(null);
//                            fragmentTransaction.commit();

            }
        });
        EaseConversationListFragment conversationListFragment = new EaseConversationListFragment();
        getChildFragmentManager().beginTransaction().add(R.id.ec_layout_conversation_list, conversationListFragment).commit();
        conversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {

            @Override
            public void onListItemClicked(EMConversation conversation) {
                startActivity(new Intent(getContext(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, conversation.conversationId()));
            }
        });
        return chatView;
    }
}
