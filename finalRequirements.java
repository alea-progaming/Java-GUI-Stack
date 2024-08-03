import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class finalRequirements implements ActionListener  {
	String [] [] data = {
			{"7",""},
			{"6",""},
			{"5",""},
			{"4",""},
			{"3",""},
			{"2",""},
			{"1",""},
			{"0",""},
			};
	String row [] = {" ", " "};
	
	int emptyCTR=7;
	int ctr =7;	
	JFrame frame;
	JButton push;
	JTextField message;
	JButton pop;
	JTable table;
	JLabel emptyMessage;
	JButton top;
	JLabel topMessage;
	JLabel overflowMessage;	
	JLabel menu;
	JLabel enter;
	
	public finalRequirements() {
			
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("GUI Stack");
		
		frame.setSize(500,300);
		frame.setVisible(true);
		
		message = new JTextField();
		message.setBounds(150, 100, 135, 30);
		message.addActionListener(null);
				
		enter = new JLabel();		
		enter.setText("Enter a Number: ");
		enter.setBounds(50, 100, 100, 30);
				
		push = new JButton();
		push.setBounds(50,50,75,30);
		push.addActionListener(this);
		push.setText("Push");
		push.setFocusable(false);
				
		pop = new JButton();
		pop.setBounds(130,50,75,30);
		pop.addActionListener(this);
		pop.setText("Pop");
		pop.setFocusable(false);
		
		top = new JButton();
		top.setBounds(210,50,75,30);
		top.addActionListener(this);
		top.setText("Top");
		top.setFocusable(false);
		
		emptyMessage = new JLabel("Error: The stack is empty.");
		emptyMessage.setBounds(50, 130, 150, 30);
		emptyMessage.setVisible(false);
				
		topMessage = new JLabel();
		topMessage.setBounds(50, 130, 150, 30);
		topMessage.setVisible(false);
		
		overflowMessage = new JLabel("Error: Stack Overflow.");
		overflowMessage.setBounds(50, 130, 150, 30);
		overflowMessage.setVisible(false);
		
		menu = new JLabel();
		menu.setText("Press the button.");
		menu.setBounds(50,20,100,30);
			
		table = new JTable(data,row);
		table.setBounds(300, 50, 150, 130);
		table.setBackground(Color.LIGHT_GRAY);
		
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);  
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
		frame.add(enter);
		frame.add(message);
		frame.add(push);
		frame.add(table);
		frame.add(pop);
		frame.add(emptyMessage);
		frame.add(top);
		frame.add(topMessage);
		frame.add(overflowMessage);	
		frame.add(menu);
	}

	public static void main(String[] args) {
		
		new finalRequirements();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==push) {
			if (ctr==-1) {
				overflowMessage.setVisible(true);
			}else {				
			emptyMessage.setVisible(false);
			topMessage.setVisible(false);		
			String input =message.getText();		
			data[ctr][1]=input;
			table.updateUI();
			ctr--;	
			}
		}
		if (e.getSource()==pop) {			
			if (ctr==emptyCTR) {
			overflowMessage.setVisible(false);	
			topMessage.setVisible(false);	
			emptyMessage.setVisible(true);
			}else {
			overflowMessage.setVisible(false);	
			topMessage.setVisible(false);
			ctr++;
			data[ctr][1]=" ";
			table.updateUI();
			}
		}
		if (e.getSource()==top) {
			
			if (ctr== emptyCTR) {
				overflowMessage.setVisible(false);
				emptyMessage.setVisible(true);
				topMessage.setVisible(false);
			}else {				
			ctr++;
			String  topValue = (String) data [ctr][1];
			topMessage.setText( "Top Value is " +topValue);
			overflowMessage.setVisible(false);
			emptyMessage.setVisible(false);
			topMessage.setVisible(true);
			ctr--;
			}
		}	
	}
}
