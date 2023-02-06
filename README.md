## Semestrální práce z předmětu KIV/FJP
### Překladač pro programovací jazyk AdAs
#### Sestavení překladače
Sestavení projektu je možné provést příkazem `mvn package`. Po úspěšném překladu je vytvořen 
.jar archiv (`AdAs-1.0.0-SNAPSHOT-jar-with-dependencies.jar`), který se nachází v adresáři `target`.
#### Spuštění překladu
`java -jar <nazev_jar_archivu> <vstupni_soubor> <vystupni_soubor>`