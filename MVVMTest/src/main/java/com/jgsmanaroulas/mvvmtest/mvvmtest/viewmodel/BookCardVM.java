package com.jgsmanaroulas.mvvmtest.mvvmtest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.view.View;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.jgsmanaroulas.mvvmtest.mvvmtest.BR;
import com.jgsmanaroulas.mvvmtest.mvvmtest.download.DownloadBook;
import com.jgsmanaroulas.mvvmtest.mvvmtest.model.Book;

import java.util.Random;

/**
 * Created by jgsmanaroulas on 08/03/16.
 */
public class BookCardVM extends BaseObservable {

    private Book book;
    private int color;

    public BookCardVM(Book book){
        this.book = book;
        this.color = createColor();
    }
    private int createColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        view.setBackgroundColor(color);
    }

    @Bindable
    public int getColor(){
        return color;
    }

    public String getBookName(){
        return book.getName();
    }

    public String getBookVersion(){
        return book.getVersion();
    }


    public void setPercentage(int percentage){
        book.setPercentage(percentage);
        notifyPropertyChanged(BR.percentage);
    }

    @Bindable
    public String getPercentage(){
        return String.valueOf(book.getPercentage());
    }
//
//    @BindingAdapter("custom:circle_progress")
//    public CircleProgress setPercentage(CircleProgress view, int percent){
//        view.setProgress(percent);
//        book.setPercentage(percent);
////        notifyPropertyChanged(BR.bookCardVM);
//        return view;
//    }
//
    public View.OnClickListener onBookCardClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DownloadBook.startDownload(BookCardVM.this);
        }
    };

}
