package GAME;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
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
import javax.swing.Timer;

/**
 *
 * @author riepj9547
 */
public class CarGame extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 2800;
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
    int carX = 0;
    int carY = 0;
    int tireMarks = 0;
    int[] tireX = new int[200];
    int[] tireY = new int[200];
    int[] tireAngle = new int[200];
    int camX = 0;
    int camY = 0;
    Rectangle carBox = new Rectangle(carX, carY, 12, 12);
    Rectangle carBoxBack = new Rectangle(carX, carY, 3, 3);
    Rectangle[] wall = new Rectangle[63];
    //AI variables
    double speedAI1 = 0;
    double accelAI1 = 0;
    double deaccelAI1 = 0;    
    double angleAI1 = 0;
    int carAI1X = 0;
    int carAI1Y = 0;
    boolean turnLeftAI1 = false;
    boolean turnRightAI1 = false;
    boolean gasAI1 = false;
    boolean startAI = false;
    Rectangle carAI1Box = new Rectangle(carAI1X, carAI1Y, 12, 12);
    Rectangle carAI1BoxBack = new Rectangle(carAI1X, carAI1Y, 3, 3);
    Rectangle eyeL1 = new Rectangle(carAI1X, carAI1Y, 3, 3);
    Rectangle eyeR1 = new Rectangle(carAI1X, carAI1Y, 3, 3);
    Rectangle eyeFront = new Rectangle(carAI1X, carAI1Y, 3, 3);

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
        g.drawString("Angle: " + angleAI1 + ", Speed: " + speedAI1 + ",Accel: " + accelAI1 + ", deaccel: " + deaccelAI1 + "AI position: " + carAI1X + ", " + carAI1Y, 50, 50);
        g.setColor(Color.BLACK);
        //Track 1
        g.fillRect(206 - camX, 528 - camY, 44, 280);
        g.fillRect(228 - camX, 256 - camY, 44, 280);
        g.fillRect(241 - camX, 205 - camY, 58, 56);
        g.fillRect(264 - camX, 161 - camY, 58, 56);
        g.fillRect(286 - camX, 126 - camY, 132, 52);
        g.fillRect(369 - camX, 112 - camY, 322, 52);
        g.fillRect(668 - camX, 123 - camY, 86, 80);
        g.fillRect(707 - camX, 164 - camY, 86, 80);
        g.fillRect(735 - camX, 219 - camY, 260, 56);
        g.fillRect(965 - camX, 244 - camY, 260, 56);
        g.fillRect(438 - camX, 322 - camY, 188, 176);
        g.fillRect(558 - camX, 385 - camY, 188, 176);
        g.fillRect(438 - camX, 495 - camY, 188, 176);
        g.fillRect(734 - camX, 399 - camY, 188, 176);
        g.fillRect(901 - camX, 430 - camY, 188, 176);
        g.fillRect(1052 - camX, 432 - camY, 188, 176);
        g.fillRect(430 - camX, 593 - camY, 188, 176);
        g.fillRect(512 - camX, 635 - camY, 188, 176);
        g.fillRect(218 - camX, 796 - camY, 42, 286);
        g.fillRect(235 - camX, 1057 - camY, 64, 74);
        g.fillRect(279 - camX, 1085 - camY, 64, 74);
        g.fillRect(342 - camX, 1085 - camY, 282, 74);
        g.fillRect(553 - camX, 1045 - camY, 282, 74);
        g.fillRect(783 - camX, 1010 - camY, 282, 74);
        g.fillRect(1002 - camX, 965 - camY, 82, 90);
        g.fillRect(1058 - camX, 926 - camY, 82, 90);
        g.fillRect(1110 - camX, 798 - camY, 82, 176);
        g.fillRect(616 - camX, 528 - camY, 316, 176);
        g.fillRect(692 - camX, 652 - camY, 226, 176);
        g.fillRect(773 - camX, 590 - camY, 226, 176);
        g.fillRect(941 - camX, 496 - camY, 226, 176);
        g.fillRect(1155 - camX, 780 - camY, 216, 84);
        g.fillRect(1216 - camX, 235 - camY, 216, 60);
        g.fillRect(1408 - camX, 219 - camY, 68, 60);
        g.fillRect(1457 - camX, 199 - camY, 68, 60);
        g.fillRect(1507 - camX, 128 - camY, 68, 102);
        g.fillRect(1553 - camX, -6 - camY, 68, 176);
        g.fillRect(1588 - camX, -197 - camY, 68, 234);
        g.fillRect(1610 - camX, -266 - camY, 90, 98);
        g.fillRect(1675 - camX, -298 - camY, 90, 98);
        g.fillRect(1755 - camX, -298 - camY, 248, 98);
        g.fillRect(1950 - camX, -236 - camY, 110, 98);
        g.fillRect(2017 - camX, -200 - camY, 110, 98);
        g.fillRect(2082 - camX, -160 - camY, 110, 98);
        g.fillRect(2138 - camX, -106 - camY, 110, 98);
        g.fillRect(1987 - camX, 74 - camY, 110, 98);
        g.fillRect(1926 - camX, 48 - camY, 110, 98);
        g.fillRect(1864 - camX, 23 - camY, 110, 98);
        g.fillRect(1803 - camX, -18 - camY, 110, 98);
        g.fillRect(1784 - camX, -73 - camY, 110, 98);
        g.fillRect(1785 - camX, -12 - camY, 110, 350);
        g.fillRect(1222 - camX, 429 - camY, 620, 134);
        g.fillRect(1748 - camX, 315 - camY, 156, 134);
        g.fillRect(1664 - camX, 381 - camY, 156, 134);
        g.fillRect(1942 - camX, 129 - camY, 156, 510);
        g.fillRect(2284 - camX, 115 - camY, 156, 510);
        g.fillRect(2246 - camX, -76 - camY, 202, 198);
        g.fillRect(1766 - camX, 444 - camY, 202, 198);
        g.fillRect(1348 - camX, 806 - camY, 444, 80);
        g.fillRect(1761 - camX, 847 - camY, 444, 80);
        g.fillRect(2284 - camX, 618 - camY, 156, 198);
        g.fillRect(2109 - camX, 801 - camY, 162, 122);
        g.fillRect(2215 - camX, 759 - camY, 162, 122);
        //hitbox
        g.setColor(Color.RED);
        g.drawRect(eyeFront.x - camX, eyeFront.y - camY, eyeFront.width, eyeFront.height);
        g.setColor(Color.PINK);
        g.drawRect(eyeL1.x - camX, eyeL1.y - camY, eyeL1.width, eyeL1.height);
        g.drawRect(eyeR1.x - camX, eyeR1.y - camY, eyeR1.width, eyeR1.height);

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

        wall[0] = new Rectangle(206, 528, 44, 280);

        wall[1] = new Rectangle(228, 256, 44, 280);

        wall[2] = new Rectangle(241, 205, 58, 56);

        wall[3] = new Rectangle(264, 161, 58, 56);

        wall[4] = new Rectangle(286, 126, 132, 52);

        wall[5] = new Rectangle(369, 112, 322, 52);

        wall[6] = new Rectangle(668, 123, 86, 80);

        wall[7] = new Rectangle(707, 164, 86, 80);

        wall[8] = new Rectangle(735, 219, 260, 56);

        wall[9] = new Rectangle(965, 244, 260, 56);

        wall[10] = new Rectangle(438, 322, 188, 176);

        wall[11] = new Rectangle(558, 385, 188, 176);

        wall[12] = new Rectangle(438, 495, 188, 176);

        wall[13] = new Rectangle(734, 399, 188, 176);

        wall[14] = new Rectangle(901, 430, 188, 176);

        wall[15] = new Rectangle(1052, 432, 188, 176);

        wall[16] = new Rectangle(430, 593, 188, 176);

        wall[17] = new Rectangle(512, 635, 188, 176);

        wall[18] = new Rectangle(218, 796, 42, 286);

        wall[19] = new Rectangle(235, 1057, 64, 74);

        wall[20] = new Rectangle(279, 1085, 64, 74);

        wall[21] = new Rectangle(342, 1085, 282, 74);

        wall[22] = new Rectangle(553, 1045, 282, 74);

        wall[23] = new Rectangle(783, 1010, 282, 74);

        wall[24] = new Rectangle(783, 1010, 282, 74);

        wall[25] = new Rectangle(1058, 926, 82, 90);

        wall[26] = new Rectangle(1110, 798, 82, 176);

        wall[27] = new Rectangle(616, 528, 316, 176);

        wall[28] = new Rectangle(692, 652, 226, 176);

        wall[29] = new Rectangle(773, 590, 226, 176);

        wall[30] = new Rectangle(941, 496, 226, 176);

        wall[31] = new Rectangle(1155, 780, 216, 84);

        wall[32] = new Rectangle(1216, 235, 216, 60);

        wall[33] = new Rectangle(1408, 219, 68, 60);

        wall[34] = new Rectangle(1457, 199, 68, 60);

        wall[35] = new Rectangle(1507, 128, 68, 102);

        wall[36] = new Rectangle(1553, -6, 68, 176);

        wall[37] = new Rectangle(1588, -197, 68, 234);

        wall[38] = new Rectangle(1610, -266, 90, 98);

        wall[39] = new Rectangle(1675, -298, 90, 98);

        wall[40] = new Rectangle(1755, -298, 248, 98);

        wall[41] = new Rectangle(1950, -236, 110, 98);

        wall[42] = new Rectangle(2017, -200, 110, 98);

        wall[43] = new Rectangle(2082, -160, 110, 98);

        wall[44] = new Rectangle(2138, -106, 110, 98);

        wall[45] = new Rectangle(1987, 74, 110, 98);

        wall[46] = new Rectangle(1926, 48, 110, 98);

        wall[47] = new Rectangle(1864, 23, 110, 98);

        wall[48] = new Rectangle(1803, -18, 110, 98);

        wall[49] = new Rectangle(1784, -73, 110, 98);

        wall[50] = new Rectangle(1785, -12, 110, 350);

        wall[51] = new Rectangle(1222, 429, 620, 134);

        wall[52] = new Rectangle(1748, 315, 156, 134);

        wall[53] = new Rectangle(1664, 381, 156, 134);

        wall[54] = new Rectangle(1942, 129, 156, 510);

        wall[55] = new Rectangle(2284, 115, 156, 510);

        wall[56] = new Rectangle(2246, -76, 202, 198);

        wall[57] = new Rectangle(1766, 444, 202, 198);

        wall[58] = new Rectangle(1348, 806, 444, 80);

        wall[59] = new Rectangle(1761, 847, 444, 80);

        wall[60] = new Rectangle(2284, 618, 156, 198);

        wall[61] = new Rectangle(2109, 801, 162, 122);

        wall[62] = new Rectangle(2215, 759, 162, 122);





    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        camX = carX - 300;
        camY = carY - 200;
        carMovement();
        carCollision();
        aiCarMovement();
        aiCarCollision();

        //turning

        if (angle > 360 || angle < -360) {
            angle = 0;
        }
        if (turnLeft == true) {
            if (eBrake == true) {
                angle = angle - 4;
            } else {
                angle = angle - 2;
            }
        }
        if (turnRight == true) {
            if (eBrake == true) {
                angle = angle + 4;
            } else {
                angle = angle + 2;
            }
        }
    }

    private void carMovement() {
        double newAngle = Math.toRadians(angle - 90);
        if (gas == true) {
            if (accel < 12) {
                accel = accel + 0.08;
                speed = accel + deaccel;
            }
        } else if (accel > 0) {
            accel = accel - 0.2;
        }
        if (brake == true) {
            if (deaccel > -6) {
                deaccel = deaccel - 0.04;
                speed = accel + deaccel;
            }
        } else if (deaccel < 0) {
            deaccel = deaccel + 0.2;
        }
        if (true) {
            speed = accel + deaccel;
            double carXD = Math.cos(newAngle) * speed;
            double carYD = Math.sin(newAngle) * speed;
            carY = carY + (int) carYD;
            carX = carX + (int) carXD;
        }
        //tireMarks
        //if (accel - deaccel <= 1 && accel - deaccel != 0) {            
        //tireX[tireMarks] = carXI + 339;
        //tireY[tireMarks] = carYI + 283;
        //tireAngle[tireMarks] = (int) angle;
        //tireMarks++;

        // }
    }

    private void carCollision() {
        double newAngle = Math.toRadians(angle);
        carBox.x = (int) (carX + 328 - 2 + 9.6 * (Math.cos(newAngle + Math.toRadians(51))) - (carBox.width / 2));
        carBox.y = (int) (carY + 272 + 9.6 * (Math.sin(newAngle + Math.toRadians(51))) - (carBox.height / 2));
        carBoxBack.x = (int) (carX + 328 - 3 + 16.15 * (Math.cos(newAngle + Math.toRadians(68))));
        carBoxBack.y = (int) (carY + 272 + 16.15 * (Math.sin(newAngle + Math.toRadians(68))));
        for (int i = 1; i < wall.length; i++) {
            if (carBox.intersects(wall[i])) {
                accel = 0;
                deaccel = -3;
            }
            if (carBoxBack.intersects(wall[i])) {
                accel = 3;
                deaccel = 0;

            }
        }

    }

    private void aiCarMovement() {
        double newAI1Angle = Math.toRadians(angleAI1 - 90);

        if (startAI == true) {
            if (accelAI1 < 12) {
                accelAI1 = accelAI1 + 0.08;
                speedAI1 = accelAI1 + deaccelAI1;
            }

            if (deaccelAI1 < 0) {
                deaccelAI1 = deaccelAI1 + 0.2;
            }

        }
        if (true) {
            speedAI1 = accelAI1 + deaccelAI1;
            double carAI1XD = Math.cos(newAI1Angle) * speedAI1;
            double carAI1YD = Math.sin(newAI1Angle) * speedAI1;
            carAI1Y = carAI1Y + (int) carAI1YD;
            carAI1X = carAI1X + (int) carAI1XD;
        }

    }

    private void aiCarCollision() {
        double newAI1Angle = Math.toRadians(angleAI1);
        boolean lEyeFirst = false;
        boolean rEyeFirst = false;
        boolean twoEyeHit = false;
        boolean twoEyeHit2 = false;
        int lastTurn = 0;
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
        if (startAI == true) {
            //if front eye hits a wall, check for for other colisions
            for (int i = 1; i < wall.length; i++) {
                if (eyeFront.intersects(wall[i])) {
                    //if the right eye also hits turn left and slow down
                    if (eyeL1.intersects(wall[i]) && eyeR1.intersects(wall[i])) {
                        deaccelAI1 = -8;
                        accelAI1 = accelAI1 + deaccelAI1;
                        //if neither eye hits sloooowww down and turn right and turn do some other things below **
                    } else if (!(eyeL1.intersects(wall[i])) && !(eyeR1.intersects(wall[i]))) {
                        //twoEyeHit = true;
                        deaccelAI1 = -8;                        
                        angleAI1 = angleAI1 + lastTurn;
                    } else if (eyeR1.intersects(wall[i])) {
                        angleAI1 = angleAI1 - 8;
                        deaccelAI1 = -3;
                        lastTurn = -8;
                    } else if (eyeL1.intersects(wall[i])) {
                        angleAI1 = angleAI1 + 8;
                        deaccelAI1 = -3;
                        lastTurn = 8;
                    }
                }
                //if the right eye hits turn left and slow down
                if (eyeR1.intersects(wall[i])) {
                    angleAI1 = angleAI1 - 5;
                    deaccelAI1 = -3;
                    lastTurn = -5;
                }else if (eyeL1.intersects(wall[i])) {
                    angleAI1 = angleAI1 + 5;
                    deaccelAI1 = -3;
                    lastTurn = 5;

                }
                //** 
                if (twoEyeHit == true) {
                    //if both eyes not hit turn left instead of left from above and slow down
                    if (eyeL1.intersects(wall[i]) && eyeR1.intersects(wall[i])) {
                        angleAI1 = angleAI1 - 14;
                        deaccelAI1 = -8;
                        accelAI1 = 0;
                    }
                    //if only right eye now hits turn left
                    if (!(eyeL1.intersects(wall[i])) && eyeR1.intersects(wall[i])) {
                        angleAI1 = angleAI1 - 8;
                        deaccelAI1 = -3;
                        twoEyeHit = false;
                    }
                    //if only left eye now hits turn right
                    if (!(eyeR1.intersects(wall[i])) && eyeL1.intersects(wall[i])) {
                        angleAI1 = angleAI1 + 8;
                        deaccelAI1 = -3;
                        twoEyeHit = false;
                    }
                    //if neither eye hits turn right
                    if (!(eyeL1.intersects(wall[i])) && !(eyeR1.intersects(wall[i]))) {
                        twoEyeHit = false;
                        angleAI1 = angleAI1 + 15;
                    }

                }



                //if AI hits wall head on
                if (carAI1Box.intersects(wall[i])) {
                    deaccelAI1 = -8; 
                    accelAI1 = accelAI1 + deaccelAI1;
                    angleAI1 = angleAI1 + lastTurn;
                    
                }
                //if (eyeR1.intersects(wall[i]) && eyeL1.intersects(wall[i])) {
                //speedAI1 = -6;
                // }
                //if(eyeR1.intersects(wall[i]) || eyeL1.intersects(wall[i])){ 
                //    if (eyeR1.intersects(wall[i]) && !(eyeL1.intersects(wall[i]))) {
                //        angleAI1 = angleAI1 - 6;
                //         accelAI1 = 2;
                //         deaccelAI1 = -7;
                //     }
                //     if (eyeL1.intersects(wall[i]) && !(eyeR1.intersects(wall[i]))) {
                //         angleAI1 = angleAI1 + 6;
                //         accelAI1 = 2;
                //         deaccelAI1 = -7;
                //     }
                //     if (eyeL1.intersects(wall[i]) && eyeR1.intersects(wall[i])) {
                //         angleAI1 = angleAI1 - 12;
                //        accelAI1 = 2;
                //         deaccelAI1 = -7;
                //     }
                //     if (!(eyeL1.intersects(wall[i])) && !(eyeR1.intersects(wall[i]))) {
                //         angleAI1 = angleAI1 - 6;
                //         accelAI1 = 2;
                //         deaccelAI1 = -7;
                //     }

                //  }
                if (carAI1BoxBack.intersects(wall[i])) {
                    if (eyeR1.intersects(wall[i]) && !(eyeL1.intersects(wall[i]))) {
                        angleAI1 = angleAI1 - 6;
                        accelAI1 = 7;
                        deaccelAI1 = -2;
                    }
                    if (eyeL1.intersects(wall[i]) && !(eyeR1.intersects(wall[i]))) {
                        angleAI1 = angleAI1 + 6;
                        accelAI1 = 7;
                        deaccelAI1 = -2;
                    }
                    if (eyeL1.intersects(wall[i]) && eyeR1.intersects(wall[i])) {
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
            if (angleAI1 > 360 || angleAI1 < -360) {
                angleAI1 = 0;
            }

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
                startAI = true;
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
