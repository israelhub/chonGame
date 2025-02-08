package chon.group.game.domain.environment;

import java.util.ArrayList;
import java.util.List;
// Adicionado biblioteca Iterator (Dizer o que é)
import java.util.Iterator;

import chon.group.game.domain.agent.Agent;
// Importa Falling Item
import chon.group.game.domain.item.FallingItem;
import javafx.scene.image.Image;

/**
 * Represents the game environment, including properties such as dimensions,
 * position,
 * background image, agents, and the protagonist.
 * The environment also controls rendering, restricts the environment area,
 * prints an agent's coordinates, and detects collisions between the protagonist
 * and agents.
 */
public class Environment {

    /** The X (horizontal) position of the environment. */
    private int posX;

    /** The Y (vertical) position of the environment. */
    private int posY;

    /** The width of the environment. */
    private int width;

    /** The height of the environment. */
    private int height;

    /** The background image of the environment. */
    private Image image;

    /** The background image of the pause. */
    private Image pauseImage;

    /** The protagonist instance. */
    private Agent protagonist;

    /** List of agents present in the environment. */
    private List<Agent> agents = new ArrayList<Agent>();

    private List<FallingItem> fallingItems = new ArrayList<>();

    private int score;

    private Image scoreImage; // Imagem do painel de score

    private int scorePanelX ; // Posição X do painel

    private int scorePanelY; // Posição Y do painel

    private int scorePanelWidth; // Largura do painel
    
    private int scorePanelHeight; // Altura do painel

    public Image getScoreImage() {
        return scoreImage;
    }

    public void setScoreImage(String pathImage) {
        this.scoreImage = new Image(getClass().getResource(pathImage).toExternalForm());
    }

    public int getScorePanelX() { return scorePanelX; }
    public int getScorePanelY() { return scorePanelY; }
    public int getScorePanelWidth() { return scorePanelWidth; }
    public int getScorePanelHeight() { return scorePanelHeight; }
    
    /**
     * Default constructor to create an empty environment.
     */
    public Environment() {
        this.fallingItems = new ArrayList<>();
    }

