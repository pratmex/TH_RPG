package pratmex;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RandomPasswordGenerator {
	
	private String[] numbers;
	private char[] characters;
	private char tempChar;
	private int i;
	private int j;
	private int[] symbols;
	
	private JFrame frame;
	
	private JTextField text;
	
	private JComboBox<String> box;
	
	private JButton button;
	
	private JLabel lengthLabel;
	private JLabel uppercaseLabel;
	private JLabel lowercaseLabel;
	private JLabel numberLabel;
	private JLabel symbolLabel;
	
	private JCheckBox uppercaseCheckBox;
	private JCheckBox lowercaseCheckBox;
	private JCheckBox numberCheckBox;
	private JCheckBox symbolCheckBox;
	
	private Random random;
	
	
	private void randomPasswordGenerator() {
		
		numbers = new String[18];
		//error -> array constants can be used with initializers only
		symbols = new int[5];
		
		symbols[0] = 35;
		symbols[1] = 36;
		symbols[2] = 38;
		symbols[3] = 64;
		symbols[4] = 95;
		
		for(i = 0; i < 18; i++) {
			numbers[i] = String.valueOf(i + 8);
		}
		
		frame = new JFrame();
		
		text = new JTextField();
		
		lengthLabel = new JLabel();
		uppercaseLabel = new JLabel();
		lowercaseLabel = new JLabel();
		numberLabel = new JLabel();
		symbolLabel = new JLabel();
		
		uppercaseCheckBox = new JCheckBox();
		lowercaseCheckBox = new JCheckBox();
		numberCheckBox = new JCheckBox();
		symbolCheckBox = new JCheckBox();
		
		box = new JComboBox<String>(numbers);
		
		button = new JButton();
		
		random = new Random();
		
		text.setBounds(100, 70, 550, 50);
		text.setBorder(BorderFactory.createEmptyBorder());
		text.setFont(new Font("consolas", Font.PLAIN,35));
		
		box.setBounds(100, 150, 60, 35);
		box.setFont(new Font("consolas", Font.BOLD,25));
		box.setBorder(BorderFactory.createEmptyBorder());
		box.setFocusable(false);
		box.setForeground(new Color(0x00165A));
		box.setBackground(new Color(0x73C2FB));
		
		lengthLabel.setText("is the selected length");
		lengthLabel.setFont(new Font("consolas",Font.PLAIN,30));
		lengthLabel.setForeground(Color.WHITE);
		lengthLabel.setBounds(190, 155, 400, 35);
		
		uppercaseCheckBox.setBounds(110, 217, 30, 30);
		uppercaseCheckBox.setBackground(new Color(0x00165A));
		uppercaseCheckBox.setFocusable(false);
		
		lowercaseCheckBox.setBounds(110, 267, 30, 30);
		lowercaseCheckBox.setBackground(new Color(0x00165A));
		lowercaseCheckBox.setFocusable(false);
		
		numberCheckBox.setBounds(110, 317, 30, 30);
		numberCheckBox.setBackground(new Color(0x00165A));
		numberCheckBox.setFocusable(false);
		
		symbolCheckBox.setBounds(110, 367, 30, 30);
		symbolCheckBox.setBackground(new Color(0x00165A));
		symbolCheckBox.setFocusable(false);
		
		uppercaseLabel.setText("Add Uppercase (A-Z)");
		uppercaseLabel.setBounds(150, 220, 350, 35);
		uppercaseLabel.setFont(new Font("consolas",Font.PLAIN,30));
		uppercaseLabel.setForeground(Color.WHITE);
		
		lowercaseLabel.setText("Add Lowercase (a-z)");
		lowercaseLabel.setBounds(150, 270, 350, 35);
		lowercaseLabel.setFont(new Font("consolas",Font.PLAIN,30));
		lowercaseLabel.setForeground(Color.WHITE);
		
		numberLabel.setText("Add Numbers (0-9)");
		numberLabel.setBounds(150, 320, 350, 35);
		numberLabel.setFont(new Font("consolas",Font.PLAIN,30));
		numberLabel.setForeground(Color.WHITE);
		
		symbolLabel.setText("Add Symbols (#, $, &, @, _)");
		symbolLabel.setBounds(150, 370, 470, 35);
		symbolLabel.setFont(new Font("consolas",Font.PLAIN,30));
		symbolLabel.setForeground(Color.WHITE);
		
		button.setText("GENERATE PASSWORD");
		button.setBounds(210, 435, 330, 40);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setFocusable(false);
		button.setBackground(new Color(0x22DD22));
		button.setFont(new Font("consolas",Font.BOLD,30));
		button.setForeground(new Color(0x00165A));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characters = new char[Integer.parseInt((String)box.getSelectedItem())];
				
				//only uppercase
				if(uppercaseCheckBox.isSelected()) {
					for(i = 0; i < characters.length; i++) {
						characters[i] = (char)random.nextInt(65,91);
					}
					
					for(i = 0; i < characters.length; i++) {
						j = random.nextInt(characters.length);
						tempChar = characters[j];
						characters[j] = characters[i];
						characters[i] = tempChar;	
					}
					
					text.setText(String.valueOf(characters));
				}
				
				//only lowercase
				if(lowercaseCheckBox.isSelected()) {
					for(i = 0; i < characters.length; i++) {
						characters[i] = (char)random.nextInt(97,123);
					}
					
					for(i = 0; i < characters.length; i++) {
						j = random.nextInt(characters.length);
						tempChar = characters[j];
						characters[j] = characters[i];
						characters[i] = tempChar;	
					}
					text.setText(String.valueOf(characters));
				}
				
				//only numbers or symbols
				if(numberCheckBox.isSelected() || symbolCheckBox.isSelected()) {
					text.setText("can't generate!");
				}
				
				//uppercase and lowercase
				if(uppercaseCheckBox.isSelected() && lowercaseCheckBox.isSelected()) {
					for(i = 0; i < (characters.length / 2); i++) {
						characters[i] = (char)random.nextInt(65,91);
					}
					for(i = (characters.length / 2); i < characters.length; i++) {
						characters[i] = (char)random.nextInt(97,123);
					}
					
					for(i = 0; i < characters.length; i++) {
						j = random.nextInt(characters.length);
						tempChar = characters[j];
						characters[j] = characters[i];
						characters[i] = tempChar;	
					}
					text.setText(String.valueOf(characters));
				}
				
				//uppercase and numbers
				if(uppercaseCheckBox.isSelected() && numberCheckBox.isSelected()) {
					if(characters.length < 16) {
						for(i = 0; i < (characters.length - 3); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = (characters.length - 3); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(48, 58);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if(characters.length > 15) {
						for(i = 0; i < (characters.length - 5); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = (characters.length - 5); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(48, 58);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
				}
				
				//lowercase and numbers
				if(lowercaseCheckBox.isSelected() && numberCheckBox.isSelected()) {
					if(characters.length < 16) {
						for(i = 0; i < (characters.length - 3); i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = (characters.length - 3); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(48, 58);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if(characters.length > 15) {
						for(i = 0; i < (characters.length - 5); i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = (characters.length - 5); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(48, 58);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
				}
				
				
				//uppercase and symbols
				if(uppercaseCheckBox.isSelected() && symbolCheckBox.isSelected()) {
					for(i = 0; i < (characters.length - 3); i++) {
						characters[i] = (char)random.nextInt(65,91);
					}
					for(i = (characters.length - 3); i < characters.length; i++) {
						characters[i] = (char)symbols[random.nextInt(symbols.length)];
					}
					for(i = 0; i < characters.length; i++) {
						j = random.nextInt(characters.length);
						tempChar = characters[j];
						characters[j] = characters[i];
						characters[i] = tempChar;	
					}
					text.setText(String.valueOf(characters));
				}
				
				//lowercase and symbols
				if(lowercaseCheckBox.isSelected() && symbolCheckBox.isSelected()) {
					for(i = 0; i < (characters.length - 3); i++) {
						characters[i] = (char)random.nextInt(97,123);
					}
					for(i = (characters.length - 3); i < characters.length; i++) {
						characters[i] = (char)symbols[random.nextInt(symbols.length)];
					}
					for(i = 0; i < characters.length; i++) {
						j = random.nextInt(characters.length);
						tempChar = characters[j];
						characters[j] = characters[i];
						characters[i] = tempChar;	
					}
					text.setText(String.valueOf(characters));
				}
				
				//uppercase, lowercase, numbers
				if(uppercaseCheckBox.isSelected() && lowercaseCheckBox.isSelected() && numberCheckBox.isSelected()) {
					if(characters.length < 11) {
						characters[0] = (char)random.nextInt(48,58);
						characters[1] = (char)random.nextInt(48,58);
						
						for(i = 2; i < (characters.length - 3); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						
						for(i = (characters.length - 3); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if((characters.length > 10) && (characters.length < 21)) {
						for(i = 0; i < 3; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 3; i < (characters.length / 2); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = (characters.length / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if(characters.length > 20) {
						for(i = 0; i < 5; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 5; i < (characters.length / 2); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = (characters.length / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
				}
				
				//uppercase, lowercase, symbols
				if(uppercaseCheckBox.isSelected() && lowercaseCheckBox.isSelected() && symbolCheckBox.isSelected()) {
					if(characters.length < 11) {
						characters[0] = (char)symbols[random.nextInt(symbols.length)];
						characters[1] = (char)symbols[random.nextInt(symbols.length)];
						
						for(i = 2; i < (characters.length / 2); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						
						for(i = (characters.length / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if((characters.length > 10) && (characters.length < 21)) {
						for(i = 0; i < 3; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 3; i < (characters.length / 2); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = (characters.length / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if(characters.length > 20) {
						for(i = 0; i < 5; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 5; i < (characters.length / 2); i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = (characters.length / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
				}
				
				//lowercase, numbers, symbols
				if(lowercaseCheckBox.isSelected() && numberCheckBox.isSelected() && symbolCheckBox.isSelected()) {
					if(characters.length < 11) {
						for(i = 0; i < 2; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 2; i < 5; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 5; i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
						
					}
					
					if((characters.length > 10) && (characters.length < 21)) {
						for(i = 0; i < 3; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 3; i < 6; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 6; i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if(characters.length > 20) {
						for(i = 0; i < 4; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 4; i < 7; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 7; i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
				}
				
				//all checkboxes are selected
				if(uppercaseCheckBox.isSelected() && lowercaseCheckBox.isSelected() && numberCheckBox.isSelected() && symbolCheckBox.isSelected()) {
					if(characters.length < 11) {
						characters[0] = (char)random.nextInt(48,58);
						characters[1] = (char)symbols[random.nextInt(symbols.length)];
						
						for(i = 2; i < 5; i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						for(i = 5; i < characters.length; i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
						
					}
					
					if((characters.length > 10) && (characters.length < 21)) {
						for(i = 0; i < 3; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 3; i < 6; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 6; i < ((characters.length - 6) / 2); i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 6 + ((characters.length - 6) / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
					
					if(characters.length > 20) {
						for(i = 0; i < 5; i++) {
							characters[i] = (char)random.nextInt(48,58);
						}
						for(i = 5; i < 10; i++) {
							characters[i] = (char)symbols[random.nextInt(symbols.length)];
						}
						for(i = 10; i < 10 + ((characters.length - 10) / 2); i++) {
							characters[i] = (char)random.nextInt(97,123);
						}
						for(i = 10 + ((characters.length - 10) / 2); i < characters.length; i++) {
							characters[i] = (char)random.nextInt(65,91);
						}
						
						for(i = 0; i < characters.length; i++) {
							j = random.nextInt(characters.length);
							tempChar = characters[j];
							characters[j] = characters[i];
							characters[i] = tempChar;	
						}
						text.setText(String.valueOf(characters));
					}
				}
			}

		});
		
		frame.setTitle("Random Password Generator");
		frame.setSize(750,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0x00165A));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(text);
		frame.add(box);
		frame.add(uppercaseCheckBox);
		frame.add(lowercaseCheckBox);
		frame.add(numberCheckBox);
		frame.add(symbolCheckBox);
		frame.add(lengthLabel);
		frame.add(uppercaseLabel);
		frame.add(lowercaseLabel);
		frame.add(numberLabel);
		frame.add(symbolLabel);
		frame.add(button);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		RandomPasswordGenerator rpg = new RandomPasswordGenerator();
		rpg.randomPasswordGenerator();
	}
	
}
