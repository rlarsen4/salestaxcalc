/* Class:	SalesTax
	Name:		Rick Larsen
	Date:		2/28/2013
	Purpose:	Defines sales tax calculator object
*/
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SalesTax extends JFrame
{
	private JPanel panel;
	private JTextField totalSales;
	private JButton calcButton;
	
	// Constants for tax rates
	private final double COUNTY_RATE = 0.02;
	private final double STATE_RATE = 0.04;
	
	// Constants for window size
	private final int WINDOW_WIDTH = 360;
	private final int WINDOW_HEIGHT = 100;
	
	public SalesTax()
	{
		setTitle("Monthly Sales Tax Reporter");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		add(panel);
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}
		
		// buildPanel method creates panel to hold other components
		private void buildPanel()
		{
			JLabel totalSalesMsg = new JLabel("Enter the total sales:");
			
			totalSales = new JTextField(10);
			
			calcButton = new JButton("Calculate Sales Tax");
			
			calcButton.addActionListener(new CalcButtonListener());
			
			panel = new JPanel();
			
			panel.add(totalSalesMsg);
			panel.add(totalSales);
			panel.add(calcButton);
					
		}
		
		private class CalcButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				double totalSalesAmount,
						 countyTaxAmount,
						 stateTaxAmount,
						 totalTaxAmount;
						 
				DecimalFormat dollar = new DecimalFormat("#,##0.00");
				
				totalSalesAmount = Double.parseDouble(totalSales.getText());
				
				countyTaxAmount = totalSalesAmount * COUNTY_RATE;
				
				stateTaxAmount = totalSalesAmount * STATE_RATE;
				
				totalTaxAmount = countyTaxAmount + stateTaxAmount;
				
				JOptionPane.showMessageDialog(null, "County Sales Tax: $" + dollar.format(countyTaxAmount) + "\nState Sales Tax: $" + dollar.format(stateTaxAmount) + "\nTotal Sales Tax: $" + dollar.format(totalTaxAmount));
			}
			
		}
			public static void main(String[] args)
			{
				SalesTax stw = new SalesTax();
			}		
	}
