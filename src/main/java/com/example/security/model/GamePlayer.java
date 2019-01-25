package com.example.security.model;

/**
 * @author DELL
 * @since 1.0.0
 */
public class GamePlayer implements IGamePlayer {

    private String name = "";

    private GamePlayerPoxy gamePlayerPoxy = null;


    public GamePlayer(String name) throws Exception {
         this.name = name;
    }
    @Override
    public void killBoss() {
        if (gamePlayerPoxy == null) {
            System.out.println("无权限打怪");
        } else {
            System.out.println("打怪");
        }
    }

    @Override
    public void upgrade() {
        if (gamePlayerPoxy == null) {
            System.out.println("无权限升级");
        } else {
            System.out.println("升级");
        }
    }

    @Override
    public IGamePlayer getPoxy() {
        gamePlayerPoxy = new GamePlayerPoxy(this);
        return gamePlayerPoxy;
    }
}