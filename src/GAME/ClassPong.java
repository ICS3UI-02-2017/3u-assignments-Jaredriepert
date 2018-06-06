package GAME;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
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
public class ClassPong extends JComponent implements ActionListener {

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
    //rectangle (x,y,width,height)
    
    Rectangle paddle1 = new Rectangle(25,250,25,100);
    Rectangle paddle2 = new Rectangle(725,250,25,100);
    Rectangle ball = new Rectangle(395,295,10,10);
    
    int ballAngle = 45;
    int ballspeed = 6;
    //control variables
    boolean paddle1Up = false;
    boolean paddle1Down = false;
    boolean paddle2Up = false;
    boolean paddle2Down = false;
    int paddleSpeed = 6;
    
    //score varialbes
    int score1 = 0;
    int score2 = 0;
    
    //create custom font
    Font biggerFont = new Font("arial", Font.BOLD, 36);
    

    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public ClassPong(){
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
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        //draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        //draw text
        g.setColor(Color.WHITE);
        g.setFont(biggerFont);
        g.drawString(""+score1, WIDTH/2 -150, 50);
        g.drawString(""+score2, WIDTH/2 +150, 50);
        //draw paddels
        g.setColor(Color.WHITE);
        g.fillRect(paddle1.x,paddle1.y,paddle1.width,paddle1.height);
        g.fillRect(paddle2.x,paddle2.y,paddle2.width,paddle2.height);
        //draw ball
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
		
		
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
        moveball();
        movepaddles();
        checkforcolision();
        checkforgoal();
    }

    private void moveball() {
        //convert ball angle to radians
        double newAngle = Math.toRadians(ballAngle);
        //determind how much to move ball x and ball y
        double moveX = ballspeed*Math.cos(newAngle);
        double moveY = ballspeed*Math.sin(newAngle);
        
        ball.x = ball.x + (int)moveX;
        ball.y = ball.y + (int)moveY;
    }

    private void checkforcolision() {
        //collistion with bottom/top
        if(ball.y <0){
            ballAngle= ballAngle* -1;
        }
        if(ball.y+ball.height>HEIGHT){
            ballAngle= ballAngle* -1;
        }
        //collistion with paddles
        //make sure the angle wont go over 360 degrees
        if(ball.intersects(paddle1)){            
            ballAngle = (180 +ballAngle * -1) & 360;
        }
        if(ball.intersects(paddle2)){
            ballAngle = (180 +ballAngle * -1) % 360;
        }
        
    }

    private void movepaddles() {
        if(paddle1Up == true){
            paddle1.y = paddle1.y - paddleSpeed;
        }else if(paddle1Down == true){
            paddle1.y = paddle1.y + paddleSpeed;
        }
        if(paddle2Up == true){
            paddle2.y = paddle2.y - paddleSpeed;
        }else if(paddle2Down == true){
            paddle2.y = paddle2.y + paddleSpeed;
        }
        
        if(paddle1.y<0){
            paddle1.y = 0;
        }
        if(paddle1.y+paddle1.height>HEIGHT){
            paddle1.y = HEIGHT-paddle1.height;
        }
        
        if(paddle2.y<0){
            paddle2.y = 0;
        }
        if(paddle2.y+paddle2.height>HEIGHT){
            paddle2.y = HEIGHT-paddle2.height;
        }
        
    }

    private void checkforgoal() {
        //ball off left side
        if(ball.x<0){
            score2++;
            ball.x = WIDTH/2 - ball.width/2;
            ball.y = HEIGHT/2 - ball.height/2;
            
        }
        //ball off right side
        if(ball.x + ball.width > WIDTH){
            score1++;
            ball.x = WIDTH/2 - ball.width/2;
            ball.y = HEIGHT/2 - ball.height/2;
            
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
        int keyCode = e.getKeyCode();
            //Player 1 controls
           if(keyCode == KeyEvent.VK_W){
               paddle1Up = true;
           }
           if(keyCode == KeyEvent.VK_S){
               paddle1Down = true;
           }
           if(keyCode == KeyEvent.VK_UP){
               paddle2Up = true;
           }
           if(keyCode == KeyEvent.VK_DOWN){
               paddle2Down = true;
           }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
               paddle1Up = false;
           }
           if(keyCode == KeyEvent.VK_S){
               paddle1Down = false;
           }
           if(keyCode == KeyEvent.VK_UP){
               paddle2Up = false;
           }
           if(keyCode == KeyEvent.VK_DOWN){
               paddle2Down = false;
           }
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
        ClassPong game = new ClassPong();
    }
}

