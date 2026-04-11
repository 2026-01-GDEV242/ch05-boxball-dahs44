import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Box myBox;
    private Random randomGenerator;
    private Color color;
    private BoxBall ball1;
    private BoxBall ball2;
    private BoxBall ball3;
    private BoxBall ball4;
    private BoxBall ball5;
    private BoxBall ball6;
    private BoxBall ball7;
    private BoxBall ball8;
    private BoxBall ball9;
    private BoxBall ball10;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     * 
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        Box myBox= new Box (100,100,500,400, myCanvas);
        myBox.draw();
        
        Box box2 = new Box(myCanvas);
        box2.draw();
        
    }

    /**
     * boxBounce - simulate 5-50 balls bouncing within a box
     * 
     * @param numOfBalls number of balls to simulate bouncing, clamped between 5-50. 
     */
    public void boxBounce()
    {
        randomGenerator = new Random(); 
        int ballNumber = randomGenerator.nextInt(9);
        int xPos;
        int yPos;
        int ballDiam;
        Color customColor;
        
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        for (int i = 0; i < ballNumber; i++)
        {
           ballDiam = randomGenerator.nextInt(10, 20);
           xPos = randomGenerator.nextInt(150, 250);
           yPos = randomGenerator.nextInt(150, 250);
           int r = randomGenerator.nextInt(225);
           int b = randomGenerator.nextInt(225);
           int g = randomGenerator.nextInt(225); 
           customColor = new Color(r, b, g);
           if (i == 0)
           {
             ball1 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball1.draw();
           }
           else if (i == 1)
           {
             ball2 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball2.draw();
           }
           else if (i == 2)
           {
             ball3 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball3.draw();
           }
           else if (i == 3)
           {
             ball4 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball4.draw();
           }
           else if (i == 4)
           {
             ball5 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball5.draw();
           }
           else if (i == 5)
           {
             ball6 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball6.draw();
           }
           else if (i == 6)
           {
             ball7 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball7.draw();
           }
           else if (i == 7)
           {
             ball8 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball8.draw();
           }
           else if (i == 8)
           {
             ball9 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball9.draw();
           }
           else if (i == 9)
           {
             ball10 = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
             ball10.draw();
           }
        }
    
        
        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball1.move();
            ball2.move();
            ball4.move();
            ball5.move();
            ball6.move();
            ball7.move();
            ball8.move();
            
            // stop once ball has travelled a certain distance on x axis
            if(ball1.getYPosition() >= 400 || ball10.getYPosition() >= 400) {
                finished = true;
                }
            
        }
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
