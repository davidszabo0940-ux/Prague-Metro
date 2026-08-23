package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf {

    /* JADX INFO: renamed from: xC */
    public static final zzf f305xC = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000 \u180e ").zza(zza(8192, 8202));

    /* JADX INFO: renamed from: xD */
    public static final zzf f306xD = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").zza(zza(8192, 8198)).zza(zza(8200, 8202));

    /* JADX INFO: renamed from: xE */
    public static final zzf f307xE = zza(0, 127);

    /* JADX INFO: renamed from: xF */
    public static final zzf f308xF;

    /* JADX INFO: renamed from: xG */
    public static final zzf f309xG;

    /* JADX INFO: renamed from: xH */
    public static final zzf f310xH;

    /* JADX INFO: renamed from: xI */
    public static final zzf f311xI;

    /* JADX INFO: renamed from: xJ */
    public static final zzf f312xJ;

    /* JADX INFO: renamed from: xK */
    public static final zzf f313xK;

    /* JADX INFO: renamed from: xL */
    public static final zzf f314xL;

    /* JADX INFO: renamed from: xM */
    public static final zzf f315xM;

    /* JADX INFO: renamed from: xN */
    public static final zzf f316xN;

    /* JADX INFO: renamed from: xO */
    public static final zzf f317xO;

    /* JADX INFO: renamed from: xP */
    public static final zzf f318xP;

    /* JADX INFO: renamed from: xQ */
    public static final zzf f319xQ;

    private static class zza extends zzf {

        /* JADX INFO: renamed from: xX */
        List<zzf> f326xX;

        zza(List<zzf> list) {
            this.f326xX = list;
        }

        @Override // com.google.android.gms.common.internal.zzf
        public zzf zza(zzf zzfVar) {
            ArrayList arrayList = new ArrayList(this.f326xX);
            arrayList.add((zzf) zzab.zzaa(zzfVar));
            return new zza(arrayList);
        }

        @Override // com.google.android.gms.common.internal.zzf
        public boolean zzd(char c) {
            Iterator<zzf> it = this.f326xX.iterator();
            while (it.hasNext()) {
                if (it.next().zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zzf zzfVarZza = zza('0', '9');
        zzf zzfVarZza2 = zzfVarZza;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzfVarZza2 = zzfVarZza2.zza(zza(c, (char) (c + '\t')));
        }
        f308xF = zzfVarZza2;
        f309xG = zza('\t', '\r').zza(zza((char) 28, ' ')).zza(zzc((char) 5760)).zza(zzc((char) 6158)).zza(zza((char) 8192, (char) 8198)).zza(zza((char) 8200, (char) 8203)).zza(zza((char) 8232, (char) 8233)).zza(zzc((char) 8287)).zza(zzc((char) 12288));
        f310xH = new zzf() { // from class: com.google.android.gms.common.internal.zzf.1
            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return Character.isDigit(c2);
            }
        };
        f311xI = new zzf() { // from class: com.google.android.gms.common.internal.zzf.5
            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return Character.isLetter(c2);
            }
        };
        f312xJ = new zzf() { // from class: com.google.android.gms.common.internal.zzf.6
            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return Character.isLetterOrDigit(c2);
            }
        };
        f313xK = new zzf() { // from class: com.google.android.gms.common.internal.zzf.7
            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return Character.isUpperCase(c2);
            }
        };
        f314xL = new zzf() { // from class: com.google.android.gms.common.internal.zzf.8
            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return Character.isLowerCase(c2);
            }
        };
        f315xM = zza((char) 0, (char) 31).zza(zza((char) 127, (char) 159));
        f316xN = zza((char) 0, ' ').zza(zza((char) 127, (char) 160)).zza(zzc((char) 173)).zza(zza((char) 1536, (char) 1539)).zza(zza("\u06dd\u070f\u1680឴឵\u180e")).zza(zza((char) 8192, (char) 8207)).zza(zza((char) 8232, (char) 8239)).zza(zza((char) 8287, (char) 8292)).zza(zza((char) 8298, (char) 8303)).zza(zzc((char) 12288)).zza(zza((char) 55296, (char) 63743)).zza(zza("\ufeff\ufff9\ufffa\ufffb"));
        f317xO = zza((char) 0, (char) 1273).zza(zzc((char) 1470)).zza(zza((char) 1488, (char) 1514)).zza(zzc((char) 1523)).zza(zzc((char) 1524)).zza(zza((char) 1536, (char) 1791)).zza(zza((char) 1872, (char) 1919)).zza(zza((char) 3584, (char) 3711)).zza(zza((char) 7680, (char) 8367)).zza(zza((char) 8448, (char) 8506)).zza(zza((char) 64336, (char) 65023)).zza(zza((char) 65136, (char) 65279)).zza(zza((char) 65377, (char) 65500));
        f318xP = new zzf() { // from class: com.google.android.gms.common.internal.zzf.9
            @Override // com.google.android.gms.common.internal.zzf
            public zzf zza(zzf zzfVar) {
                zzab.zzaa(zzfVar);
                return this;
            }

            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzb(CharSequence charSequence) {
                zzab.zzaa(charSequence);
                return true;
            }

            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return true;
            }
        };
        f319xQ = new zzf() { // from class: com.google.android.gms.common.internal.zzf.10
            @Override // com.google.android.gms.common.internal.zzf
            public zzf zza(zzf zzfVar) {
                return (zzf) zzab.zzaa(zzfVar);
            }

            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzb(CharSequence charSequence) {
                return charSequence.length() == 0;
            }

            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return false;
            }
        };
    }

    public static zzf zza(final char c, final char c2) {
        zzab.zzbn(c2 >= c);
        return new zzf() { // from class: com.google.android.gms.common.internal.zzf.4
            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c3) {
                return c <= c3 && c3 <= c2;
            }
        };
    }

    public static zzf zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f319xQ;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char cCharAt = charSequence.charAt(0);
                final char cCharAt2 = charSequence.charAt(1);
                return new zzf() { // from class: com.google.android.gms.common.internal.zzf.2
                    @Override // com.google.android.gms.common.internal.zzf
                    public boolean zzd(char c) {
                        return c == cCharAt || c == cCharAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zzf() { // from class: com.google.android.gms.common.internal.zzf.3
                    @Override // com.google.android.gms.common.internal.zzf
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zzf zzc(final char c) {
        return new zzf() { // from class: com.google.android.gms.common.internal.zzf.11
            @Override // com.google.android.gms.common.internal.zzf
            public zzf zza(zzf zzfVar) {
                return zzfVar.zzd(c) ? zzfVar : super.zza(zzfVar);
            }

            @Override // com.google.android.gms.common.internal.zzf
            public boolean zzd(char c2) {
                return c2 == c;
            }
        };
    }

    public zzf zza(zzf zzfVar) {
        return new zza(Arrays.asList(this, (zzf) zzab.zzaa(zzfVar)));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
