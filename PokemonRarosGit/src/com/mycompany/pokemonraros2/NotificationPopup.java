package com.mycompany.pokemonraros2;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class NotificationPopup implements MouseListener {

    static int pos = 0;

    public static void main(String[] args) throws MalformedURLException, IOException {
        NotificationPopup p = new NotificationPopup();
        p.popup("Porygon 43.764309, -79.458478 12:23", "https://s3-eu-west-1.amazonaws.com/pokesnipers/blackwhite/9.png", true, true);

    }

    public synchronized void popup(String message, String icon, boolean sound) throws MalformedURLException {
        popup(message, icon, sound, false);
    }

    public synchronized void popup(String message, String icon, boolean sound, boolean maps) throws MalformedURLException {
        //String message = "You got a new notification message. Isn't it awesome to have such a notification message.";
        //String header = "Nuevo pokemon raro";
        String header = message;
        //JFrame frame = new JFrame();

        JDialog frame = new JDialog();
        if (!maps) {
            frame.setTitle(message);
        } else {
            frame.setTitle(message + " maps");
        }

        frame.addMouseListener(this);

        frame.setSize(400, 100);
        frame.setUndecorated(true);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel headingLabel = new JLabel(header);

        URL url = new URL(icon);
        //Image image = ImageIO.read(url);

        ImageIcon headingIcon = new ImageIcon(url);

        headingLabel.setIcon(headingIcon); // --- use image icon you want to be as heading image.

        headingLabel.setIcon(headingIcon);
        headingLabel.setOpaque(false);
        frame.add(headingLabel, constraints);
        constraints.gridx++;
        constraints.weightx = 0f;
        constraints.weighty = 0f;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        //JButton cloesButton = new JButton("X");

        JButton cloesButton = new JButton(new AbstractAction("x") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        cloesButton.setMargin(new Insets(1, 4, 1, 4));
        cloesButton.setFocusable(false);
        frame.add(cloesButton, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel messageLabel = new JLabel("<HtMl>" + message);
        //frame.add(messageLabel, constraints);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
        Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
        frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight() - pos);
        pos += 105;

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7000); // time after which pop up will be disappeared.
                    synchronized (this) {
                        pos -= 105;
                    }

                    frame.dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        ;
        }.start();



        frame.setAlwaysOnTop(true);

        frame.setVisible(true);

        if (sound) {
            try {
                //Toolkit.getDefaultToolkit().beep();
                SoundUtils.tone(1000, 200);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(NotificationPopup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //JFrame j = (JFrame) e.getSource();
        JDialog j = (JDialog) e.getSource();
        String a = j.getTitle();
        String tokens[] = a.split(" ");
        String coords = tokens[1] + " " + tokens[2];
        if (!a.contains("maps")) {
            setClipboard(coords);
        } else {
            setClipboard(coords);
            try {
                Desktop.getDesktop().browse(new URL("https://www.google.com.mx/maps/place/" + coords.replace(" ", "") + "/").toURI());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        j.getContentPane().setBackground(Color.gray);
    }

    public void setClipboard(String str) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection data = new StringSelection(str);
        clipboard.setContents(data, data);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
