package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class zzanz {

    private static final class zza extends Writer {
        private final Appendable bfx;
        private final C0762zza bfy;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzanz$zza$zza, reason: collision with other inner class name */
        static class C0762zza implements CharSequence {
            char[] bfz;

            C0762zza() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.bfz[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.bfz.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.bfz, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.bfy = new C0762zza();
            this.bfx = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.bfx.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.bfy.bfz = cArr;
            this.bfx.append(this.bfy, i, i + i2);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzamy zzamyVar, zzaor zzaorVar) throws IOException {
        zzaon.bgW.zza(zzaorVar, zzamyVar);
    }

    public static zzamy zzh(zzaop zzaopVar) throws zzanc {
        boolean z = true;
        try {
            zzaopVar.mo24h();
            z = false;
            return zzaon.bgW.zzb(zzaopVar);
        } catch (zzaos e) {
            throw new zzanh(e);
        } catch (EOFException e2) {
            if (z) {
                return zzana.bes;
            }
            throw new zzanh(e2);
        } catch (IOException e3) {
            throw new zzamz(e3);
        } catch (NumberFormatException e4) {
            throw new zzanh(e4);
        }
    }
}
