package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import static Main.CertificateCreator.DIR_PATH;

public class MyFrame extends JFrame {
    public static final String TEXT_FIELD_DEFAULT_STRING = "enter location here";
    public static final String IMG_LOCATION = "/src/main/resources/Backgroundv5.jpg";
    public static final String TEST_STRING = "C:/Users/Sasho/Downloads/LYPCO_2023_-_Certificate_List.xlsx";
    public static boolean sourceAvailable = false;
    public static String tableLocation = "";


    //for some reason both Image and ImageIcon need to exist for the same img even though ImageIcon is never used and might need to be declared after the main sets
    Image backgroundImg = Toolkit.getDefaultToolkit().getImage(DIR_PATH + IMG_LOCATION);
    ImageIcon icon = new ImageIcon(DIR_PATH + IMG_LOCATION);


    public MyFrame() {

        JLabel lblInstruct = new JLabel();
        JTextField tfTableLocale = new JTextField();
        JLabel lblMessage = new JLabel();
        JButton btnCreate = new JButton();
        JLabel lblResult = new JLabel();
        JPanel mainPanel = new JPanel();
        JPanel wrapperPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImg, 0, 0, null);
            }
        };
        //wrapperPanel is needed to paintComponents() on everything, including mainPanel within GridBagLayout


        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        mainPanel.add(lblInstruct);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(tfTableLocale, BorderLayout.CENTER);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(lblMessage);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(btnCreate);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(lblResult);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 70)));

        //set to non-opaque for transparent painted background to show through
        mainPanel.setOpaque(false);

        //GridBag to center the mainpanel within it and the frame
        wrapperPanel.setLayout(new GridBagLayout());
        wrapperPanel.add(mainPanel, new GridBagConstraints());
        add(wrapperPanel);
        setTitle("LYPCO - Certificate Factory");
        setSize(450, 650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);


        lblInstruct.setText("Enter Table Location:");
        lblInstruct.setForeground(Color.WHITE);
        lblInstruct.setAlignmentX(Component.CENTER_ALIGNMENT);

        tfTableLocale.setText(TEXT_FIELD_DEFAULT_STRING);
        tfTableLocale.setAlignmentX(Component.CENTER_ALIGNMENT);
        tfTableLocale.setMaximumSize(new Dimension(500, 30));

        lblMessage.setText("");
        lblMessage.setForeground(Color.WHITE);
        //setting fixed size so changing label won't cause other components to jump
        lblMessage.setMinimumSize(new Dimension(200, 16));
        lblMessage.setMaximumSize(new Dimension(200, 16));
        lblMessage.setPreferredSize(new Dimension(200, 16));
        lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMessage.setHorizontalAlignment(JTextField.CENTER);

        btnCreate.setText("Create Certificate");
        btnCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCreate.setMinimumSize(new Dimension(250, 25));
        btnCreate.setMaximumSize(new Dimension(250, 25));
        btnCreate.setPreferredSize(new Dimension(250, 25));

        lblResult.setText("");
        lblResult.setForeground(Color.WHITE);
        lblResult.setMinimumSize(new Dimension(200, 16));
        lblResult.setMaximumSize(new Dimension(200, 16));
        lblResult.setPreferredSize(new Dimension(200, 16));
        lblResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblResult.setHorizontalAlignment(JTextField.CENTER);


        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CertificateCreator creator = new CertificateCreator();
                if (sourceAvailable) {
                    creator.create(tableLocation);
                    lblResult.setText("Done!");
                }
            }
        });

        tfTableLocale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (tfTableLocale.getText().equals(TEXT_FIELD_DEFAULT_STRING)) {
                    tfTableLocale.setText("");
                    lblResult.setText("");
                }
            }
        });

        tfTableLocale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                String tablePath = tfTableLocale.getText();
                if (tablePath.equals(TEXT_FIELD_DEFAULT_STRING) || tablePath.equals("")) {
                    return;
                }

                File file;
                if (tablePath.contains(".")) {
                    file = new File(tablePath);
                } else {
                    file = new File(tablePath + ".xlsx");
                }

                if (!file.isFile()) {
                    lblMessage.setText("Can't find file at given location");
                    sourceAvailable = false;

                } else {

                    if (!file.getAbsolutePath().endsWith(".xlsx")) {
                        lblMessage.setText("Wrong file format, must be .xlsx");
                        sourceAvailable = false;

                    } else {
                        lblMessage.setText("");
                        sourceAvailable = true;
                        tableLocation = file.getAbsolutePath();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
