package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzaof extends zzaop {
    private static final Reader bfJ = new Reader() { // from class: com.google.android.gms.internal.zzaof.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object bfK = new Object();
    private final List<Object> bfL;

    public zzaof(zzamy zzamyVar) {
        super(bfJ);
        this.bfL = new ArrayList();
        this.bfL.add(zzamyVar);
    }

    /* JADX INFO: renamed from: i */
    private Object m22i() {
        return this.bfL.get(this.bfL.size() - 1);
    }

    /* JADX INFO: renamed from: j */
    private Object m23j() {
        return this.bfL.remove(this.bfL.size() - 1);
    }

    private void zza(zzaoq zzaoqVar) throws IOException {
        if (mo24h() != zzaoqVar) {
            String strValueOf = String.valueOf(zzaoqVar);
            String strValueOf2 = String.valueOf(mo24h());
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 18 + String.valueOf(strValueOf2).length()).append("Expected ").append(strValueOf).append(" but was ").append(strValueOf2).toString());
        }
    }

    @Override // com.google.android.gms.internal.zzaop
    public void beginArray() throws IOException {
        zza(zzaoq.BEGIN_ARRAY);
        this.bfL.add(((zzamv) m22i()).iterator());
    }

    @Override // com.google.android.gms.internal.zzaop
    public void beginObject() throws IOException {
        zza(zzaoq.BEGIN_OBJECT);
        this.bfL.add(((zzanb) m22i()).entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.zzaop, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.bfL.clear();
        this.bfL.add(bfK);
    }

    @Override // com.google.android.gms.internal.zzaop
    public void endArray() throws IOException {
        zza(zzaoq.END_ARRAY);
        m23j();
        m23j();
    }

    @Override // com.google.android.gms.internal.zzaop
    public void endObject() throws IOException {
        zza(zzaoq.END_OBJECT);
        m23j();
        m23j();
    }

    @Override // com.google.android.gms.internal.zzaop
    /* JADX INFO: renamed from: h */
    public zzaoq mo24h() throws IOException {
        if (this.bfL.isEmpty()) {
            return zzaoq.END_DOCUMENT;
        }
        Object objM22i = m22i();
        if (objM22i instanceof Iterator) {
            boolean z = this.bfL.get(this.bfL.size() - 2) instanceof zzanb;
            Iterator it = (Iterator) objM22i;
            if (!it.hasNext()) {
                return z ? zzaoq.END_OBJECT : zzaoq.END_ARRAY;
            }
            if (z) {
                return zzaoq.NAME;
            }
            this.bfL.add(it.next());
            return mo24h();
        }
        if (objM22i instanceof zzanb) {
            return zzaoq.BEGIN_OBJECT;
        }
        if (objM22i instanceof zzamv) {
            return zzaoq.BEGIN_ARRAY;
        }
        if (!(objM22i instanceof zzane)) {
            if (objM22i instanceof zzana) {
                return zzaoq.NULL;
            }
            if (objM22i == bfK) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        zzane zzaneVar = (zzane) objM22i;
        if (zzaneVar.zzczw()) {
            return zzaoq.STRING;
        }
        if (zzaneVar.zzczu()) {
            return zzaoq.BOOLEAN;
        }
        if (zzaneVar.zzczv()) {
            return zzaoq.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.zzaop
    public boolean hasNext() throws IOException {
        zzaoq zzaoqVarMo24h = mo24h();
        return (zzaoqVarMo24h == zzaoq.END_OBJECT || zzaoqVarMo24h == zzaoq.END_ARRAY) ? false : true;
    }

    /* JADX INFO: renamed from: k */
    public void m25k() throws IOException {
        zza(zzaoq.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m22i()).next();
        this.bfL.add(entry.getValue());
        this.bfL.add(new zzane((String) entry.getKey()));
    }

    @Override // com.google.android.gms.internal.zzaop
    public boolean nextBoolean() throws IOException {
        zza(zzaoq.BOOLEAN);
        return ((zzane) m23j()).zzczl();
    }

    @Override // com.google.android.gms.internal.zzaop
    public double nextDouble() throws IOException {
        zzaoq zzaoqVarMo24h = mo24h();
        if (zzaoqVarMo24h != zzaoq.NUMBER && zzaoqVarMo24h != zzaoq.STRING) {
            String strValueOf = String.valueOf(zzaoq.NUMBER);
            String strValueOf2 = String.valueOf(zzaoqVarMo24h);
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 18 + String.valueOf(strValueOf2).length()).append("Expected ").append(strValueOf).append(" but was ").append(strValueOf2).toString());
        }
        double dZzczi = ((zzane) m22i()).zzczi();
        if (!isLenient() && (Double.isNaN(dZzczi) || Double.isInfinite(dZzczi))) {
            throw new NumberFormatException(new StringBuilder(57).append("JSON forbids NaN and infinities: ").append(dZzczi).toString());
        }
        m23j();
        return dZzczi;
    }

    @Override // com.google.android.gms.internal.zzaop
    public int nextInt() throws IOException {
        zzaoq zzaoqVarMo24h = mo24h();
        if (zzaoqVarMo24h == zzaoq.NUMBER || zzaoqVarMo24h == zzaoq.STRING) {
            int iZzczk = ((zzane) m22i()).zzczk();
            m23j();
            return iZzczk;
        }
        String strValueOf = String.valueOf(zzaoq.NUMBER);
        String strValueOf2 = String.valueOf(zzaoqVarMo24h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 18 + String.valueOf(strValueOf2).length()).append("Expected ").append(strValueOf).append(" but was ").append(strValueOf2).toString());
    }

    @Override // com.google.android.gms.internal.zzaop
    public long nextLong() throws IOException {
        zzaoq zzaoqVarMo24h = mo24h();
        if (zzaoqVarMo24h == zzaoq.NUMBER || zzaoqVarMo24h == zzaoq.STRING) {
            long jZzczj = ((zzane) m22i()).zzczj();
            m23j();
            return jZzczj;
        }
        String strValueOf = String.valueOf(zzaoq.NUMBER);
        String strValueOf2 = String.valueOf(zzaoqVarMo24h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 18 + String.valueOf(strValueOf2).length()).append("Expected ").append(strValueOf).append(" but was ").append(strValueOf2).toString());
    }

    @Override // com.google.android.gms.internal.zzaop
    public String nextName() throws IOException {
        zza(zzaoq.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m22i()).next();
        this.bfL.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.android.gms.internal.zzaop
    public void nextNull() throws IOException {
        zza(zzaoq.NULL);
        m23j();
    }

    @Override // com.google.android.gms.internal.zzaop
    public String nextString() throws IOException {
        zzaoq zzaoqVarMo24h = mo24h();
        if (zzaoqVarMo24h == zzaoq.STRING || zzaoqVarMo24h == zzaoq.NUMBER) {
            return ((zzane) m23j()).zzczh();
        }
        String strValueOf = String.valueOf(zzaoq.STRING);
        String strValueOf2 = String.valueOf(zzaoqVarMo24h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 18 + String.valueOf(strValueOf2).length()).append("Expected ").append(strValueOf).append(" but was ").append(strValueOf2).toString());
    }

    @Override // com.google.android.gms.internal.zzaop
    public void skipValue() throws IOException {
        if (mo24h() == zzaoq.NAME) {
            nextName();
        } else {
            m23j();
        }
    }

    @Override // com.google.android.gms.internal.zzaop
    public String toString() {
        return getClass().getSimpleName();
    }
}
