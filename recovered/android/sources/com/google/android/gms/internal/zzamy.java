package com.google.android.gms.internal;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzamy {
    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzaor zzaorVar = new zzaor(stringWriter);
            zzaorVar.setLenient(true);
            zzanz.zzb(this, zzaorVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public Number zzczg() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String zzczh() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double zzczi() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long zzczj() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int zzczk() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean zzczl() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean zzczm() {
        return this instanceof zzamv;
    }

    public boolean zzczn() {
        return this instanceof zzanb;
    }

    public boolean zzczo() {
        return this instanceof zzane;
    }

    public boolean zzczp() {
        return this instanceof zzana;
    }

    public zzanb zzczq() {
        if (zzczn()) {
            return (zzanb) this;
        }
        String strValueOf = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 19).append("Not a JSON Object: ").append(strValueOf).toString());
    }

    public zzamv zzczr() {
        if (zzczm()) {
            return (zzamv) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public zzane zzczs() {
        if (zzczo()) {
            return (zzane) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean zzczt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }
}
