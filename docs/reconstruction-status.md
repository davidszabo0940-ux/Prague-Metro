# Rekonstrukciós állapot

## 2026-08-23

- A megfelelő XAPK azonosítva: `com.WAPP.SupwaySimulatorA`, 1.7.0.
- A játék Unity 5.3.5f1 / Mono build.
- Az APK Android-kódja JADX és Apktool kimenetként rendelkezésre áll.
- A managed könyvtárból kiemelve az `Assembly-CSharp.dll` és a Unity DLL-ek.
- A Unity-adatok AssetRipperrel betöltve.
- 107 Mesh GLB formátumba exportálva.

## Következő vizsgálat

Az `Assembly-CSharp.dll` visszafejtését és a Unity serialized objektumok osztályneveinek összekapcsolását kell elvégezni. Ezután lehet megállapítani, mely komponensek tartoznak a menühöz, pályabetöltéshez, vonatvezérléshez, kamerához és UI-hoz.
