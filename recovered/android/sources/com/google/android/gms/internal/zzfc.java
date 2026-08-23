package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfc implements zzet {
    private final zza zzbjc;

    public interface zza {
        void zzb(RewardItemParcel rewardItemParcel);

        void zzev();
    }

    public zzfc(zza zzaVar) {
        this.zzbjc = zzaVar;
    }

    public static void zza(zzll zzllVar, zza zzaVar) {
        zzllVar.zzuk().zza("/reward", new zzfc(zzaVar));
    }

    private void zze(Map<String, String> map) {
        RewardItemParcel rewardItemParcel;
        try {
            int i = Integer.parseInt(map.get("amount"));
            String str = map.get("type");
            rewardItemParcel = !TextUtils.isEmpty(str) ? new RewardItemParcel(str, i) : null;
        } catch (NumberFormatException e) {
            zzkh.zzd("Unable to parse reward amount.", e);
        }
        this.zzbjc.zzb(rewardItemParcel);
    }

    private void zzf(Map<String, String> map) {
        this.zzbjc.zzev();
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zze(map);
        } else if ("video_start".equals(str)) {
            zzf(map);
        }
    }
}
