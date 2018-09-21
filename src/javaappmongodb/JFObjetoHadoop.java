/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb;

import java.util.ArrayList;
import java.util.List;
import javaappmongodb.controle.ObjetoHadoopControle;
import javaappmongodb.model.dao.ObjetoHadoop;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Edvania
 */
public class JFObjetoHadoop extends javax.swing.JFrame {

    private ObjetoHadoopControle controle;    
    private List<ObjetoHadoop> list = new ArrayList<ObjetoHadoop>();
    private AbstractTableModel objetoHadoopTableModel = new ObjetcoHadoopTableModel();
    /**
     * Creates new form JFObjetoHadoop
     */
    public JFObjetoHadoop() {
        initComponents();
    }

    JFObjetoHadoop(String ip, String banco, String porta) {
        controle = new ObjetoHadoopControle(ip, banco, porta);
        initComponents();
    }

    public List<ObjetoHadoop> getList() {
        return controle.getList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(objetoHadoopTableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFObjetoHadoop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFObjetoHadoop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFObjetoHadoop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFObjetoHadoop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFObjetoHadoop().setVisible(true);
            }
        });
    }

    class ObjetcoHadoopTableModel extends AbstractTableModel {

        String[] columnName = new String[]{
            "anoLetivo", "periodo", "cep", "sexo", "idade", "frequencia", "media", "rotulo"
        };
        
        public ObjetcoHadoopTableModel() {
        }

        @Override
        public int getRowCount() {
            return getList().size();
        }

        @Override
        public int getColumnCount() {
            return columnName.length;
        }
        
        @Override
        public String getColumnName(int column) {
            return columnName[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ObjetoHadoop o = getList().get(rowIndex);
            switch(columnIndex){
                case 0: return o.getAnoLetivo(); 
                case 1: return o.getPeriodo(); 
                case 2: return o.getCep(); 
                case 3: return o.getSexo(); 
                case 4: return o.getIdade(); 
                case 5: return o.getFrequencia(); 
                case 6: return o.getMedia();
                case 7: return o.getSituacao();
            }   
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
