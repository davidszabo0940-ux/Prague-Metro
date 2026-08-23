.class public Lcom/google/unity/ads/PluginUtils;
.super Ljava/lang/Object;
.source "PluginUtils.java"


# static fields
.field public static final LOGTAG:Ljava/lang/String; = "AdsUnity"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getErrorReason(I)Ljava/lang/String;
    .locals 5
    .param p0, "errorCode"    # I

    .prologue
    .line 38
    packed-switch p0, :pswitch_data_0

    .line 48
    const-string v0, "AdsUnity"

    const-string v1, "Unexpected error code: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    const-string v0, ""

    :goto_0
    return-object v0

    .line 40
    :pswitch_0
    const-string v0, "Internal error"

    goto :goto_0

    .line 42
    :pswitch_1
    const-string v0, "Invalid request"

    goto :goto_0

    .line 44
    :pswitch_2
    const-string v0, "Network Error"

    goto :goto_0

    .line 46
    :pswitch_3
    const-string v0, "No fill"

    goto :goto_0

    .line 38
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static isResultSuccess(Lcom/google/android/gms/ads/purchase/InAppPurchaseResult;)Z
    .locals 2
    .param p0, "result"    # Lcom/google/android/gms/ads/purchase/InAppPurchaseResult;

    .prologue
    .line 59
    invoke-interface {p0}, Lcom/google/android/gms/ads/purchase/InAppPurchaseResult;->getResultCode()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
