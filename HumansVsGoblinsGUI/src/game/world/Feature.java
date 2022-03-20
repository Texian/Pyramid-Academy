package game.world;

import framework.resources.Resources;
import framework.utils.FunctionalInterface;
import framework.utils.MathHelper;
import game.entities.Biped;

import java.awt.*;
import java.util.ArrayList;

public class Feature extends Tile {
    private static final long serialVersionUID = 1L;
    private FunctionalInterface action;

    public Feature(byte id, FunctionalInterface action) {
        super(id, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7), false);
        this.action = action;
    }

    public Feature(Feature copy) {
        this(copy.getId(), copy.action);
    }

    @Override
    public boolean intersects(Rectangle rect) {
        if (super.intersects(rect)) {
            this.action.action();
            return true;
        }
        return false;
    }

    public void render(Graphics g){
        g.drawImage(Resources.TEXTURES.get(super.getID()), super.x, super.y, super.width, super.height, null);
    }
}
