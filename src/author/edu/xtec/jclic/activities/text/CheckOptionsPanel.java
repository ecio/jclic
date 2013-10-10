/*
 * File    : TextOptionsPanel.java
 * Created : 25-jun-2003 17:30
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic.activities.text;

import edu.xtec.util.Options;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 1.0
 */
public class CheckOptionsPanel extends javax.swing.JPanel {
    
    Options options;
    
    /** Creates new form TextOptionsPanel */
    public CheckOptionsPanel(Options options) {
        this.options=options;
        initComponents();
    }       
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel checkButtonTextLb;

        btnPanel = new javax.swing.JPanel();
        checkButtonChk = new javax.swing.JCheckBox();
        checkButtonTextLb = new javax.swing.JLabel();
        checkButtonTxt = new javax.swing.JTextField();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        btnPanel.setLayout(new java.awt.GridBagLayout());

        btnPanel.setBorder(new javax.swing.border.TitledBorder(options.getMsg("edit_text_act_checkButton")));
        checkButtonChk.setText(options.getMsg("edit_text_act_checkButton_show"));
        checkButtonChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonChkActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        btnPanel.add(checkButtonChk, gridBagConstraints);

        checkButtonTextLb.setText(options.getMsg("edit_text_act_checkButtonText"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        btnPanel.add(checkButtonTextLb, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        btnPanel.add(checkButtonTxt, gridBagConstraints);

        add(btnPanel);

    }//GEN-END:initComponents

    private void checkButtonChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonChkActionPerformed

        checkButtonTxt.setEnabled(checkButtonChk.isSelected());
        
    }//GEN-LAST:event_checkButtonChkActionPerformed
    
    public void setOptions(TextActivityBase tab){
        checkButtonChk.setSelected(tab.hasCheckButton);
        String s=tab.checkButtonText;
        if(s==null || s.length()<1)
            s=options.getMsg("edit_text_act_defaultCheckButtonText");
        checkButtonTxt.setText(s);
        checkButtonTxt.setEnabled(checkButtonChk.isSelected());
    }
    
    public void collectData(TextActivityBase tab){
        tab.hasCheckButton=checkButtonChk.isSelected();
        String s=checkButtonTxt.getText();
        if(s==null || s.length()<1)
            s=options.getMsg("edit_text_act_defaultCheckButtonText");
        tab.checkButtonText=s;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    private javax.swing.JCheckBox checkButtonChk;
    private javax.swing.JTextField checkButtonTxt;
    // End of variables declaration//GEN-END:variables
    
}
