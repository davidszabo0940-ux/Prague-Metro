package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcm {
    private int zzasf;
    private final Object zzail = new Object();
    private List<zzcl> zzasg = new LinkedList();

    public boolean zza(zzcl zzclVar) {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzasg.contains(zzclVar);
        }
        return z;
    }

    public boolean zzb(zzcl zzclVar) {
        boolean z;
        synchronized (this.zzail) {
            Iterator<zzcl> it = this.zzasg.iterator();
            while (it.hasNext()) {
                zzcl next = it.next();
                if (zzclVar != next && next.zzhr().equals(zzclVar.zzhr())) {
                    it.remove();
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public void zzc(zzcl zzclVar) {
        synchronized (this.zzail) {
            if (this.zzasg.size() >= 10) {
                zzkh.zzcw(new StringBuilder(41).append("Queue is full, current size = ").append(this.zzasg.size()).toString());
                this.zzasg.remove(0);
            }
            int i = this.zzasf;
            this.zzasf = i + 1;
            zzclVar.zzl(i);
            this.zzasg.add(zzclVar);
        }
    }

    public zzcl zzhy() {
        int i;
        zzcl zzclVar;
        zzcl zzclVar2 = null;
        synchronized (this.zzail) {
            if (this.zzasg.size() == 0) {
                zzkh.zzcw("Queue empty");
                return null;
            }
            if (this.zzasg.size() < 2) {
                zzcl zzclVar3 = this.zzasg.get(0);
                zzclVar3.zzht();
                return zzclVar3;
            }
            int i2 = Integer.MIN_VALUE;
            for (zzcl zzclVar4 : this.zzasg) {
                int score = zzclVar4.getScore();
                if (score > i2) {
                    zzclVar = zzclVar4;
                    i = score;
                } else {
                    i = i2;
                    zzclVar = zzclVar2;
                }
                i2 = i;
                zzclVar2 = zzclVar;
            }
            this.zzasg.remove(zzclVar2);
            return zzclVar2;
        }
    }
}
