# CinemApp
CinemApp egy olyan webes alkalmazás melynek segítségével filmvetítésekre foglalhatunk helyeket egyszerűen:
- Otthonról
- vagy a reszponzív design-nak köszönhetően telefonunkat használva bárhonnan.

## További funkciók:
**Felhasználóknak** ezenkívűl lehetősége van:
- Információkat megtudni a legújabb filmekről
  - műfaj
  - korhatár
  - hoszz
  - rövid leírás
- Különböző szűrők használata, hogy a **felhasználó** igényeinek megfelelő vetítést találhasson. Szűrők:
  - napra
  - műfajra
  - idő intervallumra
- GYIK
- E-mail küldése a webalkalmazás tulajdonosainak (kapcsolatfelvétel)

### Kupon rendszer
További a funkció az *integrált* kuponrendszer ami automatikusan e-mailben kiküld egy kupont a felhasználónak minden 3. foglalás után. Ezek a kuponok jelenthetnek
- Ajándék
- Ingyen termék
- Kedvezmény
- Felajánlás

A kupont a felhasználó e-mailben kapja meg egy QR kód formájában amit majd be kell mutatnia jegy vásárlásakor a felhasználáshoz.

### Értékelés
Alkalmazásunk **felhasználókat** megkérve értékelést készít a filmekről. Miután egy felhasználó elment egy vetítésre a film végén automatikusan kap egy e-mail-t melyben megkérjük az adott film értékelésére amit természetesen nem kötelező megtennie ha nem akarja.

### Admin felület
Felhaszbálók mellett nagy figyelmet fordítottunk az **Adminokra** is
*bejelentkezés* után egy *admin felületen* különböző műveletekre van lehetőségünk.
- Film műveletek
- Vetítés műveletek
- Műfaj műveletek
- Kupon műveletek
- Foglalás műveletek 

*Mindegyik menüben lehetőségünk van létrehozásra, módosításra valamint törlésre (kivéve foglalási műveleteknél ahol csak foglalás törölésére van lahatőségünk).*

##### Vendég karbantartó
Ez egy olyan funckió ahol lehetősége van az **adminnak** az eddigi felhasználók foglalásait, foglalási adatait ellenőrizni.

## Foglalás menete:
1. Film kiválasztása
  - Itt az alkamazás ajánl nekünk pár filmet azonos műfajban amit szintén vetítenek.
2. Ülőhelyek lefoglalása
  - grafikusan reprezentált ülésmátrixban valós időben láthatjuk a már lefoglalt (piros) még szabad (zöld) és a **felhasználó** által lefoglalt helyeket (narancs)
3. Adatok megadása:
  - Név
  - Telefonszám
  - E-mail cím
  - Irányítószám
4. Ezután kapunk egy visszaigazoló e-mailt a foglalás sikerességéről és a foglalás adatairól.
5. Elmegyünk moziba élvezni a filmet.

## Képek
### Főoldal:
![alt text](documentation/readme_pictures/index.png?raw=true "Főoldal")
### Helyfoglalás:
![alt text](documentation/readme_pictures/booking.png?raw=true "Helyfoglalás")
### Értékelés:
![alt text](documentation/readme_pictures/rate.png?raw=true "Értékelés")
### Kapcsolat:
![alt text](documentation/readme_pictures/contact.png?raw=true "Kapcsolat")
### Reszponzív design:
![alt text](documentation/readme_pictures/responsive.png?raw=true "Reszponzív design")

## Build Status
[![Build Status](https://travis-ci.org/RFT-4th-team/cinemApp.svg?branch=master)](https://travis-ci.org/RFT-4th-team/cinemApp)
