package com.github.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/17 17:51
 * @Version 1.0
 */
public class MagicCard {
    public static void main(String[] args) {
        List<Integer> cards = createCards();
        magicCard(cards);
        for (Integer card:
             cards) {
            System.out.print(card + "\t");
        }
    }

    private static void magicCard(List<Integer> cards){
        boolean show = true;
        int cardNum = 1;
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) == 0 && show){
                cards.set(i,cardNum);
                count++;
                show = false;
            }else if (cards.get(i) == 0){
                show = true;
                cardNum++;
            }
            if (i == cards.size() - 1){
                i = 0;
            }
            if (count == 13){
                break;
            }
        }
    }

    private static List<Integer> createCards() {
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            cards.add(0);
        }
        return cards;
    }

}
