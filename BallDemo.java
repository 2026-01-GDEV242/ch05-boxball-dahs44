import java.awt.Color;
import java.util.Random;
import java.util.Arrays;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Tyler Ferdinand
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Box myBox;
    private Random randomGenerator;
    private Color color;
    private BoxBall ball1;

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
     * Random numbers are generated to establish xposition, ypositions, ball diameter, ball color and number of balls
     * @param numOfBalls number of balls to simulate bouncing, clamped between 5-50. 
     */
    public void boxBounce()
    {
        randomGenerator = new Random(); 
        int ballNumber = randomGenerator.nextInt(4, 29);
        int xPos;
        int yPos;
        int ballDiam;
        Color customColor;
        Box myBox= new Box (100,100,500,400, myCanvas);
        
        BoxBall[] balls = new BoxBall[ballNumber];

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);

        // create and show the balls
        for (int i = 0; i < ballNumber; i++)
        {
           ballDiam = randomGenerator.nextInt(10, 20);
           xPos = randomGenerator.nextInt(150, 300);
           yPos = randomGenerator.nextInt(150, 300);
           int r = randomGenerator.nextInt(200);
           int b = randomGenerator.nextInt(200);
           int g = randomGenerator.nextInt(200); 
           customColor = new Color(r, b, g);
           
           balls[i] = new BoxBall(xPos, yPos, ballDiam, customColor, myBox, myCanvas);
           balls[i].draw();
           
    
        
        
    }
    // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            
            for(BoxBall ball : balls){
                ball.move();
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
