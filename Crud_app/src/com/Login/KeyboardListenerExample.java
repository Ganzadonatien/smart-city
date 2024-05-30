

    import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyboardListenerExample extends JFrame implements KeyListener {
    
    private JTextArea textArea;
    
    public KeyboardListenerExample() {
        setTitle("Keyboard Listener Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.addKeyListener(this);
        
        add(textArea);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyboardListenerExample();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Invoked when a key is typed
        char c = e.getKeyChar();
        System.out.println("Key Typed: " + c);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Invoked when a physical key is pressed down
        int keyCode = e.getKeyCode();
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(keyCode));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Invoked when a physical key is released
        int keyCode = e.getKeyCode();
        System.out.println("Key Released: " + KeyEvent.getKeyText(keyCode));
    }
}

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

