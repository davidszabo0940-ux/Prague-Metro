package com.google.android.gms.common.images;

/* JADX INFO: loaded from: classes.dex */
public final class Size {
    private final int zzaie;
    private final int zzaif;

    public Size(int i, int i2) {
        this.zzaie = i;
        this.zzaif = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(120);
        }
        if (iIndexOf < 0) {
            throw zzhi(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzhi(str);
        }
    }

    private static NumberFormatException zzhi(String str) {
        throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzaie == size.zzaie && this.zzaif == size.zzaif;
    }

    public int getHeight() {
        return this.zzaif;
    }

    public int getWidth() {
        return this.zzaie;
    }

    public int hashCode() {
        return this.zzaif ^ ((this.zzaie << 16) | (this.zzaie >>> 16));
    }

    public String toString() {
        int i = this.zzaie;
        return new StringBuilder(23).append(i).append("x").append(this.zzaif).toString();
    }
}
