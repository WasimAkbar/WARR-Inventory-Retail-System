package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import actors.SalesPerson;
import algo.ItemList;
import algo.ManageCategory;
import algo.ManageItem;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;

import creator.CreManageCategory;
import net.proteanit.sql.DbUtils;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.UIManager;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EmmPanel_1 extends JPanel {
	private JTable table;
	private JTextField textField;
	private SalesPerson obj;
	private CreManageCategory CreMang;
	private ResultSet listData;
	private JButton btnBtn;
	private JTextField textField_1;
	private JButton btnSell;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ManageItem mn;
	private ManageCategory mCat;
	private JButton btnSend;
	private JLabel lblNewLabel_2;
	private ArrayList<String> autoList;
	private ItemList i;

	/**
	 * Create the panel.
	 */
	public EmmPanel_1() {
		getLocalTime();
		setBackground(Color.WHITE);
		setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 27, 497, 43);
		menuBar.setBackground(Color.LIGHT_GRAY);
		add(menuBar);

		JMenu mnNewMenu = new JMenu("User");
		menuBar.add(mnNewMenu);

		JMenuItem mntmHome = new JMenuItem("Home");
		mnNewMenu.add(mntmHome);

		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Softwere");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Version");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"WARR Retail Inventory System\nVersion: 1.1.0");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Developers");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"FAST SCHOOL OF COMPUTING \n\nDevelopers: \n1- Waseem Akbar \n2- Muhammad Rizwan\n3- Rizwan Ali\n2- Ali Saeed");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_2 = new JMenu("Exit");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(622, 70, 119, 185);
		lblNewLabel.setIcon(new ImageIcon(EmmPanel_1.class
				.getResource("/image/Boy.jpg")));
		add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 92, 606, 206);
		add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Retrive List", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblValue = new JLabel("Value");
		lblValue.setBackground(SystemColor.activeCaption);
		lblValue.setIcon(new ImageIcon(EmmPanel_1.class
				.getResource("/image/button_final.png")));
		lblValue.setBounds(138, 70, 122, 44);
		panel_1.add(lblValue);

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {

				autoList = new ArrayList<String>();
				i = new ItemList();
				autoList = i.getAutoList();
				setupAutoComplete(textField, autoList);
				panel_1.add(textField);
				textField.setVisible(true);
			}
		});

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				obj = new SalesPerson();
				listData = null;
				if (!textField.getText().isEmpty()) {

					listData = obj.retrieveListUpdateStatus.getlist(Integer
							.parseInt(textField.getText()));
					table.setModel(DbUtils.resultSetToTableModel(listData));
					btnBtn.setEnabled(true);
				} else {
					btnBtn.setEnabled(false);
				}
			}
		});
		textField.setFont(new Font("Verdana", Font.PLAIN, 22));
		textField.setBounds(269, 69, 89, 46);
		panel_1.add(textField);
		textField.setColumns(10);

		btnBtn = new JButton("Drop Item");
		btnBtn.setEnabled(false);
		btnBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String upcName = JOptionPane.showInputDialog("Enter UPC Name");

				if (!textField.getText().isEmpty() && !upcName.isEmpty()) {

					obj = new SalesPerson();
					obj.retrieveListUpdateStatus.dropItem(
							Integer.parseInt(upcName),
							Integer.parseInt(textField.getText()));

					listData = obj.retrieveListUpdateStatus.getlist(Integer
							.parseInt(textField.getText()));
					table.setModel(DbUtils.resultSetToTableModel(listData));
				}
				// if (table.getSelectedRowCount() > 0) {
				//
				// System.out.println("row selected");
				//
				// } else {
				// System.out.println("you must select a row");
				// }
			}
		});
		btnBtn.setBounds(382, 70, 122, 44);
		panel_1.add(btnBtn);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("List Status", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblListId = new JLabel("List ID");
		lblListId.setFont(new Font("Vani", Font.PLAIN, 18));
		lblListId.setBounds(152, 55, 66, 42);
		panel_2.add(lblListId);

		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				autoList = new ArrayList<String>();
				i = new ItemList();

				autoList = i.getAutoList();
				setupAutoComplete(textField_1, autoList);
				panel_2.add(textField_1);
				textField_1.setVisible(true);
			}
		});
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 22));
		textField_1.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent arg0) {

				if (!textField_1.getText().isEmpty()) {

					obj = new SalesPerson();
					listData = obj.retrieveListUpdateStatus
							.getlistStatus(Integer.parseInt(textField_1
									.getText()));
					table.setModel(DbUtils.resultSetToTableModel(listData));

					btnSell.setEnabled(true);
				} else {
					btnSell.setEnabled(false);
				}
			}
		});
		textField_1.setBounds(225, 53, 95, 44);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				obj = new SalesPerson();

				boolean Sold = obj.retrieveListUpdateStatus
						.checkListValidation((Integer.parseInt(textField_1
								.getText())));

				if (!Sold) {
					int listNO = Integer.parseInt(textField_1.getText());
					listData = obj.retrieveListUpdateStatus
							.UpdateStatus(Integer.parseInt(textField_1
									.getText()));
					double total_Bill = 0;

					total_Bill = obj.retrieveListUpdateStatus
							.getTotalListBill(Integer.parseInt(textField_1
									.getText()));
					JOptionPane.showMessageDialog(null, listNO
							+ " Total Bill: " + total_Bill);
					table.setModel(DbUtils.resultSetToTableModel(listData));
				} else
					JOptionPane.showMessageDialog(null,
							"Item List Already Sold");

			}
		});
		btnSell.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnSell.setBounds(337, 54, 74, 43);
		btnSell.setEnabled(false);
		panel_2.add(btnSell);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("View Category", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblSearchCategory = new JLabel("Search Category");
		lblSearchCategory.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSearchCategory.setBounds(136, 50, 134, 48);
		panel_4.add(lblSearchCategory);

		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				autoList = new ArrayList<String>();
				mCat = new ManageCategory();

				autoList = mCat.getAutoCate();
				setupAutoComplete(textField_2, autoList);
				panel_4.add(textField_2);
				textField_2.setVisible(true);
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				if (!textField_2.getText().isEmpty()) {

					// ERROR
					obj = new SalesPerson();
					listData = obj.creManageCategory.manageCategory
							.searchCategory(Integer.parseInt(textField_2
									.getText()));
					table.setModel(DbUtils.resultSetToTableModel(listData));
				}
			}
		});
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField_2.setBounds(281, 50, 95, 48);
		panel_4.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Add Short Item", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblItem = new JLabel("Select UPC");
		lblItem.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblItem.setBounds(131, 50, 111, 49);
		panel_3.add(lblItem);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				autoList = new ArrayList<String>();
				mn = new ManageItem();

				autoList = mn.getAutoUtem();

				setupAutoComplete(textField_3, autoList);
				panel_3.add(textField_3);
				textField_3.setVisible(true);

			}
		});

		textField_3.setBounds(245, 50, 94, 49);
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		btnSend = new JButton("Send");

		btnSend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (!textField_3.getText().isEmpty()) {

					mn = new ManageItem();
					listData = mn.sendShortItem(Integer.parseInt(textField_3
							.getText()));
					table.setModel(DbUtils.resultSetToTableModel(listData));
				}
			}
		});
		btnSend.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		btnSend.setBounds(359, 53, 89, 46);
		panel_3.add(btnSend);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("View Item", null, panel, null);
		panel.setLayout(null);

		JLabel lblEnterUpc = new JLabel("Enter UPC");
		lblEnterUpc.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEnterUpc.setBounds(151, 49, 103, 54);
		panel.add(lblEnterUpc);

		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				autoList = new ArrayList<String>();
				mn = new ManageItem();

				autoList = mn.getAutoUtem();

				setupAutoComplete(textField_4, autoList);
				panel.add(textField_4);
				textField_4.setVisible(true);
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (!textField_4.getText().isEmpty()) {

					// ERROR
					obj = new SalesPerson();
					obj = new SalesPerson();
					listData = obj.creManageItem.manageItem.searchItem(Integer
							.parseInt(textField_4.getText()));
					table.setModel(DbUtils.resultSetToTableModel(listData));
				}
			}
		});
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField_4.setBounds(264, 54, 112, 42);
		panel.add(textField_4);
		textField_4.setColumns(10);

		// JPanel panel_5 = new JPanel();
		// panel_5.setBackground(SystemColor.inactiveCaption);
		// tabbedPane.addTab("Warning List", null, panel_5, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 306, 606, 214);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.LIGHT_GRAY);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(638, 401, 103, 121);
		lblNewLabel_1.setIcon(new ImageIcon(EmmPanel_1.class
				.getResource("/image/logo_sm.jpg")));
		add(lblNewLabel_1);

		JLabel label = new JLabel("WARR");
		label.setBounds(642, 352, 85, 61);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setFont(new Font("Algerian", Font.PLAIN, 28));
		add(label);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(629, 22, 112, 48);
		lblNewLabel_2
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Current Time",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		lblNewLabel_2.setBackground(SystemColor.activeCaption);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 28));
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(512, 22, 119, 48);
		add(lblNewLabel_3);

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");

		lblNewLabel_3.setText(ft.format(dNow));

		DefaultTableCellRenderer defaultRenderer = (DefaultTableCellRenderer) table
				.getDefaultRenderer(Object.class);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
		defaultRenderer.setHorizontalAlignment(JLabel.CENTER);

	}

	public void getLocalTime() {

		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				String time = timeFormat.format(date);
				lblNewLabel_2.setText(time);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		timer.setInitialDelay(0);
		timer.start();
	}

	private static boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}

	private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}

	public static void setupAutoComplete(final JTextField txtInput,
			final ArrayList<String> items) {
		final DefaultComboBoxModel model = new DefaultComboBoxModel();

		final JComboBox cbInput = new JComboBox(model) {
			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		setAdjusting(cbInput, false);
		for (String item : items) {
			model.addElement(item);
		}

		cbInput.setSelectedItem(null);

		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						txtInput.setText(cbInput.getSelectedItem().toString());
					}
				}
			}
		});

		txtInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						txtInput.setText(cbInput.getSelectedItem().toString());
						cbInput.setPopupVisible(false);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		txtInput.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				updateList();
			}

			public void removeUpdate(DocumentEvent e) {
				updateList();
			}

			public void changedUpdate(DocumentEvent e) {
				updateList();
			}

			private void updateList() {
				setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = txtInput.getText();
				if (!input.isEmpty()) {
					for (String item : items) {
						if (item.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item);
						}
					}
				}
				cbInput.setPopupVisible(model.getSize() > 0);
				setAdjusting(cbInput, false);
			}
		});
		txtInput.setLayout(new BorderLayout());
		txtInput.add(cbInput, BorderLayout.SOUTH);
	}
}
