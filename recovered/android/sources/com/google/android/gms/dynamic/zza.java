package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza<T extends LifecycleDelegate> {

    /* JADX INFO: renamed from: LQ */
    private T f502LQ;

    /* JADX INFO: renamed from: LR */
    private Bundle f503LR;

    /* JADX INFO: renamed from: LS */
    private LinkedList<InterfaceC0754zza> f504LS;

    /* JADX INFO: renamed from: LT */
    private final zzf<T> f505LT = (zzf<T>) new zzf<T>() { // from class: com.google.android.gms.dynamic.zza.1
        @Override // com.google.android.gms.dynamic.zzf
        public void zza(T t) {
            zza.this.f502LQ = t;
            Iterator it = zza.this.f504LS.iterator();
            while (it.hasNext()) {
                ((InterfaceC0754zza) it.next()).zzb(zza.this.f502LQ);
            }
            zza.this.f504LS.clear();
            zza.this.f503LR = null;
        }
    };

    /* JADX INFO: renamed from: com.google.android.gms.dynamic.zza$zza, reason: collision with other inner class name */
    private interface InterfaceC0754zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, InterfaceC0754zza interfaceC0754zza) {
        if (this.f502LQ != null) {
            interfaceC0754zza.zzb(this.f502LQ);
            return;
        }
        if (this.f504LS == null) {
            this.f504LS = new LinkedList<>();
        }
        this.f504LS.add(interfaceC0754zza);
        if (bundle != null) {
            if (this.f503LR == null) {
                this.f503LR = (Bundle) bundle.clone();
            } else {
                this.f503LR.putAll(bundle);
            }
        }
        zza(this.f505LT);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String strZzc = com.google.android.gms.common.internal.zzh.zzc(context, iIsGooglePlayServicesAvailable, GooglePlayServicesUtil.zzbv(context));
        String strZzh = com.google.android.gms.common.internal.zzh.zzh(context, iIsGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strZzc);
        linearLayout.addView(textView);
        if (strZzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strZzh);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.dynamic.zza.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzfb(iIsGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzmz(int i) {
        while (!this.f504LS.isEmpty() && this.f504LS.getLast().getState() >= i) {
            this.f504LS.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, new InterfaceC0754zza() { // from class: com.google.android.gms.dynamic.zza.3
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public int getState() {
                return 1;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f502LQ.onCreate(bundle);
            }
        });
    }

    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zza(bundle, new InterfaceC0754zza() { // from class: com.google.android.gms.dynamic.zza.4
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public int getState() {
                return 2;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.f502LQ.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.f502LQ == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f502LQ != null) {
            this.f502LQ.onDestroy();
        } else {
            zzmz(1);
        }
    }

    public void onDestroyView() {
        if (this.f502LQ != null) {
            this.f502LQ.onDestroyView();
        } else {
            zzmz(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, new InterfaceC0754zza() { // from class: com.google.android.gms.dynamic.zza.2
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public int getState() {
                return 0;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f502LQ.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.f502LQ != null) {
            this.f502LQ.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f502LQ != null) {
            this.f502LQ.onPause();
        } else {
            zzmz(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, new InterfaceC0754zza() { // from class: com.google.android.gms.dynamic.zza.7
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public int getState() {
                return 5;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f502LQ.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f502LQ != null) {
            this.f502LQ.onSaveInstanceState(bundle);
        } else if (this.f503LR != null) {
            bundle.putAll(this.f503LR);
        }
    }

    public void onStart() {
        zza((Bundle) null, new InterfaceC0754zza() { // from class: com.google.android.gms.dynamic.zza.6
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public int getState() {
                return 4;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0754zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f502LQ.onStart();
            }
        });
    }

    public void onStop() {
        if (this.f502LQ != null) {
            this.f502LQ.onStop();
        } else {
            zzmz(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> zzfVar);

    public T zzbcr() {
        return this.f502LQ;
    }
}
