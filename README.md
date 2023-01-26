# 2.erronka


# 2.fasea

## Taulak
 - **Langilea**
    - emaila
    - izena
    - erabiltzailea
    - pasahitza
    - jaiotzadata
    - taldea
  - **Partida**
    - id
    - erabiltzailea
    - puntuazioa
    - data
    - jokua
  - **Balorazioa**
    - langilea/erabiltzailea
    - jokua
    - balorazioa
  - **Komentarioa**
    - langilea/erabiltzailea
    - jokua
    - komentarioa
  - **Inkesta**
    - langilea/erabiltzailea
    - 1.galdera
    - 2.galdera
    - 3.galdera
    - 4.galdera
  - **Jokoa**
    - id
    - izena

## Bigarren RestApia

### RestApian momentuz erakutziko ditugun eragiketak:

- **partidak/partidaGuztiak**
  - **Mota:** GET
- **partidak/partidaOnenak**
  - **Mota:** GET
  - **Azalpena:** Langile bakoitzaren partidarik onena joku bakoitzean
- **partidak/partidaRankingByJokua{jokua}**
  - **Mota:** GET
  - **Azalpena:** Joku bakoitzean puntuazio altuena daukaten partiden rankingnak (max --> min)

- **langileak/langileErabiltzailea{erabiltzailea}**
  - **Mota: GET**
  - **Azalapena:** Langileen erabiltzailea lortzeko

- **balorazioak/jokuBakoitzarenBalorazioak**
  - **Mota:** GET
  - **Azalpena:** Joku bakoitza dituen balorazio guztiak
- **balorazioak/BalorazioaSartu**
  - **Mota:** POST
  - **Azalpena:** Webaren balorazioak datu basean gordetzeko
- **balorazioak/balorazioaAldatu**
  - **Mota:** PUT
  - **Azalpena:** Aldaketa gordetzeko langile/erabiltzaile batek balorazioa aldatzen duenean

- **komentarioak/jokuBakoitzarenKomentarioak**
  - **Mota:** GET
  - **Azalpena:** Joku bakoitza dituen komentario guztiak
- **komentarioak/komentarioaSartu**
  - **Mota:** POST
  - **Azalpena:** Webarenkomentarioak datu basean gordetzeko
- **komentarioak/komentarioEzabatu**
  - **Mota:** DELETE
  - **Azalpena:** Komentarioak ezabatzeko.

- **inkestak/bakoitzarenInkesta{erabiltzailea}**
  - **Mota:** GET
  - **Azalpena:** Erabiltzailea bakoitzaren erantzunak ikusteko
- **inkestakiInkestaDatuakSartu**
  - **Mota:** POST
  - **Azalpena:** Inkestaren datuak sartu
- **inkesta/inkestarenErantzunakAldatu**
  - **Mota:** PUT
  - **Azalpena:** Inkestaren datuak aldatu ahal izateko
