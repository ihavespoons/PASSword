package password;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.border.TitledBorder;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	private JPanel contentPane;

	private static final long serialVersionUID = 206289167578737777L;

	private static String password = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Launch the application
				try {
					setLookAndFeel();
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		// Frame properties
		setTitle("Random Password Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Center panel
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(0, 2, 0, 0));

		// Controls
		JPanel controls = new JPanel();
		controls.setBorder(new TitledBorder(null, "Controls", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		center.add(controls);
		controls.setLayout(new GridLayout(0, 1, 0, 0));

		// Empty label
		JLabel label_0 = new JLabel("");
		controls.add(label_0);

		// Password length label
		JLabel lengthLabel = new JLabel("Password Length: ");
		controls.add(lengthLabel);

		// Password length spinner
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(8), new Integer(1), null, new Integer(1)));
		controls.add(spinner);

		// Uppercase checkbox
		JCheckBox uppercase = new JCheckBox("Uppercase Letters");
		uppercase.setSelected(true);
		controls.add(uppercase);

		// Lowercase checkbox
		JCheckBox lowercase = new JCheckBox("Lowercase Letters");
		lowercase.setSelected(true);
		controls.add(lowercase);

		// Numbers checkbox
		JCheckBox numbers = new JCheckBox("Numbers");
		numbers.setSelected(true);
		controls.add(numbers);

		// Symbols checkbox
		JCheckBox symbols = new JCheckBox("Symbols");
		symbols.setSelected(true);
		controls.add(symbols);

		// Empty label
		JLabel label_1 = new JLabel("");
		controls.add(label_1);

		// Password scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Generated Password", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		center.add(scrollPane);

		// Password text area
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		// South panel
		JPanel south = new JPanel();
		contentPane.add(south, BorderLayout.SOUTH);

		// Generate button
		JButton generate = new JButton("Generate");
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (uppercase.isSelected() || lowercase.isSelected() || numbers.isSelected() || symbols.isSelected()) {
					password = PasswordGenerator.generate((Integer) spinner.getValue(), uppercase.isSelected(),
							lowercase.isSelected(), numbers.isSelected(), symbols.isSelected());
					textArea.setText(password);
				}
			}
		});
		south.add(generate);

		// Copy button
		JButton Copy = new JButton("Copy");
		Copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(password);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		south.add(Copy);
	}

	private static void setLookAndFeel() {
		// Set Nimbus look and feel if available, else set Cross-Platform look
		// and feel
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception ex) {
			}
		}
	}
}
