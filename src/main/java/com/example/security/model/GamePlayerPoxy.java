package com.example.security.model;

/**
 * @author DELL
 * @since 1.0.0
 */
public class GamePlayerPoxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    public GamePlayerPoxy(IGamePlayer iGamePlayer) {
        gamePlayer = iGamePlayer;
    }
    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }

    @Override
    public IGamePlayer getPoxy() {
        return this;
    }
}