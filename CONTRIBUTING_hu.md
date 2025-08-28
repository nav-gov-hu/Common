# Hozzájárulás a projekthez

A projekthez bárki szabadon hozzájárulhat fejlesztési ötlet vagy javaslat hozzáadásával akár szöveges megjegyzés (issue), akár kód (merge request) formájában. A hozzájáruláskor a hozzájáruló automatikusan elfogadja a projekt licensz (MIT) által meghatározott feltételeket.

## 1) Fejlesztési ötletem vagy kérdésem van (issue)

Minden feladott issue-t megválaszolunk, de kérjük, hogy lehetőség szerint kerüljük a duplikációkat. Minden issue nyilvános, a kérdést és a választ is mindenki láthatja. Amennyiben az issue javaslat és annak tartalmával egyetértünk, úgy a javaslatot befogadjuk és a projekt kanban táblájára is felkerül mint feladat. A módosítást a későbbiekben új commit alatt hozzá fogjuk adni a projekthez.

A projekt alatt lehetőség van a dokumentáció hibáinak jelzésére is.

Kérjük a tárgynak megfelelő sablon használatát az issue-k alatt kiválasztani, a következők alapján:

- kérdés esetén: Kérdés-válasz / Q&A issue
- javaslat esetén: Fejlesztési kérés / Feature request
- dokumentációs hiba jelzése esetén: Dokumentációs hiba / Documentation error

Kérjük a sablon tárgy mezőjében a [] címke utáni részt annak megfelelően kitölteni, amire az issue vonatkozik!

A fenti feltételeknek nem megfelelő issue-kat törölni fogjuk.

## 2) Saját kódot szeretnék adni (merge request)

Ha az MR tartalmával egyetértünk, úgy a változtatást mergeljük és ha a váloztatáshoz szerver oldali módosításra is szükség van, úgy a feladat a projekt kanban táblájára is felkerül. Ha az MR hibás vagy hiányos, úgy kérni fogjuk annak javítását vagy kiegészítését.

### 2.1) Merge request feladás folyamat
1. Saját fejlesztő környezet felállítása (IDE, GIT, stb) kliens oldalon.
2. Github repository forkolása.
3. A forkolt repository klózonása saját gépre.
4. Új branch létrehozása a névkonvenciónak megfelelően.
5. A kódok módosítása, ellenőrzés, tesztelés.
6. Commit(ok) a saját lokális branchre. 
7. A commitált változtatások pusholása a saját repository fork alá.
8. Merge request feladása a GitHub felületén. A MR-t azon főverzió szerinti branchre kell feladni, amelyre a módosítási igény vonatkozik. A projektben támogatott a merge commit és a squash is, de több commit esetén preferáljuk a squasholást. (https://github.blog/2016-04-01-squash-your-commits/)

### 2.2) Merge requestek kezelése
- Minden merge request kötelező eleme a leírás, a leírás nélküli MR-eket elutasítjuk.
- Az MR leírása legyen annyira tömör és egyértelmű amennyire lehetséges, és derüljön ki belőle, hogy mi volt az igény, amit az adott változás tartalmaz.
- Az MR csak akkor mergelhető, ha a reviewerek megfelelőnek találták.
- Ha az MR hiányos vagy hibás, akkor a review során kérni fogjuk a javítását vagy a kiegészítését.

### 2.3) Merge request névkonvenciók
A merge requesteket kérjük minden esetben az alábbi névkonvenció szerint elnevezni: `[típus]/[változtatások tömören]`. 

A `[típus]/` prefix az alábbi értékeket veheti fel:

- `feature/` = új funkcionalitás hozzáadása
- `try/` = javaslat kísérleti jelleggel
- `fix/` = javítás, pontosítás

A `[változtatások tömören]` postfix tartalmazza azon üzleti igényt, amire a módosítás irányul. Például:

- `[feature]/[modifyWithoutMaster keresőparaméter hozzáadása a /queryInvoiceDigest operációhoz]`
- `[fix]/[annotácíó elírás javítása a ProductCodeCategoryType típusban]`

Nem helyesek a többértelmű, túl általános megfogalmazások (pl: /queryInvoiceDigest operáció módosítása), ezeket lehetőség szerint kerüljük.