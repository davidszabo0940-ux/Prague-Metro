package com.google.unity.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.io.ByteArrayOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CustomNativeAd {
    private Activity activity;
    private NativeCustomTemplateAd nativeAd;

    public CustomNativeAd(Activity activity, NativeCustomTemplateAd ad) {
        this.activity = activity;
        this.nativeAd = ad;
    }

    public String[] getAvailableAssetNames() {
        List<String> assetNames = this.nativeAd.getAvailableAssetNames();
        return (String[]) assetNames.toArray(new String[assetNames.size()]);
    }

    public String getTemplateId() {
        return this.nativeAd.getCustomTemplateId();
    }

    public void performClick(final String assetName) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.CustomNativeAd.1
            @Override // java.lang.Runnable
            public void run() {
                CustomNativeAd.this.nativeAd.performClick(assetName);
            }
        });
    }

    public void recordImpression() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.CustomNativeAd.2
            @Override // java.lang.Runnable
            public void run() {
                CustomNativeAd.this.nativeAd.recordImpression();
            }
        });
    }

    public byte[] getImage(String key) {
        NativeAd.Image imageAsset = this.nativeAd.getImage(key);
        if (imageAsset == null) {
            return new byte[0];
        }
        Drawable imageDrawable = imageAsset.getDrawable();
        Bitmap bitmap = ((BitmapDrawable) imageDrawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public String getText(String key) {
        CharSequence assetText = this.nativeAd.getText(key);
        return assetText == null ? "" : this.nativeAd.getText(key).toString();
    }
}
