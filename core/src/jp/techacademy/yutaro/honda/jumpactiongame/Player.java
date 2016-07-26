package jp.techacademy.yutaro.honda.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

public class Player extends GameObject{

    public static final float PLAYER_WIDTH = 1.0f;
    public static final float PLAYER_HEIGHT = 1.0f;

    public static final int PLAYER_STATE_JUMP = 0;
    public static final int PLAYER_STATE_FALL = 1;

    public static final float PLAYER_JUMP_VELOCITY = 11.0f;
    public static final float PLAYER_MOVE_VELOCITY = 20.0f;

    int mState;

    public Player(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        mState = PLAYER_STATE_FALL;
    }

    public void update (float delta, float accelX) {

        velocity.add(0, GameScreen.GRAVITY * delta);
        velocity.x = -accelX / 10 * PLAYER_MOVE_VELOCITY;
        setPosition(getX() + velocity.x * delta, getY() + velocity.y * delta);

        if (velocity.y > 0) {
            if (mState != PLAYER_STATE_JUMP) {
                mState = PLAYER_STATE_JUMP;
            }
        }

        if (velocity.y < 0) {
            if (mState != PLAYER_STATE_FALL) {
                mState = PLAYER_STATE_FALL;
            }
        }

        if (getX() + PLAYER_WIDTH / 2 < 0) {
            setX(GameScreen.WORLD_WIDTH - PLAYER_WIDTH / 2);
        } else if (getX() + PLAYER_WIDTH / 2 > GameScreen.WORLD_WIDTH) {
            setX(0);
        }
    }

    public void hitStep () {
        velocity.y = PLAYER_JUMP_VELOCITY;
        mState = PLAYER_STATE_JUMP;
    }
}
