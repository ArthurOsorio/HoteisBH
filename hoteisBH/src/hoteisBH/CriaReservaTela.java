package hoteisBH;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import javax.swing.JSlider;


public class CriaReservaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCPF;
	public JSlider slider = new JSlider();
	JLabel lblJslider = new JLabel("0");
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int value;

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
		sl_contentPane.putConstraint(SpringLayout.WEST, lblJslider, 293, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblJslider, -1, SpringLayout.NORTH, slider);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblJslider, 312, SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 61, SpringLayout.WEST, contentPane);
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
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
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
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
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
		btnConcluir.setActionCommand("CONCLUIR");
		btnConcluir.addActionListener(new ActionButtonsListenerReservaTela(this));
		panel.add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("CANCELAR");
		btnCancelar.addActionListener(new ActionButtonsListenerReservaTela(this));
		panel.add(btnCancelar);
		slider.setMaximum(30);
		
		slider.addChangeListener(new SliderListener(this));
		slider.setValue(0);
		sl_contentPane.putConstraint(SpringLayout.WEST, slider, 27, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, slider, -19, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, slider, -27, SpringLayout.EAST, contentPane);
		contentPane.add(slider);
		
		JLabel lblDias = new JLabel("Dias para reservar");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblDias);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDias, -96, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDias, 0, SpringLayout.WEST, txtNome);
		contentPane.add(lblDias);
		lblJslider.setMinimumSize(new Dimension(10, 14));
		lblJslider.setPreferredSize(new Dimension(10, 14));
		contentPane.add(lblJslider);
	}
}
