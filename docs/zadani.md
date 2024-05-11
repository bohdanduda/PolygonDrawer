# Zadání zkušebního úkolu

Vytvořte program, který má jako vstup URL. Po potvrzení vstupu program stáhne textový soubor ze zadané URL, vykreslí polygon podle zadání z textového souboru a spočítá a výpíše obvod v pixelech. Formát textového souboru je následující:
- všechno od znaku # do konce řádku je chápáno jako komentář a je ignorováno
- všechny prázdné řádky (řádky obsahující pouze netisknutelné znaky) jsou ignorovány
- na prvním (neprázdném) řádku je rozměr obrázku zadaný ve formátu [šířka]x[výška], hodnoty jsou celočíselné a vyjadřují rozměr v pixelech
- na každém dalším (neprázdném) řádku je souřadnice ve formátu x,y, mezery v řetězci jsou ignorovány
- složka souřadnice má následující formát: [referenční_hodnota][číslo][jednotka]
   - referenční hodnota je jedno písmeno, které nemusí být uvedeno (pokud není uvedeno, bere se výchozí hodnota, označena níže)
     - pro souřadnici X to je:
        - L = levá hrana obrázku (výchozí)
        - C = střed osy X
        - R = pravá hrana obrázku
      - pro souřadnici Y to je:
        - T = horní hrana obrázku (výchozí)
        - C = střed osy Y
        - B = spodní hrana obrázku
      - číslo může být desetinné a to kladné i záporné
      - jednotka může být:
        - px = pixely (výchozí, nemusí být uvedena)
        - % = počet procent (šířky obrázku pro souřadnice X, nebo výšky obrázku pro souřadnice Y)

Pokud je vstup nevalidní, program zobrazí chybovou hlášku.

Program vytvořte v libovolném programovacím jazyce vč. testů. **Dbejte na "čistý kód"**. Minimalizujte počet
použitých závislostí. Rozhraní aplikace je ponecháno na volbě řešitele.

# Příklady rozhraní:

- webová aplikace, s inputem a tlačítkem, po potvrzení je vykreslen obrázek pomocí canvasu a obvod je vypsán do nějakého elementu
- CLI aplikace, kde parametr je URL a výstupem je SVG nebo PNG a obvod vypsaný na stdout
        
## Příklady souřadnic:

0,0 = levý horní roh obrázku
L0,T0 = levý horní roh obrázku
R-100%,B-100% = levý horní roh obrázku
C0,C0 = střed obrázku
50%,50% = střed obrázku

## Příklad vstupu:

https://medoro.org/prace/vstup.txt

