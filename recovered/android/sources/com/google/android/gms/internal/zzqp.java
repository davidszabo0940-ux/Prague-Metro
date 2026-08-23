package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface zzqp {
    void startActivityForResult(Intent intent, int i);

    <T extends zzqo> T zza(String str, Class<T> cls);

    void zza(String str, @NonNull zzqo zzqoVar);

    Activity zzaqp();
}
