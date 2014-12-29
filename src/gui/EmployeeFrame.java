package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.Toolkit;

public class EmployeeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					UIManager
							.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				EmployeeFrame.class.getResource("/image/emp.png")));
		setTitle("Employee Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		EmmPanel_1 P1 = new EmmPanel_1();
		contentPane.add(P1);
		P1.setLayout(null);
	}

}
