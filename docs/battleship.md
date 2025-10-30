### Problem

`BattleshipGenerator` ma za zadanie wygenerować planszę do gry w statki. Plansza jest siatką kwadratów rozmiaru 10 × 10.

Każdy ze statków jest spójnym podzbiorem komórek planszy, zwanych dalej masztami.

Żadne dwa statki nie mogą się stykać.

Dwa statki stykają się wtedy, kiedy któryś maszt statku pierwszego sąsiaduje bezpośrednio lub diagonalnie z którymś masztem statku drugiego.

Plansza ma zawierać następującą liczbę statków:
- 1 x czteromasztowy
- 2 x trójmasztowy
- 3 x dwumasztowy
- 4 x jednomasztowy

### Dodatkowe rozważania

Byłoby pożądane, żeby każda prawidłowa plansza mogła zostać wygenerowana przez fabrykę.

Dodatkowo byłoby fajnie, gdyby każda z możliwych plansz była generowana z równym prawdopodobieństwem. Sprawiłoby to, że rezultat byłby nieprzewidywalny.

### Szkic rozwiązania

#### Wypełnienie planszy statkami

1. Wygenerowane zostają wszystkie statki wymagane do wypełnienia planszy
2. Zostaje również wylosowana w sposób jednorodny pozycja każdego ze statków.
3. Sprawdzone zostaje, czy ustalona konfiguracja statków jest prawidłowa. Jeśli nie, to podana procedura jest ponawiana do skutku.

#### Generowanie statków

Okazuje się, że wcześniejsza definicja statków pokrywa się z definicją polimino.

Zostają więc najpierw wygenerowane wszystkie polimino o ograniczonym z góry stopniu.

Późniejsze losowanie statku to nic innego, jak wylosowanie któregoś z wyznaczonych polimin. Losowanie zostaje zrealizowane w sposób jednorodny.

### Uzasadnienie podjętych decyzji

1. Możliwa jest niefortunna sytuacja, w której będzie wymagane wiele prób, by otrzymać prawidłową planszę. Nierozważnym byłoby więc konstruowanie kształtu statku w środku głównej pętli. Liczba dostępnych kształtów w naszej sytuacji jest niewielka, a dodatkowo prędkość wyznaczenia ich wszystkich dla małych stopni jest zadowalająca. Dlatego dobrym pomysłem jest skonstruowanie wszystkich możliwych kształtów, by potem błyskawicznie losować jeden z nich.
2. Połączenie jednorodności losowania kształtu statku oraz jego pozycji i niezależności tych obliczeń między różnymi statkami sprawia, że każda plansza jest jednakowo prawdopodobna zakładając, że rozróżniamy statki i z dokładnością do pseudolosowości. W naszej sytuacji statki są nierozróżnialne, więc niektóre układy są bardziej prawdopodobne od innych. Jednak to nie szkodzi, bo taki rezultat jest w moim mniemaniu nawet bardziej pożądany.
3. Prawdopodobnie istnieje bardziej wydajne rozwiązanie, lecz niezmiernie skomplikowane byłoby stworzenie takiego, które byłoby wydajniejsze i zachowywałoby wspomnianą wcześniej jednorodność losowania.
4. Zastosowane rozwiązanie sprawia, że program jest dosyć elastyczny. Można w łatwy sposób zmienić rozmiar planszy, liczbę statków, a nawet wprowadzić statki o większej liczbie masztów. Specyfikacja zadania co prawda nie przewiduje takiej sytuacji, jednak mimo to warto uodpornić oprogramowanie na przeróżne zmiany.  




