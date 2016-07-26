package jp.techacademy.yutaro.honda.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;


public class Enemy extends GameObject {

    public static final float ENEMY_WIDTH = 0.8f;
    public static final float ENEMY_HEIGHT = 0.8f;

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
    }
}