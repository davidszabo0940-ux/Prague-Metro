package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class zzand {
    public zzamy zza(Reader reader) throws zzanh, zzamz {
        try {
            zzaop zzaopVar = new zzaop(reader);
            zzamy zzamyVarZzh = zzh(zzaopVar);
            if (zzamyVarZzh.zzczp() || zzaopVar.mo24h() == zzaoq.END_DOCUMENT) {
                return zzamyVarZzh;
            }
            throw new zzanh("Did not consume the entire document.");
        } catch (zzaos e) {
            throw new zzanh(e);
        } catch (IOException e2) {
            throw new zzamz(e2);
        } catch (NumberFormatException e3) {
            throw new zzanh(e3);
        }
    }

    public zzamy zzh(zzaop zzaopVar) throws zzanh, zzamz {
        boolean zIsLenient = zzaopVar.isLenient();
        zzaopVar.setLenient(true);
        try {
            try {
                zzamy zzamyVarZzh = zzanz.zzh(zzaopVar);
                zzaopVar.setLenient(zIsLenient);
                return zzamyVarZzh;
            } catch (OutOfMemoryError e) {
                String strValueOf = String.valueOf(zzaopVar);
                throw new zzanc(new StringBuilder(String.valueOf(strValueOf).length() + 36).append("Failed parsing JSON source: ").append(strValueOf).append(" to Json").toString(), e);
            } catch (StackOverflowError e2) {
                String strValueOf2 = String.valueOf(zzaopVar);
                throw new zzanc(new StringBuilder(String.valueOf(strValueOf2).length() + 36).append("Failed parsing JSON source: ").append(strValueOf2).append(" to Json").toString(), e2);
            }
        } catch (Throwable th) {
            zzaopVar.setLenient(zIsLenient);
            throw th;
        }
    }

    public zzamy zzsy(String str) throws zzanh {
        return zza(new StringReader(str));
    }
}
