package com.example.fx.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Card {
    private int Num_card;
    private int nbrTaureau;
    private String pictureURL;


    public static List<Card> cartes = new ArrayList<>();
    public static List<Card> AllcarteV = new ArrayList<>();
    public static List<Card> Allcarte = new ArrayList<>();

    public Card(int n, int num,String pictureURL) {
        Num_card = n;
        nbrTaureau = num;
        this.pictureURL = pictureURL;

    }

    public static int taureau(int Num_card, int i, String pictureURL) {
        if (Num_card % 10 == 5) {
            cartes.get(i - 1).setNbrTaureau(cartes.get(i - 1).getNbrTaureau() + 2);
        }
        if (Num_card % 10 == 0) {
            cartes.get(i - 1).setNbrTaureau(cartes.get(i - 1).getNbrTaureau() + 3);
        }
        if (Num_card % 11 == 0) {
            cartes.get(i - 1).setNbrTaureau(cartes.get(i - 1).getNbrTaureau() + 5);
        }
        if (Num_card % 10 != 5 && Num_card % 10 != 0 && Num_card % 11 != 0) {
            cartes.get(i - 1).setNbrTaureau(cartes.get(i - 1).getNbrTaureau() + 1);
        }
        return cartes.get(i - 1).getNbrTaureau();
    }

    public static List<Card> cart() {
        // Initialiser les cartes avec les valeurs de 1 à 104
        for (int i = 1; i <= 104; i++) {
            Card card = new Card(0, 0);
            cartes.add(card);
            Allcarte.add(card);
            cartes.get(i - 1).setNum_card(i);
            Allcarte.get(i - 1).setNum_card(i);
            taureau(cartes.get(i - 1).getNum_card(), i);
            taureau(Allcarte.get(i - 1).getNum_card(), i);
        }

        return cartes;
    }

    // Method to get the image path for the card image.
    public String getImagePath(Card card) {
        // Returns a constructed string that presumably points to where the card's image is stored.
        // The card's number is used as part of the file path.
        return "file:src/main/resources/cards/" + card.getNum_card() +".png";
    }

}