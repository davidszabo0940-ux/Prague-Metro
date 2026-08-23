package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class zzaop implements Closeable {
    private static final char[] bhm = ")]}'\n".toCharArray();
    private long bhs;
    private int bht;
    private String bhu;
    private int bhw;
    private String[] bhx;
    private int[] bhy;

    /* JADX INFO: renamed from: in */
    private final Reader f537in;
    private boolean bhn = false;
    private final char[] bho = new char[1024];
    private int pos = 0;
    private int aYn = 0;
    private int bhp = 0;
    private int bhq = 0;
    private int bhr = 0;
    private int[] bhv = new int[32];

    static {
        zzanu.bff = new zzanu() { // from class: com.google.android.gms.internal.zzaop.1
            @Override // com.google.android.gms.internal.zzanu
            public void zzi(zzaop zzaopVar) throws IOException {
                if (zzaopVar instanceof zzaof) {
                    ((zzaof) zzaopVar).m25k();
                    return;
                }
                int iM38u = zzaopVar.bhr;
                if (iM38u == 0) {
                    iM38u = zzaopVar.m38u();
                }
                if (iM38u == 13) {
                    zzaopVar.bhr = 9;
                    return;
                }
                if (iM38u == 12) {
                    zzaopVar.bhr = 8;
                    return;
                }
                if (iM38u == 14) {
                    zzaopVar.bhr = 10;
                    return;
                }
                String strValueOf = String.valueOf(zzaopVar.mo24h());
                int lineNumber = zzaopVar.getLineNumber();
                int columnNumber = zzaopVar.getColumnNumber();
                String path = zzaopVar.getPath();
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 70 + String.valueOf(path).length()).append("Expected a name but was ").append(strValueOf).append(" ").append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
        };
    }

    public zzaop(Reader reader) {
        this.bhw = 0;
        int[] iArr = this.bhv;
        int i = this.bhw;
        this.bhw = i + 1;
        iArr[i] = 6;
        this.bhx = new String[32];
        this.bhy = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f537in = reader;
    }

    /* JADX INFO: renamed from: A */
    private void m35A() throws IOException {
        char c;
        do {
            if (this.pos >= this.aYn && !zzaed(1)) {
                return;
            }
            char[] cArr = this.bho;
            int i = this.pos;
            this.pos = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.bhp++;
                this.bhq = this.pos;
                return;
            }
        } while (c != '\r');
    }

    /* JADX INFO: renamed from: B */
    private char m36B() throws IOException {
        int i;
        if (this.pos == this.aYn && !zzaed(1)) {
            throw zztd("Unterminated escape sequence");
        }
        char[] cArr = this.bho;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.bhp++;
                this.bhq = this.pos;
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.pos + 4 > this.aYn && !zzaed(4)) {
                    throw zztd("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.bho[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else {
                        if (c3 < 'A' || c3 > 'F') {
                            String strValueOf = String.valueOf(new String(this.bho, this.pos, 4));
                            throw new NumberFormatException(strValueOf.length() != 0 ? "\\u".concat(strValueOf) : new String("\\u"));
                        }
                        i = (c3 - 'A') + 10;
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                return c;
        }
    }

    /* JADX INFO: renamed from: C */
    private void m37C() throws IOException {
        zzda(true);
        this.pos--;
        if (this.pos + bhm.length <= this.aYn || zzaed(bhm.length)) {
            for (int i = 0; i < bhm.length; i++) {
                if (this.bho[this.pos + i] != bhm[i]) {
                    return;
                }
            }
            this.pos += bhm.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColumnNumber() {
        return (this.pos - this.bhq) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLineNumber() {
        return this.bhp + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u */
    public int m38u() throws IOException {
        int i = this.bhv[this.bhw - 1];
        if (i == 1) {
            this.bhv[this.bhw - 1] = 2;
        } else if (i == 2) {
            switch (zzda(true)) {
                case 44:
                    break;
                case 59:
                    m43z();
                    break;
                case 93:
                    this.bhr = 4;
                    return 4;
                default:
                    throw zztd("Unterminated array");
            }
        } else {
            if (i == 3 || i == 5) {
                this.bhv[this.bhw - 1] = 4;
                if (i == 5) {
                    switch (zzda(true)) {
                        case 44:
                            break;
                        case 59:
                            m43z();
                            break;
                        case 125:
                            this.bhr = 2;
                            return 2;
                        default:
                            throw zztd("Unterminated object");
                    }
                }
                int iZzda = zzda(true);
                switch (iZzda) {
                    case 34:
                        this.bhr = 13;
                        return 13;
                    case 39:
                        m43z();
                        this.bhr = 12;
                        return 12;
                    case 125:
                        if (i == 5) {
                            throw zztd("Expected name");
                        }
                        this.bhr = 2;
                        return 2;
                    default:
                        m43z();
                        this.pos--;
                        if (!zze((char) iZzda)) {
                            throw zztd("Expected name");
                        }
                        this.bhr = 14;
                        return 14;
                }
            }
            if (i == 4) {
                this.bhv[this.bhw - 1] = 5;
                switch (zzda(true)) {
                    case 58:
                        break;
                    case 59:
                    case 60:
                    default:
                        throw zztd("Expected ':'");
                    case 61:
                        m43z();
                        if ((this.pos < this.aYn || zzaed(1)) && this.bho[this.pos] == '>') {
                            this.pos++;
                        }
                        break;
                }
            } else if (i == 6) {
                if (this.bhn) {
                    m37C();
                }
                this.bhv[this.bhw - 1] = 7;
            } else if (i == 7) {
                if (zzda(false) == -1) {
                    this.bhr = 17;
                    return 17;
                }
                m43z();
                this.pos--;
            } else if (i == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        switch (zzda(true)) {
            case 34:
                if (this.bhw == 1) {
                    m43z();
                }
                this.bhr = 9;
                return 9;
            case 39:
                m43z();
                this.bhr = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.bhr = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.bhr = 4;
                    return 4;
                }
                break;
            case 123:
                this.bhr = 1;
                return 1;
            default:
                this.pos--;
                if (this.bhw == 1) {
                    m43z();
                }
                int iM39v = m39v();
                if (iM39v != 0) {
                    return iM39v;
                }
                int iM40w = m40w();
                if (iM40w != 0) {
                    return iM40w;
                }
                if (!zze(this.bho[this.pos])) {
                    throw zztd("Expected value");
                }
                m43z();
                this.bhr = 10;
                return 10;
        }
        if (i != 1 && i != 2) {
            throw zztd("Unexpected value");
        }
        m43z();
        this.pos--;
        this.bhr = 7;
        return 7;
    }

    /* JADX INFO: renamed from: v */
    private int m39v() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.bho[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.aYn && !zzaed(i2 + 1)) {
                return 0;
            }
            char c2 = this.bho[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.aYn || zzaed(length + 1)) && zze(this.bho[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.bhr = i;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:90:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0089 A[SYNTHETIC] */
    /* JADX INFO: renamed from: w */
    private int m40w() throws IOException {
        char c;
        char c2;
        boolean z;
        boolean z2;
        char[] cArr = this.bho;
        int i = this.pos;
        long j = 0;
        boolean z3 = false;
        boolean z4 = true;
        char c3 = 0;
        int i2 = 0;
        int i3 = this.aYn;
        int i4 = i;
        while (true) {
            if (i4 + i2 != i3) {
                c = cArr[i4 + i2];
                switch (c) {
                    case '+':
                        if (c3 == 5) {
                            return 0;
                        }
                        c2 = 6;
                        z = z4;
                        z2 = z3;
                        continue;
                        continue;
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c3 = c2;
                        break;
                        break;
                    case '-':
                        if (c3 == 0) {
                            c2 = 1;
                            boolean z5 = z4;
                            z2 = true;
                            z = z5;
                            continue;
                            continue;
                        } else {
                            if (c3 == 5) {
                                return 0;
                            }
                            c2 = 6;
                            z = z4;
                            z2 = z3;
                        }
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c3 = c2;
                        break;
                    case '.':
                        if (c3 == 2) {
                            return 0;
                        }
                        c2 = 3;
                        z = z4;
                        z2 = z3;
                        continue;
                        continue;
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c3 = c2;
                        break;
                        break;
                    case 'E':
                    case 'e':
                        if (c3 == 2 && c3 != 4) {
                            return 0;
                        }
                        c2 = 5;
                        z = z4;
                        z2 = z3;
                        continue;
                        continue;
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c3 = c2;
                        break;
                        break;
                    default:
                        if (c < '0' && c <= '9') {
                            if (c3 == 1 || c3 == 0) {
                                j = -(c - '0');
                                c2 = 2;
                                z = z4;
                                z2 = z3;
                            } else if (c3 == 2) {
                                if (j == 0) {
                                    return 0;
                                }
                                long j2 = (10 * j) - ((long) (c - '0'));
                                boolean z6 = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) & z4;
                                z2 = z3;
                                j = j2;
                                char c4 = c3;
                                z = z6;
                                c2 = c4;
                            } else if (c3 == 3) {
                                c2 = 4;
                                z = z4;
                                z2 = z3;
                            } else if (c3 == 5 || c3 == 6) {
                                c2 = 7;
                                z = z4;
                                z2 = z3;
                            } else {
                                c2 = c3;
                                z = z4;
                                z2 = z3;
                            }
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c3 = c2;
                        } else if (zze(c)) {
                            return 0;
                        }
                        break;
                }
            } else {
                if (i2 == cArr.length) {
                    return 0;
                }
                if (zzaed(i2 + 1)) {
                    i4 = this.pos;
                    i3 = this.aYn;
                    c = cArr[i4 + i2];
                    switch (c) {
                        case '+':
                            if (c3 == 5) {
                                return 0;
                            }
                            c2 = 6;
                            z = z4;
                            z2 = z3;
                            continue;
                            continue;
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c3 = c2;
                            break;
                            break;
                        case '-':
                            if (c3 == 0) {
                                c2 = 1;
                                boolean z7 = z4;
                                z2 = true;
                                z = z7;
                                continue;
                                continue;
                            } else {
                                if (c3 == 5) {
                                    return 0;
                                }
                                c2 = 6;
                                z = z4;
                                z2 = z3;
                            }
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c3 = c2;
                            break;
                        case '.':
                            if (c3 == 2) {
                                return 0;
                            }
                            c2 = 3;
                            z = z4;
                            z2 = z3;
                            continue;
                            continue;
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c3 = c2;
                            break;
                            break;
                        case 'E':
                        case 'e':
                            if (c3 == 2) {
                            }
                            c2 = 5;
                            z = z4;
                            z2 = z3;
                            continue;
                            continue;
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c3 = c2;
                            break;
                        default:
                            if (c < '0') {
                            }
                            if (zze(c)) {
                                return 0;
                            }
                            break;
                    }
                }
            }
        }
        if (c3 == 2 && z4 && (j != Long.MIN_VALUE || z3)) {
            if (!z3) {
                j = -j;
            }
            this.bhs = j;
            this.pos += i2;
            this.bhr = 15;
            return 15;
        }
        if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        }
        this.bht = i2;
        this.bhr = 16;
        return 16;
    }

    /* JADX INFO: renamed from: x */
    private String m41x() throws IOException {
        String string;
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.aYn) {
                switch (this.bho[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m43z();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.bho.length) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.bho, this.pos, i);
                this.pos = i + this.pos;
                if (zzaed(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (zzaed(i + 1)) {
            }
        }
        if (sb == null) {
            string = new String(this.bho, this.pos, i);
        } else {
            sb.append(this.bho, this.pos, i);
            string = sb.toString();
        }
        this.pos = i + this.pos;
        return string;
    }

    /* JADX INFO: renamed from: y */
    private void m42y() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.aYn) {
                switch (this.bho[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m43z();
                        break;
                    default:
                        i++;
                        break;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (zzaed(1));
    }

    /* JADX INFO: renamed from: z */
    private void m43z() throws IOException {
        if (!this.bhn) {
            throw zztd("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void zzaec(int i) {
        if (this.bhw == this.bhv.length) {
            int[] iArr = new int[this.bhw * 2];
            int[] iArr2 = new int[this.bhw * 2];
            String[] strArr = new String[this.bhw * 2];
            System.arraycopy(this.bhv, 0, iArr, 0, this.bhw);
            System.arraycopy(this.bhy, 0, iArr2, 0, this.bhw);
            System.arraycopy(this.bhx, 0, strArr, 0, this.bhw);
            this.bhv = iArr;
            this.bhy = iArr2;
            this.bhx = strArr;
        }
        int[] iArr3 = this.bhv;
        int i2 = this.bhw;
        this.bhw = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean zzaed(int i) throws IOException {
        char[] cArr = this.bho;
        this.bhq -= this.pos;
        if (this.aYn != this.pos) {
            this.aYn -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.aYn);
        } else {
            this.aYn = 0;
        }
        this.pos = 0;
        do {
            int i2 = this.f537in.read(cArr, this.aYn, cArr.length - this.aYn);
            if (i2 == -1) {
                return false;
            }
            this.aYn = i2 + this.aYn;
            if (this.bhp == 0 && this.bhq == 0 && this.aYn > 0 && cArr[0] == 65279) {
                this.pos++;
                this.bhq++;
                i++;
            }
        } while (this.aYn < i);
        return true;
    }

    private int zzda(boolean z) throws IOException {
        char[] cArr = this.bho;
        int i = this.pos;
        int i2 = this.aYn;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (!zzaed(1)) {
                    if (!z) {
                        return -1;
                    }
                    String strValueOf = String.valueOf("End of input at line ");
                    throw new EOFException(new StringBuilder(String.valueOf(strValueOf).length() + 30).append(strValueOf).append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
                }
                i = this.pos;
                i2 = this.aYn;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.bhp++;
                this.bhq = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean zZzaed = zzaed(2);
                    this.pos++;
                    if (!zZzaed) {
                        return c;
                    }
                }
                m43z();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!zztc("*/")) {
                            throw zztd("Unterminated comment");
                        }
                        i = this.pos + 2;
                        i2 = this.aYn;
                        break;
                        break;
                    case '/':
                        this.pos++;
                        m35A();
                        i = this.pos;
                        i2 = this.aYn;
                        break;
                    default:
                        return c;
                }
            } else {
                if (c != '#') {
                    this.pos = i3;
                    return c;
                }
                this.pos = i3;
                m43z();
                m35A();
                i = this.pos;
                i2 = this.aYn;
            }
        }
    }

    private boolean zze(char c) throws IOException {
        switch (c) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m43z();
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            default:
                return true;
        }
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.bho;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.aYn;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(m36B());
                    i = this.pos;
                    i2 = this.aYn;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.bhp++;
                    this.bhq = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zzaed(1));
        throw zztd("Unterminated string");
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.bho;
        do {
            int i = this.pos;
            int i2 = this.aYn;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    m36B();
                    i4 = this.pos;
                    i2 = this.aYn;
                } else if (c2 == '\n') {
                    this.bhp++;
                    this.bhq = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (zzaed(1));
        throw zztd("Unterminated string");
    }

    private boolean zztc(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.aYn && !zzaed(str.length())) {
                return false;
            }
            if (this.bho[this.pos] != '\n') {
                for (int i = 0; i < str.length(); i++) {
                    if (this.bho[this.pos + i] == str.charAt(i)) {
                    }
                }
                return true;
            }
            this.bhp++;
            this.bhq = this.pos + 1;
            this.pos++;
        }
    }

    private IOException zztd(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new zzaos(new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length()).append(str).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginArray() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 3) {
            zzaec(1);
            this.bhy[this.bhw - 1] = 0;
            this.bhr = 0;
        } else {
            String strValueOf = String.valueOf(mo24h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 74 + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    public void beginObject() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 1) {
            zzaec(3);
            this.bhr = 0;
        } else {
            String strValueOf = String.valueOf(mo24h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 75 + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.bhr = 0;
        this.bhv[0] = 8;
        this.bhw = 1;
        this.f537in.close();
    }

    public void endArray() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u != 4) {
            String strValueOf = String.valueOf(mo24h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 72 + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhw--;
        int[] iArr = this.bhy;
        int i = this.bhw - 1;
        iArr[i] = iArr[i] + 1;
        this.bhr = 0;
    }

    public void endObject() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u != 2) {
            String strValueOf = String.valueOf(mo24h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 73 + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhw--;
        this.bhx[this.bhw] = null;
        int[] iArr = this.bhy;
        int i = this.bhw - 1;
        iArr[i] = iArr[i] + 1;
        this.bhr = 0;
    }

    public String getPath() {
        StringBuilder sbAppend = new StringBuilder().append('$');
        int i = this.bhw;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.bhv[i2]) {
                case 1:
                case 2:
                    sbAppend.append('[').append(this.bhy[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sbAppend.append('.');
                    if (this.bhx[i2] != null) {
                        sbAppend.append(this.bhx[i2]);
                    }
                    break;
            }
        }
        return sbAppend.toString();
    }

    /* JADX INFO: renamed from: h */
    public zzaoq mo24h() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        switch (iM38u) {
            case 1:
                return zzaoq.BEGIN_OBJECT;
            case 2:
                return zzaoq.END_OBJECT;
            case 3:
                return zzaoq.BEGIN_ARRAY;
            case 4:
                return zzaoq.END_ARRAY;
            case 5:
            case 6:
                return zzaoq.BOOLEAN;
            case 7:
                return zzaoq.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzaoq.STRING;
            case 12:
            case 13:
            case 14:
                return zzaoq.NAME;
            case 15:
            case 16:
                return zzaoq.NUMBER;
            case 17:
                return zzaoq.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public boolean hasNext() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        return (iM38u == 2 || iM38u == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.bhn;
    }

    public boolean nextBoolean() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 5) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i = this.bhw - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iM38u == 6) {
            this.bhr = 0;
            int[] iArr2 = this.bhy;
            int i2 = this.bhw - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        String strValueOf = String.valueOf(mo24h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 72 + String.valueOf(path).length()).append("Expected a boolean but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public double nextDouble() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 15) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i = this.bhw - 1;
            iArr[i] = iArr[i] + 1;
            return this.bhs;
        }
        if (iM38u == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else if (iM38u == 8 || iM38u == 9) {
            this.bhu = zzf(iM38u == 8 ? '\'' : '\"');
        } else if (iM38u == 10) {
            this.bhu = m41x();
        } else if (iM38u != 11) {
            String strValueOf = String.valueOf(mo24h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 71 + String.valueOf(path).length()).append("Expected a double but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 11;
        double d = Double.parseDouble(this.bhu);
        if (!this.bhn && (Double.isNaN(d) || Double.isInfinite(d))) {
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new zzaos(new StringBuilder(String.valueOf(path2).length() + 102).append("JSON forbids NaN and infinities: ").append(d).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.bhu = null;
        this.bhr = 0;
        int[] iArr2 = this.bhy;
        int i2 = this.bhw - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public int nextInt() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 15) {
            int i = (int) this.bhs;
            if (this.bhs != i) {
                long j = this.bhs;
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iM38u == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else {
            if (iM38u != 8 && iM38u != 9) {
                String strValueOf = String.valueOf(mo24h());
                int lineNumber2 = getLineNumber();
                int columnNumber2 = getColumnNumber();
                String path2 = getPath();
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 69 + String.valueOf(path2).length()).append("Expected an int but was ").append(strValueOf).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
            }
            this.bhu = zzf(iM38u == 8 ? '\'' : '\"');
            try {
                int i3 = Integer.parseInt(this.bhu);
                this.bhr = 0;
                int[] iArr2 = this.bhy;
                int i4 = this.bhw - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException e) {
            }
        }
        this.bhr = 11;
        double d = Double.parseDouble(this.bhu);
        int i5 = (int) d;
        if (i5 != d) {
            String str = this.bhu;
            int lineNumber3 = getLineNumber();
            int columnNumber3 = getColumnNumber();
            String path3 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length()).append("Expected an int but was ").append(str).append(" at line ").append(lineNumber3).append(" column ").append(columnNumber3).append(" path ").append(path3).toString());
        }
        this.bhu = null;
        this.bhr = 0;
        int[] iArr3 = this.bhy;
        int i6 = this.bhw - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 15) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i = this.bhw - 1;
            iArr[i] = iArr[i] + 1;
            return this.bhs;
        }
        if (iM38u == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else {
            if (iM38u != 8 && iM38u != 9) {
                String strValueOf = String.valueOf(mo24h());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 69 + String.valueOf(path).length()).append("Expected a long but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.bhu = zzf(iM38u == 8 ? '\'' : '\"');
            try {
                long j = Long.parseLong(this.bhu);
                this.bhr = 0;
                int[] iArr2 = this.bhy;
                int i2 = this.bhw - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException e) {
            }
        }
        this.bhr = 11;
        double d = Double.parseDouble(this.bhu);
        long j2 = (long) d;
        if (j2 != d) {
            String str = this.bhu;
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length()).append("Expected a long but was ").append(str).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.bhu = null;
        this.bhr = 0;
        int[] iArr3 = this.bhy;
        int i3 = this.bhw - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    public String nextName() throws IOException {
        String strZzf;
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 14) {
            strZzf = m41x();
        } else if (iM38u == 12) {
            strZzf = zzf('\'');
        } else {
            if (iM38u != 13) {
                String strValueOf = String.valueOf(mo24h());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 69 + String.valueOf(path).length()).append("Expected a name but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            strZzf = zzf('\"');
        }
        this.bhr = 0;
        this.bhx[this.bhw - 1] = strZzf;
        return strZzf;
    }

    public void nextNull() throws IOException {
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 7) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i = this.bhw - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        String strValueOf = String.valueOf(mo24h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 67 + String.valueOf(path).length()).append("Expected null but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String nextString() throws IOException {
        String str;
        int iM38u = this.bhr;
        if (iM38u == 0) {
            iM38u = m38u();
        }
        if (iM38u == 10) {
            str = m41x();
        } else if (iM38u == 8) {
            str = zzf('\'');
        } else if (iM38u == 9) {
            str = zzf('\"');
        } else if (iM38u == 11) {
            str = this.bhu;
            this.bhu = null;
        } else if (iM38u == 15) {
            str = Long.toString(this.bhs);
        } else {
            if (iM38u != 16) {
                String strValueOf = String.valueOf(mo24h());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 71 + String.valueOf(path).length()).append("Expected a string but was ").append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            str = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        }
        this.bhr = 0;
        int[] iArr = this.bhy;
        int i = this.bhw - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.bhn = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int iM38u = this.bhr;
            if (iM38u == 0) {
                iM38u = m38u();
            }
            if (iM38u == 3) {
                zzaec(1);
                i++;
            } else if (iM38u == 1) {
                zzaec(3);
                i++;
            } else if (iM38u == 4 || iM38u == 2) {
                this.bhw--;
                i--;
            } else if (iM38u == 14 || iM38u == 10) {
                m42y();
            } else if (iM38u == 8 || iM38u == 12) {
                zzg('\'');
            } else if (iM38u == 9 || iM38u == 13) {
                zzg('\"');
            } else if (iM38u == 16) {
                this.pos += this.bht;
            }
            this.bhr = 0;
        } while (i != 0);
        int[] iArr = this.bhy;
        int i2 = this.bhw - 1;
        iArr[i2] = iArr[i2] + 1;
        this.bhx[this.bhw - 1] = "null";
    }

    public String toString() {
        String strValueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        return new StringBuilder(String.valueOf(strValueOf).length() + 39).append(strValueOf).append(" at line ").append(lineNumber).append(" column ").append(getColumnNumber()).toString();
    }
}
