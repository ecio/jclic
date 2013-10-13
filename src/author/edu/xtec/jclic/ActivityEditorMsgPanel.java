/*
 * File    : ActivityEditorMsgPanel.java
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

package edu.xtec.jclic;

import edu.xtec.jclic.boxes.ActiveBoxContent;
import edu.xtec.jclic.boxes.ActiveBoxContentEditor;
import edu.xtec.jclic.boxes.ActiveBoxPreviewPanel;
import edu.xtec.jclic.boxes.BoxBase;
import java.util.EventObject;
import javax.swing.JCheckBox;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.29
 */
public class ActivityEditorMsgPanel extends ActivityEditorInternalPanel {
    
    int NUM_MSG=3;
    ActiveBoxPreviewPanel[] abpp=new ActiveBoxPreviewPanel[NUM_MSG];
    JCheckBox[] abppChk=new JCheckBox[NUM_MSG];
    
    /** Creates new form MenuEditorPanel */
    public ActivityEditorMsgPanel(ActivityEditorPanel parent) {
        super(parent);
        initComponents();
        //abpp[0]=(ActiveBoxPreviewPanel)prevMsgPanel;
        //abppChk[0]=prevMsgChk;
        abpp[0]=(ActiveBoxPreviewPanel)initialMsgPanel;
        abppChk[0]=initialMsgChk;
        abpp[1]=(ActiveBoxPreviewPanel)finalMsgPanel;
        abppChk[1]=finalMsgChk;
        abpp[2]=(ActiveBoxPreviewPanel)errorMsgPanel;
        abppChk[2]=errorMsgChk;
        setEnabled(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel spacer;

        initialMsgChk = new javax.swing.JCheckBox();
        initialMsgPanel = new ActiveBoxPreviewPanel(null);
        finalMsgChk = new javax.swing.JCheckBox();
        finalMsgPanel = new ActiveBoxPreviewPanel(null);
        errorMsgChk = new javax.swing.JCheckBox();
        errorMsgPanel = new ActiveBoxPreviewPanel(null);
        spacer = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        initialMsgChk.setToolTipText(options.getMsg("edit_act_msg_initial_tooltip"));
        initialMsgChk.setText(options.getMsg("edit_act_msg_initial"));
        initialMsgChk.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(initialMsgChk, gridBagConstraints);

        initialMsgPanel.setToolTipText(options.getMsg("edit_act_msg_initial_tooltip"));
        initialMsgPanel.setPreferredSize(new java.awt.Dimension(500, 40));
        initialMsgPanel.setMinimumSize(new java.awt.Dimension(200, 40));
        initialMsgPanel.setMaximumSize(new java.awt.Dimension(32767, 40));
        initialMsgPanel.addMouseListener(getMouseClickListener());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(initialMsgPanel, gridBagConstraints);

        finalMsgChk.setToolTipText(options.getMsg("edit_act_msg_final_tooltip"));
        finalMsgChk.setText(options.getMsg("edit_act_msg_final"));
        finalMsgChk.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(finalMsgChk, gridBagConstraints);

        finalMsgPanel.setToolTipText(options.getMsg("edit_act_msg_final_tooltip"));
        finalMsgPanel.setPreferredSize(new java.awt.Dimension(500, 40));
        finalMsgPanel.setMinimumSize(new java.awt.Dimension(200, 40));
        finalMsgPanel.setMaximumSize(new java.awt.Dimension(32767, 40));
        finalMsgPanel.addMouseListener(getMouseClickListener());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(finalMsgPanel, gridBagConstraints);

        errorMsgChk.setToolTipText(options.getMsg("edit_act_msg_error_tooltip"));
        errorMsgChk.setText(options.getMsg("edit_act_msg_error"));
        errorMsgChk.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(errorMsgChk, gridBagConstraints);

        errorMsgPanel.setToolTipText(options.getMsg("edit_act_msg_error_tooltip"));
        errorMsgPanel.setPreferredSize(new java.awt.Dimension(500, 40));
        errorMsgPanel.setMinimumSize(new java.awt.Dimension(200, 40));
        errorMsgPanel.setMaximumSize(new java.awt.Dimension(32767, 40));
        errorMsgPanel.addMouseListener(getMouseClickListener());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(errorMsgPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(spacer, gridBagConstraints);

    }//GEN-END:initComponents
    
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        for(int i=0; i<NUM_MSG; i++){
            abppChk[i].setEnabled(enabled);
            abpp[i].setEnabled(enabled);
        }        
    }


    @Override
    public boolean eventPerformed(EventObject ev){
        Object src=(ev==null ? null : ev.getSource());
        boolean result=(src!=null && isEnabled());
        if(result){
            for(int i=0; i<NUM_MSG; i++){
                if(src==abppChk[i]){
                    abpp[i].getActiveBox().setInactive(!abppChk[i].isSelected());
                    break;
                }
                else if(src==abpp[i]){
                    ActiveBoxContent abc=ActiveBoxContentEditor.getActiveBoxContent(abpp[i].getActiveBoxContent(), this, options, getActivityEditor().getMediaBagEditor(), abpp[i].getActiveBox());
                    if(abc!=null){
                        if(!abppChk[i].isSelected()){
                            abppChk[i].setSelected(true);
                            abpp[i].getActiveBox().setInactive(false);
                        }
                        abpp[i].setActiveBoxContent(abc);
                    }
                    else
                        result=false;
                }
            }
        }
        return result;
    }
    
    /*
    public void clear() {
        for(int i=0; i<NUM_MSG; i++){
            abppChk[i].setSelected(false);
            ActiveBoxContent abc=new ActiveBoxContent();
            abc.setBoxBase(new BoxBase());
            abpp[i].setActiveBoxContent(abc);
            abpp[i].getActiveBox().setInactive(true);
        }
    }
     */
    
    public void fillData() {
        Activity act=getActivity();
        //if(act!=null){
        for(int i=0; i<NUM_MSG; i++){
            ActiveBoxContent abc = act==null ? null : act.messages[Activity.MAIN+i];
            abppChk[i].setSelected(abc!=null);
            if(abc!=null)
                abpp[i].setActiveBoxContent(abc);
            else{
                ActiveBoxContent nabc=new ActiveBoxContent();
                nabc.setBoxBase(new BoxBase());
                abpp[i].setActiveBoxContent(nabc);
            }
            abpp[i].getActiveBox().setInactive(abc==null);
        }
        //}
    }
    
    private ActiveBoxContent getActiveBoxContent(int n){
        return abppChk[n].isSelected() ? abpp[n].getActiveBoxContent() : null;
    }
    
    public void saveData(){
        Activity act=getActivity();
        if(act!=null)
            for(int i=0; i<NUM_MSG; i++)
                act.messages[Activity.MAIN+i]=getActiveBoxContent(i);
    }
    
    /*
    public boolean dataChanged(){
        boolean result=false;
        Activity act=getActivity();
        if(act!=null)
            for(int i=0; !result && i<NUM_MSG; i++)
                result=!Utils.compareTrimStringsIgnoreCase
                (act.messages[Activity.MAIN+i]
                , getActiveBoxContent(i));
        return result;
    }
     */
    
    protected javax.swing.Icon getIcon(){
        return edu.xtec.util.ResourceManager.getImageIcon("icons/messages.gif");
    }
    
    protected String getTitle() {
        return options.getMsg("edit_act_panels_messages");
    }
    
    protected String getTooltip() {
        return options.getMsg("edit_act_panels_messages_tooltip");
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox errorMsgChk;
    private javax.swing.JPanel errorMsgPanel;
    private javax.swing.JCheckBox finalMsgChk;
    private javax.swing.JPanel finalMsgPanel;
    private javax.swing.JCheckBox initialMsgChk;
    private javax.swing.JPanel initialMsgPanel;
    // End of variables declaration//GEN-END:variables
    
}