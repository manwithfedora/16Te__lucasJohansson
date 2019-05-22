import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Sweep extends JFrame {
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JPanel jPanel1;
    
    
    int wid = 9, hei = 9, noOfBombs = 10;
    JToggleButton[][] blocks = new JToggleButton[hei][wid];
    int[][] blox = new int[hei][wid];
    boolean first, canPlay;
    
    ActionListener listen = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int i = 0, j = 0;
            boolean found = false;
            for(i = 0; i < hei; i++){
                for(j = 0; j < wid; j++){
                    if(e.getSource() == blocks[i][j]){
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
            if(canPlay){
                blocks[i][j].setSelected(true);
                if(!first){
                    spawn(i, j);
                    first = true;
                }
                if(blox[i][j]!= -1 ){
                    open(i,j);
                    reval();
                } else lose();
                checkWin();
            } else reval();
        }
    };
    private void checkWin(){
        boolean won = true;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0) {
                    won = false;
                    break;
                }
            }
            if(!won) break;
        }
        if(won){
            JOptionPane.showMessageDialog(null, "You win!!!");
            canPlay=false;
        }
    }
    
    private void lose(){
        canPlay = false;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == -1) {
                    blocks[i][j].setText("BOOM");
                    blocks[i][j].setSelected(true);
                }
            }
        }
    }
    
    private void open(int y, int x){
        if(y < 0 || x < 0 || x > wid - 1 || y > hei - 1 || blox[y][x] != 0) return;
        int bombs = 0;
        for(int i = y - 1; i <= y + 1;i++){
            for(int j = x - 1; j <= x + 1;j++){
                if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1) && blox[i][j] == -1)
                    bombs++;
            }
        }
        if(bombs == 0){
            blox[y][x] = -2;
            for(int i = y - 1; i <= y + 1;i++){
                for(int j = x - 1; j <= x + 1;j++){
                    if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1))
                    if(i != y || j != x) open(i,j);
                }
            }
        } else blox[y][x] = bombs;
    }

    private void reval(){
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(false);

                }
                if(blox[i][j] == -2){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(true);
                }
                if(blox[i][j] > 0){
                    blocks[i][j].setText(""+blox[i][j]);
                    blocks[i][j].setSelected(true);
                }
                if(!canPlay && blox[i][j] == -1) blocks[i][j].setSelected(true);
            }
        }
        jPanel1.repaint();
    }
    
    private void spawn(int y, int x){
        for(int k = 1; k <= noOfBombs;k++){
            int i, j;
            do{
                i = (int)(Math.random()*(wid-.01));
                j = (int)(Math.random()*(hei-.01));
            }
            while(blox[i][j] == -1 || (i == y && j == x));
            blox[i][j] = -1;
            
        }
    }
    
    public Sweep() {
        initComponents();
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j] = new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                blocks[i][j].addActionListener(listen);
            }
        }
        first = false;
        canPlay = true;
    }
    
    private void resiz(){
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
            }
        }
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jMenu1.setText("Game");
        
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        jMenuItem1.setText("New game");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    private void jPanel1ComponentResized(ComponentEvent evt) {
        resiz();
    }
    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        blox = new int[hei][wid];
        reval();
        canPlay = true;
        first = false;
    }
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sweep().setVisible(true);
            }
        });}    }