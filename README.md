# map-practice

_Megjegyzés: a lenyitható megoldások füleknél
rosszul van a kód tördelve, mert csak így engedi a HTML,
de te használd az automatikus formázást IntelliJ-ben!_

## Elmélet

A Map adatstruktúra kulcs-érték párokat jelent.

Például: 
Az osztályban kinek mi a kedvenc színe?


| Kulcs     |      Érték      |
|-----------|:---------------:|
| M. Béla   | bugyirózsaszín  |
| I. Lili   |   libafoszöld   |
| Z. Margit |  diplomatakék   |
| U. Pityu  | bugyirózsaszín  |


**Kulcs**: az osztálytárs neve, 
ami egyértelműen beazonosítja a tanulót,
tehát két ugyanolyan kulcs nem szerepelhet
(nem lehet két Z. Margit)

**Érték**: az osztálytárs kedvenc színe,
ami mindig a kulcshoz tartozó érték,
szerepelhetnek ugyanolyan értékek
(tehát több tanulónak is lehet ugyanaz a kedvenc színe)

Ezek a kulcsok és értékek bármilyen **összetett** típusok lehetnek,
(tehár primitív típusok nem), a jelen esetben a kulcs az String
(hiszen szöveges érték) és az érték is String, (hiszen az is szöveges
érték.)

Map-ek deklarálásakor nekünk explicit meg kell adnunk milyen
típusúak lesznek a kulcsaink és értékeink, tehát a kacsacsőrbe
két típust is be kell írnünk - az eddig tanult kollekciókkal
(List, Set) szemben, ahol csak egy típust kell megadnunk.

`Map<String, String> tanuloKedvencSzine`;

A kacsacsőrben az első típus a kulcs típusa,
a második az értéké.

Vegyünk egy olyan példát, ahol eltérő a kulcs és az érték típusa!
Ilyen az osztály tanulóinak az átlaga:

| Kulcs     | Érték |
|-----------|:-----:|
| M. Béla   |  2.1  |
| I. Lili   |  4.9  |
| Z. Margit |  1.0  |
| U. Pityu  |  3.8  |

Ezt a kulcs-érték párokat tartalmazó "táblázatot" az alábbi adatstruktúrában
tudnánk reprezentálni:

`Map<String, Double> tanuloAtlaga`;

Az érték egy tört szám, ezért Double-ben tároljuk.

Kérdés: miért nem kisbetűs double-ben?
<details><summary>Válasz</summary><p>
Mert primitív típusokat nem tárolhatunk Map-ben!
</p></details>

Hogyan nézne ki, ha a tanulóknak nem csak az átlagát, de minden jegyét el szeretném tárolni?

| Kulcs     |         Érték          |
|-----------|:----------------------:|
| M. Béla   |    1, 3, 3, 4, 3, 2    |
| I. Lili   | 5, 5, 5, 5, 5, 4, 5, 5 |
| Z. Margit |        1, 1, 1         |
| U. Pityu  |       4, 5, 3, 5       |

A táblázatban látjuk hogy most mintha "több érték" szerepelne az érték osztályban - méghozzá
nem is mindig ugyanannyi darab!

Fontos megjegyezni, hogy a Map kulcs-érték párokat jelent, nem pedig kulcs-érték**ek** párokat, tehát
ez **_nem_** valami ilyemi adatsruktúra lesz:
`Map<String, Integer, Integer, Integer, Integer, Integer, ..., ?> tanuloJegyei;`

Hogyan lehetne akkor mégis megoldani ezt?
A kulcsom a tanuló neve, az értékem pedig...? A tanuló jegye...-inek a LISTÁJA!
Azaz ez így fog kinézni: `Map<String, List<Integer>> tanuloJegyei`;
Figyeld meg a kacsacsőröket, melyik "mettől meddig tart"!

**Kulcs**: `String`

**Érték**: `List<Integer>`

Tehát minden Stringhez tartozik egy Integer lista!

_Megjegyzés: kulcsként is tudunk kollekciókat (Set, List, akár Map) megadni, de nem szokás!_

A Map egy interfész, egyik implementációja a HashMap, mi mindig ezt az implementációt
fogjuk használni: `Map<String, List<Integer>> tanuloJegyei = new HashMap<>();`

A Map nem egy rendezett adatstruktúra, kulcs alapján való keresésben teljesít jól.
Használni akkor érdemes, amikor egy kulcsra fogsz rákeresni és annak kell lekérned
a hozzátartozó adatait!

## Feladatok

### 1. Miben tárolnád el?
Gondolkozz el, milyen adatstrukturában (List, Set, Map) és milyen típusokkal 
tárolnád el az alábbi adatokat!
#### 1.a Kártyapakli
Van egy kártyapaklid, aminek mindig meg kell keverned a lapjait!
<details><summary>Megoldás</summary><p>
Listában: List < Card > cards;
</p></details>

#### 1.b Telefonkönyv
Van egy telefonkönyved, ahol név alapján szeretnél keresni, és eltárolni
infókat, pl. telefonszám, foglalkozás.
<details><summary>Megoldás</summary><p>
Mapben: Map < String, ContactInfo > phoneBook;
Ahol a ContactInfo osztály (amit te magad hozol létre)
tartalmazza a telefonszámot és a foglalkozást is!
</p></details>

#### 1.c Szótár
Egy magyar-angol szótárat szerenél készíteni.
<details><summary>Megoldás</summary><p>
Mapben: Map < String, String > dictionary;
</p></details>

### 2. Egyszerű map metódusok

