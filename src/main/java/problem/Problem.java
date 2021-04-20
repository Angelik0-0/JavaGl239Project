package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "На плоскости задано два множества параллельных прямоугольников.\n" +
            "Требуется найти пересечение множеств.";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-1 Смолинской Алисы";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Quad> quads;
    private ArrayList<Quad> resultQuads;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        quads = new ArrayList<>();
        resultQuads = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param setVal номер множества
     */
    public void addPoint(double x1, double y1, double x2, double y2, int setVal) {
        Quad quad = new Quad(new Vector2(x1, y1), new Vector2(x2, y2), setVal);
        quads.add(quad);
    }


    /**
     * Решить задачу
     */

    public void solve2() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
                        p.isSolution = true;
                        p2.isSolution = true;
                    }
                }
            }
        }
    }

    public void solve() {
        // перебираем пары прямоугольников
        for (Quad q : quads) {
            for (Quad p : quads) {
                if (q != p && q.setNumber != p.setNumber) {
                    if((q.c.x < p.a.x || p.c.x < q.a.x) || (q.c.y < p.a.y || p.c.y < q.a.y)){
                        int k=0;
                        k++;
                    } else {
                        double x1=10, x2=10, y1=10, y2=10;
                        if(q.a.x <= p.a.x && q.c.x <= p.c.x){
                            if(q.a.y <= p.a.y && q.c.y <= p.c.y) {x1 = p.a.x; y1 = p.a.y; x2 = q.c.x ; y2 = q.c.y;}
                            else if(q.a.y <= p.a.y && q.c.y >= p.c.y) {x1 = p.a.x; y1 = p.a.y; x2 = q.c.x; y2 = p.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y <= p.c.y) {x1 = p.a.x; y1 = q.a.y; x2 = q.c.x; y2 = q.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y >= p.c.y) {x1 = p.a.x; y1 = q.a.y; x2 = q.c.x; y2 = p.c.y;}
                        } else if(q.a.x <= p.a.x && q.c.x >= p.c.x){
                            if(q.a.y <= p.a.y && q.c.y <= p.c.y) {x1 = p.a.x; y1 = p.a.y; x2 = p.c.x; y2 = q.c.y;}
                            else if(q.a.y <= p.a.y && q.c.y >= p.c.y) {x1 = p.a.x; y1 = p.a.y; x2 = p.c.x; y2 = p.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y <= p.c.y) {x1 = p.a.x; y1 = q.a.y; x2 = p.c.x; y2 = q.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y >= p.c.y) {x1 = p.a.x; y1 = q.a.y; x2 = p.c.x; y2 = p.c.y;}
                        } else if(q.a.x >= p.a.x && q.c.x <= p.c.x){
                            if(q.a.y <= p.a.y && q.c.y <= p.c.y) {x1 = q.a.x; y1 = p.a.y; x2 = q.c.x; y2 = q.c.y;}
                            else if(q.a.y <= p.a.y && q.c.y >= p.c.y) {x1 = q.a.x; y1 = p.a.y; x2 = q.c.x; y2 = p.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y <= p.c.y) {x1 = q.a.x; y1 = q.a.y; x2 = q.c.x; y2 = q.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y >= p.c.y) {x1 = q.a.x; y1 = q.a.y; x2 = q.c.x; y2 = p.c.y;}
                        }else if(q.a.x >= p.a.x && q.c.x >= p.c.x){
                            if(q.a.y <= p.a.y && q.c.y <= p.c.y) {x1 = q.a.x; y1 = p.a.y; x2 = p.c.x; y2 = q.c.y;}
                            else if(q.a.y <= p.a.y && q.c.y >= p.c.y) {x1 = q.a.x; y1 = p.a.y; x2 = p.c.x; y2 = p.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y <= p.c.y) {x1 = q.a.x; y1 = q.a.y; x2 = p.c.x; y2 = q.c.y;}
                            else if(q.a.y >= p.a.y && q.c.y >= p.c.y) {x1 = q.a.x; y1 = q.a.y; x2 = p.c.x; y2 = p.c.y;}
                        }
                        Quad quad = new Quad(new Vector2(x1, y1), new Vector2(x2, y2), 3);
                        resultQuads.add(quad);
                    }
                }
            }
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        quads.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Quad quad = new Quad(new Vector2(x1, y1), new Vector2(x2, y2), setVal);
                quads.add(quad);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Quad quad : quads) {
                out.printf("%.2f %.2f %.2f %.2f %d\n", quad.a.x, quad.a.y, quad.c.x, quad.c.y, quad.setNumber);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
//            Point p = Point.getRandomPoint();
//            points.add(p);
            Quad q = Quad.getRandomQuad();
            quads.add(q);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        quads.clear();
        resultQuads.clear();
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
//        for (Point point : points) {
//           point.render(gl);
//      }
        for (Quad quad : quads) {
            quad.render(gl);
        }
        for (Quad quad : resultQuads) {
            quad.render(gl);
        }


//        for (int i = 0; i < 20; i++) {
//            Figures.renderPoint(gl,new Vector2(Math.random()*2-1,Math.random()*2-1),5);
//        }


        //Figures.renderPoint(gl,new Vector2(0,0),3);
        //Figures.renderPoint(gl,new Vector2(0.5,0.7),3);

        //Figures.renderLine(gl,new Vector2(-1,0), new Vector2(1,0) ,4);

        //Figures.renderLine_Strip(gl,new Vector2(0.9,0.1), new Vector2(1,0) , new Vector2(0.9,-0.1), 5);

        //Figures.renderTriangle(gl,new Vector2(0.9,0.1), new Vector2(1,0) , new Vector2(0.9,-0.1), true);
        // Figures.renderTriangle(gl,new Vector2(-0.9,0.1), new Vector2(-1,0) , new Vector2(-0.9,-0.1), true);

        //  Figures.renderQuads(gl,new Vector2(-0.2,0), new Vector2(-0.1,-0.4) , new Vector2(0.4,0.4), new Vector2(0,-0.5), true);
        //Figures.renderTriangle_Strip(gl,new Vector2(-0.9,0.1), new Vector2(-1,0) , new Vector2(-0.9,-0.1), new Vector2(0.5,0.5) , new Vector2(-0.9,-0.1), true);
//
//
//        Quad quad = new Quad(new Vector2(0.5, 0.6), new Vector2(0,0),1);
//        quad.render(gl);
//
//        Quad quad2 = new Quad(new Vector2(0.1, 0.3), new Vector2(-0.1,-0.7),2);
//        quad2.render(gl);

        // Figures.renderCircle(gl,new Vector2(0,0), 0.5,false);


    }
}
