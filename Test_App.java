import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Which of these is the Capital of UAE");
			radioButton[0].setText("Dubai");
			radioButton[1].setText("Abu Dhabi");
			radioButton[2].setText("Fujera");
			radioButton[3].setText("Ras-al-Khaimah");
		}
		if (current == 1) {
			label.setText("Que2:  Who created this Application?");
			radioButton[0].setText("Bill Gates");
			radioButton[1].setText("Maroor Chethan Pai");
			radioButton[2].setText("Elon Musk");
			radioButton[3].setText("Anupam Mittal");
		}
		if (current == 2) {
			label.setText("Que3: What would be the heart rate of a person if the cardiac output is 5 L, blood volume in the ventricles at the end of diastole is 100 mL and at the end of ventricular systole is 50 mL?");
			radioButton[0].setText("100 beats per minute");
			radioButton[1].setText("70 beats per minute");
			radioButton[2].setText("92 beats per minute");
			radioButton[3].setText("The person has died :( ");
		}
		if (current == 3) {
			label.setText("Que4: Which is The host country of G20 summit this year?");
			radioButton[0].setText("Brazil");
			radioButton[1].setText("Indonasia");
			radioButton[2].setText("India");
			radioButton[3].setText("China");
		}
		if (current == 4) {
			label.setText("Que5:  What is the Parent company of ChatGBT");
			radioButton[0].setText("OpenAI");
			radioButton[1].setText("Microsoft");
			radioButton[2].setText("Meta");
			radioButton[3].setText("NeuroLink");
		}
		if (current == 5) {
			label.setText("Que6: How to read entire file in one line using java 8?");
			radioButton[0].setText("Files.readAllLines()");
			radioButton[1].setText("Files.read()");
			radioButton[2].setText("Files.readFile()");
			radioButton[3].setText("Files.lines()");
		}
		if (current == 6) {
			label.setText("Que7:  Hydrolysis of Sucrose is catalysed by");
			radioButton[0].setText("H+");
			radioButton[1].setText("enzymes");
			radioButton[2].setText("Mineral acids");
			radioButton[3].setText("all of the above");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following people are not a part of Mahabharata?");
			radioButton[0].setText("Ghatotkatcha");
			radioButton[1].setText("Hanuman");
			radioButton[2].setText("Khumbhakaran");
			radioButton[3].setText("Pandu");
		}
		if (current == 8) {
			label.setText("Que9: Which of the following was formed in S.Miller's experiment?");
			radioButton[0].setText("amino acids");
			radioButton[1].setText("lipids");
			radioButton[2].setText("UV radiations");
			radioButton[3].setText("Nucliec acid");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a Environmental Burden?");
			radioButton[0].setText("Oligotrophication");
			radioButton[1].setText("Eutrophication");
			radioButton[2].setText("dystrophy");
			radioButton[3].setText("None of the above");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[3].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Champaion's Online Test App");
	}

}