# 2.erronka


# 2.fasea

## Taulak
 - **Langilea**
    - emaila
    - izena
    - erabiltzailea
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
    - 4 galdera

## Bigarren RestApia

### RestApian momentuz erakutziko ditugun eragiketak:

- partidak/partidaGuztiak
  - Mota: GET
- partidak/partidaOnenak
  - Mota:GET
  - Azalpena: Langile bakoitzaren partidarik onena joku bakoitzean
- partidak/partidaRankingByJokua{jokua}
  - Mota: GET
  - Azalpena: Joku bakoitzean puntuazio altuena daukaten partiden rankingnak (max --> min)
