# ProjectMOSC

Celem zadania było napisanie aplikacji zarządzającej umowami między klientami a ich systemami.

### Plan zadania

Planem zadania było ukończenie zadania w skali minimum 80%. 

###### W zadaniu wykonano następujące rzeczy:
- Dodano pełną obsługę CRUD dla wszystkich z 3 pozycji: Klient, System i Umowa.
- Dodano możliwość pobrania danych za pomocą arkusza kalkulacyjnego o formacie '.xlsx' dla Umów.

###### Braki w zadaniu:
- Klient: Brak komunikatu w przypadku dodania niepoprawnego wpisu.
- System: Brak komunikatu w przypadku dodania niepoprawnego wpisu.
- Umowa: Brak komunikatu w przypadku dodania niepoprawnego wpisu.
- Brak możliwości pobrania danych za pomocą arkusza kalkulacyjnego o formacie '.xls' 
- Dane poprzez arkusz kalkulacyjny dodają się tylko gdą sa wszystkie. Brak stosownego komunikatu, dlaczego dane nie dodały się.
- Dodanie testów jednostkowych

Aplikacja została napisana w sposób poprawny, lecz z faktu na czas na oddanie zadania to testy jednostkowowe zostały pominięte. Decyzja na kompatybilność

### Technologie

##### Posiadane w stopniu wystarczającym do podanego zadania:
- Java 8
- Maven
- Apache Tomcat 8
- PostgreSQL
- HTML
- CSS
- Javascript
- JQuery
- Bootstrap
- Apache POI

##### Umiejętności, która wymagały nauki w kierunku zadania:
- Spring Framework / MVC
- Hibernate


### Plii inicjalizacyjne 
W folderze "postgresql-scripts" znajdują się 3 plik. 
- '1. create database.sql' - utworzenie bazy danych
- '2. create table.sql' - utworzenie tabel dla powyższej bazy danych
- '3. insert simple data.sql' - przykładowe dane do zasilenia bazy

### Kompatybyliność
Aplikacja została sprawdzona na kilku przeglądarkach aby sprawdzić jej działanie.
- Microsoft Edge - Wersja 83.0.478.45
- Mozilla Firefox - Wersja 76.0
- Google Chrome - Wersja 83.0.4103.97
- Internet Explorer - Wersja 11.900.18362.0
Aplikacja chodziła zgodnie na wszystkich przeglądarkach.