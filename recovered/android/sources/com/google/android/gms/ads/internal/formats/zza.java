package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzir;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zza {
    private static final int zzbew = Color.rgb(12, 174, 206);
    private static final int zzbex = Color.rgb(204, 204, 204);
    static final int zzbey = zzbex;
    static final int zzbez = zzbew;
    private final int mBackgroundColor;
    private final int mTextColor;
    private final String zzbfa;
    private final List<Drawable> zzbfb;
    private final int zzbfc;
    private final int zzbfd;
    private final int zzbfe;

    public zza(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i, int i2) {
        this.zzbfa = str;
        this.zzbfb = list;
        this.mBackgroundColor = num != null ? num.intValue() : zzbey;
        this.mTextColor = num2 != null ? num2.intValue() : zzbez;
        this.zzbfc = num3 != null ? num3.intValue() : 12;
        this.zzbfd = i;
        this.zzbfe = i2;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public String getText() {
        return this.zzbfa;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.zzbfc;
    }

    public List<Drawable> zzkr() {
        return this.zzbfb;
    }

    public int zzks() {
        return this.zzbfd;
    }

    public int zzkt() {
        return this.zzbfe;
    }
}
