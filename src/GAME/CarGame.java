package GAME;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.util.Scanner;
import javax.swing.Timer;

/**
 *
 * @author riepj9547
 */
public class CarGame extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 3500;
    static final int HEIGHT = 2800;
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
    double speed = 0;
    double accel = 0;
    double deaccel = 0;
    double angle = 0;
    boolean gas = false;
    boolean brake = false;
    boolean turnLeft = false;
    boolean turnRight = false;
    boolean eBrake = false;
    boolean boost = false;
    int carX = 50;
    int carY = 280;
    int tireMarks = 0;
    int[] tireX = new int[400];
    int[] tireY = new int[400];
    int[] tireAngle = new int[400];
    double[] lapTimes = new double[10];
    double[] tireLife = new double[400];
    int camX = 0;
    int camY = 0;
    Rectangle carBox = new Rectangle(carX, carY, 12, 12);
    Rectangle carBoxBack = new Rectangle(carX, carY, 3, 3);
    Rectangle[] wall = new Rectangle[63];
    Rectangle[] Blocks = new Rectangle[300];
    Rectangle[] finishLine = new Rectangle[2];
    int numBlocks = 0;
    int laps = 0;
    boolean halfway = false;
    boolean crossFinish = false;
    boolean startGame = false;
    boolean startPlayer = false;
    double timerSec = 0;   
    int countDown = 360;
    String trackName = "Track1";
    int mX = 0;
    int mY = 0;
    boolean click = false;
    double timeStart = 0;
    //AI variables
    double speedAI1 = 0;
    double accelAI1 = 0;
    double deaccelAI1 = 0;
    double angleAI1 = 0;
    int carAI1X = 30;
    int carAI1Y = 280;
    boolean turnLeftAI1 = false;
    boolean turnRightAI1 = false;
    boolean gasAI1 = false;
    boolean startAI = false;
    boolean allEyeHit = false;
    Rectangle carAI1Box = new Rectangle(carAI1X, carAI1Y, 12, 12);
    Rectangle carAI1BoxBack = new Rectangle(carAI1X, carAI1Y, 3, 3);
    Rectangle eyeL1 = new Rectangle(carAI1X, carAI1Y, 3, 3);
    Rectangle eyeR1 = new Rectangle(carAI1X, carAI1Y, 3, 3);
    Rectangle eyeFront = new Rectangle(carAI1X, carAI1Y, 3, 3);
    //AI 2
    double speedAI2 = 0;
    double accelAI2 = 0;
    double deaccelAI2 = 0;
    double angleAI2 = 0;
    int carAI2X =0;
    int carAI2Y = 280;
    boolean turnLeftAI2 = false;
    boolean turnRightAI2 = false;
    boolean gasAI2 = false;
    boolean startA2 = false;
    boolean allEyeHit2 = false;
    Rectangle carAI2Box = new Rectangle(carAI2X, carAI2Y, 12, 12);
    Rectangle carAI2BoxBack = new Rectangle(carAI2X, carAI2Y, 3, 3);
    Rectangle eyeL2 = new Rectangle(carAI2X, carAI2Y, 3, 3);
    Rectangle eyeR2 = new Rectangle(carAI2X, carAI2Y, 3, 3);
    Rectangle eyeFront2 = new Rectangle(carAI2X, carAI2Y, 3, 3);
    //fonts
    Font biggestFont = new Font("arial", Font.BOLD, 72);
    Font biggerFont = new Font("arial", Font.BOLD, 36);
    Font smallerFont = new Font("arial", Font.BOLD, 28);
    

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public CarGame() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);
        preSetup();
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

        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        //angle number
        if(startGame == true){
        g.setColor(Color.RED);        
        g.fillRect(finishLine[0].x - camX, finishLine[0].y - camY, finishLine[0].width, finishLine[0].height);
        
        g.setColor(Color.BLACK);
        //track creator
        for (int i = 0; i < numBlocks; i++) {
            g.fillRect(Blocks[i].x - camX, Blocks[i].y - camY, Blocks[i].width, Blocks[i].height);
        }

        }


        //hitbox
        //g.setColor(Color.RED);
        //g.drawRect(eyeFront.x - camX, eyeFront.y - camY, eyeFront.width, eyeFront.height);
        //g.setColor(Color.PINK);
        //g.drawRect(eyeL1.x - camX, eyeL1.y - camY, eyeL1.width, eyeL1.height);
        //g.drawRect(eyeR1.x - camX, eyeR1.y - camY, eyeR1.width, eyeR1.height);

        g.setColor(Color.BLACK);
        for (int i = 1; i < tireMarks; i++) {
            g.translate(tireX[i] - camX, tireY[i] - camY);
            g2d.rotate(Math.toRadians(tireAngle[i]));
            g.fillRect(0, 0, 2, 2);
            g2d.rotate(Math.toRadians(-tireAngle[i]));
            g.translate(-(tireX[i] - camX), -(tireY[i] - camY));

        }
        g.setColor(Color.RED);               
        g.setFont(smallerFont);
        g.drawString("" + timerSec/1000, 590, 50);
                
        g.drawString("Laps: "+ (laps+1), 0, 20);        
        for (int i = 0; i < laps; i++) {
            g.drawString("Lap "+ (i+1) + ": "+ lapTimes[i], 0, 50+(i*25));
        }
        
        g.setFont(biggestFont);        
         if(countDown > 300 && countDown < 359){
        g.drawString("5", 600, 300);        
        }else if (countDown > 240 && countDown < 300){
            g.drawString("4", 600, 300);            
        }else if (countDown > 180 && countDown < 240){
            g.drawString("3", 600, 300);
        }else if (countDown > 120 && countDown < 180){
            g.drawString("2", 600, 300);
        }else if (countDown > 60 && countDown < 120){
            g.drawString("1", 600, 300);
        }else if (countDown > 1 && countDown < 60){
            g.drawString("GO!", 600, 300);
            startAI = true;
            startPlayer = true;
        }
        

        //player car
        g.setColor(Color.BLUE);
        //frontLeftWheel
        g.translate(carX + 328 - camX, carY + 272 - camY);
        g2d.rotate(Math.toRadians(angle));
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carX + 328 - camX), -(carY + 272 - camY));
        //frontRightWheel
        g.translate(carX + 339 - camX, carY + 272 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carX + 339 - camX), -(carY + 272 - camY));
        //backRightWheel
        g.translate(carX + 339 - camX, carY + 283 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carX + 339 - camX), -(carY + 283 - camY));
        //backLeftWheel
        g.translate(carX + 328 - camX, carY + 283 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carX + 328 - camX), -(carY + 283 - camY));
        //boddy
        g.translate(carX + 331 - camX, carY + 279 - camY);
        g.fillRect(-6, 0, 12, 12);
        g.translate(-(carX + 331 - camX), -(carY + 279 - camY));
        //body
        g.translate(carX + 331 - camX, carY + 270 - camY);
        g.fillRect(-6, 0, 12, 12);
        g.translate(-(carX + 331 - camX), -(carY + 270 - camY));
        //frontbody
        g.translate(carX + 333 - camX, carY + 268 - camY);
        g.fillRect(-6, 0, 8, 8);
        g2d.rotate(Math.toRadians(-angle));
        g.translate(-(carX + 333 - camX), -(carY + 268 - camY));
        // AI car
        g.setColor(Color.RED);
        //frontLeftWheel
        g.translate(carAI1X + 328 - camX, carAI1Y + 272 - camY);
        g2d.rotate(Math.toRadians(angleAI1));
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI1X + 328 - camX), -(carAI1Y + 272 - camY));
        //frontRightWheel
        g.translate(carAI1X + 339 - camX, carAI1Y + 272 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI1X + 339 - camX), -(carAI1Y + 272 - camY));
        //backRightWheel
        g.translate(carAI1X + 339 - camX, carAI1Y + 283 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI1X + 339 - camX), -(carAI1Y + 283 - camY));
        //backLeftWheel
        g.translate(carAI1X + 328 - camX, carAI1Y + 283 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI1X + 328 - camX), -(carAI1Y + 283 - camY));
        //boddy
        g.translate(carAI1X + 331 - camX, carAI1Y + 279 - camY);
        g.fillRect(-6, 0, 12, 12);
        g.translate(-(carAI1X + 331 - camX), -(carAI1Y + 279 - camY));
        //body
        g.translate(carAI1X + 331 - camX, carAI1Y + 270 - camY);
        g.fillRect(-6, 0, 12, 12);
        g.translate(-(carAI1X + 331 - camX), -(carAI1Y + 270 - camY));
        //frontbody
        g.translate(carAI1X + 333 - camX, carAI1Y + 268 - camY);
        g.fillRect(-6, 0, 8, 8);
        g2d.rotate(Math.toRadians(-angleAI1));
        g.translate(-(carAI1X + 333 - camX), -(carAI1Y + 268 - camY));
        //AI2 car
        g.setColor(Color.ORANGE);
        //frontLeftWheel
        g.translate(carAI2X + 328 - camX, carAI2Y + 272 - camY);
        g2d.rotate(Math.toRadians(angleAI2));
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI2X + 328 - camX), -(carAI2Y + 272 - camY));
        //frontRightWheel
        g.translate(carAI2X + 339 - camX, carAI2Y + 272 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI2X + 339 - camX), -(carAI2Y + 272 - camY));
        //backRightWheel
        g.translate(carAI2X + 339 - camX, carAI2Y + 283 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI2X + 339 - camX), -(carAI2Y + 283 - camY));
        //backLeftWheel
        g.translate(carAI2X + 328 - camX, carAI2Y + 283 - camY);
        g.fillRect(-6, 0, 6, 6);
        g.translate(-(carAI2X + 328 - camX), -(carAI2Y + 283 - camY));
        //boddy
        g.translate(carAI2X + 331 - camX, carAI2Y + 279 - camY);
        g.fillRect(-6, 0, 12, 12);
        g.translate(-(carAI2X + 331 - camX), -(carAI2Y + 279 - camY));
        //body
        g.translate(carAI2X + 331 - camX, carAI2Y + 270 - camY);
        g.fillRect(-6, 0, 12, 12);
        g.translate(-(carAI2X + 331 - camX), -(carAI2Y + 270 - camY));
        //frontbody
        g.translate(carAI2X + 333 - camX, carAI2Y + 268 - camY);
        g.fillRect(-6, 0, 8, 8);
        g2d.rotate(Math.toRadians(-angleAI2));
        g.translate(-(carAI2X + 333 - camX), -(carAI2Y + 268 - camY));

        g.setFont(biggestFont);
        if(countDown > 359){
            g.setColor(Color.WHITE);            
            g.clearRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            g.fillRect(900, 300, 75, 50);
            g.setColor(Color.BLACK);
            g.fillRect(900, 500, 75, 50);
            g.setColor(Color.RED);
            g.setFont(smallerFont);
            g.drawString("Track", 900, 320);
            g.drawString("1", 937, 340);
            g.drawString("Track", 900, 520);
            g.drawString("2", 937, 540);
            g.setColor(Color.RED);
            g.setFont(biggestFont);
            g.drawString("Controls: ", 20, 300);
            g.setColor(Color.BLACK);
            g.drawString("W to move forward ", 20, 360);
            g.drawString("A and D to turn ", 20, 420);
            g.drawString("S to slow down ", 20, 480);
            g.drawString("SPACE to use E brake ", 20, 540);
            g.drawString("Select Track to Start ", 20, 600);
            
        }

        //g.setColor(Color.PINK);
        //g.drawRect(eyeL1.x - camX, eyeL1.y - camY, eyeL1.width, eyeL1.height);
        //g.setColor(Color.PINK);
        //g.drawRect(eyeR1.x - camX, eyeR1.y - camY, eyeR1.width, eyeR1.height);

        // g.setColor(Color.GREEN);
        // g.drawRect(carAI1Box.x- camX, carAI1Box.y- camY, carAI1Box.width, carAI1Box.height);
        // g.drawRect(carAI1BoxBack.x- camX, carAI1BoxBack.y- camY, carAI1BoxBack.width, carAI1BoxBack.height);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here        
        Scanner in = null;
        try {
            in = new Scanner(new File(trackName+""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        numBlocks = in.nextInt();
        numBlocks = numBlocks - 2;
        in.nextLine();
        for (int i = 0; i < numBlocks; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            int h = in.nextInt();
            Blocks[i] = new Rectangle(x, y, w, h);

        }
        in.nextLine();
        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        finishLine[0] = new Rectangle(x, y, w, h);
        x = in.nextInt();
        y = in.nextInt();
        w = in.nextInt();
        h = in.nextInt();
        finishLine[1] = new Rectangle(x, y, w, h);
        
        
    }

    

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        //set camera over player
        camX = carX - 300;
        camY = carY - 200;
        carMovement();
        carCollision();
        aiCarMovement();
        aiCarCollision();
        //if a tire mark dies, move it away
        for (int i = 1; i < tireMarks; i++) {
            tireLife[i] = tireLife[i] - 0.1;
            if (tireLife[i] <= 0) {
                tireX[i] = -2000;
                tireY[i] = -2000;

            }
        }
        //if I have more tire marks than im supposed to have reset them to 0
        if (tireMarks >= tireX.length - 1) {
            tireMarks = 0;
        }
        
        //display time 
        if (startAI == true) {
            if (timeStart == 0) {
                timeStart = System.currentTimeMillis();
            }
            timerSec = System.currentTimeMillis() - timeStart;
        }
        
        //start game!!!
        if(startGame == false){
            if(click==true){
                if(mX > 900 && mX <975 && mY > 300 && mY < 350){
                    trackName = "Track1";
                    buildTrack();
                    startGame = true;
                }
                if(mX > 900 && mX <975 && mY > 500 && mY < 550){
                    trackName = "Track2";
                    buildTrack();
                    startGame = true;
                }
            }
        }
        if(startGame == true){
            if(countDown > 0){
            countDown = countDown-2;
            }
            
            
            
        }


        //turning
        //reset angle if it is less or more than 360
        if (angle > 360 || angle < -360) {
            angle = 0;
        }
        //turn left while the key is down, if ebrake is on turn sharper
        if (turnLeft == true) {
            if (eBrake == true) {
                angle = angle - 4;
                if (tireMarks < tireX.length - 1) {
                    tireMarks++;
                    tireX[tireMarks] = carBoxBack.x;
                    tireY[tireMarks] = carBoxBack.y;
                    tireAngle[tireMarks] = (int) angle;
                    tireLife[tireMarks] = 15;
                } //else {
                //for (int i = 0; i < tireX.length; i++) {
                //   tireX[i] = -500;
                //   tireY[i] = -500;
                //   tireMarks = 0;
                // }

                // }
            } else {
                angle = angle - 2;
            }
        }
        //turn right while the key is down, if ebrake is on turn sharper
        if (turnRight == true) {
            if (eBrake == true) {
                angle = angle + 4;
                if (tireMarks < tireX.length - 1) {
                    tireMarks++;
                    tireX[tireMarks] = carBoxBack.x;
                    tireY[tireMarks] = carBoxBack.y;
                    tireAngle[tireMarks] = (int) angle;
                    tireLife[tireMarks] = 30;
                } //else {
                // for (int i = 0; i < tireX.length; i++) {
                //    tireX[i] = -500;
                //    tireY[i] = -500;
                //    tireMarks = 0;
                // }
                //}
            } else {
                angle = angle + 2;
            }
        }
    }
    private void buildTrack(){
        Scanner in = null;
        try {
            in = new Scanner(new File(trackName+""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        numBlocks = in.nextInt();
        numBlocks = numBlocks - 2;
        in.nextLine();
        for (int i = 0; i < numBlocks; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            int h = in.nextInt();
            Blocks[i] = new Rectangle(x, y, w, h);

        }
        in.nextLine();
        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        finishLine[0] = new Rectangle(x, y, w, h);
        x = in.nextInt();
        y = in.nextInt();
        w = in.nextInt();
        h = in.nextInt();
        finishLine[1] = new Rectangle(x, y, w, h);
    }

    private void carMovement() {
        double newAngle = Math.toRadians(angle - 90);
        //move forward if the gas is down
        if (gas == true) {
            if (accel < 12) {
                accel = accel + 0.08;
                speed = accel + deaccel;
            }
        } else if (accel > 0) {
            accel = accel - 0.2;
        }
        //slow down if u want aswell
        if (brake == true) {
            if (deaccel > -6) {
                deaccel = deaccel - 0.04;
                speed = accel + deaccel;
            }
        } else if (deaccel < 0) {
            deaccel = deaccel + 0.2;
        }
        //calculate the distance to travel at the angle I am facing
        if (true) {
            speed = accel + deaccel;
            double carXD = Math.cos(newAngle) * speed;
            double carYD = Math.sin(newAngle) * speed;
            carY = carY + (int) carYD;
            carX = carX + (int) carXD;
        }

        if (eBrake == true) {
        }
    }

    private void carCollision() {
        double newAngle = Math.toRadians(angle);
        //create the players hit boxes
        carBox.x = (int) (carX + 328 - 2 + 9.6 * (Math.cos(newAngle + Math.toRadians(51))) - (carBox.width / 2));
        carBox.y = (int) (carY + 272 + 9.6 * (Math.sin(newAngle + Math.toRadians(51))) - (carBox.height / 2));
        carBoxBack.x = (int) (carX + 328 - 3 + 16.15 * (Math.cos(newAngle + Math.toRadians(68))));
        carBoxBack.y = (int) (carY + 272 + 16.15 * (Math.sin(newAngle + Math.toRadians(68))));
        //check for collisions on every wall
        for (int i = 1; i < numBlocks; i++) {
            //if I hit bounce off
            if (carBox.intersects(Blocks[i])) {
                accel = 0;
                deaccel = -3;
            }
            if (carBoxBack.intersects(Blocks[i])) {
                accel = 3;
                deaccel = 0;

            }
        }
        
        if (carBox.intersects(finishLine[1])) {
            halfway = true;
        }
        //when crossed finish line
        if (carBox.intersects(finishLine[0])) {
            if (halfway == true) { 
                if(laps == 0){
                    lapTimes[laps] = (Math.round(timerSec))/1000.0;
                }else{
                    if(lapTimes[laps]==0){
                    lapTimes[laps] = (Math.round(timerSec))/1000.0;
                    }
                    for (int i = laps-1; i >=0; i--) {
                        lapTimes[laps] = lapTimes[laps] -lapTimes[i];
                    }
                    
                }              
                
                laps++;
                halfway = false;

            }
        }

    }

    private void aiCarMovement() {
        double newAI1Angle = Math.toRadians(angleAI1 - 90);
        double newAI2Angle = Math.toRadians(angleAI2 - 90);
        //move the AI when active
        if (startAI == true) {
            if (accelAI1 < 12) {
                accelAI1 = accelAI1 + 0.08;
                speedAI1 = accelAI1 + deaccelAI1;
            }

            if (deaccelAI1 < 0) {
                deaccelAI1 = deaccelAI1 + 0.2;
            }
        
        
            if (accelAI2 < 12) {
                accelAI2 = accelAI2 + 0.08;
                speedAI2 = accelAI2 + deaccelAI2;
            }

            if (deaccelAI2 < 0) {
                deaccelAI2 = deaccelAI2 + 0.2;
            }

        }
        
        //calcualte the distance for the AI to travel at
        if (true) {
            speedAI1 = accelAI1 + deaccelAI1;
            double carAI1XD = Math.cos(newAI1Angle) * speedAI1;
            double carAI1YD = Math.sin(newAI1Angle) * speedAI1;
            carAI1Y = carAI1Y + (int) carAI1YD;
            carAI1X = carAI1X + (int) carAI1XD;
            //calcualte the distance for the AI to travel at
        
            speedAI2 = accelAI2 + deaccelAI2;
            double carAI2XD = Math.cos(newAI2Angle) * speedAI2;
            double carAI2YD = Math.sin(newAI2Angle) * speedAI2;
            carAI2Y = carAI2Y + (int) carAI2YD;
            carAI2X = carAI2X + (int) carAI2XD;
        }
        
        
        

    }

    private void aiCarCollision() {
        double newAI1Angle = Math.toRadians(angleAI1);
        boolean lEyeFirst = false;
        boolean rEyeFirst = false;
        int lastTurn = 0;
        //create all the AI's hitboxes and eyes
        eyeL1.x = (int) (carAI1X + 328 + 65 * (Math.cos(newAI1Angle - Math.toRadians(118.3))));
        eyeL1.y = (int) (carAI1Y + 272 + 65 * (Math.sin(newAI1Angle - Math.toRadians(118.3))));
        eyeR1.x = (int) (carAI1X + 339 + 65 * (Math.cos(newAI1Angle - Math.toRadians(61.7))));
        eyeR1.y = (int) (carAI1Y + 272 + 65 * (Math.sin(newAI1Angle - Math.toRadians(61.7))));
        eyeFront.x = (int) (carAI1X + 334 + 88 * (Math.cos(newAI1Angle - Math.toRadians(90))));
        eyeFront.y = (int) (carAI1Y + 272 + 88 * (Math.sin(newAI1Angle - Math.toRadians(90))));

        carAI1Box.x = (int) (carAI1X + 328 - 2 + 9.6 * (Math.cos(newAI1Angle + Math.toRadians(51))) - (carAI1Box.width / 2));
        carAI1Box.y = (int) (carAI1Y + 272 + 9.6 * (Math.sin(newAI1Angle + Math.toRadians(51))) - (carAI1Box.height / 2));
        carAI1BoxBack.x = (int) (carAI1X + 328 - 3 + 16.15 * (Math.cos(newAI1Angle + Math.toRadians(68))));
        carAI1BoxBack.y = (int) (carAI1Y + 272 + 16.15 * (Math.sin(newAI1Angle + Math.toRadians(68))));
        //if an AI eye hits a wall turn him, if a hitbox hits a wall bounce off
        if (startAI == true) {
            //if front eye hits a wall, check for for other colisions
            for (int i = 1; i < numBlocks; i++) {
                if (eyeFront.intersects(Blocks[i])) {
                    //if the right eye also hits turn left and slow down
                    if (eyeL1.intersects(Blocks[i]) && eyeR1.intersects(Blocks[i])) {
                        deaccelAI1 = -8;
                        accelAI1 = accelAI1 + 0.5 * deaccelAI1;
                        allEyeHit = true;
                        //if neither eye hits sloooowww down and turn the same as the last time you turned
                    } else if (!(eyeL1.intersects(Blocks[i])) && !(eyeR1.intersects(Blocks[i]))) {
                        //twoEyeHit = true;
                        deaccelAI1 = -8;

                        angleAI1 = angleAI1 + lastTurn;
                        allEyeHit = false;
                        //if right eye hits turn left
                    } else if (eyeR1.intersects(Blocks[i])) {
                        angleAI1 = angleAI1 - 8;
                        deaccelAI1 = -3;
                        lastTurn = -8;
                        //if left eye hits turn right
                    } else if (eyeL1.intersects(Blocks[i])) {
                        angleAI1 = angleAI1 + 8;
                        deaccelAI1 = -3;
                        lastTurn = 8;
                    }
                }
                //if only the right eye hits turn left and slow down
                if (eyeR1.intersects(Blocks[i])) {
                    angleAI1 = angleAI1 - 8;
                    deaccelAI1 = -3;
                    lastTurn = -5;
                    allEyeHit = true;
                    //if only the left eye hits turn left and slow down
                } else if (eyeL1.intersects(Blocks[i])) {
                    angleAI1 = angleAI1 + 8;
                    deaccelAI1 = -3;
                    lastTurn = 5;
                    allEyeHit = true;

                }

                //if AI hits wall head on
                if (carAI1Box.intersects(Blocks[i])) {
                    deaccelAI1 = -18;
                    accelAI1 = 0;
                    angleAI1 = angleAI1 + lastTurn;

                }

                if (carAI1BoxBack.intersects(Blocks[i])) {
                    if (eyeR1.intersects(Blocks[i]) && !(eyeL1.intersects(Blocks[i]))) {
                        angleAI1 = angleAI1 - 6;
                        accelAI1 = 7;
                        deaccelAI1 = -2;
                    }
                    if (eyeL1.intersects(Blocks[i]) && !(eyeR1.intersects(Blocks[i]))) {
                        angleAI1 = angleAI1 + 6;
                        accelAI1 = 7;
                        deaccelAI1 = -2;
                    }
                    if (eyeL1.intersects(Blocks[i]) && eyeR1.intersects(Blocks[i])) {
                        angleAI1 = angleAI1 - 12;
                        accelAI1 = 7;
                        deaccelAI1 = -2;
                    }
                    if (!(eyeL1.intersects(wall[i])) && !(eyeR1.intersects(wall[i]))) {
                        angleAI1 = angleAI1 - 6;
                        accelAI1 = 7;
                        deaccelAI1 = -2;
                    }

                }

            }
            //reset angle if greater than or las than 360
            if (angleAI1 > 360 || angleAI1 < -360) {
                angleAI1 = 0;
            }

        }
        
        //AI2
        double newAI2Angle = Math.toRadians(angleAI2);
        boolean lEyeFirst2 = false;
        boolean rEyeFirst2 = false;
        int lastTurn2 = 0;
        //create all the AI's hitboxes and eyes
        eyeL2.x = (int) (carAI2X + 328 + 65 * (Math.cos(newAI2Angle - Math.toRadians(118.3))));
        eyeL2.y = (int) (carAI2Y + 272 + 65 * (Math.sin(newAI2Angle - Math.toRadians(118.3))));
        eyeR2.x = (int) (carAI2X + 339 + 65 * (Math.cos(newAI2Angle - Math.toRadians(61.7))));
        eyeR2.y = (int) (carAI2Y + 272 + 65 * (Math.sin(newAI2Angle - Math.toRadians(61.7))));
        eyeFront2.x = (int) (carAI2X + 334 + 88 * (Math.cos(newAI2Angle - Math.toRadians(90))));
        eyeFront2.y = (int) (carAI2Y + 272 + 88 * (Math.sin(newAI2Angle - Math.toRadians(90))));

        carAI2Box.x = (int) (carAI2X + 328 - 2 + 9.6 * (Math.cos(newAI2Angle + Math.toRadians(51))) - (carAI2Box.width / 2));
        carAI2Box.y = (int) (carAI2Y + 272 + 9.6 * (Math.sin(newAI2Angle + Math.toRadians(51))) - (carAI2Box.height / 2));
        carAI2BoxBack.x = (int) (carAI2X + 328 - 3 + 16.15 * (Math.cos(newAI2Angle + Math.toRadians(68))));
        carAI2BoxBack.y = (int) (carAI2Y + 272 + 16.15 * (Math.sin(newAI2Angle + Math.toRadians(68))));
        //if an AI eye hits a wall turn him, if a hitbox hits a wall bounce off
        if (startAI == true) {
            //if front eye hits a wall, check for for other colisions
            for (int i = 1; i < numBlocks; i++) {
                if (eyeFront2.intersects(Blocks[i])) {
                    //if the right eye also hits turn left and slow down
                    if (eyeL2.intersects(Blocks[i]) && eyeR2.intersects(Blocks[i])) {
                        deaccelAI2 = -8;
                        accelAI2 = accelAI2 + 0.5 * deaccelAI2;
                        allEyeHit2 = true;
                        //if neither eye hits sloooowww down and turn the same as the last time you turned
                    } else if (!(eyeL2.intersects(Blocks[i])) && !(eyeR2.intersects(Blocks[i]))) {
                        //twoEyeHit = true;
                        deaccelAI2 = -8;

                        angleAI2 = angleAI2 + lastTurn2;
                        allEyeHit2 = false;
                        //if right eye hits turn left
                    } else if (eyeR2.intersects(Blocks[i])) {
                        angleAI2 = angleAI2 - 8;
                        deaccelAI2 = -3;
                        lastTurn2 = -8;
                        //if left eye hits turn right
                    } else if (eyeL2.intersects(Blocks[i])) {
                        angleAI2 = angleAI2 + 8;
                        deaccelAI2 = -3;
                        lastTurn2 = 8;
                    }
                }
                //if only the right eye hits turn left and slow down
                if (eyeR2.intersects(Blocks[i])) {
                    angleAI2 = angleAI2 - 8;
                    deaccelAI2 = -3;
                    lastTurn2 = -5;
                    allEyeHit2 = true;
                    //if only the left eye hits turn left and slow down
                } else if (eyeL2.intersects(Blocks[i])) {
                    angleAI2 = angleAI2 + 8;
                    deaccelAI2 = -3;
                    lastTurn2 = 5;
                    allEyeHit2 = true;

                }

                //if AI hits wall head on
                if (carAI2Box.intersects(Blocks[i])) {
                    deaccelAI2 = -18;
                    accelAI2 = 0;
                    angleAI2 = angleAI2 + lastTurn2;

                }

                if (carAI2BoxBack.intersects(Blocks[i])) {
                    if (eyeR2.intersects(Blocks[i]) && !(eyeL2.intersects(Blocks[i]))) {
                        angleAI2 = angleAI2 - 6;
                        accelAI2 = 7;
                        deaccelAI2 = -2;
                    }
                    if (eyeL2.intersects(Blocks[i]) && !(eyeR2.intersects(Blocks[i]))) {
                        angleAI2 = angleAI2 + 6;
                        accelAI2 = 7;
                        deaccelAI2 = -2;
                    }
                    if (eyeL2.intersects(Blocks[i]) && eyeR2.intersects(Blocks[i])) {
                        angleAI2 = angleAI2 - 12;
                        accelAI2 = 7;
                        deaccelAI2 = -2;
                    }
                    if (!(eyeL2.intersects(wall[i])) && !(eyeR2.intersects(wall[i]))) {
                        angleAI2 = angleAI2 - 6;
                        accelAI2 = 7;
                        deaccelAI2 = -2;
                    }

                }

            }
            //reset angle if greater than or las than 360
            if (angleAI2 > 360 || angleAI2 < -360) {
                angleAI2 = 0;
            }

        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            mX = e.getX();
            mY = e.getY();
           click = true;
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
            click = false; 
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
            //only when the player is allowed to move accept the movement
            if(startPlayer == true){            
            if (keyCode == KeyEvent.VK_W) {
                gas = true;
            }
            if (keyCode == KeyEvent.VK_A) {
                turnLeft = true;
            }
            if (keyCode == KeyEvent.VK_D) {
                turnRight = true;
            }
            if (keyCode == KeyEvent.VK_S) {
                brake = true;
            }
            }
            if (keyCode == KeyEvent.VK_UP) {
                //gasAI1 = true;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                //turnLeftAI1 = true;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                // turnRightAI1 = true;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
            }
            if (keyCode == KeyEvent.VK_SPACE) {
                eBrake = true;
            }
            if (keyCode == KeyEvent.VK_SHIFT) {
                boost = true;
            }
            if (keyCode == KeyEvent.VK_ENTER) {
                startGame = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                gas = false;
            }
            if (keyCode == KeyEvent.VK_A) {
                turnLeft = false;
            }
            if (keyCode == KeyEvent.VK_D) {
                turnRight = false;
            }
            if (keyCode == KeyEvent.VK_S) {
                brake = false;
            }
            if (keyCode == KeyEvent.VK_UP) {
                gasAI1 = false;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                turnLeftAI1 = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                turnRightAI1 = false;
            }
            if (keyCode == KeyEvent.VK_SPACE) {
                eBrake = false;
            }
            if (keyCode == KeyEvent.VK_SHIFT) {
                boost = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        CarGame game = new CarGame();
    }
}
