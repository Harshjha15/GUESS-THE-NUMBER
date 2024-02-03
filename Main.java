import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


class guess extends JFrame{
int sc=0;
int r=100;
int hig=0;
int l=-1;
int compNumber;
public int isCorrect(){
        if(l > compNumber) {
            return -1;
        }
        else if(l < compNumber)
        {
	return 1;
        }

        else {
            return 0;
        }
    }
    public void Counter(){
        sc++;
    }
guess(String s1){
super(s1);
Random rr = new Random();
 compNumber = rr.nextInt(100)+1 ;
}
guess(){
Random rr = new Random();
compNumber = rr.nextInt(100)+1 ;
}

JButton b1,b2,b3,b4;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1;
void setcomponents(){

setLayout(null);
Cursor c1= new Cursor(Cursor.HAND_CURSOR);
Font f1=new Font("Times New Roman",Font.BOLD,28);
Font f2=new Font("Times New Roman",Font.BOLD,22);
Font f3=new Font("Times New Roman",Font.BOLD,16);

b1=new JButton("NEW GAME");
b2=new JButton("CLEAR");
b3=new JButton("DONE");
b4=new JButton("HINT");
l1=new JLabel("GUESS");
l2=new JLabel("Try to guess correct in minimum moves !");
l3=new JLabel("GUESS THE NUMBER GAME");
l4=new JLabel("( 0-100 )");
l5=new JLabel("");
l6=new JLabel("");
t1=new JTextField();

add(b1);
add(b2);
add(l1);
add(l2);
add(t1);
add(b3);
add(l3);
add(b4);
add(l4);
add(l5);
add(l6);

b1.setCursor(c1);
b2.setCursor(c1);
b3.setCursor(c1);
b4.setCursor(c1);
t1.setCursor(c1);

l1.setFont(f1);
l2.setFont(f3);
l3.setFont(f1);
b1.setFont(f3);
b2.setFont(f3);
b3.setFont(f3);
b4.setFont(f3);
t1.setFont(f1);
l5.setFont(f2);
l6.setFont(f2);

Color  bro   = new Color(196,70,18);
Color  blu   = new Color(10,182,199);
Color  gg   = new Color(5,215,16);
Color tr =new Color(214,70,186);
Color yg =new Color(205,136,7);

l3.setForeground(Color.RED);
b1.setForeground(blu);
b2.setForeground(blu);
b3.setForeground(blu);
b4.setForeground(blu);
t1.setForeground(tr);
l1.setForeground(Color.BLUE);
l4.setForeground(Color.BLUE);
l2.setForeground(yg);
l5.setForeground(gg);
l6.setForeground(gg);


l1.setBounds(100,180,300,50);
l2.setBounds(100,400,450,50);
l3.setBounds(100,30,400,50);
l4.setBounds(120,200,200,50);
l5.setBounds(50,500,250,50);
l6.setBounds(350,500,250,50);
b1.setBounds(40,100,250,50);
b2.setBounds(300,100,250,50);
b3.setBounds(200,250,148,50);
b4.setBounds(352,250,148,50);
t1.setBounds(200,170,300,75);

b1.addActionListener(new restr());
b2.addActionListener(new clr());
b3.addActionListener(new okh());
b4.addActionListener(new hin());
}

class  hin implements ActionListener{
public void actionPerformed(ActionEvent e1){
try{
t1.setText("");
l2.setText("Dont loose Hope Captain :) ");
sc=sc+10;
if(isCorrect()==-1){
JOptionPane.showMessageDialog(null,"Lower number please!");
}
else if(isCorrect()==1){
JOptionPane.showMessageDialog(null,"Higher number please!");
}
}
catch(Exception e){
sc=sc+10;
if(isCorrect()==-1){
JOptionPane.showMessageDialog(null,"Lower number please!");
}
else if(isCorrect()==1){
JOptionPane.showMessageDialog(null,"Higher number please!");
}
}
}
}

class  restr implements ActionListener{
public void actionPerformed(ActionEvent e1){
try{
int s1=Integer.parseInt(t1.getText());
t1.setText("");
l2.setText("Try to guess correct in minimum moves !");
// l2.setText(""+compNumber);
Random rr = new Random();
compNumber = rr.nextInt(100)+1 ;
 sc=0;
 r=100;
 l=-1;
}
catch(Exception e){
Random rr = new Random();
compNumber = rr.nextInt(100)+1 ;
// l2.setText(""+compNumber);
l2.setText("Try to guess correct in minimum moves !");
 sc=0;
r=100;
 l=-1;
}
}
}

class  clr implements ActionListener{
public void actionPerformed(ActionEvent e1){
try{
t1.setText("");
l2.setText("Try to guess correct in minimum moves !");
}
catch(Exception e){}
}
}


class  okh implements ActionListener{
public void actionPerformed(ActionEvent e1){
try{
int s1=Integer.parseInt(t1.getText());
t1.setText("");
if(s1!=compNumber){
l2.setText("Wrong Guess Try Aagain !");
sc++;
l=s1;
}
else{
Font f1=new Font("Times New Roman",Font.BOLD,24);
l2.setFont(f1);
l2.setText("What A Guess YOU WON");
r=r-sc;
l6.setText("Your Score "+r);
if(r>hig){
hig=r;
r=100;
sc=0;
l5.setText("Yeah New Record "+hig);
}
else{
r=100;
sc=0;
l5.setText(" High Score "+hig);
}
JOptionPane.showMessageDialog(null,"Start new game");
Random rr = new Random();
compNumber = rr.nextInt(100)+1 ;
l5.setText(" High Score "+hig);
l6.setText("");
l2.setText("Try to guess correct in minimum moves !");
}

}
catch(Exception e){
l5.setText(" ");
l6.setText("");
}
}
}

public static void main(String args[]){
guess c1=new guess("GUESS THE Number");
c1.setVisible(true);
c1.setSize(600,600);
c1.setcomponents();
c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
