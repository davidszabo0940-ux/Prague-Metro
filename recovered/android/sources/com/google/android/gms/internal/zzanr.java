package com.google.android.gms.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public final class zzanr {
    static final Type[] beG = new Type[0];

    private static final class zza implements Serializable, GenericArrayType {
        private final Type beH;

        public zza(Type type) {
            this.beH = zzanr.zze(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && zzanr.zza(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.beH;
        }

        public int hashCode() {
            return this.beH.hashCode();
        }

        public String toString() {
            return String.valueOf(zzanr.zzg(this.beH)).concat("[]");
        }
    }

    private static final class zzb implements Serializable, ParameterizedType {
        private final Type beI;
        private final Type beJ;
        private final Type[] beK;

        public zzb(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                zzanq.zzbn(type != null || (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null));
            }
            this.beI = type == null ? null : zzanr.zze(type);
            this.beJ = zzanr.zze(type2);
            this.beK = (Type[]) typeArr.clone();
            for (int i = 0; i < this.beK.length; i++) {
                zzanq.zzaa(this.beK[i]);
                zzanr.zzi(this.beK[i]);
                this.beK[i] = zzanr.zze(this.beK[i]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && zzanr.zza(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.beK.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.beI;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.beJ;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.beK) ^ this.beJ.hashCode()) ^ zzanr.zzcm(this.beI);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.beK.length + 1) * 30);
            sb.append(zzanr.zzg(this.beJ));
            if (this.beK.length == 0) {
                return sb.toString();
            }
            sb.append("<").append(zzanr.zzg(this.beK[0]));
            for (int i = 1; i < this.beK.length; i++) {
                sb.append(", ").append(zzanr.zzg(this.beK[i]));
            }
            return sb.append(">").toString();
        }
    }

    private static final class zzc implements Serializable, WildcardType {
        private final Type beL;
        private final Type beM;

        public zzc(Type[] typeArr, Type[] typeArr2) {
            zzanq.zzbn(typeArr2.length <= 1);
            zzanq.zzbn(typeArr.length == 1);
            if (typeArr2.length != 1) {
                zzanq.zzaa(typeArr[0]);
                zzanr.zzi(typeArr[0]);
                this.beM = null;
                this.beL = zzanr.zze(typeArr[0]);
                return;
            }
            zzanq.zzaa(typeArr2[0]);
            zzanr.zzi(typeArr2[0]);
            zzanq.zzbn(typeArr[0] == Object.class);
            this.beM = zzanr.zze(typeArr2[0]);
            this.beL = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && zzanr.zza(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return this.beM != null ? new Type[]{this.beM} : zzanr.beG;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.beL};
        }

        public int hashCode() {
            return (this.beM != null ? this.beM.hashCode() + 31 : 1) ^ (this.beL.hashCode() + 31);
        }

        public String toString() {
            if (this.beM != null) {
                String strValueOf = String.valueOf(zzanr.zzg(this.beM));
                return strValueOf.length() != 0 ? "? super ".concat(strValueOf) : new String("? super ");
            }
            if (this.beL == Object.class) {
                return "?";
            }
            String strValueOf2 = String.valueOf(zzanr.zzg(this.beL));
            return strValueOf2.length() != 0 ? "? extends ".concat(strValueOf2) : new String("? extends ");
        }
    }

    static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static int zza(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> zza(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static ParameterizedType zza(Type type, Type type2, Type... typeArr) {
        return new zzb(type, type2, typeArr);
    }

    public static Type zza(Type type, Class<?> cls) {
        Type typeZzb = zzb(type, cls, Collection.class);
        if (typeZzb instanceof WildcardType) {
            typeZzb = ((WildcardType) typeZzb).getUpperBounds()[0];
        }
        return typeZzb instanceof ParameterizedType ? ((ParameterizedType) typeZzb).getActualTypeArguments()[0] : Object.class;
    }

    static Type zza(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return zza(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return zza(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type zza(Type type, Class<?> cls, Type type2) {
        Type typeZza;
        TypeVariable typeVariable;
        do {
            Type type3 = type2;
            if (!(type3 instanceof TypeVariable)) {
                if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                    Class cls2 = (Class) type3;
                    Class<?> componentType = cls2.getComponentType();
                    Type typeZza2 = zza(type, cls, (Type) componentType);
                    return componentType != typeZza2 ? zzb(typeZza2) : cls2;
                }
                if (type3 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type3;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeZza3 = zza(type, cls, genericComponentType);
                    return genericComponentType != typeZza3 ? zzb(typeZza3) : genericArrayType;
                }
                if (!(type3 instanceof ParameterizedType)) {
                    if (!(type3 instanceof WildcardType)) {
                        return type3;
                    }
                    WildcardType wildcardType = (WildcardType) type3;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length != 1) {
                        return (upperBounds.length != 1 || (typeZza = zza(type, cls, upperBounds[0])) == upperBounds[0]) ? wildcardType : zzc(typeZza);
                    }
                    Type typeZza4 = zza(type, cls, lowerBounds[0]);
                    return typeZza4 != lowerBounds[0] ? zzd(typeZza4) : wildcardType;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type3;
                Type ownerType = parameterizedType.getOwnerType();
                Type typeZza5 = zza(type, cls, ownerType);
                boolean z = typeZza5 != ownerType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                boolean z2 = z;
                Type[] typeArr = actualTypeArguments;
                for (int i = 0; i < length; i++) {
                    Type typeZza6 = zza(type, cls, typeArr[i]);
                    if (typeZza6 != typeArr[i]) {
                        if (!z2) {
                            typeArr = (Type[]) typeArr.clone();
                            z2 = true;
                        }
                        typeArr[i] = typeZza6;
                    }
                }
                return z2 ? zza(typeZza5, parameterizedType.getRawType(), typeArr) : parameterizedType;
            }
            typeVariable = (TypeVariable) type3;
            type2 = zza(type, cls, (TypeVariable<?>) typeVariable);
        } while (type2 != typeVariable);
        return type2;
    }

    static Type zza(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsZza = zza(typeVariable);
        if (clsZza == null) {
            return typeVariable;
        }
        Type typeZza = zza(type, cls, clsZza);
        if (!(typeZza instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeZza).getActualTypeArguments()[zza(clsZza.getTypeParameters(), typeVariable)];
    }

    public static boolean zza(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return zza(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static GenericArrayType zzb(Type type) {
        return new zza(type);
    }

    static Type zzb(Type type, Class<?> cls, Class<?> cls2) {
        zzanq.zzbn(cls2.isAssignableFrom(cls));
        return zza(type, cls, zza(type, cls, cls2));
    }

    public static Type[] zzb(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeZzb = zzb(type, cls, Map.class);
        return typeZzb instanceof ParameterizedType ? ((ParameterizedType) typeZzb).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static WildcardType zzc(Type type) {
        return new zzc(new Type[]{type}, beG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzcm(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static WildcardType zzd(Type type) {
        return new zzc(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type zze(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new zza(zze(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new zzb(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new zza(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new zzc(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static Class<?> zzf(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            zzanq.zzbn(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(zzf(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return zzf(((WildcardType) type).getUpperBounds()[0]);
        }
        String name = type == null ? "null" : type.getClass().getName();
        String strValueOf = String.valueOf("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        String strValueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 13 + String.valueOf(strValueOf2).length() + String.valueOf(name).length()).append(strValueOf).append(strValueOf2).append("> is of type ").append(name).toString());
    }

    public static String zzg(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type zzh(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzi(Type type) {
        zzanq.zzbn(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }
}
