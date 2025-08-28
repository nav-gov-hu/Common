# Hozzájárulás a projekthez

`scroll down for English version`

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

--------------------------------------------------------------------------------------------------------------------------------------------

# Contributing to the project

Anyone is free to contribute to the project by posting a development idea or suggestion, either in the form of a text comment (issue) or as code (merge request). All contributors will be considered to have automatically accepted the terms of the project license (MIT).

## 1) I have a development idea or question (issue)

We will respond to all submitted issues, but please avoid duplications wherever possible. All issues are public: both
the question and the response are visible to everyone. If the issue is a proposal and we agree with the content thereof, we will accept the
proposal and list it on the project Kanban board as a task. The change will then be added to the project as a new commit.

In the project it is possible to indicate the errors of the project documentation.

Please select the use of the template suitable for the subject from the issues, based on the following:

  - for questions: Kérdés-válasz / Q&A issue
  - for proposals: Fejlesztési kérés / Feature request
  - for documentation errors: Dokumentációs hiba / Documentation error

Please fill out the part after the [] label in the subject field of the template according to what the issue is referencing.

## 2) I would like to submit my own code (merge request)

If we agree with the content of the merge request, we will merge the change, and if the change requires server-side changes as well, we will
also post the task on the project Kanban board. If the merge request is incorrect or incomplete, we will ask you to correct or supplement it.

### 2.1) Merge request submission workflow

1.  Set up your own client-side development environment (IDE, GIT, etc.).
2.  Fork the Online-Invoice repository.
3.  Clone the forked repository to your own device.
4.  Create a new branch, adhering to the naming convention.
5.  Modify, verify and test the codes. 
6.  Commit your change(s) to your own local branch.
7.  Push your committed changes to your own repository fork.
8.  Send a merge request on the GitHub screen. The merge request should be sent to the appropriate branch to
    which the change applies. The project supports both merge commit
    and squash, but squash is preferred for multiple commits. (https://github.blog/2016-04-01-squash-your-commits/)

### 4.2) Management of merge requests

  - All merge requests must have a description. PRs without a description will be rejected.
  - Merge request descriptions should be as clear and concise as possible, and they should show what issue was addressed by the PR in
    question.
  - A merge request can only be merged if reviewers find it appropriate.
  - If the merge request is incomplete or incorrect, we will ask you to correct or complete it during the review.

### 4.3) Merge request naming conventions

Always name the merge requests according to the following naming convention: `[type]/[short description of changes]`.

The `[type]/` prefix should be given one of the following values:

  - `feature/` = when adding new functionality
  - `try/` = for proposals, implemented on an experimental basis
  - `fix/` = correction, clarification

The `[short description of changes]` postfix should contain the business need to be met by the change. Example:

  - `[feature]/[adding modifyWithoutMaster search parameter to the /queryInvoiceDigest operation]`
  - `[fix]/[correcting an annotation typo in ProductCodeCategoryType]`

Formulations that are ambiguous or too general (e.g. “modifying the /queryInvoiceDigest operation”), are incorrect and should be avoided if
possible.
