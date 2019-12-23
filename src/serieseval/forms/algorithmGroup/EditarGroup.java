/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.forms.algorithmGroup;

import java.awt.BorderLayout;
import java.awt.Container;
import serieseval.controller.GroupController;
import serieseval.controller.UserController;
import serieseval.model.Dmgroup;
import serieseval.model.Role;
import serieseval.model.User;

/**
 *
 * @author Laura
 */
public class EditarGroup extends javax.swing.JPanel {

    public Dmgroup grupo;
    /**
     * Creates new form CreateUser
     */
    public EditarGroup(Dmgroup grupo) {        
        this.grupo = grupo;
        initComponents();        
        usernameTbox.setText(grupo.getName());            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seriesevalPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("seriesevalPU").createEntityManager();
        roleQuery = java.beans.Beans.isDesignTime() ? null : seriesevalPUEntityManager.createQuery("SELECT r FROM Role r");
        roleList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : roleQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        usernameTbox = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        jLabel1.setText("Nombre");

        saveBtn.setText("Guardar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(68, 68, 68)
                        .addComponent(usernameTbox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn)
                    .addComponent(saveBtn))
                .addContainerGap(214, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        GroupController uc = new GroupController();
        
        grupo.setName(usernameTbox.getText());            
        
        uc.Editar(grupo);
        GroupForm u = new GroupForm();
        u.setVisible(true);
        Container c =  this.getParent();
        c.removeAll();        
        c.add(u);       
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        // TODO add your handling code here:
        GroupForm u = new GroupForm();
        u.setVisible(true);
        
        Container c =  this.getParent();
        c.removeAll();
        c.setLayout(new BorderLayout());
        c.add(u);
        c.setSize(300, 300);       
        c.revalidate();    
        c.repaint();      
        
    }//GEN-LAST:event_cancelarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel jLabel1;
    private java.util.List<serieseval.model.Role> roleList;
    private javax.persistence.Query roleQuery;
    private javax.swing.JButton saveBtn;
    private javax.persistence.EntityManager seriesevalPUEntityManager;
    private javax.swing.JTextField usernameTbox;
    // End of variables declaration//GEN-END:variables
}