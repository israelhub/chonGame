package chon.group.game.drawer;

public interface EnvironmentDrawer {

    void clearEnvironment();

    void drawBackground();

    void drawAgents();

    void drawLifeBar();

    void drawStatusPanel();

    void drawPauseScreen();

    void drawGameOverScreen(); // New method added

    void drawScorePanel(); // New method added

}