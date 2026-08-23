.class Lcom/google/unity/ads/Banner$1$1;
.super Lcom/google/android/gms/ads/AdListener;
.source "Banner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/unity/ads/Banner$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/unity/ads/Banner$1;


# direct methods
.method constructor <init>(Lcom/google/unity/ads/Banner$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/google/unity/ads/Banner$1;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    invoke-direct {p0}, Lcom/google/android/gms/ads/AdListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdClosed()V
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/unity/ads/UnityBannerAdListener;->onAdClosed()V

    .line 139
    :cond_0
    return-void
.end method

.method public onAdFailedToLoad(I)V
    .locals 2
    .param p1, "errorCode"    # I

    .prologue
    .line 122
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 123
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    invoke-static {p1}, Lcom/google/unity/ads/PluginUtils;->getErrorReason(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/unity/ads/UnityBannerAdListener;->onAdFailedToLoad(Ljava/lang/String;)V

    .line 125
    :cond_0
    return-void
.end method

.method public onAdLeftApplication()V
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/unity/ads/UnityBannerAdListener;->onAdLeftApplication()V

    .line 146
    :cond_0
    return-void
.end method

.method public onAdLoaded()V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/unity/ads/UnityBannerAdListener;->onAdLoaded()V

    .line 118
    :cond_0
    return-void
.end method

.method public onAdOpened()V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/google/unity/ads/Banner$1$1;->this$1:Lcom/google/unity/ads/Banner$1;

    iget-object v0, v0, Lcom/google/unity/ads/Banner$1;->this$0:Lcom/google/unity/ads/Banner;

    invoke-static {v0}, Lcom/google/unity/ads/Banner;->access$200(Lcom/google/unity/ads/Banner;)Lcom/google/unity/ads/UnityBannerAdListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/unity/ads/UnityBannerAdListener;->onAdOpened()V

    .line 132
    :cond_0
    return-void
.end method
