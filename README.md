# Subway Simulator Prague Metro – reconstruction workspace

Ez a repó a `Subway Simulator Prague Metro` 1.7.0 APK/XAPK alapján készülő rekonstrukciós munkaterület.

## Forráscsomag

- package: `com.WAPP.SupwaySimulatorA`
- version: `1.7.0` / versionCode `170`
- Unity: `5.3.5f1`, régi Mono-alapú build
- eredeti csomag: `Subway+Simulator+Prague+Metro_1.7.0_APKPure.xapk`

## Mappaszerkezet

- `recovered/android/sources` – JADX által visszaalakított Java-szerű Android-kód
- `recovered/android/smali` – Apktool smali-kódja
- `recovered/android/AndroidManifest.xml` – visszafejtett manifest
- `recovered/unity/managed` – Unity és a játék managed DLL-jei, köztük `Assembly-CSharp.dll`
- `recovered/unity/models` – AssetRipperrel exportált 107 Mesh GLB formátumban
- `docs` – rekonstrukciós jegyzetek és későbbi vizsgálati eredmények

## Fontos korlát

Ez még nem eredeti, közvetlenül buildelhető Unity-projekt. Az eredeti Unity-project settings, scene- és forrásfájlok hiányoznak; a rekonstrukciót fokozatosan építjük fel a managed DLL-ekből, a serialized Unity-adatokból és a kinyert assetekből.

## Következő lépések

1. `Assembly-CSharp.dll` osztályainak és metódusainak feltérképezése.
2. Scene-ek, GameObject-ek és MonoBehaviour-komponensek azonosítása.
3. A fő játékmenet rekonstruálása: menü, pályabetöltés, vonatvezérlés.
4. Minimális Unity-projektváz létrehozása és assetek visszakötése.

Az APK, OBB és a teljes nyers Unity-adatcsomag méretük miatt nem része ennek a Git-commitnak; ezek helyi munkapéldányként az elemzési munkaterületen maradnak.
