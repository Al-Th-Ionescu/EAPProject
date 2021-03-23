# EAPProject - Descriere

Tema proiectului este o gradina zoologica, care accepta vizitatori.

Fiecare vizitator trebuie sa aiba un bilet, dar depinzand de varsta 
si statutul fiecarui vizitator, se pot aplica reduceri la pretul de baza al biletului.
Clasa vizitator este abstracta si prezinta atributele nume, prenume, vasta si bilet.
Din clasa vizitator deriva clasele Copil, Student si Adult.
Clasele Copil si Student vor beneficia de o reducere, in timp ce un Adult 
plateste pretul intreg.
Am folosit functie statice pentru a numara cate bilete sunt cumparate (egale cu numarul 
vizitatorilor) de fiecare fel, si respectiv pentru a gasi suma totala de bani incasati (ca incasari
totale, respectiv separate pentru fiecare tip de bilet).
Am adaugat interfata animal_behavior cu metodele doarme(), mananca(), se_inmulteste().
Aceasta interfata este implementata in clasa abstracta Animal. 
Clasa Animal, mai departe, se imparte in clasele Carnivore si Erbivore care o mostenesc.
La fel, mai departe, Leu mosteneste clasa Carnivore si Zebra mosteneste clasa Erbivore.
Am facut Override la functiile mostenite, adaugand diferite functionalitati.
Functia se_inmulteste() se apeleaza doar pe vectorii de animale, si functioneaza doar
daca exista 2 sau mai multe animale de acelasi fel ( >=2 lei sau >=2 zebre). Daca totusi
vectorul ramane fara spatiu, se va afisa mesajul ca "Nu este spatiu suficient in gradina zoologica",
deoarece vectorul de animale va avea alocat ca spatiu numarul maxim de animale care pot trai in
incinta gradinii zoologice.
Numarul animalelor (lei, zebre, erbivore, carnivore, totale) se pot afisa prin intermediul unor functii
statice.