    /**
     * Constructor to initialize the environment with dimensions, position, and a
     * background image.
     *
     * @param posX      the initial X (horizontal) position of the environment
     * @param posY      the initial Y (vertical) position of the environment
     * @param width     the width of the environment
     * @param height    the height of the environment
     * @param pathImage the path to the background image
     */
    public Environment(int posX, int posY, int width, int height, String pathImage) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.setImage(pathImage);
        this.agents = new ArrayList<Agent>();
        this.fallingItems = new ArrayList<>(); // Inicializar a lista
    }

    /**
     * Constructor to initialize the environment with dimensions, position, a
     * background image, and a list of agents.
     *
     * @param posX      the initial X (horizontal) position of the environment
     * @param posY      the initial Y (vertical) position of the environment
     * @param width     the width of the environment
     * @param height    the height of the environment
     * @param pathImage the path to the background image
     * @param agents    the list of agents in the environment
     */
    public Environment(int posX, int posY, int width, int height, String pathImage, ArrayList<Agent> agents) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.setImage(pathImage);
        this.setAgents(agents);
    }

    /**
     * Gets the X (horizontal) position of the environment.
     *
     * @return the X position of the environment
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Sets the X (horizontal) position of the environment.
     *
     * @param posX the new X position of the environment
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Gets the Y (vertical) position of the environment.
     *
     * @return the Y position of the environment
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets the Y (vertical) position of the environment.
     *
     * @param posY the new Y position of the environment
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Gets the width of the environment.
     *
     * @return the width of the environment
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the environment.
     *
     * @param width the new width of the environment
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the height of the environment.
     *
     * @return the height of the environment
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the environment.
     *
     * @param height the new height of the environment
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the background image of the environment.
     *
     * @return the background image of the environment
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the background image of the environment.
     *
     * @param pathImage the path to the new background image
     */
    public void setImage(String pathImage) {
        this.image = new Image(getClass().getResource(pathImage).toExternalForm());
    }

    public Image getPauseImage() {
        return pauseImage;
    }

    public void setPauseImage(String pathImage) {
        this.pauseImage = new Image(getClass().getResource(pathImage).toExternalForm());
    }

    /**
     * Gets the protagonist of the environment.
     *
     * @return the protagonist of the environment
     */
    public Agent getProtagonist() {
        return protagonist;
    }

    /**
     * Sets the protagonist of the environment.
     *
     * @param protagonist the new protagonist of the environment
     */
    public void setProtagonist(Agent protagonist) {
        this.protagonist = protagonist;
    }

    /**
     * Gets the list of agents present in the environment.
     *
     * @return the list of agents
     */
    public List<Agent> getAgents() {
        return agents;
    }

    /**
     * Sets the list of agents present in the environment.
     *
     * @param agents the new list of agents
     */
    public void setAgents(ArrayList<Agent> agents) {
        this.agents = agents;
    }

    public List<FallingItem> getFallingItems() {
        return fallingItems;
    }

    public void setFallingItems(List<FallingItem> fallingItems) {
        this.fallingItems = fallingItems;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Checks if the protagonist is within the environment's boundaries and adjusts
     * its position if necessary.
     */
    public void checkBorders() {
        if (this.protagonist.getPosX() < 0) {
            this.protagonist.setPosX(0);
        } else if ((this.protagonist.getPosX() + this.protagonist.getWidth()) > this.width) {
            this.protagonist.setPosX(this.width - protagonist.getWidth());
        } else if (this.protagonist.getPosY() < 0) {
            this.protagonist.setPosY(0);
        } else if ((this.protagonist.getPosY() + this.protagonist.getHeight()) > this.height) {
            this.protagonist.setPosY(this.height - this.protagonist.getHeight());
        }
    }

    /**
     * Detects collisions between the protagonist and other agents in the
     * environment.
     */
    public void detectCollision() {
        for (Agent agent : this.agents) {
            if (protagonist != null && intersect(this.protagonist, agent)) {
                System.out.println("Collision detected with agent: " + agent);
                /* The protagonist takes damage when colliding with an agent. */
                protagonist.takeDamage(10);
            }
        }
    }

    /**
     * Checks if two agents collide with each other based on their positions and
     * dimensions.
     *
     * This method uses the coordinates and dimensions of both agents to determine
     * if their areas overlap. The collision is calculated by comparing the edges
     * of the image represented by each agent.
     *
     * @param a the first agent
     * @param b the second agent
     * @return true if the agents collide, otherwise false
     */

    private boolean intersect(Agent a, Agent b) {
        // Returns true if there is a collision between two agents
        return a.getPosX() < b.getPosX() + b.getWidth() &&
                a.getPosX() + a.getWidth() > b.getPosX() &&
                a.getPosY() < b.getPosY() + b.getHeight() &&
                a.getPosY() + a.getHeight() > b.getPosY();
    }

    public void cleanupItems() {
        int groundOffset = 50; // ajuste esse valor conforme necessário
        fallingItems.removeIf(item -> 
            item.getPosY() > (height - groundOffset) || 
            (item.getPosY() + item.getHeight() > (height - groundOffset))
        );
    }

    // Detecta a colisão entre o protagonista e os itens que caem do céu
    public void detectFallingItemCollision() {
        // Usar um iterator para remover itens de forma mais eficiente
        Iterator<FallingItem> iterator = fallingItems.iterator();
        while (iterator.hasNext()) {
            FallingItem item = iterator.next();
            if (intersectWithItem(protagonist, item)) {
                if (item.isBomb()) {
                    protagonist.takeDamage(1000);
                } else {
                    score++;
                }
                iterator.remove();
                break; // Sai do loop após primeira colisão
            }
        }
        // Limpa itens fora da tela
        cleanupItems();
    }

    // Verifica se teve interseção entre o protagonista e os itens que caem do ceu
    private boolean intersectWithItem(Agent agent, FallingItem item) {
        return agent.getPosX() < item.getPosX() + item.getWidth() &&
               agent.getPosX() + agent.getWidth() > item.getPosX() &&
               agent.getPosY() < item.getPosY() + item.getHeight() &&
               agent.getPosY() + agent.getHeight() > item.getPosY();
    }

}