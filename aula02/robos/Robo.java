package robos;

import area.Area;

public abstract class Robo {
    private int posX, posY;
    private Area area;
    
    public Robo(int posX, int posY, Area area) {
        this.area = area;
        if(isPosYValid(posY) ){
            this.posY = posY;
        }
        this.posX = posX;
        
        
    }

    public boolean isPosYValid(int posY){
        return posY >= 0 && posY <= area.getMaxY();
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        if(isPosYValid(posY) ){
            this.posY = posY;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Area getArea() {
        return area;
    }

    public abstract boolean moverNorte(int deslocamento);
    public abstract boolean moverSul(int deslocamento);
    public abstract boolean moverOeste(int deslocamento);
    public abstract boolean moverLeste(int deslocamento);
    
}
