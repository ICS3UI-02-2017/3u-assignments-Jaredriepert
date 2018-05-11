package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author riepj9547
 */
public class ShapeFace extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    Color skin = new Color(239, 206, 141);
    Color darkskin = new Color(219, 194, 144);
    Color brown = new Color(73, 52, 30);
    Color darkGrey = new Color(30, 39, 53);
    Color lightGrey = new Color(40, 52, 71);
    
    int lEyeBrowY = 265;
    int rEyeBrowY = 265;    
    int eyeBrowChange = 0;
    int rEyeX = 300;
    int rEyeY = 310;
    int lEyeY = 310;
    int lEyeX = 370;

    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public ShapeFace(){
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        
        
       
        //shoulder right
        g.translate(300, 415);
        g2d.rotate(Math.toRadians(-38));
        g.setColor(darkGrey);
	g.fillOval(-2, -2, 64, 104);
        g.setColor(lightGrey);
        g.fillOval(0, 0, 60, 100);
        g2d.rotate(Math.toRadians(38));
        g.translate(-300, -415);
        //arm right
        g.translate(347, 452);        
        g2d.rotate(Math.toRadians(-30));
        g.setColor(darkGrey);
        g.fillOval(-2, -2, 54, 114);
        g.setColor(lightGrey);
        g.fillOval(0, 0, 50, 110);
        g2d.rotate(Math.toRadians(30));
        g.translate(-347, -452);
        //body
        g.setColor(darkGrey);
        g.fillOval(250, 368, 119, 184);
        g.setColor(lightGrey);
        g.fillOval(252, 370, 115, 180); 
        //shoulder left
        g.translate(200, 370);
        g2d.rotate(Math.toRadians(38));
        g.setColor(darkGrey);
        g.fillOval(35, -30, 64, 104);
        g.setColor(lightGrey);
	g.fillOval(37, -28, 60, 100);
        g2d.rotate(Math.toRadians(-38));
        g.translate(-200, -370); 
        //arm left
        g.setColor(darkGrey);
        g.fillOval(188, 438, 54, 110);
        g.setColor(lightGrey);
        g.fillOval(190, 440, 50, 110);
        
        //forhead and main face
        g.setColor(lightGrey);
        g.fillOval(198, 198, 204, 184);
        g.setColor(darkGrey);
        g.fillOval(200, 200, 200, 180);
        g.setColor(skin);
        g.fillRect(220, 280, 180, 100);
        //eyes
        g.setColor(Color.WHITE);
        g.fillOval(280, 290, 40, 40);
        g.fillOval(350, 290, 40, 40);
        g.setColor(Color.BLACK);
        g.fillOval(lEyeX, lEyeY, 15, 15);
        g.fillOval(rEyeX, rEyeY, 15, 15);
        
        //forhead cover        
        g.setColor(darkGrey);
        g.fillRect(220, 280, 180, 20);        
        //chin
        int[] chinx = {220, 400, 340};
        int[] chiny = {380, 380, 440};       
        g.setColor(darkGrey);
        g.fillPolygon(chinx,chiny, 3); 
        g.setColor(darkGrey);
        g.fillRect(220, 340, 180, 40);
        //ear
        g.setColor(skin);
        g.fillOval(180, 290, 60, 72);
        g.setColor(darkskin);
        g.fillOval(198, 308, 30, 42);
        
        //g.fillArc(140, 145, 20, 20,150,210);
        //g.fillArc(175, 145, 20, 20,150,210);
        //eyebrows
        g.setColor(brown);
        //g.translate(260, 250);
        //g2d.rotate(Math.toRadians(25));
        g.fillRoundRect(260, lEyeBrowY, 80, 20, 20, 20);
        //g2d.rotate(Math.toRadians(-25));
        //g.translate(-260, -250);
        //g.translate(330, 260);
        //g2d.rotate(Math.toRadians(18));
        g.fillRoundRect(330, rEyeBrowY, 80, 20, 20, 20);
        //g2d.rotate(Math.toRadians(-18));
        //g.translate(-330, -260);
	
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
       if(lEyeBrowY==240){
           eyeBrowChange = 1;
       }else if(lEyeBrowY==300){
           eyeBrowChange = 0;
       }
       
           
        if(eyeBrowChange == 0){
       lEyeBrowY--;
       rEyeBrowY++;
       }
       if(eyeBrowChange == 1){
       lEyeBrowY++;
       rEyeBrowY--;
       }
        if(rEyeX!=285){
            rEyeX--;            
        }
        if(lEyeX != 350){
            lEyeX--;            
        }
           
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        ShapeFace game = new ShapeFace();
    }
}

