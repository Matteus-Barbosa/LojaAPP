package atv01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LojaApp().setVisible(true);
        });
    }
}
