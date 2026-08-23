package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.appcompat.C0178R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class NotificationCompatImplBase {
    static final int MAX_MEDIA_BUTTONS = 5;
    static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

    NotificationCompatImplBase() {
    }

    public static <T extends NotificationCompatBase.Action> void overrideContentView(NotificationBuilderWithBuilderAccessor builder, Context context, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, int number, Bitmap largeIcon, CharSequence subText, boolean useChronometer, long when, List<T> actions, int[] actionsToShowInCompact, boolean showCancelButton, PendingIntent cancelButtonIntent) {
        RemoteViews views = generateContentView(context, contentTitle, contentText, contentInfo, number, largeIcon, subText, useChronometer, when, actions, actionsToShowInCompact, showCancelButton, cancelButtonIntent);
        builder.getBuilder().setContent(views);
        if (showCancelButton) {
            builder.getBuilder().setOngoing(true);
        }
    }

    private static <T extends NotificationCompatBase.Action> RemoteViews generateContentView(Context context, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, int number, Bitmap largeIcon, CharSequence subText, boolean useChronometer, long when, List<T> actions, int[] actionsToShowInCompact, boolean showCancelButton, PendingIntent cancelButtonIntent) {
        RemoteViews view = applyStandardTemplate(context, contentTitle, contentText, contentInfo, number, largeIcon, subText, useChronometer, when, C0178R.layout.notification_template_media, true);
        int numActions = actions.size();
        int N = actionsToShowInCompact == null ? 0 : Math.min(actionsToShowInCompact.length, 3);
        view.removeAllViews(C0178R.id.media_actions);
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                if (i >= numActions) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(numActions - 1)));
                }
                NotificationCompatBase.Action action = actions.get(actionsToShowInCompact[i]);
                RemoteViews button = generateMediaActionButton(context, action);
                view.addView(C0178R.id.media_actions, button);
            }
        }
        if (showCancelButton) {
            view.setViewVisibility(C0178R.id.end_padder, 8);
            view.setViewVisibility(C0178R.id.cancel_action, 0);
            view.setOnClickPendingIntent(C0178R.id.cancel_action, cancelButtonIntent);
            view.setInt(C0178R.id.cancel_action, "setAlpha", context.getResources().getInteger(C0178R.integer.cancel_button_image_alpha));
        } else {
            view.setViewVisibility(C0178R.id.end_padder, 0);
            view.setViewVisibility(C0178R.id.cancel_action, 8);
        }
        return view;
    }

    public static <T extends NotificationCompatBase.Action> void overrideBigContentView(Notification n, Context context, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, int number, Bitmap largeIcon, CharSequence subText, boolean useChronometer, long when, List<T> actions, boolean showCancelButton, PendingIntent cancelButtonIntent) {
        n.bigContentView = generateBigContentView(context, contentTitle, contentText, contentInfo, number, largeIcon, subText, useChronometer, when, actions, showCancelButton, cancelButtonIntent);
        if (showCancelButton) {
            n.flags |= 2;
        }
    }

    private static <T extends NotificationCompatBase.Action> RemoteViews generateBigContentView(Context context, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, int number, Bitmap largeIcon, CharSequence subText, boolean useChronometer, long when, List<T> actions, boolean showCancelButton, PendingIntent cancelButtonIntent) {
        int actionCount = Math.min(actions.size(), 5);
        RemoteViews big = applyStandardTemplate(context, contentTitle, contentText, contentInfo, number, largeIcon, subText, useChronometer, when, getBigLayoutResource(actionCount), false);
        big.removeAllViews(C0178R.id.media_actions);
        if (actionCount > 0) {
            for (int i = 0; i < actionCount; i++) {
                RemoteViews button = generateMediaActionButton(context, actions.get(i));
                big.addView(C0178R.id.media_actions, button);
            }
        }
        if (showCancelButton) {
            big.setViewVisibility(C0178R.id.cancel_action, 0);
            big.setInt(C0178R.id.cancel_action, "setAlpha", context.getResources().getInteger(C0178R.integer.cancel_button_image_alpha));
            big.setOnClickPendingIntent(C0178R.id.cancel_action, cancelButtonIntent);
        } else {
            big.setViewVisibility(C0178R.id.cancel_action, 8);
        }
        return big;
    }

    private static RemoteViews generateMediaActionButton(Context context, NotificationCompatBase.Action action) {
        boolean tombstone = action.getActionIntent() == null;
        RemoteViews button = new RemoteViews(context.getPackageName(), C0178R.layout.notification_media_action);
        button.setImageViewResource(C0178R.id.action0, action.getIcon());
        if (!tombstone) {
            button.setOnClickPendingIntent(C0178R.id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            button.setContentDescription(C0178R.id.action0, action.getTitle());
        }
        return button;
    }

    private static int getBigLayoutResource(int actionCount) {
        return actionCount <= 3 ? C0178R.layout.notification_template_big_media_narrow : C0178R.layout.notification_template_big_media;
    }

    private static RemoteViews applyStandardTemplate(Context context, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, int number, Bitmap largeIcon, CharSequence subText, boolean useChronometer, long when, int resId, boolean fitIn1U) {
        RemoteViews contentView = new RemoteViews(context.getPackageName(), resId);
        boolean showLine3 = false;
        boolean showLine2 = false;
        if (largeIcon != null && Build.VERSION.SDK_INT >= 16) {
            contentView.setViewVisibility(C0178R.id.icon, 0);
            contentView.setImageViewBitmap(C0178R.id.icon, largeIcon);
        } else {
            contentView.setViewVisibility(C0178R.id.icon, 8);
        }
        if (contentTitle != null) {
            contentView.setTextViewText(C0178R.id.title, contentTitle);
        }
        if (contentText != null) {
            contentView.setTextViewText(C0178R.id.text, contentText);
            showLine3 = true;
        }
        if (contentInfo != null) {
            contentView.setTextViewText(C0178R.id.info, contentInfo);
            contentView.setViewVisibility(C0178R.id.info, 0);
            showLine3 = true;
        } else if (number > 0) {
            int tooBig = context.getResources().getInteger(C0178R.integer.status_bar_notification_info_maxnum);
            if (number > tooBig) {
                contentView.setTextViewText(C0178R.id.info, context.getResources().getString(C0178R.string.status_bar_notification_info_overflow));
            } else {
                NumberFormat f = NumberFormat.getIntegerInstance();
                contentView.setTextViewText(C0178R.id.info, f.format(number));
            }
            contentView.setViewVisibility(C0178R.id.info, 0);
            showLine3 = true;
        } else {
            contentView.setViewVisibility(C0178R.id.info, 8);
        }
        if (subText != null && Build.VERSION.SDK_INT >= 16) {
            contentView.setTextViewText(C0178R.id.text, subText);
            if (contentText != null) {
                contentView.setTextViewText(C0178R.id.text2, contentText);
                contentView.setViewVisibility(C0178R.id.text2, 0);
                showLine2 = true;
            } else {
                contentView.setViewVisibility(C0178R.id.text2, 8);
            }
        }
        if (showLine2 && Build.VERSION.SDK_INT >= 16) {
            if (fitIn1U) {
                Resources res = context.getResources();
                float subTextSize = res.getDimensionPixelSize(C0178R.dimen.notification_subtext_size);
                contentView.setTextViewTextSize(C0178R.id.text, 0, subTextSize);
            }
            contentView.setViewPadding(C0178R.id.line1, 0, 0, 0, 0);
        }
        if (when != 0) {
            if (useChronometer) {
                contentView.setViewVisibility(C0178R.id.chronometer, 0);
                contentView.setLong(C0178R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + when);
                contentView.setBoolean(C0178R.id.chronometer, "setStarted", true);
            } else {
                contentView.setViewVisibility(C0178R.id.time, 0);
                contentView.setLong(C0178R.id.time, "setTime", when);
            }
        }
        contentView.setViewVisibility(C0178R.id.line3, showLine3 ? 0 : 8);
        return contentView;
    }
}
