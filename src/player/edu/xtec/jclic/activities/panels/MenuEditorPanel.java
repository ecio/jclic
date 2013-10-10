/*
 * File    : MenuEditorPanel.java
 * Created : 10-jun-2002 09:59
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

package edu.xtec.jclic.activities.panels;

import edu.xtec.jclic.edit.Editor;
import edu.xtec.jclic.edit.EditorPanel;
import edu.xtec.util.Options;
import edu.xtec.util.SmallButton;
import java.awt.Container;
import javax.swing.Icon;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.09
 */
public class MenuEditorPanel extends EditorPanel {

    /** Creates new form MenuEditorPanel */
    public MenuEditorPanel(Options options) {
        super(options);
        MenuEditor.createActions(options);
        initComponents();
        postInit(250, true, true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JLabel captionLb;
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        captionLb = new javax.swing.JLabel();
        captionText = new javax.swing.JTextField();
        captionText.getDocument().addDocumentListener(this);

        setLayout(new java.awt.BorderLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.setOpaque(false);
        captionLb.setLabelFor(captionText);
        captionLb.setText(options.getMsg("edit_name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 2);
        mainPanel.add(captionLb, gridBagConstraints);

        captionText.setToolTipText(options.getMsg("menu_dlg_name_tooltip"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 4);
        mainPanel.add(captionText, gridBagConstraints);

        add(mainPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents


    /*
    private void captionTextActionPerformed(java.awt.event.ActionEvent evt) {
        setModified(true);
        save();
    }
     */
    
    public boolean checkIfEditorValid(Editor e) {
        return e instanceof MenuEditor;
    }
    
    /*
    public void clear() {
        super.clear();
        captionText.setText(null);
    }
     */
    
    protected MenuEditor getMenuEditor(){
        return (MenuEditor)editor;
    }
    
    protected Menu getMenu(){
        if(editor==null)
            return null;
        else
            return getMenuEditor().getMenu();
    }
    
    public void fillData() {
        Menu m=getMenu();
        captionText.setText(m==null ? "" : m.description);
    }
    
    public void saveData(){
        Menu m=getMenu();
        if(m!=null){
            getMenuEditor().setDescription(captionText.getText());
            // Is this really useful?
            //captionText.setText(m.description);
            //getMenuEditor().saveData();
        }
    }
    
    /*
    public boolean isModified(){
        boolean result=super.isModified();
        if(!result && getMenu()!=null){
            result=!(Utils.compareObjects
            (captionText.getText()
            , getMenu().description));
        }
        return result;        
    }
     */
    
    @Override
    protected Icon getIcon(){
        return MenuEditor.getIcon();
    }
    
    @Override
    protected String getTitle(){
        return options.getMsg("menu_dlg_title");
    }
    
    @Override
    protected void addActionsTo(Container cnt){
        cnt.add(new SmallButton(MenuEditor.newMenuElementAction));
        cnt.add(new SmallButton(MenuEditor.newMenuAction));
        cnt.add(new SmallButton(Editor.moveUpAction));
        cnt.add(new SmallButton(Editor.moveDownAction));
        cnt.add(new SmallButton(Editor.copyAction));
        cnt.add(new SmallButton(Editor.cutAction));
        cnt.add(new SmallButton(Editor.pasteAction));
        cnt.add(new SmallButton(Editor.deleteAction));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField captionText;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

}
