package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Paint {

    public static void renderTriangle_Strip(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, Vector2 pos4, Vector2 pos5, boolean filled){
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
    public static void renderCircle(GL2 gl, Vector2 pos, double radius, boolean filled){

        double theta;
        double step = 1;
        if(filled) {
            gl.glBegin(GL.GL_TRIANGLE_FAN);
            for(double a=0; a<360; a += step){
                theta = 2 * Math.PI * a / 180;
                gl.glColor3d(1, 0.8, 0);
                gl.glVertex3d(radius * Math.cos(theta), radius * Math.sin(theta), 0);
            }
            gl.glEnd();
        } else {
            gl.glLineWidth(10);
            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glColor3d(0, 1, 1);

            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x + Math.sin(Math.PI/512*i)*radius, pos.y - Math.cos(Math.PI/512*i)*radius);

            }
            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x + Math.sin(Math.PI/512*(256 - i))*radius, pos.y + Math.cos(Math.PI/512*(256 - i))*radius);
            }
            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x - Math.sin(Math.PI/512*i)*radius, pos.y + Math.cos(Math.PI/512*i)*radius);
            }

            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x - Math.sin(Math.PI/512*(256 - i))*radius, pos.y - Math.cos(Math.PI/512*(256 - i))*radius);
            }


            gl.glEnd();
        }

    }
}
