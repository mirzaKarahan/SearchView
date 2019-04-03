package com.mirzakarahan.searchview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SearchView extends RelativeLayout {
    private Context mContext;
    private EditText edtSearch;
    private Button btnSearch,btnSort;
    private ISearchView iSearchView;

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        LayoutInflater mInflate= LayoutInflater.from(context);
        View mView =mInflate.inflate(R.layout.search_view,this,true);

        edtSearch = mView.findViewById(R.id.edtSearchCategory);
        btnSearch = mView.findViewById(R.id.btnSearchCategory);
        btnSort = mView.findViewById(R.id.btnSortCategory);
        if (!btnSort.isEnabled()){

        }
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iSearchView != null && edtSearch.getText().length()>2){
                    iSearchView.onSearch(getSearch());
                }
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iSearchView != null){
                    iSearchView.onSort();
                }
            }
        });
    }


    public void setListener(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
    }

    public String getSearch(){
        return edtSearch.getText().toString();
    }

    public void setBtnSortEnable(Boolean status){
        btnSort.setEnabled(status);
        if (status) {
            btnSort.setVisibility(VISIBLE);
        } else {
            btnSort.setVisibility(GONE);
        }
    }
    public void setBtnSearchEnable(Boolean status){
        btnSearch.setEnabled(status);
    }
}
