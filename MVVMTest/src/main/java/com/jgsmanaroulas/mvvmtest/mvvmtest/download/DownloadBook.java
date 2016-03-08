package com.jgsmanaroulas.mvvmtest.mvvmtest.download;

import com.jgsmanaroulas.mvvmtest.mvvmtest.model.Book;
import com.jgsmanaroulas.mvvmtest.mvvmtest.viewmodel.BookCardVM;

/**
 * Created by jgsmanaroulas on 08/03/16.
 */
public class DownloadBook {

    public static void startDownload(final BookCardVM book){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (Integer.parseInt(book.getPercentage())<100){
                    try {
                        Thread.sleep(1000);
                        book.setPercentage(Integer.parseInt(book.getPercentage())+3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
