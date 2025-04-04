package hoteisBH;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

public class CriaReservaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaReservaTela frame = new CriaReservaTela();
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
	public CriaReservaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 43, SpringLayout.NORTH, contentPane);
		lblNewLabel.setMaximumSize(new Dimension(27, 35));
		lblNewLabel.setPreferredSize(new Dimension(27, 50));
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNome, 55, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNome, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNome, 88, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNome, 646, SpringLayout.WEST, contentPane);
		txtNome.setMinimumSize(new Dimension(7, 5));
		txtNome.setPreferredSize(new Dimension(200, 5));
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, txtNome);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_1.setPreferredSize(new Dimension(42, 50));
		contentPane.add(lblNewLabel_1);
		
		txtTelefone = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, txtTelefone);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTelefone, 156, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtTelefone, -227, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTelefone, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTelefone, 646, SpringLayout.WEST, contentPane);
		txtTelefone.setPreferredSize(new Dimension(7, 5));
		txtTelefone.setMinimumSize(new Dimension(7, 5));
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 45, SpringLayout.SOUTH, txtTelefone);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		txtCPF = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtCPF, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtCPF, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtCPF, 287, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtCPF, 646, SpringLayout.WEST, contentPane);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 386, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 646, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConcluir = new JButton("Concluir");
		panel.add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
	}

}
