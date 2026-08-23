package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzds {
    private static final Object zzamp = new Object();
    private static zzds zzber;
    private final Context mContext;
    private final com.google.android.gms.common.util.zze zzaoa;
    private final zza zzbes;
    private long zzbet = zzdr.zzbeq;

    private static class zza extends SQLiteOpenHelper {
        public zza(Context context) {
            super(context, "direct_app_install_log.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE directappinstall( column_id INTEGER PRIMARY KEY AUTOINCREMENT, reference LONG, package TEXT, tracking_url TEXT, timestamp INTEGER, path TEXT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS directappinstall");
            onCreate(sQLiteDatabase);
        }
    }

    private zzds(Context context, com.google.android.gms.common.util.zze zzeVar) {
        this.mContext = context;
        this.zzbes = new zza(this.mContext);
        this.zzaoa = zzeVar;
    }

    public static zzds zza(Context context, com.google.android.gms.common.util.zze zzeVar) {
        zzds zzdsVar;
        synchronized (zzamp) {
            if (zzber == null) {
                zzber = new zzds(context, zzeVar);
            }
            zzdsVar = zzber;
        }
        return zzdsVar;
    }

    private void zza(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = sQLiteDatabase.query("directappinstall", new String[]{"path"}, "package = ?", new String[]{str}, null, null, null);
        } catch (SQLiteException e) {
            zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 70).append("No package name ").append(str).append(" was recorded. Cleaning up records older than one day.").toString());
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("path"));
                if (!TextUtils.isEmpty(string)) {
                    zzdt.zzkq().zzd(this.mContext, string);
                }
                sQLiteDatabase.delete("directappinstall", "package = ?", new String[]{str});
            }
            cursorQuery.close();
        }
        sQLiteDatabase.delete("directappinstall", "timestamp < ?", new String[]{Long.toString(Long.valueOf(this.zzaoa.currentTimeMillis() - zzkp()).longValue())});
    }

    private long zzkp() {
        return this.zzbet;
    }

    public void zza(long j, String str, String str2) {
        SQLiteDatabase writableDatabase = this.zzbes.getWritableDatabase();
        zza(writableDatabase, str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("reference", Long.valueOf(j));
        contentValues.put("package", str);
        contentValues.put("tracking_url", str2);
        contentValues.put("timestamp", Long.valueOf(this.zzaoa.currentTimeMillis()));
        writableDatabase.insert("directappinstall", null, contentValues);
        this.zzbes.close();
    }

    public boolean zzat(String str) {
        String strValueOf = String.valueOf(str);
        zzkh.zzcw(strValueOf.length() != 0 ? "Deleting entry in direct app install log with file path: ".concat(strValueOf) : new String("Deleting entry in direct app install log with file path: "));
        boolean z = this.zzbes.getWritableDatabase().delete("directappinstall", "path = ?", new String[]{str}) > 0;
        this.zzbes.close();
        return z;
    }
}
