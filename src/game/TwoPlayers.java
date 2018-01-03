/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

/**
 *
 * @author User-PC
 */

import java.util.ArrayList;
import java.util.Random;

public class TwoPlayers extends javax.swing.JFrame {

     Deck dc = new Deck();
       
    int ff=0;
    int i=0;
    int superPower=0;
    int value1=0;
    int value2=0;
    String name="";
    String suit1="";
    String suit2="";
    int intialValue=0;
    String intialSuit="";
    int pValue=0;
    String playerSuit="";
    int ai=4;
    int temp=0;
    int temp2=0;
    String temp3="";
    String temp1="";
    int playerScore=0;
    int hostScore=0;
    ArrayList<Integer> bt = new ArrayList<Integer>();
     
    int[] humanValue = new int[25];
    String[] humanSuit = new String[25];
      
    int[] aiValue = new int[25];
    String[] aiSuit = new String[25];
    public TwoPlayers() {
      
    }
    
    public TwoPlayers(String playerName){
        bt.add(5);
        bt.add(6);
        bt.add(7);
        bt.add(8);
        bt.add(9);
        bt.add(10);
        bt.add(11);
        bt.add(12);
      
        //Initializing the values and suits
        for(int a=0;a<25;a++)
        {
            humanValue[a]=-1;
            humanSuit[a]="empty";
        }
        
        for(int a=0;a<25;a++)
        {
            aiValue[a]=-1;
            aiSuit[a]="empty";
        }
        
        initComponents();
        jLabel3.setText(playerName);
        name=jLabel3.getText();
        //error label if player drops wrong card
        jLabel12.setVisible(false);
      
        dc.shuffle();
        
        jButton6.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);
        jButton15.setVisible(false);
        jButton14.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
     
     
        //distributing cards to the human player
        Card card1 = dc.deck.get(i);
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card1.getImage())));
        i++;        
        
        Card card2 = dc.deck.get(i);
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card2.getImage())));
        i++;
        
        Card card3 = dc.deck.get(i);
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card3.getImage())));
        i++;
        
        Card card4 = dc.deck.get(i);
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card4.getImage())));
        i++;
   
      //Storing human values
      humanValue[0]=card1.getValue();
      System.out.println("HumanValue0:"+humanValue[0]);
      humanValue[1]=card2.getValue();
      System.out.println("HumanValue1:"+humanValue[1]);
      humanValue[2]=card3.getValue();
      System.out.println("HumanValue2:"+humanValue[2]);
      humanValue[3]=card4.getValue();
      System.out.println("HumanValue3:"+humanValue[3]);
   
      //Stroring human suit
      humanSuit[0]=card1.getSuit();
      humanSuit[1]=card2.getSuit();
      humanSuit[2]=card3.getSuit();
      humanSuit[3]=card4.getSuit();
        
     //Distributing cards to the AI players
      Card carda1 = dc.deck.get(i);
      i++;
      Card carda2 = dc.deck.get(i);
      i++;
      Card carda3 = dc.deck.get(i);
      i++;
      Card carda4 = dc.deck.get(i);
      i++;
   
      //Storing ai values
      
      aiValue[0]=carda1.getValue();
      aiValue[1]=carda2.getValue();
      aiValue[2]=carda3.getValue();
      aiValue[3]=carda4.getValue();
    
      //Stroring hai suit
      aiSuit[0]=carda1.getSuit();
      aiSuit[1]=carda2.getSuit();
      aiSuit[2]=carda3.getSuit();
      aiSuit[3]=carda4.getSuit();
    
      //
       Card c20 = dc.deck.get(i);
       jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c20.getImage())));
       i++;
     //maincard value
        intialValue=c20.getValue();
        System.out.println("MainCardValue:"+intialValue);
        intialSuit=c20.getSuit();
    }
    
    public void aiDrop()
    {   
        if(intialValue==100)
        {
            intialValue=temp2;
            intialSuit=temp1;
        }
        int drop1=0;
        int b=0;
      //  int v=0;
        for(b=0; b<25; b++)
        {            
            if(intialValue==aiValue[b] || intialSuit==aiSuit[b])
            {
                    if(aiSuit[b]=="Spades")
                        superPower=0;
                    else if(aiSuit[b]=="Diamonds")
                        superPower=1;
                    else if(aiSuit[b]=="Hearts")
                        superPower=2;
                    else if(aiSuit[b]=="Clubs")
                        superPower=3;
                    System.out.println("host value: "+(aiValue[b]));
                    System.out.println("hostsuper: "+aiSuit[b]);
                   // v=aiValue[b];
                    Card ac = new Card(superPower,aiValue[b]-1);
                    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + ac.getImage()))); // Middle Card
                    intialValue=aiValue[b];
                    intialSuit=aiSuit[b];
                    temp1=intialSuit;
                    temp2=intialValue;
                    aiValue[b] = -1;
                    aiSuit[b] = "empty";
                    
                    //checking if ai won
                    int check=0;
                    for(int c=0;c<25;c++)
                    {
                        if(aiValue[c]==-1)
                        check++;
                    }
                    if(check==25)
                    {
                        for(int h=0;h<25;h++)
                        {
                            if(humanValue[h]>0)
                            {
                                playerScore=playerScore+humanValue[h];
                            }
                        }
                        
                        AIWinnerScreen awin = new AIWinnerScreen(playerScore,name);
                        awin.setVisible(true);
                        dispose();
                    }
                    drop1=1;
                    
                    break;
        }      }
            if(drop1==1)
            {
                
                if(temp2==5)
                {
                 System.out.println("*********Super Power******");   
                    Random rn = new Random();
                    int sPower = rn.nextInt(4);
                    System.out.println("sPower : "+sPower);   
                    
                    if(sPower==0)
                    {
                        intialSuit="Spades";
                        jLabel14.setVisible(true);
                        jLabel14.setText("Please drop "+intialSuit+" card");
                    }
                    else if(sPower==1)
                    {
                        intialSuit="Diamonds";
                        jLabel14.setVisible(true);
                        jLabel14.setText("Please drop "+intialSuit+" card");
                    }
                    else if(sPower==2)
                    {
                        intialSuit="Hearts";
                        jLabel14.setVisible(true);
                        jLabel14.setText("Please drop "+intialSuit+" card");
                    }
                    else
                    {
                        intialSuit="Clubs";
                        jLabel14.setVisible(true);
                        jLabel14.setText("Please drop "+intialSuit+" card");
                    }
                    intialValue=100;
                }
               
                
            }
            else
            {
              
                Card c21 = dc.deck.get(i);
                i++;
                aiValue[ai]=c21.getValue();
                aiSuit[ai]=c21.getSuit();
                ai++;
           
             System.out.println("picks as card unmatched with value v:"+aiValue[ai-1]);
             System.out.println("picks as card unmatched with suit S:"+aiSuit[ai-1]);
        }
    }
    
    //checking if human won
    public void checkWinner()
    {
        int check=0;
        for(int b=0;b<25;b++)
        {
            if(humanValue[b]==-1)
               check++;
        }
        if(check==25)
        {
            for(int h=0;h<25;h++)
            {
                if(aiValue[h]>0)
                {
                    hostScore=hostScore+aiValue[h];
                }
            }
                        
            WinnerScreen win = new WinnerScreen(hostScore,name);
            win.setVisible(true);
            dispose();
        }
    }
    public void dropCard(int button)
    {
       
      // System.out.println("pValue: "+pValue);
        jLabel14.setVisible(false);
        //present values
        value1=humanValue[button-1];
        suit1=humanSuit[button-1];
           
       if(suit1=="Spades")
           superPower=0;
       else if(suit1=="Diamonds")
           superPower=1;
       else if(suit1=="Hearts")
           superPower=2;
       else if(suit1=="Clubs")
           superPower=3;
    
        Card dc = new Card(superPower,value1-1);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + dc.getImage()))); // Middle Card
        humanValue[button-1]=-1;
        humanSuit[button-1]="empty";
        checkWinner();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 240, 70, 96);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N
        jLabel6.setText("jLabel5");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 260, 70, 70);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N
        jLabel7.setText("jLabel5");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 210, 70, 96);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N
        jLabel8.setText("jLabel5");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 180, 70, 96);

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("AI Player 1");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 90, 120, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, 490, 140, 30);

        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(550, 360, 70, 100);

        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(520, 360, 70, 100);

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(490, 360, 70, 100);

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(460, 360, 70, 100);

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(430, 360, 70, 100);

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(400, 360, 70, 100);

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(370, 360, 70, 100);

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(340, 360, 70, 100);

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(310, 360, 70, 100);

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(280, 360, 70, 100);

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(250, 360, 70, 100);

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(220, 360, 70, 100);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(480, 220, 70, 100);

        jButton3.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Instructions");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(0, 10, 190, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(350, 220, 70, 100);

        jButton1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(750, 0, 100, 30);

        jLabel12.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Please Drop the correct Card");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(260, 330, 330, 20);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/S.PNG"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(270, 170, 40, 30);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/D.PNG"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17);
        jButton17.setBounds(340, 170, 40, 30);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/H.PNG"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18);
        jButton18.setBounds(400, 170, 40, 30);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/C.PNG"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19);
        jButton19.setBounds(460, 170, 40, 30);

        jLabel13.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Super Power!!!! Nominate a suit ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(210, 100, 360, 50);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(90, 200, 200, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/card-2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -40, 860, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Deck
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(bt.isEmpty())
        {
            jLabel12.setVisible(false);
            jLabel14.setVisible(false);
            if(!(jButton13.isVisible()))
            {
                jButton13.setVisible(true);
                Card card1 = dc.deck.get(i);
                i++;
                humanValue[0]=card1.getValue();
                humanSuit[0]=card1.getSuit();
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card1.getImage())));
                              
            }
            else if(!(jButton12.isVisible()))
            {
                jButton12.setVisible(true);
                Card card2 = dc.deck.get(i);
                i++;
                humanValue[1]=card2.getValue();
                humanSuit[1]=card2.getSuit();
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card2.getImage())));
                       
            }
            else if(!(jButton11.isVisible()))
            {
                jButton11.setVisible(true);
                Card card3 = dc.deck.get(i);
                i++;
                humanValue[2]=card3.getValue();
                humanSuit[2]=card3.getSuit();
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card3.getImage())));
                       
            }
            else if(!(jButton10.isVisible()))
            {
                jButton10.setVisible(true);
                Card card4 = dc.deck.get(i);
                i++;
                humanValue[3]=card4.getValue();
                humanSuit[3]=card4.getSuit();
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + card4.getImage())));
                       
            }
            else if(!(jButton9.isVisible()))
            {
                jButton9.setVisible(true);
                Card c5 = dc.deck.get(i);
                i++;
                humanValue[4]=c5.getValue();
                humanSuit[4]=c5.getSuit();
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c5.getImage())));
                       
            }
            else if(!(jButton8.isVisible()))
            {
                jButton8.setVisible(true);
                Card c6 = dc.deck.get(i);
                i++;
                humanValue[5]=c6.getValue();
                humanSuit[5]=c6.getSuit();
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c6.getImage())));
                       
            }
            else if(!(jButton7.isVisible()))
            {
                jButton7.setVisible(true);
                Card c7 = dc.deck.get(i);
                i++;
                humanValue[6]=c7.getValue();
                humanSuit[6]=c7.getSuit();
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c7.getImage())));
                       
            }
            else if(!(jButton6.isVisible()))
            {
                jButton6.setVisible(true);
                Card c8 = dc.deck.get(i);
                i++;
                humanValue[7]=c8.getValue();
                humanSuit[7]=c8.getSuit();
                jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c8.getImage())));
                       
            }
            else if(!(jButton5.isVisible()))
            {
                jButton5.setVisible(true);
                Card c9 = dc.deck.get(i);
                i++;
                humanValue[8]=c9.getValue();
                humanSuit[8]=c9.getSuit();
                jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c9.getImage())));
                       
            }
            else if(!(jButton4.isVisible()))
            {
                jButton4.setVisible(true);
                Card c10 = dc.deck.get(i);
                i++;
                humanValue[9]=c10.getValue();
                humanSuit[9]=c10.getSuit();
                jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c10.getImage())));
                       
            }
            else if(!(jButton15.isVisible()))
            {
                jButton15.setVisible(true);
                Card c11 = dc.deck.get(i);
                i++;
                humanValue[10]=c11.getValue();
                humanSuit[10]=c11.getSuit();
                jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c11.getImage())));
                       
            }
            else if(!(jButton14.isVisible()))
            {
                jButton14.setVisible(true);
                Card c12 = dc.deck.get(i);
                i++;
                humanValue[11]=c12.getValue();
                humanSuit[11]=c12.getSuit();
                jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c12.getImage())));
                       
            }
        }
        else
        {
        if(bt.get(0)==5)
        {
            jButton9.setVisible(true);
            Card c5 = dc.deck.get(i);
            i++;
            humanValue[4]=c5.getValue();
            humanSuit[4]=c5.getSuit();
         //   intialSuit=c8.getSuit();
         //   intialValue=c8.getValue();
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c5.getImage())));
            bt.remove(0);
        }
        
        else if(bt.get(0)==6)
        {
            jButton8.setVisible(true);
            Card c6 = dc.deck.get(i);
            i++;
            humanValue[5]=c6.getValue();
            humanSuit[5]=c6.getSuit();
         //   intialSuit=c8.getSuit();
         //   intialValue=c8.getValue();
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c6.getImage())));
            bt.remove(0);
        }
        
        else if(bt.get(0)==7)
        {
            jButton7.setVisible(true);
            Card c7 = dc.deck.get(i);
            i++;
            humanValue[6]=c7.getValue();
            humanSuit[6]=c7.getSuit();
         //   intialSuit=c8.getSuit();
         //   intialValue=c8.getValue();
            jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c7.getImage())));
            bt.remove(0);
        }
        
        else if(bt.get(0)==8)
        {
            jButton6.setVisible(true);
            Card c8 = dc.deck.get(i);
            i++;
            humanValue[7]=c8.getValue();
            humanSuit[7]=c8.getSuit();
         //   intialSuit=c8.getSuit();
         //   intialValue=c8.getValue();
            jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c8.getImage())));
            bt.remove(0);
        }
        else if(bt.get(0)==9)
        {
            jButton5.setVisible(true);
            Card c9 = dc.deck.get(i);
            i++;
            humanValue[8]=c9.getValue();
            humanSuit[8]=c9.getSuit();
          //  intialSuit=c9.getSuit();
          //  intialValue=c9.getValue();
            jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c9.getImage())));
            bt.remove(0);
        }
        else if(bt.get(0)==10)
        {
            jButton4.setVisible(true);
            Card c10 = dc.deck.get(i);
            i++;
            humanValue[9]=c10.getValue();
            humanSuit[9]=c10.getSuit();
        //    intialSuit=c10.getSuit();
        //    intialValue=c10.getValue();
            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c10.getImage())));
            bt.remove(0);
        }
        else if(bt.get(0)==11)
        {
            jButton15.setVisible(true);
            Card c11 = dc.deck.get(i);
            i++;
            humanValue[10]=c11.getValue();
            humanSuit[10]=c11.getSuit();
        //    intialSuit=c11.getSuit();
        //    intialValue=c11.getValue();
            jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c11.getImage())));
            bt.remove(0);
        }
        else if(bt.get(0)==12)
        {
            jButton14.setVisible(true);
            Card c12 = dc.deck.get(i);
            i++;
            humanValue[11]=c12.getValue();
            humanSuit[11]=c12.getSuit();
        //    intialSuit=c12.getSuit();
        //    intialValue=c12.getValue();
            jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + c12.getImage())));
            bt.remove(0);
        }}
       aiDrop(); 
    }//GEN-LAST:event_jButton2ActionPerformed
    // Quit Button 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          MainScreen main = new MainScreen();
          main.setVisible(true);
          
          dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void superPower()
    {
        intialValue=pValue;
           intialSuit=playerSuit;
           temp3=intialSuit;
     
              jButton16.setVisible(true);
              jButton17.setVisible(true);
              jButton18.setVisible(true);
              jButton19.setVisible(true);
              jLabel13.setVisible(true); 
        
    }

