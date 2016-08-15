package view;

import controller.LoginController;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel mainPanel;
        private EnrollmentSystemView mainView;
        private LoginController lc;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		/** Frame setup */
		this.setTitle("Enrollment System");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1000, 620);
		this.setLocationRelativeTo(null);
	}

	public void renderMainView() {
		mainView = new LoginView(this, lc);
                frameRevalidate();
		this.setContentPane((JPanel) mainView);
	}
	
        public void switchView(EnrollmentSystemView mainView) {
                frameRevalidate();
		this.setContentPane((JPanel) mainView);
                this.setVisible(true);
	}
        
        public void frameRevalidate()
	{
		validate();
		repaint();
		setVisible(true);
	}

        public void setLoginController(LoginController lc)
        {
            this.lc = lc;
        }

}
