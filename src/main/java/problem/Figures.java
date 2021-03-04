package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Figures {

    public static void renderPoint(GL2 gl, Vector2 pos, float size){
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3d(1,1,1);
        gl.glVertex2d(pos.x,pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 pos1, Vector2 pos2, float size){
        gl.glLineWidth(size);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3d(1,1,0);
        gl.glVertex2d(pos1.x,pos1.y);
        gl.glColor3d(1,0,1);
        gl.glVertex2d(pos2.x,pos2.y);
        gl.glEnd();
    }

    public static void renderLine_Strip(GL2 gl, Vector2 pos1,Vector2 pos2,Vector2 pos3, float size){
        gl.glLineWidth(size);
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3d(0,1,0);
        gl.glVertex2d(pos1.x,pos1.y);
        gl.glColor3d(1,0,0);
        gl.glVertex2d(pos2.x,pos2.y);
        gl.glColor3d(0,0,1);
        gl.glVertex2d(pos3.x,pos3.y);
        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, boolean filled) {
        if (filled) {
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3d(1, 1, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1, 0, 0);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0, 0, 1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glEnd();
        }
    }

    public static void renderTriangle_Strip(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, Vector2 pos4, Vector2 pos5,boolean filled){
        if (filled) {
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            gl.glColor3d(1, 1, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos5.x, pos5.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glColor3d(0,1,0);
            gl.glVertex2d(pos1.x,pos1.y);
            gl.glColor3d(1,0,0);
            gl.glVertex2d(pos2.x,pos2.y);
            gl.glColor3d(0,0,1);
            gl.glVertex2d(pos3.x,pos3.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos5.x, pos5.y);
            gl.glEnd();
        }
    }

    public static void renderQuads(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, Vector2 pos4, boolean filled){
        if (filled) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3d(1, 1, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(1, 1, 0);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glColor3d(1,0,1);
            gl.glVertex2d(pos1.x,pos1.y);
            gl.glColor3d(1,0,1);
            gl.glVertex2d(pos2.x,pos2.y);
            gl.glColor3d(1,0,1);
            gl.glVertex2d(pos3.x,pos3.y);
            gl.glColor3d(1, 0, 1);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glEnd();
        }
    }
}
