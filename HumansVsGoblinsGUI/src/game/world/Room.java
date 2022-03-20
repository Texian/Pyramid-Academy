package game.world;

import framework.resources.Resources;
import game.entities.Gob;
import game.entities.Hume;
import game.world.generator.RoomData;

import java.awt.Graphics;
import java.util.ArrayList;

public class Room {
    private RoomData data;
    private ArrayList<Feature> feature;
    private ArrayList<Gob> gob;

    public Room(RoomData data) {
        this.data = data;
        this.feature = new ArrayList<>();
        this.gob = new ArrayList<>();
    }

    public RoomData getData() {
        return data;
    }

    public void placeFeature(Feature feature) {
        if (data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.FLOOR ||
                data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.TREE ||
                data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.TILE)
            this.feature.add(feature);
        else
            this.placeFeature(new Feature(feature));
    }

    public void featureInteraction(Hume player) {
        for(int i = 0; i < this.feature.size(); i++) {
            if (this.feature.get(i).intersects(player))
                this.feature.remove(i);
        }
    }

    public ArrayList<Gob> getGob() {
        return gob;
    }

    public void addGob(Gob gob){
        if (data.getTileAt(gob.x / Tile.SIZE, gob.y / Tile.SIZE).getID() == Resources.FLOOR) {
            this.gob.add(gob);
        } else {
            this.addGob(new Gob(gob));
        }
    }

    public void render(Graphics g) {
        this.data.render(g);
        for(Feature feature : feature) {
            feature.render(g);
        }
        for(Gob gob : gob) {
            gob.render(g);
        }
    }
}
