/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb;

import java.util.ArrayList;
import java.util.List;
import javaappmongodb.controle.AlunoControle;
import javaappmongodb.model.dao.Aluno;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Edvania
 */
public class JFAluno extends javax.swing.JFrame {

    /**
     * Creates new form JFAluno
     */
    private AlunoControle aluno;    
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private AlunoTableModel alunoTableModel = new AlunoTableModel();
    
    public JFAluno() {
        initComponents();
    }

    JFAluno(String ip, String banco, String porta) {
        aluno = new AlunoControle(ip, banco, porta);
        initComponents();
    }
    
    private List<Aluno> getAlunos() {
        return aluno.getAlunos();
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

        jTable1.setModel(alunoTableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    class AlunoTableModel extends AbstractTableModel {

        private String[] columnName = new String[]{
            "ID","ANO","PERÍODO","CURSO","CIDADE","UF","CEP","DATA","IDADE","SEXO"
        };
        
        @Override
        public int getRowCount() {
            return getAlunos().size();
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
            Aluno aluno = getAlunos().get(rowIndex);
            switch(columnIndex){
                case 0: return aluno.getId();
                case 1: return aluno.getAnoLetivo();
                case 2: return aluno.getPeriodo();
                case 3: return aluno.getCurso();
                case 4: return aluno.getCidade();
                case 5: return aluno.getEstado();
                case 6: return aluno.getCep();
                case 7: return aluno.getNascimento();
                case 8: return aluno.getIdade();
                case 9: return aluno.getSexo();
            }
            return null;
        }
        
    }

}
