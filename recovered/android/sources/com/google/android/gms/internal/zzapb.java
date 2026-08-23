package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzapb extends IOException {
    public zzapb(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ag */
    static zzapb m73ag() {
        return new zzapb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: renamed from: ah */
    static zzapb m74ah() {
        return new zzapb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: renamed from: ai */
    static zzapb m75ai() {
        return new zzapb("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: renamed from: aj */
    static zzapb m76aj() {
        return new zzapb("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: renamed from: ak */
    static zzapb m77ak() {
        return new zzapb("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: renamed from: al */
    static zzapb m78al() {
        return new zzapb("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: renamed from: am */
    static zzapb m79am() {
        return new zzapb("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
