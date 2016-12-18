import model.*;
import javax.swing.*;
import java.awt.event.*;
public class ControlPanel extends JPanel
{   
	private Concert concert;
   	/*
		declare the GUI components
		Hint: use ControlPanel for the buttons 
		?????????BUTTON?????????????4???
		Setband, SetPrice, Sell & Exit
	*/

	private JButton btn_band = new JButton("Set Band");
	private JButton btn_price = new JButton("Set Price");
	private JButton btn_sell = new JButton("Sell");
	private JButton btn_exit = new JButton("Exit");
	
	public ControlPanel(Concert concert)
	{   
		this.concert = concert;
        //setup & build needed here
		setup();
		build();
        //add the components and set the listeners
		
	}
	//setup????????GUI????????
	private void setup()
	{
		btn_band.addActionListener(new BandListener(concert.band()));
		btn_price.addActionListener(new PriceListener(concert.stadium()));
		btn_sell.addActionListener(new SaleListener(concert.stadium()));
		btn_exit.addActionListener(new ExitListener());
	}
	//build???????GUI???JPanel???
	private void build()
	{	
		add(btn_band);
		add(btn_price);
		add(btn_sell);
		add(btn_exit);

	}
    //////inner class
	private class BandListener implements ActionListener
	{   
        private Band band;
    
        public BandListener(Band band)
        {   
           this.band = band;   
        }
        public void actionPerformed(ActionEvent e)
        {   
            new BandWindow(band);   
        }
    }
    //////inner class
	private class PriceListener implements ActionListener
	{   
        private Stadium stadium;
    
        public PriceListener(Stadium stadium)
        {   
           this.stadium = stadium;   
        }
        public void actionPerformed(ActionEvent e)
        {   
            new PriceWindow(stadium);   
        }
    }
    //////inner class
	private class SaleListener implements ActionListener
	{   
        private Stadium stadium;
    
        public SaleListener(Stadium stadium)
        {   
           this.stadium = stadium;   
        }
        public void actionPerformed(ActionEvent e)
        {   
            new SaleWindow(stadium);   
        }
    }
   ////inner class
	private class ExitListener implements ActionListener
	{
        public void actionPerformed(ActionEvent e)
        {   
            System.exit(0);
        }
    }
}

