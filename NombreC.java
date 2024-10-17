package org.yourorghere;
import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;



/**
 * Plano.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class NombreC implements GLEventListener, KeyListener{
public static double tx,ty,tz;
public static float rx,ry,rz;
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new NombreC());
        canvas.addKeyListener(new NombreC());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {                
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {        

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
      
        gl.setSwapInterval(1);

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { 
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        gl.glTranslatef(0.0f, 0.0f, -6.0f);
        glu.gluLookAt(5+tx, 1+ty, 0+tz, 5+tx, 1+ty, -3+tz, 0, 1, 0);       
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);
        
        gl.glBegin(GL.GL_QUADS);
        
            //frente superior
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 4.75f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 4.75f, -2.0f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 4.75f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 4.75f, -2.0f);
            //piso J A B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.0f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 0.0f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 0.0f, -20.0f); 
            //piso C J L G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -28.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.0f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.0f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0.0f, -28.0f); 
            //piso H E F L
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 0f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 0.0f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.0f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0.0f, -20.0f);
            
            //piso abajo
            
            //piso J A B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 0.5f, -20.0f); 
            //piso C J L G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -28.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -28.0f); 
            //piso H E F L
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -20.0f);
            
            //laterales del piso
            
            // A B
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 0f, -2.0f);
            // B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(10.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(10.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 0f, -20.0f);
            // D H
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(10.0f, 0f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(10.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.0f, 0f, -20.0f);
            // H E
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 0f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 0.5f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.0f, 0f, -2.0f);
            // E F
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0f, -2.0f);
            // F G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(32.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(32.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0f, -28.0f);
            // C G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -28.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -28.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 0.5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0f, -28.0f);
            // A C
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 0.5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(2.0f, 0.5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(2.0f, 0f, -28.0f);
            
            //paredes laterales
            
            // B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(10.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(10.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 0f, -20.0f);
            // D H
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(10.0f, 0f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(10.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.0f, 0f, -20.0f);
            // H E
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 0f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.0f, 0f, -2.0f);
            // F G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(32.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(32.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0f, -28.0f);
            // C G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -28.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -28.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0f, -28.0f);
            // A C
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(2.0f, 5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(2.0f, 0f, -28.0f);
            
            //paredes adentro
            
            // B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(9.75f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(9.75f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(9.75f, 5f, -20.25f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(9.75f, 0f, -20.25f);
            // D H
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(9.75f, 0f, -20.25f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(9.75f, 5f, -20.25f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.25f, 5f, -20.25f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.25f, 0f, -20.25f);
            // H E
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.25f, 0f, -20.25f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.25f, 5f, -20.25f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.25f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.25f, 0f, -2.0f);
            // F G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(31.75f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(31.75f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(31.75f, 5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(31.75f, 0f, -28.0f);
            // C G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -27.75f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -27.75f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 5f, -27.75f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 0f, -27.75f);
            // A C
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.25f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.25f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(2.25f, 5f, -28.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(2.25f, 0f, -28.0f);
            
            // frontales
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(2.25f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(2.25f, 0f, -2.0f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(9.75f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(9.75f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10f, 0f, -2.0f);
            // 
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(24.25f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(24.25f, 0f, -2.0f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(31.75f, 0f, -2.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(31.75f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32f, 0f, -2.0f);
            
            //techo superior
            //piso J A B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 5f, -20.0f); 
            //piso C J L G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 5f, -28.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 5f, -28.0f); 
            //piso H E F L
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 5f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 5f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 5f, -20.0f);
            
            //techo inferior
            
            //piso J A B D
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 4.75f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 4.75f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10.0f, 4.75f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10.0f, 4.75f, -20.0f); 
            //piso C J L G
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2.0f, 4.75f, -28.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2.0f, 4.75f, -20.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 4.75f, -20.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 4.75f, -28.0f); 
            //piso H E F L
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(24.0f, 4.75f, -20.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(24.0f, 4.75f, -2.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(32.0f, 4.75f, -2.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(32.0f, 4.75f, -20.0f);
            
            //laberinto
            
            //PARED 1
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(6f, 0.5f, -6.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(6f, 4.75f, -6.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10f, 4.75f, -6.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10f, 0.5f, -6.0f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(6f, 0.5f, -5.75f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(6f, 4.75f, -5.75f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10f, 4.75f, -5.75f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10f, 0.5f, -5.75f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(6f, 0.5f, -5.75f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(6f, 4.75f, -5.75f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(6f, 4.75f, -6f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(6f, 0.5f, -6f);
            
            //PARED 2
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2f, 0.5f, -10.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2f, 4.75f, -10.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(6f, 4.75f, -10.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(6f, 0.5f, -10.0f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(2f, 0.5f, -10.25f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(2f, 4.75f, -10.25f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(6f, 4.75f, -10.25f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(6f, 0.5f, -10.25f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(6f, 0.5f, -10f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(6f, 4.75f, -10f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(6f, 4.75f, -10.25f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(6f, 0.5f, -10.25f);
            
            //PARED 3
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(8f, 0.5f, -14.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(8f, 4.75f, -14.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10f, 4.75f, -14.0f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10f, 0.5f, -14.0f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(8f, 0.5f, -14.25f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(8f, 4.75f, -14.25f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(10f, 4.75f, -14.25f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(10f, 0.5f, -14.25f);
            //
            gl.glColor3f(1f, 0f, 0f);    
            gl.glVertex3f(8f, 0.5f, -14.0f);  
            gl.glColor3f(1f, 1f, 0f);    
            gl.glVertex3f(8f, 4.75f, -14.0f);  
            gl.glColor3f(1f, 0f, 1f);    
            gl.glVertex3f(8f, 4.75f, -14.25f);  
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex3f(8f, 0.5f, -14.25f);
            
        gl.glEnd(); 
        
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }


    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            tx -= .1;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            tx += .1;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            ty -= .1;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ty += .1;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {//up
            tz -= .1;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//down
            tz += .1;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            rx -= 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_N) {
            rx += 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {//o
            ry -= 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {//i
            ry += 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            rz -= 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            rz += 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            tx = ty = tz= 0;
            rx = ry = rz= 0;
        }

    }
        
        private void drawSphere(GL gl, float radius, int slices, int stacks) {
        GLU glu = new GLU();
        GLUquadric quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
        glu.gluQuadricNormals(quadric, GLU.GLU_SMOOTH);
        glu.gluQuadricOrientation(quadric, GLU.GLU_OUTSIDE);
        glu.gluSphere(quadric, radius, slices, stacks);
        glu.gluDeleteQuadric(quadric);
        }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}