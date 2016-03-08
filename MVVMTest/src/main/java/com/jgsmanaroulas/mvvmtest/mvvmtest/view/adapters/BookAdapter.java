package com.jgsmanaroulas.mvvmtest.mvvmtest.view.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.jgsmanaroulas.mvvmtest.mvvmtest.R;
import com.jgsmanaroulas.mvvmtest.mvvmtest.BR;
import com.jgsmanaroulas.mvvmtest.mvvmtest.databinding.BookCardBinding;
import com.jgsmanaroulas.mvvmtest.mvvmtest.download.DownloadBook;
import com.jgsmanaroulas.mvvmtest.mvvmtest.viewmodel.BookCardVM;

import java.util.ArrayList;

/**
 * Created by jgsmanaroulas on 07/03/16.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<BookCardVM> items;
    private RecyclerView recyclerView;

    public BookAdapter(ArrayList<BookCardVM> items, RecyclerView view){
        this.items = items;
        this.recyclerView = view;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_card, viewGroup, false);
//        view.setOnClickListener(mOnClickListener);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int i) {
        final BookCardVM vm = items.get(i);
        bookViewHolder.getBinding().setBookCardVM(vm);
        bookViewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class BookViewHolder extends RecyclerView.ViewHolder{
        private BookCardBinding binding;

        public BookViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BookCardVM item = items.get(getLayoutPosition());
                    DownloadBook.startDownload(item);
                }
            });
            this.binding = DataBindingUtil.bind(itemView);
        }

        public BookCardBinding getBinding(){
            return binding;
        }
    }

}
