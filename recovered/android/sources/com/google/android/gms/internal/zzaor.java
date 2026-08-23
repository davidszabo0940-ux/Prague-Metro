package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class zzaor implements Closeable, Flushable {
    private static final String[] bhK = new String[128];
    private static final String[] bhL;
    private boolean bec;
    private boolean bed;
    private String bhM;
    private String bhN;
    private boolean bhn;
    private int[] bhv = new int[32];
    private int bhw = 0;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            bhK[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        bhK[34] = "\\\"";
        bhK[92] = "\\\\";
        bhK[9] = "\\t";
        bhK[8] = "\\b";
        bhK[10] = "\\n";
        bhK[13] = "\\r";
        bhK[12] = "\\f";
        bhL = (String[]) bhK.clone();
        bhL[60] = "\\u003c";
        bhL[62] = "\\u003e";
        bhL[38] = "\\u0026";
        bhL[61] = "\\u003d";
        bhL[39] = "\\u0027";
    }

    public zzaor(Writer writer) {
        zzaec(6);
        this.separator = ":";
        this.bec = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    /* JADX INFO: renamed from: F */
    private int m44F() {
        if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.bhv[this.bhw - 1];
    }

    /* JADX INFO: renamed from: G */
    private void m45G() throws IOException {
        if (this.bhN != null) {
            m47I();
            zzte(this.bhN);
            this.bhN = null;
        }
    }

    /* JADX INFO: renamed from: H */
    private void m46H() throws IOException {
        if (this.bhM == null) {
            return;
        }
        this.out.write("\n");
        int i = this.bhw;
        for (int i2 = 1; i2 < i; i2++) {
            this.out.write(this.bhM);
        }
    }

    /* JADX INFO: renamed from: I */
    private void m47I() throws IOException {
        int iM44F = m44F();
        if (iM44F == 5) {
            this.out.write(44);
        } else if (iM44F != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m46H();
        zzaee(4);
    }

    private void zzaec(int i) {
        if (this.bhw == this.bhv.length) {
            int[] iArr = new int[this.bhw * 2];
            System.arraycopy(this.bhv, 0, iArr, 0, this.bhw);
            this.bhv = iArr;
        }
        int[] iArr2 = this.bhv;
        int i2 = this.bhw;
        this.bhw = i2 + 1;
        iArr2[i2] = i;
    }

    private void zzaee(int i) {
        this.bhv[this.bhw - 1] = i;
    }

    private zzaor zzc(int i, int i2, String str) throws IOException {
        int iM44F = m44F();
        if (iM44F != i2 && iM44F != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.bhN != null) {
            String strValueOf = String.valueOf(this.bhN);
            throw new IllegalStateException(strValueOf.length() != 0 ? "Dangling name: ".concat(strValueOf) : new String("Dangling name: "));
        }
        this.bhw--;
        if (iM44F == i2) {
            m46H();
        }
        this.out.write(str);
        return this;
    }

    private void zzdd(boolean z) throws IOException {
        switch (m44F()) {
            case 1:
                zzaee(2);
                m46H();
                return;
            case 2:
                this.out.append(',');
                m46H();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                zzaee(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.bhn) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.bhn && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        zzaee(7);
    }

    private zzaor zzq(int i, String str) throws IOException {
        zzdd(true);
        zzaec(i);
        this.out.write(str);
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    private void zzte(String str) throws IOException {
        String str2;
        int i = 0;
        String[] strArr = this.bed ? bhL : bhK;
        this.out.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.out.write(str, i, i2 - i);
                    }
                    this.out.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.out.write(str, i, i2 - i);
                }
                this.out.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    /* JADX INFO: renamed from: D */
    public final boolean m48D() {
        return this.bed;
    }

    /* JADX INFO: renamed from: E */
    public final boolean m49E() {
        return this.bec;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.bhw;
        if (i > 1 || (i == 1 && this.bhv[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.bhw = 0;
    }

    public void flush() throws IOException {
        if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public boolean isLenient() {
        return this.bhn;
    }

    /* JADX INFO: renamed from: n */
    public zzaor mo28n() throws IOException {
        m45G();
        return zzq(1, "[");
    }

    /* JADX INFO: renamed from: o */
    public zzaor mo29o() throws IOException {
        return zzc(1, 2, "]");
    }

    /* JADX INFO: renamed from: p */
    public zzaor mo30p() throws IOException {
        m45G();
        return zzq(3, "{");
    }

    /* JADX INFO: renamed from: q */
    public zzaor mo31q() throws IOException {
        return zzc(3, 5, "}");
    }

    /* JADX INFO: renamed from: r */
    public zzaor mo32r() throws IOException {
        if (this.bhN == null) {
            zzdd(false);
            this.out.write("null");
        } else if (this.bec) {
            m45G();
            zzdd(false);
            this.out.write("null");
        } else {
            this.bhN = null;
        }
        return this;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.bhM = null;
            this.separator = ":";
        } else {
            this.bhM = str;
            this.separator = ": ";
        }
    }

    public final void setLenient(boolean z) {
        this.bhn = z;
    }

    public zzaor zza(Number number) throws IOException {
        if (number == null) {
            return mo32r();
        }
        m45G();
        String string = number.toString();
        if (!this.bhn && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            String strValueOf = String.valueOf(number);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 39).append("Numeric values must be finite, but was ").append(strValueOf).toString());
        }
        zzdd(false);
        this.out.append((CharSequence) string);
        return this;
    }

    public zzaor zzcp(long j) throws IOException {
        m45G();
        zzdd(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public zzaor zzcz(boolean z) throws IOException {
        m45G();
        zzdd(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public final void zzdb(boolean z) {
        this.bed = z;
    }

    public final void zzdc(boolean z) {
        this.bec = z;
    }

    public zzaor zzta(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.bhN != null) {
            throw new IllegalStateException();
        }
        if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.bhN = str;
        return this;
    }

    public zzaor zztb(String str) throws IOException {
        if (str == null) {
            return mo32r();
        }
        m45G();
        zzdd(false);
        zzte(str);
        return this;
    }
}
