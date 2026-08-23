.class public final Lcom/google/android/gms/internal/zzjy$zza;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzjy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "zza"
.end annotation


# instance fields
.field public final errorCode:I

.field public final zzaoy:Lcom/google/android/gms/ads/internal/client/AdSizeParcel;

.field public final zzcii:Lorg/json/JSONObject;

.field public final zzcik:Lcom/google/android/gms/internal/zzge;

.field public final zzcio:J

.field public final zzcip:J

.field public final zzcit:Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;

.field public final zzciu:Lcom/google/android/gms/ads/internal/request/AdResponseParcel;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/ads/internal/request/AdResponseParcel;Lcom/google/android/gms/internal/zzge;Lcom/google/android/gms/ads/internal/client/AdSizeParcel;IJJLorg/json/JSONObject;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzcit:Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzciu:Lcom/google/android/gms/ads/internal/request/AdResponseParcel;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzcik:Lcom/google/android/gms/internal/zzge;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzaoy:Lcom/google/android/gms/ads/internal/client/AdSizeParcel;

    iput p5, p0, Lcom/google/android/gms/internal/zzjy$zza;->errorCode:I

    iput-wide p6, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzcio:J

    iput-wide p8, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzcip:J

    iput-object p10, p0, Lcom/google/android/gms/internal/zzjy$zza;->zzcii:Lorg/json/JSONObject;

    return-void
.end method
