package com.h5190019.ibrahim_metehan_barutcu.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190019.ibrahim_metehan_barutcu.R;

public class GlideUtil {

    public static void downloadAndShowImage(Context context, String url, ImageView img) {
        Glide.with(context)
                .load(url)
                .error(R.drawable.error)
                .centerCrop()
                .into(img);
    }
}
