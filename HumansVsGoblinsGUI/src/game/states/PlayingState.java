package game.states;

import framework.gamestates.GameState;
import framework.gamestates.GameStateManager;
import framework.resources.Resources;
import framework.utils.MathHelper;
import game.entities.Gob;
import game.entities.Hume;
import game.world.Feature;
import game.world.Tile;
import game.world.World;
import game.world.generator.LevelGenerator;
import game.world.generator.RoomData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayingState extends GameState {
    private LevelGenerator levelg;
    private World world;
    private Hume player;

    public PlayingState(GameStateManager gsm) {
        super(gsm);
        this.levelg = new LevelGenerator();
        this.player = new Hume();
        this.generateLevel();
    }

    @Override
    protected void loop() {
        this.player.move();
        this.world.changeRoom(player);
        this.collisions();
        this.world.getRoom().featureInteraction(player);
        this.player.regen();
        this.playerAttack();
    }

    @Override
    protected void render(Graphics g) {
        this.world.getRoom().render(g);
        this.player.render(g);

        g.drawImage(Resources.TEXTURES.get(Resources.ATTACK), this.player.getAttackBox().x, this.player.getAttackBox().y, this.player.getAttackBox().width, this.player.getAttackBox().height, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawImage(Resources.TEXTURES.get(Resources.HEALTH), 0, 0, Tile.SIZE*2/3, Tile.SIZE*2/3,null);
        g.drawString(this.player.getHP() + "/" +this.player.getHPMax(), Tile.SIZE*2/3+5, 20);
        g.drawImage(Resources.TEXTURES.get(Resources.ARMOR), 80, 0, Tile.SIZE*2/3, Tile.SIZE*2/3,null);
        g.drawString(this.player.getArmor()+"", Tile.SIZE*2/3+85, 20);
        g.drawImage(Resources.TEXTURES.get(Resources.WEAPON), 160, 0, Tile.SIZE*2/3, Tile.SIZE*2/3,null);
        g.drawString(this.player.getItem()+"", Tile.SIZE*2/3+165, 20);
    }

    @Override
    protected void keyPressed(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_W:
                this.player.setMovingUp(true);
                break;
            case KeyEvent.VK_S:
                this.player.setMovingDown(true);
                break;
            case KeyEvent.VK_A:
                this.player.setMovingLeft(true);
                break;
            case KeyEvent.VK_D:
                this.player.setMovingRight(true);
                break;
            case KeyEvent.VK_SPACE:
                this.player.attack(true);
        }
    }

    @Override
    protected void keyReleased(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_W:
                this.player.setMovingUp(false);
                break;
            case KeyEvent.VK_S:
                this.player.setMovingDown(false);
                break;
            case KeyEvent.VK_A:
                this.player.setMovingLeft(false);
                break;
            case KeyEvent.VK_D:
                this.player.setMovingRight(false);
                break;
            case KeyEvent.VK_SPACE:
                this.player.attack(false);
        }
    }

    private void generateLevel() {
        this.generator.reset();
        while(!this.generator.isFinished()) {
            this.generator.generate();
        }
        this.world = new World(this.generator.getRoomsData());

        this.world.getRandomRoom().placeFeature(new Taskbar.Feature(Resources.TREES, this::generateLevel));

        for(int i=0; i<12; i++) {
            this.world.getRandomRoom().placeFeature(new Feature(Resources.CHEST, this::randomLoot));
        }
        for(int i=0; i<=25; i++) {
            this.world.getRandomRoom().spawnGob(new Gob(Resources.GOB, 5, this.player));
        }
        this.spawnPlayer();
    }

    private void spawnPlayer() {
        if(this.world.getRoom(0,0).getData().getTileAt(player.x/Tile.SIZE, player.y/Tile.SIZE).getID() != Resources.FLOOR) {
            this.player.replaceRandomly();
            this.spawnPlayer();
        }
    }

    private void collisions() {
        RoomData roomIn = this.world.getRoom().getData();
        for (int i = 0; i < roomIn.getWidth(); i++) {
            for (int j = 0; j < roomIn.getHeight(); j++) {
                this.player.handleCollision(roomIn.getTileAt(i, j));
                for (Gob gob : this.world.getRoom().getGobs()) {
                    gob.handleCollision(roomIn.getTileAt(i, j));
                }
            }
        }
    }

    private void randomLoot() {
        switch (MathHelper.randomInt(3)) {
            case 0:
                this.player.heal(MathHelper.randomInt(3, 5));
                break;
            case 1:
                this.player.addArmor(MathHelper.randomInt(3, 7));
                break;
            case 2:
                this.player.addWeapon(MathHelper.randomInt(2, 5));
                break;
        }
    }
    private void playerAttack () {
        this.player.decreaseTime();
        for (int i = 0; i < this.world.getRoom().getGobs().size(); i++) {
            this.world.getRoom().getGobs().get(i).move();

            if (this.world.getRoom().getGobs().get(i).intersects(this.player)) {
                this.player.damage(5 - 5 * this.player.getArmor() / 100);
            }

            if (this.world.getRoom().getGobs().get(i).intersects(this.player.getAttackBox())) {
                this.world.getRoom().getGobs().get(i).damage(3, this.player.getFacing());
                if (this.world.getRoom().getGobs().get(i).getHP() <= 0) {
                    this.world.getRoom().getGobs().remove(i);
                }
            }
        }
    }
}

