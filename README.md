# Relazione One To Many
Ogni `elemento` di una tabella può essere collegato a **più** elementi di un'altra tabella, ma gli `elementi` di quest'altra tabella possono essere collegati a un **solo** elemento della prima.

## Steps
1. Creare l'entità
    - [Entità 1](src/main/java/com/generation/relazionionetomany/entity/User.java)
    - [Entità 2](src/main/java/com/generation/relazionionetomany/entity/Photo.java)
2. Collegare le tabelle(creare la relazione)
    - [Many to one(tabella che ha la foreign key)](src/main/java/com/generation/relazionionetomany/entity/Photo.java)
    - [One to many](src/main/java/com/generation/relazionionetomany/entity/User.java)
    
