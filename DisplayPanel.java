import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class DisplayPanel extends JPanel implements MyObserver//??Obersever??
{   
    private Concert concert;
    /*
     *  add GUI components
     *  DisplayPanel for the JLabels and JTextFields
     *  ?????? Label???? ? TextField ????????...
     *  ??... <(???)/ 
     */
    //??? ...
    private JTextField t_income = new JTextField(10);
    private JTextField t_cost = new JTextField(10);
    private JTextField t_profit = new JTextField(10);
    //?? ...
    private JLabel lb_income = new JLabel("Income $");
    private JLabel lb_cost = new JLabel("Cost $");
    private JLabel lb_profit = new JLabel("Profit $");
    
    public DisplayPanel(Concert concert)
    {   
        this.concert = concert; //?? ????(?????NULL) Orz
        //attach Observer to Concert
        concert.attach(this);//??????(?????Model??)
        //attach Observer to Band    
        concert.band().attach(this);
        //attach Observer to Stadium
        concert.stadium().attach(this);
        //attach Observer to each Seat
        for(Seat seats : concert.stadium().seats()) //seats????????foreach
            seats.attach(this);
         
        //call setup and build
        setup();
        //to add components to the panel
        build();
    }
    private void setup()
    {
        //??????????? ...
    }
    private void build()
    {
        //??GUI???JPanel??
        add(lb_income);
        add(t_income);
        add(lb_cost);
        add(t_cost);
        add(lb_profit);
        add(t_profit);
    }
    public void update()
    {
        //??Observer??
        System.out.println("update() called");
        t_income.setText(concert.income());
        t_cost.setText(concert.cost());
        t_profit.setText(concert.profit());
    }
   
}

