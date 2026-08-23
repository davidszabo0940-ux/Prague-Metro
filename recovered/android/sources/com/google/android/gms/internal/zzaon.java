package com.google.android.gms.internal;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzaon {
    public static final zzank<Class> bgh = new zzank<Class>() { // from class: com.google.android.gms.internal.zzaon.1
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Class cls) throws IOException {
            if (cls == null) {
                zzaorVar.mo32r();
            } else {
                String strValueOf = String.valueOf(cls.getName());
                throw new UnsupportedOperationException(new StringBuilder(String.valueOf(strValueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(strValueOf).append(". Forgot to register a type adapter?").toString());
            }
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public Class zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzanl bgi = zza(Class.class, bgh);
    public static final zzank<BitSet> bgj = new zzank<BitSet>() { // from class: com.google.android.gms.internal.zzaon.12
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                zzaorVar.mo32r();
                return;
            }
            zzaorVar.mo28n();
            for (int i = 0; i < bitSet.length(); i++) {
                zzaorVar.zzcp(bitSet.get(i) ? 1 : 0);
            }
            zzaorVar.mo29o();
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
        public BitSet zzb(zzaop zzaopVar) throws IOException {
            boolean zNextBoolean;
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            zzaopVar.beginArray();
            zzaoq zzaoqVarMo24h = zzaopVar.mo24h();
            int i = 0;
            while (zzaoqVarMo24h != zzaoq.END_ARRAY) {
                switch (C040826.bfU[zzaoqVarMo24h.ordinal()]) {
                    case 1:
                        zNextBoolean = zzaopVar.nextInt() != 0;
                        break;
                    case 2:
                        zNextBoolean = zzaopVar.nextBoolean();
                        break;
                    case 3:
                        String strNextString = zzaopVar.nextString();
                        try {
                            zNextBoolean = Integer.parseInt(strNextString) != 0;
                        } catch (NumberFormatException e) {
                            String strValueOf = String.valueOf(strNextString);
                            throw new zzanh(strValueOf.length() != 0 ? "Error: Expecting: bitset number value (1, 0), Found: ".concat(strValueOf) : new String("Error: Expecting: bitset number value (1, 0), Found: "));
                        }
                        break;
                    default:
                        String strValueOf2 = String.valueOf(zzaoqVarMo24h);
                        throw new zzanh(new StringBuilder(String.valueOf(strValueOf2).length() + 27).append("Invalid bitset value type: ").append(strValueOf2).toString());
                }
                if (zNextBoolean) {
                    bitSet.set(i);
                }
                i++;
                zzaoqVarMo24h = zzaopVar.mo24h();
            }
            zzaopVar.endArray();
            return bitSet;
        }
    };
    public static final zzanl bgk = zza(BitSet.class, bgj);
    public static final zzank<Boolean> bgl = new zzank<Boolean>() { // from class: com.google.android.gms.internal.zzaon.23
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Boolean bool) throws IOException {
            if (bool == null) {
                zzaorVar.mo32r();
            } else {
                zzaorVar.zzcz(bool.booleanValue());
            }
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
        public Boolean zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return zzaopVar.mo24h() == zzaoq.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzaopVar.nextString())) : Boolean.valueOf(zzaopVar.nextBoolean());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzank<Boolean> bgm = new zzank<Boolean>() { // from class: com.google.android.gms.internal.zzaon.27
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Boolean bool) throws IOException {
            zzaorVar.zztb(bool == null ? "null" : bool.toString());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
        public Boolean zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return Boolean.valueOf(zzaopVar.nextString());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzanl bgn = zza(Boolean.TYPE, Boolean.class, bgl);
    public static final zzank<Number> bgo = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.28
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) zzaopVar.nextInt());
            } catch (NumberFormatException e) {
                throw new zzanh(e);
            }
        }
    };
    public static final zzanl bgp = zza(Byte.TYPE, Byte.class, bgo);
    public static final zzank<Number> bgq = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.29
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) zzaopVar.nextInt());
            } catch (NumberFormatException e) {
                throw new zzanh(e);
            }
        }
    };
    public static final zzanl bgr = zza(Short.TYPE, Short.class, bgq);
    public static final zzank<Number> bgs = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.30
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(zzaopVar.nextInt());
            } catch (NumberFormatException e) {
                throw new zzanh(e);
            }
        }
    };
    public static final zzanl bgt = zza(Integer.TYPE, Integer.class, bgs);
    public static final zzank<Number> bgu = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.31
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                return Long.valueOf(zzaopVar.nextLong());
            } catch (NumberFormatException e) {
                throw new zzanh(e);
            }
        }
    };
    public static final zzank<Number> bgv = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.32
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return Float.valueOf((float) zzaopVar.nextDouble());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzank<Number> bgw = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.2
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return Double.valueOf(zzaopVar.nextDouble());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzank<Number> bgx = new zzank<Number>() { // from class: com.google.android.gms.internal.zzaon.3
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Number number) throws IOException {
            zzaorVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public Number zzb(zzaop zzaopVar) throws IOException {
            zzaoq zzaoqVarMo24h = zzaopVar.mo24h();
            switch (zzaoqVarMo24h) {
                case NUMBER:
                    return new zzanv(zzaopVar.nextString());
                case BOOLEAN:
                case STRING:
                default:
                    String strValueOf = String.valueOf(zzaoqVarMo24h);
                    throw new zzanh(new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Expecting number, got: ").append(strValueOf).toString());
                case NULL:
                    zzaopVar.nextNull();
                    return null;
            }
        }
    };
    public static final zzanl bgy = zza(Number.class, bgx);
    public static final zzank<Character> bgz = new zzank<Character>() { // from class: com.google.android.gms.internal.zzaon.4
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Character ch) throws IOException {
            zzaorVar.zztb(ch == null ? null : String.valueOf(ch));
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public Character zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            String strNextString = zzaopVar.nextString();
            if (strNextString.length() == 1) {
                return Character.valueOf(strNextString.charAt(0));
            }
            String strValueOf = String.valueOf(strNextString);
            throw new zzanh(strValueOf.length() != 0 ? "Expecting character, got: ".concat(strValueOf) : new String("Expecting character, got: "));
        }
    };
    public static final zzanl bgA = zza(Character.TYPE, Character.class, bgz);
    public static final zzank<String> bgB = new zzank<String>() { // from class: com.google.android.gms.internal.zzaon.5
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, String str) throws IOException {
            zzaorVar.zztb(str);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public String zzb(zzaop zzaopVar) throws IOException {
            zzaoq zzaoqVarMo24h = zzaopVar.mo24h();
            if (zzaoqVarMo24h != zzaoq.NULL) {
                return zzaoqVarMo24h == zzaoq.BOOLEAN ? Boolean.toString(zzaopVar.nextBoolean()) : zzaopVar.nextString();
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzank<BigDecimal> bgC = new zzank<BigDecimal>() { // from class: com.google.android.gms.internal.zzaon.6
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, BigDecimal bigDecimal) throws IOException {
            zzaorVar.zza(bigDecimal);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public BigDecimal zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                return new BigDecimal(zzaopVar.nextString());
            } catch (NumberFormatException e) {
                throw new zzanh(e);
            }
        }
    };
    public static final zzank<BigInteger> bgD = new zzank<BigInteger>() { // from class: com.google.android.gms.internal.zzaon.7
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, BigInteger bigInteger) throws IOException {
            zzaorVar.zza(bigInteger);
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public BigInteger zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                return new BigInteger(zzaopVar.nextString());
            } catch (NumberFormatException e) {
                throw new zzanh(e);
            }
        }
    };
    public static final zzanl bgE = zza(String.class, bgB);
    public static final zzank<StringBuilder> bgF = new zzank<StringBuilder>() { // from class: com.google.android.gms.internal.zzaon.8
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, StringBuilder sb) throws IOException {
            zzaorVar.zztb(sb == null ? null : sb.toString());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public StringBuilder zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return new StringBuilder(zzaopVar.nextString());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzanl bgG = zza(StringBuilder.class, bgF);
    public static final zzank<StringBuffer> bgH = new zzank<StringBuffer>() { // from class: com.google.android.gms.internal.zzaon.9
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, StringBuffer stringBuffer) throws IOException {
            zzaorVar.zztb(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
        public StringBuffer zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return new StringBuffer(zzaopVar.nextString());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzanl bgI = zza(StringBuffer.class, bgH);
    public static final zzank<URL> bgJ = new zzank<URL>() { // from class: com.google.android.gms.internal.zzaon.10
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, URL url) throws IOException {
            zzaorVar.zztb(url == null ? null : url.toExternalForm());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
        public URL zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            String strNextString = zzaopVar.nextString();
            if ("null".equals(strNextString)) {
                return null;
            }
            return new URL(strNextString);
        }
    };
    public static final zzanl bgK = zza(URL.class, bgJ);
    public static final zzank<URI> bgL = new zzank<URI>() { // from class: com.google.android.gms.internal.zzaon.11
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, URI uri) throws IOException {
            zzaorVar.zztb(uri == null ? null : uri.toASCIIString());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
        public URI zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            try {
                String strNextString = zzaopVar.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new URI(strNextString);
            } catch (URISyntaxException e) {
                throw new zzamz(e);
            }
        }
    };
    public static final zzanl bgM = zza(URI.class, bgL);
    public static final zzank<InetAddress> bgN = new zzank<InetAddress>() { // from class: com.google.android.gms.internal.zzaon.13
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, InetAddress inetAddress) throws IOException {
            zzaorVar.zztb(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] */
        public InetAddress zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return InetAddress.getByName(zzaopVar.nextString());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzanl bgO = zzb(InetAddress.class, bgN);
    public static final zzank<UUID> bgP = new zzank<UUID>() { // from class: com.google.android.gms.internal.zzaon.14
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, UUID uuid) throws IOException {
            zzaorVar.zztb(uuid == null ? null : uuid.toString());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
        public UUID zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return UUID.fromString(zzaopVar.nextString());
            }
            zzaopVar.nextNull();
            return null;
        }
    };
    public static final zzanl bgQ = zza(UUID.class, bgP);
    public static final zzanl bgR = new zzanl() { // from class: com.google.android.gms.internal.zzaon.15
        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            if (zzaooVar.m33s() != Timestamp.class) {
                return null;
            }
            final zzank<T> zzankVarZzk = zzamsVar.zzk(Date.class);
            return (zzank<T>) new zzank<Timestamp>() { // from class: com.google.android.gms.internal.zzaon.15.1
                @Override // com.google.android.gms.internal.zzank
                public void zza(zzaor zzaorVar, Timestamp timestamp) throws IOException {
                    zzankVarZzk.zza(zzaorVar, timestamp);
                }

                @Override // com.google.android.gms.internal.zzank
                /* JADX INFO: renamed from: zzaa, reason: merged with bridge method [inline-methods] */
                public Timestamp zzb(zzaop zzaopVar) throws IOException {
                    Date date = (Date) zzankVarZzk.zzb(zzaopVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }
            };
        }
    };
    public static final zzank<Calendar> bgS = new zzank<Calendar>() { // from class: com.google.android.gms.internal.zzaon.16
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                zzaorVar.mo32r();
                return;
            }
            zzaorVar.mo30p();
            zzaorVar.zzta("year");
            zzaorVar.zzcp(calendar.get(1));
            zzaorVar.zzta("month");
            zzaorVar.zzcp(calendar.get(2));
            zzaorVar.zzta("dayOfMonth");
            zzaorVar.zzcp(calendar.get(5));
            zzaorVar.zzta("hourOfDay");
            zzaorVar.zzcp(calendar.get(11));
            zzaorVar.zzta("minute");
            zzaorVar.zzcp(calendar.get(12));
            zzaorVar.zzta("second");
            zzaorVar.zzcp(calendar.get(13));
            zzaorVar.mo31q();
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzab, reason: merged with bridge method [inline-methods] */
        public Calendar zzb(zzaop zzaopVar) throws IOException {
            int i = 0;
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            zzaopVar.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (zzaopVar.mo24h() != zzaoq.END_OBJECT) {
                String strNextName = zzaopVar.nextName();
                int iNextInt = zzaopVar.nextInt();
                if ("year".equals(strNextName)) {
                    i6 = iNextInt;
                } else if ("month".equals(strNextName)) {
                    i5 = iNextInt;
                } else if ("dayOfMonth".equals(strNextName)) {
                    i4 = iNextInt;
                } else if ("hourOfDay".equals(strNextName)) {
                    i3 = iNextInt;
                } else if ("minute".equals(strNextName)) {
                    i2 = iNextInt;
                } else if ("second".equals(strNextName)) {
                    i = iNextInt;
                }
            }
            zzaopVar.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }
    };
    public static final zzanl bgT = zzb(Calendar.class, GregorianCalendar.class, bgS);
    public static final zzank<Locale> bgU = new zzank<Locale>() { // from class: com.google.android.gms.internal.zzaon.17
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Locale locale) throws IOException {
            zzaorVar.zztb(locale == null ? null : locale.toString());
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzac, reason: merged with bridge method [inline-methods] */
        public Locale zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(zzaopVar.nextString(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }
    };
    public static final zzanl bgV = zza(Locale.class, bgU);
    public static final zzank<zzamy> bgW = new zzank<zzamy>() { // from class: com.google.android.gms.internal.zzaon.18
        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, zzamy zzamyVar) throws IOException {
            if (zzamyVar == null || zzamyVar.zzczp()) {
                zzaorVar.mo32r();
                return;
            }
            if (zzamyVar.zzczo()) {
                zzane zzaneVarZzczs = zzamyVar.zzczs();
                if (zzaneVarZzczs.zzczv()) {
                    zzaorVar.zza(zzaneVarZzczs.zzczg());
                    return;
                } else if (zzaneVarZzczs.zzczu()) {
                    zzaorVar.zzcz(zzaneVarZzczs.zzczl());
                    return;
                } else {
                    zzaorVar.zztb(zzaneVarZzczs.zzczh());
                    return;
                }
            }
            if (zzamyVar.zzczm()) {
                zzaorVar.mo28n();
                Iterator<zzamy> it = zzamyVar.zzczr().iterator();
                while (it.hasNext()) {
                    zza(zzaorVar, it.next());
                }
                zzaorVar.mo29o();
                return;
            }
            if (!zzamyVar.zzczn()) {
                String strValueOf = String.valueOf(zzamyVar.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 15).append("Couldn't write ").append(strValueOf).toString());
            }
            zzaorVar.mo30p();
            for (Map.Entry<String, zzamy> entry : zzamyVar.zzczq().entrySet()) {
                zzaorVar.zzta(entry.getKey());
                zza(zzaorVar, entry.getValue());
            }
            zzaorVar.mo31q();
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
        public zzamy zzb(zzaop zzaopVar) throws IOException {
            switch (C040826.bfU[zzaopVar.mo24h().ordinal()]) {
                case 1:
                    return new zzane(new zzanv(zzaopVar.nextString()));
                case 2:
                    return new zzane(Boolean.valueOf(zzaopVar.nextBoolean()));
                case 3:
                    return new zzane(zzaopVar.nextString());
                case 4:
                    zzaopVar.nextNull();
                    return zzana.bes;
                case 5:
                    zzamv zzamvVar = new zzamv();
                    zzaopVar.beginArray();
                    while (zzaopVar.hasNext()) {
                        zzamvVar.zzc((zzamy) zzb(zzaopVar));
                    }
                    zzaopVar.endArray();
                    return zzamvVar;
                case 6:
                    zzanb zzanbVar = new zzanb();
                    zzaopVar.beginObject();
                    while (zzaopVar.hasNext()) {
                        zzanbVar.zza(zzaopVar.nextName(), (zzamy) zzb(zzaopVar));
                    }
                    zzaopVar.endObject();
                    return zzanbVar;
                default:
                    throw new IllegalArgumentException();
            }
        }
    };
    public static final zzanl bgX = zzb(zzamy.class, bgW);
    public static final zzanl bgY = new zzanl() { // from class: com.google.android.gms.internal.zzaon.19
        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            Class<? super T> clsM33s = zzaooVar.m33s();
            if (!Enum.class.isAssignableFrom(clsM33s) || clsM33s == Enum.class) {
                return null;
            }
            if (!clsM33s.isEnum()) {
                clsM33s = clsM33s.getSuperclass();
            }
            return new zza(clsM33s);
        }
    };

    private static final class zza<T extends Enum<T>> extends zzank<T> {
        private final Map<String, T> bhi = new HashMap();
        private final Map<T, String> bhj = new HashMap();

        public zza(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    zzann zzannVar = (zzann) cls.getField(strName).getAnnotation(zzann.class);
                    if (zzannVar != null) {
                        strName = zzannVar.value();
                        String[] strArrZzczy = zzannVar.zzczy();
                        for (String str : strArrZzczy) {
                            this.bhi.put(str, t);
                        }
                    }
                    String str2 = strName;
                    this.bhi.put(str2, t);
                    this.bhj.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, T t) throws IOException {
            zzaorVar.zztb(t == null ? null : this.bhj.get(t));
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public T zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() != zzaoq.NULL) {
                return this.bhi.get(zzaopVar.nextString());
            }
            zzaopVar.nextNull();
            return null;
        }
    }

    public static <TT> zzanl zza(final zzaoo<TT> zzaooVar, final zzank<TT> zzankVar) {
        return new zzanl() { // from class: com.google.android.gms.internal.zzaon.20
            @Override // com.google.android.gms.internal.zzanl
            public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar2) {
                if (zzaooVar2.equals(zzaooVar)) {
                    return zzankVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zza(final Class<TT> cls, final zzank<TT> zzankVar) {
        return new zzanl() { // from class: com.google.android.gms.internal.zzaon.21
            public String toString() {
                String strValueOf = String.valueOf(cls.getName());
                String strValueOf2 = String.valueOf(zzankVar);
                return new StringBuilder(String.valueOf(strValueOf).length() + 23 + String.valueOf(strValueOf2).length()).append("Factory[type=").append(strValueOf).append(",adapter=").append(strValueOf2).append("]").toString();
            }

            @Override // com.google.android.gms.internal.zzanl
            public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
                if (zzaooVar.m33s() == cls) {
                    return zzankVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zza(final Class<TT> cls, final Class<TT> cls2, final zzank<? super TT> zzankVar) {
        return new zzanl() { // from class: com.google.android.gms.internal.zzaon.22
            public String toString() {
                String strValueOf = String.valueOf(cls2.getName());
                String strValueOf2 = String.valueOf(cls.getName());
                String strValueOf3 = String.valueOf(zzankVar);
                return new StringBuilder(String.valueOf(strValueOf).length() + 24 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length()).append("Factory[type=").append(strValueOf).append("+").append(strValueOf2).append(",adapter=").append(strValueOf3).append("]").toString();
            }

            @Override // com.google.android.gms.internal.zzanl
            public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
                Class<? super T> clsM33s = zzaooVar.m33s();
                if (clsM33s == cls || clsM33s == cls2) {
                    return zzankVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zzb(final Class<TT> cls, final zzank<TT> zzankVar) {
        return new zzanl() { // from class: com.google.android.gms.internal.zzaon.25
            public String toString() {
                String strValueOf = String.valueOf(cls.getName());
                String strValueOf2 = String.valueOf(zzankVar);
                return new StringBuilder(String.valueOf(strValueOf).length() + 32 + String.valueOf(strValueOf2).length()).append("Factory[typeHierarchy=").append(strValueOf).append(",adapter=").append(strValueOf2).append("]").toString();
            }

            @Override // com.google.android.gms.internal.zzanl
            public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
                if (cls.isAssignableFrom(zzaooVar.m33s())) {
                    return zzankVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzank<? super TT> zzankVar) {
        return new zzanl() { // from class: com.google.android.gms.internal.zzaon.24
            public String toString() {
                String strValueOf = String.valueOf(cls.getName());
                String strValueOf2 = String.valueOf(cls2.getName());
                String strValueOf3 = String.valueOf(zzankVar);
                return new StringBuilder(String.valueOf(strValueOf).length() + 24 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length()).append("Factory[type=").append(strValueOf).append("+").append(strValueOf2).append(",adapter=").append(strValueOf3).append("]").toString();
            }

            @Override // com.google.android.gms.internal.zzanl
            public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
                Class<? super T> clsM33s = zzaooVar.m33s();
                if (clsM33s == cls || clsM33s == cls2) {
                    return zzankVar;
                }
                return null;
            }
        };
    }
}
