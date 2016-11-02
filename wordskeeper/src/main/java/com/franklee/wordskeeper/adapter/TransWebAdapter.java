package com.franklee.wordskeeper.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.franklee.wordskeeper.BR;
import com.franklee.wordskeeper.R;
import com.franklee.wordskeeper.bean.WebBean;
import com.franklee.wordskeeper.databinding.ItemTranWebBinding;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public class TransWebAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<WebBean> mList;
    private ItemTranWebBinding binding;

    public View.OnClickListener itemClickListener;

    public TransWebAdapter(Context context, List<WebBean> list){
        mContext = context;
        inflater = LayoutInflater.from(context);
        mList = list;


    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            binding = DataBindingUtil.inflate(inflater, R.layout.item_tran_web, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);

        }else {
            binding = (ItemTranWebBinding) convertView.getTag();
        }
        WebBean webBean = mList.get(position);
        binding.setVariable(BR.item, webBean.getKey());
        binding.setItem2(webBean.getStr_value());
        binding.setAdapter(this);
        return  convertView;
    }


    public void setOnclickListener(View.OnClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
