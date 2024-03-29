/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serieseval.forms.algorithms;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import serieseval.controller.AlgorithmController;
import serieseval.controller.UserController;
import serieseval.model.Algorithm;
import serieseval.model.User;

/**
 *
 * @author Laura
 */
public class AlgorithmForm extends javax.swing.JPanel {

    /**
     * Creates new form Usuarios
     */
    public AlgorithmForm() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        seriesevalPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("seriesevalPU").createEntityManager();
        algorithmQuery = java.beans.Beans.isDesignTime() ? null : seriesevalPUEntityManager.createQuery("SELECT a FROM Algorithm a");
        algorithmList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : algorithmQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newBtn = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();

        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, algorithmList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idalgorithm}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idgroup.name}"));
        columnBinding.setColumnName("Grupo");
        columnBinding.setColumnClass(String.class);
        jTableBinding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        newBtn.setText("Crear Algoritmo");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("Borrar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarBtn)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBtn)
                    .addComponent(editarBtn)
                    .addComponent(eliminarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        CreateAlgorithm u = new CreateAlgorithm();
        u.setVisible(true);
        Container c = this.getParent();
        c.removeAll();
        c.setLayout(new BorderLayout());
        c.add(u);
        c.setSize(300, 300);
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_newBtnActionPerformed

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        // TODO add your handling code here:
        Integer selected = jTable1.getSelectedRow();
        if (selected >= 0) {
            Algorithm selectedAlgorithm = algorithmList.get(selected);
            EditarAlgorithm u = new EditarAlgorithm(selectedAlgorithm);
            u.setVisible(true);
            Container c = this.getParent();
            c.removeAll();
            c.setLayout(new BorderLayout());
            c.add(u);
            c.setSize(300, 300);
            c.revalidate();
            c.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Algoritmo para editarlo.");
        }

    }//GEN-LAST:event_editarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:
        Integer selected = jTable1.getSelectedRow();
        if (selected >= 0) {
            Algorithm selectedAlgorithm = algorithmList.get(selected);            
            AlgorithmController uc = new AlgorithmController();
            uc.Borrar(selectedAlgorithm);
            
            AlgorithmForm uf = new AlgorithmForm();
            Container c = this.getParent();
            c.removeAll();
            c.setLayout(new BorderLayout());
            c.add(uf);
            c.setSize(300, 300);
            c.revalidate();
            c.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Algoritmo para eliminarlo.");
        }

    }//GEN-LAST:event_eliminarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<serieseval.model.Algorithm> algorithmList;
    private javax.persistence.Query algorithmQuery;
    private javax.swing.JButton editarBtn;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newBtn;
    private javax.persistence.EntityManager seriesevalPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void persist(Object object) {
        seriesevalPUEntityManager.getTransaction().begin();
        try {
            seriesevalPUEntityManager.persist(object);
            seriesevalPUEntityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            seriesevalPUEntityManager.getTransaction().rollback();
        } finally {
            seriesevalPUEntityManager.close();
        }
    }
}
