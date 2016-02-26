## Aihemäärittely.

**Aihe:** Budjetti-sovellus erilaisten menojen ja tulojen kirjanpitoa tai suunnittelua varten. Kirjanpito talletettavissa ja luettavissa. 

**Käyttäjät:** Budjetti suunnittelijat tai kirjanpitäjät.

**Käyttäjien toiminnot:** Kirjanpidon luominen, tallennus tai lukeminen ja kirjanpidon muokkaus mikäli oikeudet muokata.(salasana vahvisteinen toteutus).

---

###LuokkaKaavio.

![Luokka kaavio](/dokumentaatio/budjetointisovellus.png)

---

###Sekvenssiaaviot

![Sekvenssi Kaavio1](/dokumentaatio/sekvenssikaavio1.png)

---

![Sekvenssi Kaavio2](/dokumentaatio/sekvenssikaavio2.png)

---

##RakenneKuvaus

Ohjelman suoritus alkaa Main-luokasta jossa luodaan LogiikkaUI-luokka joka toimii ohjelman logiikan ja ui:n erottajana. LogiikkaUI luo Budjetti- ja UIKehys-luokan. Budjetti-luokka on varsinainen logiikka luokka jonka sisällä tapahtuu käyttäjän antamien budjetti merkintöjen käsittely ja säilytys. Budjetti-luokassa luodaan TiedostonKasittelija joka hoitaa tiedostoihin liittyvät tapahtumat(muunmuassa Scanner- ja File-tapahtumat). TiedostonKasittelijassa luodaan Salaus-luokka, joka hoitaa tiedoston salauksen purkamisen ja salaamisen. Budjetti luokka annetaan parametrinä UIKehyskselle. UIKehys sisältää käyttöliittymän ja sielä luodaan myös luokka VirheIlmoitus, jonka tehtävänä on ilmoittaa pop-upilla käyttäjälle virheen sattuessa. 
