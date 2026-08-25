# Játékkód-inventár

A játék saját logikája az `recovered/unity/managed/Assembly-UnityScript.dll` fájlban található. A DLL 23 játéktípust tartalmaz; a nevekből és mezőkből a következő fő rendszerek azonosíthatók.

## Fő vezérlő

### `Rekonstrukce`

A legfontosabb vezérlőosztály. Kezeli többek között a sebességet és gyorsulást, a vezetőkarokat, az ajtókat, a fényeket, a hangokat, a kabin kijelzőit, a vonatállapotot, a menüt és a kártya behelyezését.

Fő metódusok: `Start`, `Update`, `OnGUI`, `Selftest`, `Selftest2`, `pauza`, `svetla`, `vlozKartu`, `vlozKartu2`, `vlozKartu3`, `vlozKartu4`, `otevriLeve`, `otevriPrave`, `zavriLeve`, `zavriPrave`, `Klaksonstart`, `Klaksonstop`.

### `NoveMenu`

A főmenü és az útvonalválasztás vezérlője. Tartalmazza a nyelvváltást, a kezdő- és végállomás kiválasztását, a viselkedéstípust, a grafikai beállításokat és a pályairány betöltését.

Fő metódusok: `Start`, `OnGUI`, `animuj`, `zmenjazyk`, `nactismerdepo`, `nactismermotol`.

## Állomások és útvonal

### `bod`

Állomás-/útvonalpont-adatokat tartalmaz: kezdőállomás, végállomás, következő állomás, érkező szerelvény, utascsere, sebességkorlát és állomásnév.

### `Hlasic`

A fedélzeti bemondások rendszere. Külön kezeli az ajtóhangokat, végállomást, következő állomást, átszállást és oktatómódot.

### `Hodiny`

Az óra és indulási idő kijelzőinek logikája.

## Vonat- és pályarendszerek

- `AiVuz` – AI-vonat/szerelvény indítása és irányfüggő működés.
- `AIGroup` – AI-csoportok spawnolása és térrégiói.
- `Vyhybka` – pályaváltó/váltó vezérlése.
- `vypnoutPredchozi` – előző szakasz vagy kapcsoló kikapcsolása.
- `zapnoutNasledujici` – következő szakasz vagy kapcsoló bekapcsolása.
- `StatikAI` – statikus AI-arány vagy utasmegoszlás.
- `AIpersona` – AI-karakterek anyagai és oldalisága.
- `elza` – azonosított vonat-/kabinrendszer, kijelzők és állapotok.

## Kamera és megjelenítés

- `OtaceniKamery` – kamera forgatása és dőlése.
- `Obrazovka` – állomási/kameraképernyő és render texture.
- `renderKam` – kamera villogtatása vagy fényjelzése.
- `SvteloTma` – világítás/fényviszonyok váltása.
- `Sporic` – képernyő- vagy UI-elem mozgatása.
- `FpsMeter`, `test` – FPS-mérés és debug UI.

## Egyéb játékmenet

- `intro` – bevezető/logó és menübe léptetés.
- `sebevrah` – azonosított pályaesemény vagy karaktermozgás.
- `cebevrahbod` – kapcsolódó eseménypont.
- `Obrazovka` – kijelzők és kameraanyagok.

## Következtetés

A kód szerkezete alapján a projekt nem elveszett teljesen: a fő vezérlési logika és a játékmenet-komponensek nevei visszanyerhetők. A következő technikai lépés a Unity serialized objektumok és ezek a MonoBehaviour-típusok közötti kapcsolatok feltérképezése, majd egy új Unity 5.3.5f1 projektváz létrehozása.
