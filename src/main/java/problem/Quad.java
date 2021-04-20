package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Quad {
    /**
     * константа множества 1
     */
    public static final int SET_1 = 0;
    /**
     * константа множества 2
     */
    public static final int SET_2 = 1;
    /**
     * номер множества
     */
    int setNumber;
    Vector2 a;
    Vector2 b;
    Vector2 c;
    Vector2 d;

    Quad(Vector2 a, Vector2 c, int setNumber) {
        if(a.x> c.x){
            double k = a.x;
            a.x = c.x;
            c.x = k;
        }
        if(a.y> c.y){
            double k = a.y;
            a.y = c.y;
            c.y = k;
        }
        this.a = a;
        this.b = new Vector2(c.x, a.y);
        this.c = c;
        this.d = new Vector2(a.x, c.y);
        this.setNumber = setNumber;
    }

    public void render(GL2 gl) {
        if(setNumber == 3){
            gl.glColor3d(0, 1, 0);
            Figures.renderQuads(gl, a, b, c, d, true);
        } else if(setNumber == SET_1){
            gl.glColor3d(1, 0, 1);
            Figures.renderQuads(gl, a, b, c, d, false);
        } else if(setNumber == SET_2){
            gl.glColor3d(1, 1, 0);
            Figures.renderQuads(gl, a, b, c, d, false);
        }

    }

    /**
     * Получить случайную точку
     *
     * @return
     */
    public static Quad getRandomQuad() {
        Random r = new Random();
        double x1 = r.nextDouble()*2-1;
        double x2 = r.nextDouble()*2-1;
        double y1 = r.nextDouble()*2-1;
        double y2 = r.nextDouble()*2-1;
        int nSetVal = r.nextInt(2);
        return new Quad(new Vector2(x1, y1), new Vector2(x2, y2), nSetVal);
    }
}