## 2.a Vissza az oviba!
Készítsd egy map-et, ami a barátaidnak a régi
óvodai jeleit tárolja el!

<details><summary>Megoldás</summary><pre>
Map< String, String> ovodaiJelek = new HashMap<>();
</pre></details>

Töltsd fel a saját neveddel és jeleddel!
Ehhez használd a `.put()` metódust!

<details><summary>Megoldás</summary><pre>
ovodaiJelek.put("Zámbó Jimmy", "korona");
</pre></details>

Adj még hozzá legalább 2 kulcs-érték párt!
Ezeket a párokat Entry-nek hívjuk.

Vegyél fel egy olyan entry-t is, ahol
a kulcs különböző, ám az érték már szerepel az értékek közt!

Vegyél fel egy olyan entry-t, ahol már
szereplő kulcsot adsz meg! Mi történik ilyenkor?
Az eredeti érték marad vagy felülíródik vagy összefűzödik?

Írasd ki a maped-et! `System.out.println(ovodaiJelek);`
Milyen sorrenben írja ki az elemeket?

Távoltísd el a kulcs alapján 
az egyik kulcs-érték párt a `remove()` metódussal!

<details><summary>Megoldás</summary><pre>
`ovodaiJelek.remove("Zámbó Jimmy");`
</pre></details>

Kérd le a `.get()` metódussal az egyik kulcshoz tartozó 
értéket és írasd ki!

<details><summary>Megoldás</summary><pre>
System.out.println(ovodaiJelek.get("Zámbó Jimmy")); // korona
</pre></details>

Írd ki az összes kulcsot a `.keySet()`-tel!
<details><summary>Megoldás</summary><pre>
System.out.println(ovodaiJelek.keySet());
</pre></details>

Tedd meg ugyanezt az értékekre, keresd meg, melyik
metódus használható erre!
<details><summary>Megoldás</summary><pre>
System.out.println(ovodaiJelek.values());
</pre></details>

Nézd meg az .entrySet() metódust, mivel tér vissza?
(Hívd meg a mapeden és vidd rá a kurzort, olvasd el a
fejlécét és a leírását!)
<details><summary>Megoldás</summary><pre>
Mily' meglepő, Set-tel tér vissza, amiben
a kulcs-érték párokból képzett Entry-ket tároljuk
</pre></details>

Vizsgáld meg mi a különbség aközött, 
ha csak a maped írod ki,
és ha a map `entrySet()`-jét!
<details><summary>Megoldás</summary><pre>
Kiíráskor nagyon minimális különbséget látunk,
a kapcsoszárójel helyett szögletes a zárójel, ám
itt a háttérben az történik, hogy más az adatstruktúra,
amit kiíratunk: első esetben Map, második esetben Set!
</pre></details>

Mi történik, ha nem létező kulcsot adsz meg paraméterül
a `.get()` metódusnak?
<details><summary>Megoldás</summary><pre>
null-t ad vissza
</pre></details>

Hogyan oldanád meg, hogy kicseréld a saját 
óvodai jeledet egy másikra?

## 2.b Vissza a tesiórára!
Írj egy mapet, ami testmagasságaokat tart számon!
Add hozzá az alábbi értékeket:

```
heightMap.put("Sziproka", 131);
heightMap.put("Csuporka", 134);
heightMap.put("Puszedli", 123);
heightMap.put("X-Professzor", 185);
heightMap.put("Mohó Jojó", 152);
```

Írasd ki az összes testmagasságot! (A neveket NE!)

Írd ki, mekkora a legnagyobb testmagasság!
<details><summary>Segítség</summary><p>
A values()-on kell végigiterálni, érdemes
foreach ciklust használnod!
</p></details>

<details><summary>Még több segítség</summary><pre>
A foreach ciklus fejléce:
for (int height : heightMap.values())
</pre></details>

A segédváltozódnak semmiképp se adj meg alapértéknek
0-t, de azt se csináld, hogy lekéred egy konkrét kulcs 
értékét és azt állítod be neki!
Ehelyett használd ezt:
`int maxHeight = Integer.MIN_VALUE;` 

Írd ki, ki a legmagasabb!
_Ez már sokkal csúnyább megoldás lesz :)_
<details><summary>Segítség</summary><p>
Ugyanúgy meg kell keresned a legnagyobb magasságot,
majd eltárolnod a hozzá tartozó kulcsot!
Ez hasonló ahhoz, mint amikor a tömbön való végigiteráláskor
eltároluk az indexet és az indexen lévő értéket is!
Azaz vegyél fel egy segédváltozót a névnek!
</p></details>

Mi lesz most a kollekció, amin végig kell iterálnod,
hogy fog kinézni a foreach ciklus?
<details><summary>Segítség</summary><p>
Az .entrySet()-en kell végigmenni!
</p></details>

**TRÜKK!** Írd be IntelliJ-be, hogy `heightMap.entrySet()`,
majd nyomj egy Alt+Entert! Válaszd azt az opciót, hogy
`Iterate over...` és voilá! Automatikusan kitöltötte
neked a foreach fejlécét! Igen, csúnya!:)
Érdemes átírni az automatikusan generált "aktuális elem"
változójának a nevét `stringIntegerEntry`-ről akár csak sima
`entry`-re! Ezen a `Map.Entry` típusú változón fogsz tudni
hívni `.getKey()` és `.getValue()` metódusokat!

<details><summary>Segítség</summary><code>
for (Map.Entry< String, Integer> entry : heightMap.entrySet()) {
    // TODO    
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
}
</code></details>