// First Card
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        // TODO add your handling code here:
       // System.out.println("intialValue: "+intialValue);
       jLabel12.setVisible(false);
       pValue=humanValue[0];
       playerSuit=humanSuit[0];
       if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
       if(pValue==5)
       {
           dropCard(1);
           superPower();           
           jButton13.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {    
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(1);
           jButton13.setVisible(false);   
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
                 
        
    }//GEN-LAST:event_jButton13ActionPerformed
    // Instructions Button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        GameInstructions gameins = new GameInstructions();
        gameins.setVisible(true);
        
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        //System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[11];
       playerSuit=humanSuit[11];
       if(pValue==5)
       {
           dropCard(12);
           superPower();           
           jButton14.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(12);
           jButton14.setVisible(false);   
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
      
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        //System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[2];
       playerSuit=humanSuit[2];
       if(pValue==5)
       {
           dropCard(3);
           superPower();           
           jButton11.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(3);
           jButton11.setVisible(false); 
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
        
       
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        //System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
       jLabel12.setVisible(false);
       pValue=humanValue[1];
       playerSuit=humanSuit[1];
       if(pValue==5)
       {
           dropCard(2);
           superPower();           
           jButton12.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
            intialValue=pValue;
            intialSuit=playerSuit;
            dropCard(2);
            jButton12.setVisible(false);  
            aiDrop();
       }
       else
           jLabel12.setVisible(true);
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
       // System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[3];
       playerSuit=humanSuit[3];
       if(pValue==5)
       {
           dropCard(4);
           superPower();           
           jButton10.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(4);
           jButton10.setVisible(false);  
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
       // System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[4];
       playerSuit=humanSuit[4];
       if(pValue==5)
       {
           dropCard(5);
           superPower();           
           jButton9.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(5);
           jButton9.setVisible(false);     
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       // System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[5];
       playerSuit=humanSuit[5];
       if(pValue==5)
       {
           dropCard(6);
           superPower();           
           jButton8.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(6);
           jButton8.setVisible(false);     
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
   
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
       // System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[6];
       playerSuit=humanSuit[6];
       if(pValue==5)
       {
           dropCard(7);
           superPower();           
           jButton7.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(7);
           jButton7.setVisible(false);     
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[7];
       playerSuit=humanSuit[7];
       if(pValue==5)
       {
           dropCard(8);
           superPower();           
           jButton6.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(8);
           jButton6.setVisible(false);   
           aiDrop();
       }
       else
           jLabel12.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[8];
       playerSuit=humanSuit[8];
       if(pValue==5)
       {
           dropCard(9);
           superPower();           
           jButton5.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(9);
           jButton5.setVisible(false);  
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       // System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[9];
       playerSuit=humanSuit[9];
       if(pValue==5)
       {
           dropCard(10);
           superPower();           
           jButton4.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(10);
           jButton4.setVisible(false);       
           aiDrop();
       }
       else
           jLabel12.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        //System.out.println("intialValue: "+intialValue);
        if(intialValue==120)
        {
            intialValue=temp;
            intialSuit=temp3;
        }
         jLabel12.setVisible(false);
       pValue=humanValue[10];
       playerSuit=humanSuit[10];
       if(pValue==5)
       {
           dropCard(11);
           superPower();           
           jButton15.setVisible(false);   
       }
       else if(pValue==intialValue || playerSuit==intialSuit)
       {
           intialValue=pValue;
           intialSuit=playerSuit;
           dropCard(11);
           jButton15.setVisible(false);   
           aiDrop();
       }
       else
           jLabel12.setVisible(true);
     
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        intialSuit="Spades";
        temp=intialValue;
        
        intialValue=120;
        aiDrop();
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
        jLabel13.setVisible(false);
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        intialSuit="Diamonds";
        temp=intialValue;
        intialValue=120;
        aiDrop();
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
        jLabel13.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        intialSuit="Hearts";
        temp=intialValue;
        intialValue=120;
        aiDrop();
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
        jLabel13.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        intialSuit="Clubs";
        temp=intialValue;
        intialValue=120;
        aiDrop();
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
        jLabel13.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TwoPlayers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TwoPlayers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TwoPlayers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TwoPlayers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
       //         new TwoPlayers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
