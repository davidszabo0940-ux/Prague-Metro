# Reconstructed Unity project

Ez a projektváz a visszafejtett `Assembly-UnityScript.dll` fő komponenseinek újraépítéséhez készült.

## Cél

A projekt nem állítja, hogy az eredeti forráskódot tartalmazza. A `RekonstrukceRecovered` és `NoveMenuRecovered` osztályok új C# alapok, amelyek az eredeti osztályneveket, mezőket és fő belépési pontokat követik.

## Unity-verzió

Az eredeti játék Unity `5.3.5f1` verzióval készült. A projektvázat ezzel a verzióval kell először megnyitni, majd csak később érdemes modern Unity-verzióra migrálni.

## Következő lépés

A kinyert scene-ekből vissza kell kötni a `StationPoint` komponenseket, a kabin ajtó- és kijelzőreferenciáit, majd a `RekonstrukceRecovered` állapotgépét az eredeti metódusok viselkedésével kell pontosítani.
