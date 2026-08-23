package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaog extends zzaor {
    private static final Writer bfM = new Writer() { // from class: com.google.android.gms.internal.zzaog.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    private static final zzane bfN = new zzane("closed");
    private final List<zzamy> bfL;
    private String bfO;
    private zzamy bfP;

    public zzaog() {
        super(bfM);
        this.bfL = new ArrayList();
        this.bfP = zzana.bes;
    }

    /* JADX INFO: renamed from: m */
    private zzamy m26m() {
        return this.bfL.get(this.bfL.size() - 1);
    }

    private void zzd(zzamy zzamyVar) {
        if (this.bfO != null) {
            if (!zzamyVar.zzczp() || m49E()) {
                ((zzanb) m26m()).zza(this.bfO, zzamyVar);
            }
            this.bfO = null;
            return;
        }
        if (this.bfL.isEmpty()) {
            this.bfP = zzamyVar;
            return;
        }
        zzamy zzamyVarM26m = m26m();
        if (!(zzamyVarM26m instanceof zzamv)) {
            throw new IllegalStateException();
        }
        ((zzamv) zzamyVarM26m).zzc(zzamyVar);
    }

    @Override // com.google.android.gms.internal.zzaor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.bfL.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.bfL.add(bfN);
    }

    @Override // com.google.android.gms.internal.zzaor, java.io.Flushable
    public void flush() throws IOException {
    }

    /* JADX INFO: renamed from: l */
    public zzamy m27l() {
        if (this.bfL.isEmpty()) {
            return this.bfP;
        }
        String strValueOf = String.valueOf(this.bfL);
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 34).append("Expected one JSON element but was ").append(strValueOf).toString());
    }

    @Override // com.google.android.gms.internal.zzaor
    /* JADX INFO: renamed from: n */
    public zzaor mo28n() throws IOException {
        zzamv zzamvVar = new zzamv();
        zzd(zzamvVar);
        this.bfL.add(zzamvVar);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    /* JADX INFO: renamed from: o */
    public zzaor mo29o() throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        }
        if (!(m26m() instanceof zzamv)) {
            throw new IllegalStateException();
        }
        this.bfL.remove(this.bfL.size() - 1);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    /* JADX INFO: renamed from: p */
    public zzaor mo30p() throws IOException {
        zzanb zzanbVar = new zzanb();
        zzd(zzanbVar);
        this.bfL.add(zzanbVar);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    /* JADX INFO: renamed from: q */
    public zzaor mo31q() throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        }
        if (!(m26m() instanceof zzanb)) {
            throw new IllegalStateException();
        }
        this.bfL.remove(this.bfL.size() - 1);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    /* JADX INFO: renamed from: r */
    public zzaor mo32r() throws IOException {
        zzd(zzana.bes);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    public zzaor zza(Number number) throws IOException {
        if (number == null) {
            return mo32r();
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                String strValueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(strValueOf).toString());
            }
        }
        zzd(new zzane(number));
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    public zzaor zzcp(long j) throws IOException {
        zzd(new zzane(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    public zzaor zzcz(boolean z) throws IOException {
        zzd(new zzane(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    public zzaor zzta(String str) throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        }
        if (!(m26m() instanceof zzanb)) {
            throw new IllegalStateException();
        }
        this.bfO = str;
        return this;
    }

    @Override // com.google.android.gms.internal.zzaor
    public zzaor zztb(String str) throws IOException {
        if (str == null) {
            return mo32r();
        }
        zzd(new zzane(str));
        return this;
    }
}
