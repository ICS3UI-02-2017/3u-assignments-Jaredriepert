/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

/**
 *
 * @author riepj9547
 */
public class A4Q9 extends javax.swing.JFrame {

    /**
     * Creates new form A4Q9
     */
    public A4Q9() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        secondNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        result = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        subButton = new javax.swing.JButton();
        divButton = new javax.swing.JButton();
        multButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("First number");
        jLabel1.setToolTipText("");

        firstNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNumberActionPerformed(evt);
            }
        });

        jLabel2.setText("Second number");

        jLabel3.setText("Result");

        addButton.setText("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        subButton.setText("subtract");
        subButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subButtonActionPerformed(evt);
            }
        });

        divButton.setText("divide");
        divButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divButtonActionPerformed(evt);
            }
        });

        multButton.setText("multiply");
        multButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNumber)
                            .addComponent(secondNumber)
                            .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(subButton)
                        .addGap(18, 18, 18)
                        .addComponent(divButton)
                        .addGap(18, 18, 18)
                        .addComponent(multButton)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(subButton)
                    .addComponent(divButton)
                    .addComponent(multButton))
                .addContainerGap(309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNumberActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //take the first number
        String firstString = firstNumber.getText();
        
        double firstInt = Integer.parseInt(firstString);
        
        //get the second number
        String secondString = secondNumber.getText();
        
        double secondInt = Integer.parseInt(secondString);
        //add them and display it
        double resultInt = firstInt+secondInt;
        
        result.setText(""+resultInt);
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void subButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subButtonActionPerformed
         //take the first number
        String firstString = firstNumber.getText();
        
        double firstInt = Integer.parseInt(firstString);
        
        //get the second number
        String secondString = secondNumber.getText();
        
        double secondInt = Integer.parseInt(secondString);
        //subtract them and display it
        double resultInt = firstInt-secondInt;
        
        result.setText(""+resultInt);
    }//GEN-LAST:event_subButtonActionPerformed

    private void divButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButtonActionPerformed
        //take the first number
        String firstString = firstNumber.getText();
        
        double firstInt = Integer.parseInt(firstString);
        
        //get the second number
        String secondString = secondNumber.getText();
        
        double secondInt = Integer.parseInt(secondString);
        //divide them and display it
        double resultInt = firstInt/secondInt;
        
        result.setText(""+resultInt);
    }//GEN-LAST:event_divButtonActionPerformed

    private void multButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multButtonActionPerformed
        //take the first number
        String firstString = firstNumber.getText();
        
        double firstInt = Integer.parseInt(firstString);
        
        //get the second number
        String secondString = secondNumber.getText();
        
        double secondInt = Integer.parseInt(secondString);
        //multiply them and display it
        double resultInt = firstInt*secondInt;
        
        result.setText(""+resultInt);
    }//GEN-LAST:event_multButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(A4Q9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A4Q9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A4Q9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A4Q9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A4Q9().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton divButton;
    private javax.swing.JTextField firstNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton multButton;
    private javax.swing.JTextField result;
    private javax.swing.JTextField secondNumber;
    private javax.swing.JButton subButton;
    // End of variables declaration//GEN-END:variables
}
