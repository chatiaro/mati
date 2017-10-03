//<summarry>
//This program solves math problems, has a great GUI and is very reliable
//</summary>
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.List; 

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseMotionListener;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
/**
 *
 * @author Charitra Arora
 */
public class Mati extends JFrame implements MouseMotionListener{

    //<summary>
    //Main Method
    //</summary>
    public static void main(String[] args) 
    {
        new Mati();
    }
            
    public Mati(){
        //<summary>
        //Frame Settings
        //</summary>
        setUndecorated(true);//Remove titleBar
        setSize(1100, 600);//Size                
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);                
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);//Spawn window in center        
        setVisible(true);

                        
        //<summary>
        //Adding Load Components
        //</summary>  
        addComponentsForPhase1();
        
        //<summary>
        //The images take time to load during runtime, which makes the app slow. Hence i am adding a method to set images before hand
        //</summary>
        loadImages();
        
        //Dont know why but components in my frame are visible only afte I resize the frame
        this.setSize(1100, 580); 
        setLocationRelativeTo(null);//Spawn window in center        
        
        errBack.setBounds(0,0,1100,580);
        getContentPane().add(errBack);
        errBack.setLayout(null);
        errBack.setIcon(rszImg("res/quardErrWithGaussian.png",1100, 580));
        errBack.setIcon(rszImg("res/quardWithGaussian.png",1100, 580));
        errBack.setVisible(false);
    }   
    
    Timer loader;
    int counter;
    public void addComponentsForLoadingPhase()
    {               
        
        add(backPanel);//adding backPanel to frame                 
                            
        JLabel header = new JLabel("MATI");
        header.setFont(new Font("Copperplate Gothic Bold", 40, 27));  
        header.setBounds(38, 36, 235, 30);
        header.setForeground(Color.white);
        backPanel.add(header);        
        
        loader = new Timer(1, new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                counter++;
            }
        });
        
    }
    
    //#VariableDeclaration    
    JLabel backPanel/*the base*/, 
    introPanel/*the label that show the intro*/, 
    introTitle/*The label that displays the title*/, 
    introText/*Displays the introduction text*/,
    closeLabel/*the label used for closing*/,
    taskBar/*The bottom bar with all the menus*/;

    JButton okButton;//The button to continue

    Timer animator;//Used for the sliding animation 

    JLabel quardPanel, bankingPanel;
    public void loadImages()
    {
            quardPanel = new JLabel();
            quardPanel.setIcon(rszImg("res\\syllabus_back_final!!.png", 724, 484));
            
            bankingPanel = new JLabel();
            bankingPanel.setIcon(rszImg("res\\syllabus_back_final!!.png", 724, 484));  
    }
    String[] topics = {"Compound Interest", "Banking", "Shares and Dividends", "Linera Inequations"
        , "Quardratic Equations", "Factorization", "Matrices", "Distance And Section Formulae", "Trigonometrical Identities", 
            "Equation Of a Straight Line", "Circle", "Mensuration", "Hieghts and Distances", "Graphs", "Mean, Media and Mode" };
    public void addComponentsForPhase1()
    {     
                        
        backPanel =new JLabel();//Adding Background Image to backPanel         
        backPanel.setLayout(null);//Setting layout to null so that i can place components anywhere i like        
        backPanel.setIcon(rszImg("res\\theBackFinal!!.png", 1100, 580)); 
        add(backPanel);//adding backPanel to frame
        
        //closeLabel
        closeLabel = new JLabel("X");     
        closeLabel.setBounds(1080, 9, 20, 18);//Location and size
        closeLabel.setForeground(Color.white);//Color of the text
        closeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));//Changing the deault cursor to hand cursor
        closeLabel.setFont(new Font("Copperplate Gothic Bold", 40, 14));//Font         
        backPanel.add(closeLabel);

        closeLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                closeLabel.setFont(new Font("Copperplate Gothic Bold", 40, 18));
            }
            public void mouseExited(MouseEvent e)
            {
                closeLabel.setFont(new Font("Copperplate Gothic Bold", 40, 14));
            }
            public void mouseClicked(MouseEvent e)
            {
                dispose();
            }
        });
           
        //introPanel
        introPanel = new JLabel();//initializing introPanel                
        introPanel.setLayout(null);                
        introPanel.setBounds(215, 25, 724, 484);        
        introPanel.setIcon(rszImg("res\\syllabus_back_final!!.png", 724, 484));
        backPanel.add(introPanel);
        
        //introTitle
        introTitle = new JLabel("Welcome User");
        introTitle.setFont(new Font("Copperplate Gothic Bold", 40, 27));  
        introTitle.setBounds(38, 36, 235, 30);
        introTitle.setForeground(Color.white);
        introPanel.add(introTitle);
        
        //intorText
        //The intro text is multi line. I tried using \n but it didn't work, so html tags are used to change lines
        introText = new JLabel("<html><p>Matti is an app created by me to help you \n" +
                               "<p>guys with the toughest of math problems!! \n" +
                               "<p>Matti takes direct input from you and \n" +
                               "<p>through a complex algorithm generates\n" +
                               "<p>the answer!! Matti can also explain the method\n" +
                               "it used to solve a particular <p>sum!!\n" +
                               " \n" +
                               "<p><p>                                                    \t ~chatti");
        introText.setFont(new Font("Copperplate Gothic Bold", 40, 20));//Font (name, style, size)  
        introText.setBounds(80, 157, 524, 200);//Location and size
        introText.setForeground(Color.white);//The color of thee text
        introPanel.add(introText);
        
        //okButton
        okButton = new JButton("Got It");//Initalizing
        okButton.setBounds(610, 417, 84, 26);//Location and size
        okButton.setFont(new Font("Copperplate Gothic Bold", 40, 16));//Font  
        okButton.setBackground(new Color(0, 0, 0, 0));//Transparent (r,g,b,a)
        okButton.setForeground(Color.white);//Text color        
        okButton.setBorderPainted(false);//remove border        
        okButton.setHorizontalTextPosition(SwingConstants.CENTER);//Place text at the center of the image
        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//To change the default cusor fo the button to Hand Cursor
        okButton.setIcon(rszImg("res\\btnBack.png", 88, 28));
        introPanel.add(okButton);   
        okButton.addMouseListener(new MouseAdapter(){
            //When the mouse enters the button, the width and height are incremented by two
            //and the location is deceremented by two. 
            public void mouseEntered(MouseEvent e)
            {
                okButton.setBounds(608, 415, 88, 28);//Increaseing size and decreasing x and y cordinates
            }
            public void mouseExited(MouseEvent e)
            {
                okButton.setBounds(610, 417, 84, 26);//decerasing size and incerasing x and y cordinates
            }
        });

        //Assign action to the okButton
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {                
                //Hides the introPanel
                introPanel.setVisible(false);
                //Shows the taskbar
                taskBar.setVisible(true);
                //starts the taskBar slide up animation
                animator.start();
            }
        });      
        
        //Taskbar (0, 580);
        taskBar = new JLabel();
        taskBar.setBounds(0, 570, this.getWidth(), 79);
        taskBar.setBackground(Color.BLACK);
        taskBar.setVisible(false);
        taskBar.setLayout(null);
        taskBar.setIcon(rszImg("res\\tooolBarBack.png",this.getWidth(), 79));
        backPanel.add(taskBar);  

        //Animator new Point(0, 580);
        animator = new Timer(1, new ActionListener()
        {
            int yCord = 570;            
            public void actionPerformed(ActionEvent e)
            {
                yCord-=4;                
                taskBar.setBounds(0, yCord, getWidth(), 79);                

                if(yCord <= 510)
                {
                   animator.stop();
                   addComponentsForPhase2();
                }
                repaint();
            }
        });        
    }    
    JLabel syllabus, calci;
    public void addComponentsForPhase2()
    {
        //The introPanel is now used as the basePanel        
        introPanel.removeAll();        

        syllabus = new JLabel();
        syllabus.setBounds(250, -2, 75, 78);
        syllabus.setIcon(rszImg("res/Math_Syllabus_Final.png", 75, 78));                
        syllabus.addMouseMotionListener(this);        
        taskBar.add(syllabus);        

        syllabus.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                introPanel.setVisible(true);
            }
        });

        calci = new JLabel();
        calci.setBounds(370, 17, 40, 40);
        calci.setIcon(rszImg("res/caculatorImg.png", 40, 40));                
        calci.addMouseMotionListener(this);
        taskBar.add(calci);        

        syllabus.addMouseListener(new MouseAdapter(){            
            public void mouseClicked(MouseEvent e)
            {
                introPanel.setVisible(true);
                introPanel.removeAll();
                addTopics();
            }
        });                
    }

    int lastLoc = 370;
    private void addTopics()
        {
            JLabel header = new JLabel("Syllabus");
            header.setFont(new Font("Copperplate Gothic Bold", 17, 26));
            header.setBounds(20, 10, 150, 50);            
            header.setForeground(Color.white);
            introPanel.add(header);
                
            for (int i = 0; i < topics.length; i++)
            {
                JLabel topicLabel = new JLabel();
                topicLabel.setSize(800, 35);
                topicLabel.setForeground(Color.white);
                topicLabel.setFont(new Font("Copperplate Gothic Bold", 17, 21));
                topicLabel.setText(topics[i]);    
                topicLabel.setBounds(50, 60 + i * 30, 800, 35);
                topicLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                introPanel.add(topicLabel);                                                

                topicLabel.addMouseListener(new MouseAdapter(){
                    public void mouseEntered(MouseEvent e)
                    {
                        topicLabel.setFont(new Font("Copperplate Gothic Bold", 17, 23));
                    }
                    public void mouseExited(MouseEvent e)
                    {
                        topicLabel.setFont(new Font("Copperplate Gothic Bold", 17, 21));
                    }                       
                    public void mouseClicked(MouseEvent e)         
                    {
                        lastLoc += 50;
                        
                        introPanel.setVisible(false);                        
                        getTopicNameAndEvaluate(topicLabel.getText());
                        
                        JLabel taskBarButt = new JLabel();
                        taskBarButt.setText(topicLabel.getText().charAt(0) + "");
                        taskBarButt.setBounds(lastLoc, 15, 48, 48);
                        taskBarButt.setHorizontalTextPosition(SwingConstants.CENTER);
                        taskBarButt.setIcon(rszImg("res/math_chp_bg.png", 47, 47));                          
                        taskBarButt.setFont(new Font("Copperplate Gothic Bold", 17, 41));
                        taskBar.add(taskBarButt);
                        taskBarButt.setBounds(lastLoc, 14,48, 48);                   
                        taskBarButt.addMouseMotionListener(new MouseAdapter(){
                            public void mouseDragged(MouseEvent e)
                            {
                                JLabel sender = (JLabel) e.getSource();
                                int x = e.getX() + sender.getX();               
                                sender.setBounds(x, sender.getY(), sender.getWidth(), sender.getHeight());
                            }                            
                        });
                    }
                });
            }
        }        

        JLabel answerPanel;
        JLabel[] allPanels = new JLabel[40];
        public void getTopicNameAndEvaluate(String topic)
        {
            //first, to add the answer panel
           
             for(int i = 0; i<topics.length; i++)
            {   
                quardPanel.setBounds(215, 25, 724, 484);   
                bankingPanel.setBounds(215, 25, 724, 484);          
                
                JLabel title = new JLabel();
                title.setFont(new Font("Copperplate Gothic Bold", 17, 21));
                title.setForeground(Color.white);
                title.setBounds(20, 10, 500, 50);  
                if(topic.equals("Quardratic Equations"))
                {
                   quardPanel.setVisible(true);
                    
                   backPanel.add(quardPanel);
                   addComponentsForQuardratic(quardPanel);
                   quardPanel.add(title);
                   title.setText("Quardratic Equations");
                   bankingPanel.setVisible(false);
                }
                  else if(topic.equals("Banking"))
                {
                    bankingPanel.setVisible(true);
                    
                    backPanel.add(bankingPanel);
                    addComponentsForBanking(bankingPanel);
                    bankingPanel.add(title);
                    quardPanel.setVisible(false);                    
                    title.setText("Banking");
                }      
                //<summary>
                //adding components
                //</summary>
                                 
              }        
        }
        int lastButtLoc;      
           
       /////////////The Textfields are mulit purpose. Hence no permanent name/////////
       JTextField tf1 = new JTextField();
       JTextField tf2 = new JTextField();
       JTextField tf3 = new JTextField();
       JTextField tf4 = new JTextField();
       
       JLabel[] labs = new JLabel[4];
       public void addComponentsForBanking(JLabel parent)
       {
           for(int i = 0; i<labs.length; i++)
           {
               labs[i] = new JLabel();
               labs[i].setFont(new Font("Copperplate Gothic Bold", 17, 15));
               labs[i].setBounds(30, 50 + i * 40, 100, 30);
               labs[i].setForeground(Color.white);
                              
               parent.add(labs[i]);
               if(i == 1)
                   labs[i].setText("Text1");
               else if(i == 2)
                  labs[i].setText("Test2");
               else if(i == 3)
                  labs[i].setText("Test3");
               else if(i == 4)
                  labs[i].setText("Test4");
           }
           
           JTextField tf1 = new JTextField();
           JTextField tf2 = new JTextField();
           JTextField tf3 = new JTextField();
           JTextField tf4 = new JTextField();
       }
       
       /////////////////////////////////////////////////////////////////////////////////////////////////
       
       JTextField xSqTf = new JTextField();
       JTextField xTf = new JTextField();
       JTextField num = new JTextField();

       JLabel[] txtLbl = new JLabel[3];       
       JTextField ansQuardratic;
       int raisedTo = 0;
       String txt1, txt2, txt3;
       public void addComponentsForQuardratic(JLabel parent)
       {
           //<summary>
           //Creating  labels and 3 jtext fields, used for entering the quardratic eqn
           //</summary>              
           
           xSqTf.setBackground(new Color(169,169,169));
           xSqTf.setForeground(Color.white);
           xSqTf.setFont(new Font("Copperplate Gothic Bold", 17, 14));
           xSqTf.setBorder(BorderFactory.createEmptyBorder());
           xSqTf.setBounds(120, 140, 40, 20);           
           parent.add(xSqTf);
           
           xTf.setBackground(new Color(169,169,169));
           xTf.setForeground(Color.white);
           xTf.setFont(new Font("Copperplate Gothic Bold", 17, 14));
           xTf.setBorder(BorderFactory.createEmptyBorder());
           xTf.setBounds(200, 140, 40, 20);           
           parent.add(xTf);
           
           num.setBackground(new Color(169,169,169));
           num.setForeground(Color.white);
           num.setFont(new Font("Copperplate Gothic Bold", 17, 14));
           num.setBorder(BorderFactory.createEmptyBorder());
           num.setBounds(280, 140, 40, 20);           
           parent.add(num);
           for(int i = 0; i<3; i++)
           {   
               raisedTo++;                              
               
               txtLbl[i] = new JLabel();
               txtLbl[i].setBackground(new Color(169, 169, 169));
               txtLbl[i].setForeground(Color.white);
               txtLbl[i].setBounds(80 + i * 90, 140, 40, 20);
               txtLbl[i].setBorder(BorderFactory.createEmptyBorder());
               txtLbl[i].setFont(new Font("Copperplate Gothic Bold", 17, 14));
               parent.add(txtLbl[i]);
                          
               if(raisedTo == 1)
                  txtLbl[i].setText("aX^2");     
                  
               else if(raisedTo == 2)
                  txtLbl[i].setText("bX");
                  
               else if(raisedTo == 3)
                  txtLbl[i].setText("c");
            }
           
           JButton solveQuard = new JButton("Solve");
           solveQuard.setBounds(560, 230, 98, 26);//Location and size
           solveQuard.setFont(new Font("Copperplate Gothic Bold", 40, 16));//Font  
           solveQuard.setBackground(new Color(0, 0, 0, 0));//Transparent (r,g,b,a)
           solveQuard.setForeground(Color.white);//Text color        
           solveQuard.setBorderPainted(false);//remove border        
           solveQuard.setHorizontalTextPosition(SwingConstants.CENTER);//Place text at the center of the image
           solveQuard.setCursor(new Cursor(Cursor.HAND_CURSOR));//To change the default cusor fo the button to Hand Cursor
           solveQuard.setIcon(rszImg("res\\btnBack.png", 98, 26));
           parent.add(solveQuard); 
           
           solveQuard.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e)
               {
                   answerPanel = new JLabel();
                   answerPanel.setBounds(0, 270, getWidth(), 215);                                                          
                   answerPanel.setIcon(rszImg("res\\ansPanelBack.png", getWidth(), 350));
                   answerPanel.setLayout(null);
                   answerPanel.setVisible(false);
                   parent.add(answerPanel);                                      
                                      
                   matiQuardtic(xSqTf.getText(), xTf.getText(), num.getText());                       
                }
            });
       }
        JTextArea ansField;
        String[] args = new String[3];
       private void matiQuardtic(String arg, String arg2, String arg3) {
           try{
                double a = Double.parseDouble(arg);
                double b = Double.parseDouble(arg2);
                double c = Double.parseDouble(arg3);
                
                double temp = Math.sqrt(b * b - 4 * a * c);
                String dou = temp + "";
                if (dou.equals("NaN"))
                {
                    showErr("Imaginary Roots", "Error");
                }

                else if(temp >= 1) {
                String nature = "";
                if (temp > 0)
                    nature = "real and unequal";
                else if (temp == 0)
                    nature = "real and equal";                                                

                //Obtaining the roots and rounding them to 2nd decimal place 
                double root1 = Math.round(((-b + temp) / (2 * a)) * 100) / 100.0;
                double root2 = Math.round(((-b - temp) / (2 * a)) * 100) / 100.0;
                
                answerPanel.setVisible(true);  

                ansField = new JTextArea();
                ansField.setOpaque(false);
                ansField.setForeground(Color.white);
                ansField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));                

                JScrollPane sp = new JScrollPane(ansField); 
                sp.setBorder(BorderFactory.createEmptyBorder());
                sp.setBounds(0, 0, answerPanel.getWidth(), answerPanel.getHeight());
                sp.setOpaque(false);
                sp.getViewport().setOpaque(false);
                answerPanel.add(sp);                                       

                ansField.setText("Here, \n" + 
                    "a = " + a + ",b = " + b + " and c = " + c + "\n" +
                    "First, To find the discriminant of the equation,\n" +
                    "b\u00B2 - 4ac\n" +
                    "(" + b + ")\u00B2" + "- 4\u00D7" + a + "\u00D7" + c +
                    "=> " + (b * b) + "- 4\u00D7" + a + "\u00D7" + c +
                    "=> " + (b * b) + "-" + (4 * a * c) +
                    "=> " + ((b * b) - (4 * a * c)) +
                    "\n\u2235 discriminant = " + (temp * temp) + "\n" +
                    "\u2234 Nature Of Roots is " + nature + "\n\n" +
                    "Now, to find the roots of the equation, \n" +
                    "(-b \u00B1 \u221Ab\u00B2 - 4\u00D7a\u00D7c)\u00F72\u00D7a\n" +
                    "=>(" + -b + "\u00B1 \u221A" + b + "\u00B2 - 4\u00D7" + a + "\u00D7" + c + ")\u00F72\u00D7" + a + "\n" +
                    "=>(" + -b + "+ \u221A" + (b * b - 4 * a * c) + ")\u00F72\u00D7" + a + "\n" +
                    "=>(" + -b + "+" + temp + ")\u00F72\u00D7" + a + "\n" +
                    "=>(" + (-b + temp) + ")\u00F72\u00D7" + a + "\n" +
                    "=>" + ((-b + temp) / (2 * a)) + "\n" +
                    "\u2234 root1 = " + root1 + "\n" +
                    "Similarly,\n" +
                    "=>(" + -b + "-" + temp + ")\u00F72\u00D7" + a + "\n" +
                    "=>(" + (-b - temp) + ")\u00D7" + a + "\n" +
                    "\u2234 root2 = " + root2);                    
                }
            }
            catch (Exception ex)
            {                                
                showErr(ex.getMessage(), "Error");
            }
       }                  
       JLabel errBack = new JLabel();
              
       Point clickPoint;       
       public void showErr(String errMsg, String errTitle)
       {
           this.backPanel.setVisible(false);
           this.errBack.setVisible(true);                             

           JPanel errMsgPanel = new JPanel();
           errMsgPanel.setBackground(new Color(0, 0, 0,170));
           errMsgPanel.setBounds(400, 200, 400, 150);
           errMsgPanel.setSize(400, 150);               
           errMsgPanel.setVisible(true);        
           errMsgPanel.setLayout(null);      
           
           errMsgPanel.addMouseListener(new MouseAdapter(){
               public void mousePressed(MouseEvent e)
               {
                   clickPoint = e.getPoint();
               }
           });
           errMsgPanel.addMouseMotionListener(new MouseAdapter(){
               public void mouseDragged(MouseEvent e)
               {
                int currX = errMsgPanel.getX();
                int currY = errMsgPanel.getY();

                int xMov = (currX + e.getX()) - (currX + (int)clickPoint.getX());
                int yMov = (currY + e.getY()) - (currY + (int)clickPoint.getY());

                int x = currX + xMov;
                int y = currY + yMov;

                errMsgPanel.setLocation(new Point(x, y));
                repaint();
               }
           });

           JLabel title = new JLabel();
           title.setText(errTitle);
           title.setBounds(20, 3, 200, 30);
           title.setForeground(Color.white);
           title.setFont(new Font("Copperplate Gothic Bold", 40, 20));
           errMsgPanel.add(title);

           JLabel msg = new JLabel();
           msg.setBounds(10, -40, 150, 210);
           msg.setText(errMsg);
           msg.setForeground(Color.white);
           msg.setFont(new Font("Copperplate Gothic Bold", 40, 15));        
           errMsgPanel.add(msg);

           JButton btn_ok = new JButton("OK");
           btn_ok.setBounds(300, 120, 100, 30);
           btn_ok.setBackground(new Color(0,0,0,0));
           btn_ok.setForeground(Color.white);
           btn_ok.setBorderPainted(false);//remove border        
           btn_ok.setFont(new Font("Copperplate Gothic Bold", 40, 15));    
           btn_ok.setCursor(new Cursor(Cursor.HAND_CURSOR));

           btn_ok.addMouseListener(new MouseAdapter()
           {
               public void mouseClicked(MouseEvent e) 
               {
                 errBack.remove(errMsgPanel);
                 
                 backPanel.setVisible(true);
                 errBack.setVisible(false);                                                              
                 repaint();
              }
        });        
        
        errMsgPanel.add(btn_ok);
        errBack.add(errMsgPanel);
        errBack.setIcon(rszImg("res/quardErrWithGaussian.png",1100, 580));           
        repaint();
    }

    /////////////////////////////ToResizeAnImageAccordingToComponentSize///////////////////////////
    public ImageIcon rszImg(String imagePath, int width, int height)
    {        
        BufferedImage img = null;//To store the image
        ImageIcon imageBack = null;
        try {            
            //To read image in a buffered image
            img = ImageIO.read(new File(imagePath));
            //Change it's size by using getScaledInstance
            Image rsz_img = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);               
            //Read the image into ImageIcon
            imageBack = new ImageIcon(rsz_img);                        
        }catch(IOException ex)
        {
            showErr(ex.getMessage(), "Error");
        }
        //To return the resized image
        return imageBack;
    }    
    
    ///////////////ForMovingAComponent/////////////////////////
    public void mouseDragged(MouseEvent e)
    {
        JLabel sender = (JLabel) e.getSource();

        
        int x = e.getX() + sender.getX();               
        sender.setBounds(x, sender.getY(), sender.getWidth(), sender.getHeight());        
    }
    ///////////////////////////////////////////////////////////////
    public void mouseMoved(MouseEvent e)
    {
        
    }       
}
