# AirlyClient

Projekt korzysta z bibliotek: "JCommander" i "Gson" i budowany jest za pomocą Gradle'a.

Parametry:

--key X  - String opisujący API key dostępu do serwisu, API key może być równierz pobrany z zmiennej środowiskowej API_KEY

--longitude X - Wartość numeryczna określająca szerokość geograficzną pomiaru

--latitude X - Wartość numeryczna określająca wysokośc geograficzną pomiaru

--sensor X - Wartość określająca ID wybranego sensora

--history - Opcja odpowiedzialna za dodatkowe wyświetlenie skróconej wersji poprzednich pomiarów

Program do pracy potrzebuje API key pobranego w dowolny z wymienionych sposobów i pozycji na mapie lub ID wybranego sensora