.class public Lcom/google/unity/ads/RewardBasedVideo;
.super Ljava/lang/Object;
.source "RewardBasedVideo.java"


# instance fields
.field private activity:Landroid/app/Activity;

.field private adListener:Lcom/google/unity/ads/UnityRewardBasedVideoAdListener;

.field private isLoaded:Z

.field private final mLock:Ljava/lang/Object;

.field private rewardBasedVideo:Lcom/google/android/gms/ads/reward/RewardedVideoAd;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/google/unity/ads/UnityRewardBasedVideoAdListener;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "adListener"    # Lcom/google/unity/ads/UnityRewardBasedVideoAdListener;

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->mLock:Ljava/lang/Object;

    .line 55
    iput-object p1, p0, Lcom/google/unity/ads/RewardBasedVideo;->activity:Landroid/app/Activity;

    .line 56
    iput-object p2, p0, Lcom/google/unity/ads/RewardBasedVideo;->adListener:Lcom/google/unity/ads/UnityRewardBasedVideoAdListener;

    .line 57
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->isLoaded:Z

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/google/unity/ads/RewardBasedVideo;)Lcom/google/android/gms/ads/reward/RewardedVideoAd;
    .locals 1
    .param p0, "x0"    # Lcom/google/unity/ads/RewardBasedVideo;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->rewardBasedVideo:Lcom/google/android/gms/ads/reward/RewardedVideoAd;

    return-object v0
.end method

.method static synthetic access$002(Lcom/google/unity/ads/RewardBasedVideo;Lcom/google/android/gms/ads/reward/RewardedVideoAd;)Lcom/google/android/gms/ads/reward/RewardedVideoAd;
    .locals 0
    .param p0, "x0"    # Lcom/google/unity/ads/RewardBasedVideo;
    .param p1, "x1"    # Lcom/google/android/gms/ads/reward/RewardedVideoAd;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/google/unity/ads/RewardBasedVideo;->rewardBasedVideo:Lcom/google/android/gms/ads/reward/RewardedVideoAd;

    return-object p1
.end method

.method static synthetic access$100(Lcom/google/unity/ads/RewardBasedVideo;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/google/unity/ads/RewardBasedVideo;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$202(Lcom/google/unity/ads/RewardBasedVideo;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/unity/ads/RewardBasedVideo;
    .param p1, "x1"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Lcom/google/unity/ads/RewardBasedVideo;->isLoaded:Z

    return p1
.end method

.method static synthetic access$300(Lcom/google/unity/ads/RewardBasedVideo;)Lcom/google/unity/ads/UnityRewardBasedVideoAdListener;
    .locals 1
    .param p0, "x0"    # Lcom/google/unity/ads/RewardBasedVideo;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->adListener:Lcom/google/unity/ads/UnityRewardBasedVideoAdListener;

    return-object v0
.end method


# virtual methods
.method public create()V
    .locals 2

    .prologue
    .line 64
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->activity:Landroid/app/Activity;

    new-instance v1, Lcom/google/unity/ads/RewardBasedVideo$1;

    invoke-direct {v1, p0}, Lcom/google/unity/ads/RewardBasedVideo$1;-><init>(Lcom/google/unity/ads/RewardBasedVideo;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 107
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->rewardBasedVideo:Lcom/google/android/gms/ads/reward/RewardedVideoAd;

    invoke-interface {v0}, Lcom/google/android/gms/ads/reward/RewardedVideoAd;->destroy()V

    .line 153
    return-void
.end method

.method public isLoaded()Z
    .locals 1

    .prologue
    .line 128
    iget-boolean v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->isLoaded:Z

    return v0
.end method

.method public loadAd(Lcom/google/android/gms/ads/AdRequest;Ljava/lang/String;)V
    .locals 2
    .param p1, "request"    # Lcom/google/android/gms/ads/AdRequest;
    .param p2, "adUnitId"    # Ljava/lang/String;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->activity:Landroid/app/Activity;

    new-instance v1, Lcom/google/unity/ads/RewardBasedVideo$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/google/unity/ads/RewardBasedVideo$2;-><init>(Lcom/google/unity/ads/RewardBasedVideo;Ljava/lang/String;Lcom/google/android/gms/ads/AdRequest;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 122
    return-void
.end method

.method public show()V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/google/unity/ads/RewardBasedVideo;->activity:Landroid/app/Activity;

    new-instance v1, Lcom/google/unity/ads/RewardBasedVideo$3;

    invoke-direct {v1, p0}, Lcom/google/unity/ads/RewardBasedVideo$3;-><init>(Lcom/google/unity/ads/RewardBasedVideo;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 146
    return-void
.end method
