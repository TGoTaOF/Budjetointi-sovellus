##Testausdokumentti

**Luokkaa VirheIlmoitus.java varten.**

Luokka VirheIlmoitus on luokka joka avaa virheilmoituksen pop-uppina virheen sattuessa. Luokkaa kutsutaan vain virheensattuessa(Poikkeuksena metodi: "virheellinenSyote()" joka tarkistaa syötteen ja ilmoittaa vain jos syöte on epäkelpo. Tälle olemassa 1 JUni testi). Testasin luokkaa ajamalla ohjelmaa monta kertaa ja yrittämällä luoda tilanteita jossa jotain on mennyt vikaan tai ollut puutteellista(esim. käyttäjän syöte väärälainen).

###VirheImoitus-luokan metodien testaus:

**.virheellinenSyote()**: Annoin epäkelvon syötteen ja tyhjän syötteen. Molemmilla kerroilla VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin. JUnit olemassa oikean syötteen antamisesta.

**.virheSalasanaaKysyttaessa()**: Annoin väärän salasanan. VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.syoteEiLuku()**: Annoin luvun sijaan kirjaimia. VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.uudenBudjetinLuominenEpaonnistui()**: Annoin budjetille nimeksi merkkijonon täynnä epäkelpoja merkkejä. VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.budjetinTallentaminenEpaonnistui()**: Asetin tallennus tiedoston kirjoitus kieltoon(eväsin oikeudet muokata tiedostoa komentoriviltä). VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.budjetinAvaaminenEpaonnistui()**: Yritin avata tiedoston joka ei ollut budjetti. VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.eiRiviaValittuna()**: Jätin rivin valitsematta. VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.tyhjaKentta()**: Jätin kentän tyhjäksi. VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.

**.merkinnanNimiJoKaytossa()**: Yritin lisätä merkinnän budjettiin kaksi kertaa. Toista lisätessä VirheIlmoitus luokka ilmoitti asiasta, niinkuin pitikin.
