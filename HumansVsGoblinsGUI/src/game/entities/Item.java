package game.entities;

import java.util.Collection;
import java.util.Collections;

public class Item {
    String shield = "Shield";
    String dagger = "Dagger";
    String boots = "Boots";
    String elixir = "Elixir";

    String[] items = new String[10];
    int[] position = new int[2];

    Item(){}

    Item(String[] items, int[] position){
        this.items = items;
    }

    public void setPos(int[] position) {
        this.position = position;
    }

    public String[] itemArray(){
        String[] items;
        items =Collections.nCopies(5, dagger).toArray(new String[5]);
        items = Collections.nCopies(1, shield).toArray(new String[1]);
        items = Collections.nCopies(3, boots).toArray(new String[3]);
        items = Collections.nCopies(1, elixir).toArray(new String[1]);
        return items;
    }
}
